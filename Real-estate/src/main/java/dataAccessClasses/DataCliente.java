package dataAccessClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Tarea;

public class DataCliente {
	public static Cliente getOne(Integer id) {
	    Connection conn = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    try {
	        conn = ConnectionClass.connect();
	        String sqlQuery = "SELECT * FROM Clientes c WHERE c.id_cliente = ?";
	        statement = conn.prepareStatement(sqlQuery);
	        statement.setInt(1, id);
	        resultSet = statement.executeQuery();
	        
	        if (resultSet.next()) {
	        	Cliente c = new Cliente();
	        	c.setId_cliente(resultSet.getInt("id_cliente"));
	        	c.setNombre(resultSet.getString("nombre"));
	        	c.setApellido(resultSet.getString("apellido"));
	        	c.setMail(resultSet.getString("mail"));
	        	c.setTelefono(resultSet.getString("telefono"));
	        	return c;
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
	    return null;
	}
	
	public static List<Cliente> getAll() {
	    Connection conn = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    List<Cliente> listaClientes = new ArrayList<>();
	    try {
	        conn = ConnectionClass.connect();
	        String sqlQuery = "SELECT * FROM inmobiliaria.clientes";
	        statement = conn.prepareStatement(sqlQuery);
	        resultSet = statement.executeQuery();
	        
	        while (resultSet.next()) {
	        	Cliente c = new Cliente();
	        	int idCliente = resultSet.getInt("id_cliente");
	        	c.setId_cliente(idCliente);
	        	c.setNombre(resultSet.getString("nombre"));
	        	c.setApellido(resultSet.getString("apellido"));
	        	c.setMail(resultSet.getString("mail"));
	        	c.setTelefono(resultSet.getString("telefono"));
	        	listaClientes.add(c);
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
	    return listaClientes;
	}
	public static boolean newCliente(Cliente c) throws SQLException {
	    Connection conn = null;
	    PreparedStatement statement = null;
	    try {
	    	conn = ConnectionClass.connect();
	    	String nombre = c.getNombre();
	    	String apellido = c.getApellido();
	    	String telefono = c.getTelefono();
	    	String mail = c.getMail();
	    	String SqlQuery = "INSERT INTO clientes (nombre, apellido, telefono, mail) VALUES (?,?,?,?)";
	    	statement = conn.prepareStatement(SqlQuery);
	    	statement.setString(1, nombre);
	    	statement.setString(2, apellido);
	    	statement.setString(3, telefono);
	    	statement.setString(4, mail);	    	
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
	
	public static boolean update(Cliente cliente) {
	    Connection conn = null;
	    PreparedStatement statement = null;
	    boolean actualizado = false;

	    try {
	        conn = ConnectionClass.connect();
	        String sqlQuery = "UPDATE clientes SET nombre = ?, apellido = ?, telefono = ?, mail = ? WHERE id_cliente = ?";
	        statement = conn.prepareStatement(sqlQuery);

	        // Setear los valores en el SQL
	        statement.setString(1, cliente.getNombre());
	        statement.setString(2, cliente.getApellido());
	        statement.setString(3, cliente.getTelefono());
	        statement.setString(4, cliente.getMail());
	        statement.setInt(5, cliente.getId_cliente());

	        // Ejecutar la actualización
	        int filasActualizadas = statement.executeUpdate();
	        actualizado = (filasActualizadas > 0);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (statement != null) statement.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return actualizado;
	}
	
	public static boolean delete(int idCliente) {
		Connection conn = null;
		PreparedStatement statement = null;
		boolean eliminado = false;
		
		try {
			conn = ConnectionClass.connect();
			String sqlQuery = "DELETE FROM clientes c WHERE c.id_cliente = ?";
			statement = conn.prepareStatement(sqlQuery);
			
			statement.setInt(1, idCliente);
			
			int filasAfectadas = statement.executeUpdate();
			eliminado = (filasAfectadas > 0);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (statement != null) statement.close();
					if (conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return eliminado;
	}
	
	
}
