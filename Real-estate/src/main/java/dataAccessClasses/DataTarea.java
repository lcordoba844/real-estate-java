package dataAccessClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Casa;
import model.Departamento;
import model.Localidad;
import model.Propiedad;
import model.Tarea;
import model.Tarea.EstadoTarea;

public class DataTarea {
	
		public static boolean addNewTarea(Tarea tarea) throws SQLException {
		    Connection conn = null;
		    PreparedStatement statement = null;
		    try {
		    	conn = ConnectionClass.connect();
		    	String descripcion = tarea.getDescripcion();
		    	String estadoSt = tarea.getEstado().toString();
		    	double importe = tarea.getImporte();
		    	boolean pagado = tarea.isPagado();
		    	Date fecha_asignacion = tarea.getFecha_asignacion();
		    	Date fecha_realizacion = tarea.getFecha_realizacion();
		    	int id_propiedad = tarea.getProp().getId_propiedad();
		    	String SqlQuery = "INSERT INTO tareas (descripcion, estado, importe, pagado, fecha_asignacion, fecha_realizacion, id_propiedad) VALUES (?,?,?,?,?,?,?)";
		    	statement = conn.prepareStatement(SqlQuery);
		    	statement.setString(1, descripcion);
		    	statement.setString(2, estadoSt);
		    	statement.setDouble(3, importe);
		    	statement.setBoolean(4, pagado);
		    	statement.setDate(5, fecha_asignacion != null ? new java.sql.Date(fecha_asignacion.getTime()) : null);
		    	statement.setDate(6, fecha_realizacion != null ? new java.sql.Date(fecha_realizacion.getTime()) : null);
		    	statement.setInt(7, id_propiedad);
		        int rowsInserted = statement.executeUpdate();
		        return rowsInserted > 0;
		    } catch (SQLException e)  {
		        e.printStackTrace();
		        return false;
		    } finally {
		        if (statement != null) {
		            statement.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    }
		}
		
		public static List<Tarea> getManyTareas(int idPropiedad) {
			Connection conn = null;
			PreparedStatement statement = null; 
			ResultSet resultSet = null;
			Tarea tareaActual = null;
			List<Tarea> listTareas = new ArrayList<>();
			try {
				conn = ConnectionClass.connect();
				String sqlQuery = "SELECT * FROM tareas WHERE tareas.id_propiedad = ?";
				statement = conn.prepareStatement(sqlQuery);
				statement.setInt(1, idPropiedad);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
						tareaActual = new Tarea(
								resultSet.getString("descripcion"),
								Tarea.EstadoTarea.valueOf(resultSet.getString("estado")),
								resultSet.getDouble("importe"),
								resultSet.getBoolean("pagado"),
								resultSet.getDate("fecha_asignacion"),
								resultSet.getDate("fecha_pago"),								
								DataPropiedad.getOne(resultSet.getInt(idPropiedad))
						);
								listTareas.add(tareaActual);								
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
			        try {
			            if (resultSet != null) {
			                resultSet.close();
			            }
			            if (statement != null) {
			                statement.close();
			            }
			            if (conn != null) {
			                conn.close();
			            }
			        } catch (SQLException e) {
			            e.printStackTrace(); 
			        }
				}
			return listTareas;
		}
	}
