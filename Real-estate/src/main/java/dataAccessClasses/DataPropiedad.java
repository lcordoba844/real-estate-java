package dataAccessClasses;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Casa;
import model.Departamento;
import model.Localidad;
import model.Propiedad;

public class DataPropiedad {
	
	public static boolean addNewPropiedad(Propiedad prop) throws SQLException {
	    Connection conn = null;
	    PreparedStatement statement = null;
	    try {
	        conn = ConnectionClass.connect();
	        String tipo = prop.getTipo_propiedad();
	        int cant_baños = prop.getCant_baños();
	        int cant_dormitorios = prop.getCant_dormitorios();
	        Localidad loc = prop.getLocalidad();
	        int id_localidad = loc.getId(); 
	        String descripcion = prop.getDescripcion();
	        String direccion = prop.getDireccion();
	        String estado = prop.getEstado();
	        int id_propiedad = prop.getId_propiedad(); 
	        double precio = prop.getPrecio(); 
	        boolean cochera = prop.tieneCochera();

	        String sqlQuery;
	        if (prop instanceof Casa casa) {
	            int cant_pisos = casa.getCant_pisos();
	            double mts2_cubiertos = casa.getMts2cubiertos();
	            double mts2_tot_terreno = casa.getMts2tot_terreno();

	            sqlQuery = "INSERT INTO propiedades (tipo_propiedad, estado, cant_dormitorios, " +
	                    "cant_baños, cant_pisos, mts2_tot_terreno, mts2_cubiertos, cochera, descripcion, direccion, " +
	                    "id_localidad, precio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		        statement = conn.prepareStatement(sqlQuery);
		        statement.setString(1, tipo);
		        statement.setString(2, estado);
		        statement.setInt(3, cant_dormitorios);
		        statement.setInt(4, cant_baños);
		        statement.setInt(5, cant_pisos);
		        statement.setDouble(6, mts2_tot_terreno);
		        statement.setDouble(7, mts2_cubiertos);
		        statement.setBoolean(8, cochera);
		        statement.setString(9, descripcion);
		        statement.setString(10, direccion);
		        statement.setInt(11, id_localidad);
		        statement.setDouble(12, precio); 
		        
	        } else if (prop instanceof Departamento dpto){
	            boolean balcon = dpto.tieneBalcon();
	            boolean terraza = dpto.tieneTerraza();
	            String orientacion = dpto.getOrientacion();
	            double mts2Tot = dpto.getMts2Tot();
	            
	            sqlQuery = "INSERT INTO propiedades (tipo_propiedad, estado, cant_dormitorios, " +
	                    "cant_baños, mts2tot,balcon, terraza, cochera, orientacion, descripcion, direccion, " +
	                    "id_localidad, precio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		        statement = conn.prepareStatement(sqlQuery);
		        statement.setString(1, tipo);
		        statement.setString(2, estado);
		        statement.setInt(3, cant_dormitorios);
		        statement.setInt(4, cant_baños);
		        statement.setDouble(5, mts2Tot);
		        statement.setBoolean(6, balcon);
		        statement.setBoolean(7, terraza);
		        statement.setBoolean(8, cochera);
		        statement.setString(9, orientacion);
		        statement.setString(10, descripcion);
		        statement.setString(11, direccion);
		        statement.setInt(12, id_localidad);
		        statement.setDouble(13, precio); 
		        
	        }
	        int rowsInserted = statement.executeUpdate();
	        return rowsInserted > 0;
	    } catch (SQLException e) {
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
	
	
	public static boolean updatePropiedad(Propiedad prop) throws SQLException {
	    Connection conn = null;
	    PreparedStatement statement = null;
	    try {
	        conn = ConnectionClass.connect();
	        String tipo = prop.getTipo_propiedad();
	        int cant_baños = prop.getCant_baños();
	        int cant_dormitorios = prop.getCant_dormitorios();
	        Localidad loc = prop.getLocalidad();
	        int id_localidad = loc.getId(); 
	        String descripcion = prop.getDescripcion();
	        String direccion = prop.getDireccion();
	        String estado = prop.getEstado();
	        int id_propiedad = prop.getId_propiedad(); 
	        double precio = prop.getPrecio(); 
	        boolean cochera = prop.tieneCochera();

	        String sqlQuery;
	        if (prop instanceof Casa) {
	            Casa casa = (Casa) prop;
	            int cant_pisos = casa.getCant_pisos();
	            double mts2_cubiertos = casa.getMts2cubiertos();
	            double mts2_tot_terreno = casa.getMts2tot_terreno();

	            sqlQuery = "UPDATE propiedades SET tipo_propiedad = ?, estado = ?, cant_dormitorios = ?, " +
	                    "cant_baños = ?, cant_pisos = ?, mts2_tot_terreno = ?, mts2_cubiertos = ?, cochera = ?, descripcion = ?, direccion = ?, " +
	                    "id_localidad = ?, precio = ? WHERE id_propiedad = ?";
		        statement = conn.prepareStatement(sqlQuery);
		        statement.setString(1, tipo);
		        statement.setString(2, estado);
		        statement.setInt(3, cant_dormitorios);
		        statement.setInt(4, cant_baños);
		        statement.setInt(5, cant_pisos);
		        statement.setDouble(6, mts2_tot_terreno);
		        statement.setDouble(7, mts2_cubiertos);
		        statement.setBoolean(8, cochera);
		        statement.setString(9, descripcion);
		        statement.setString(10, direccion);
		        statement.setInt(11, id_localidad);
		        statement.setDouble(12, precio); 
		        statement.setInt(13, id_propiedad);
		        
	        } else if (prop instanceof Departamento){
	            Departamento dpto = (Departamento) prop;
	            boolean balcon = dpto.tieneBalcon();
	            boolean terraza = dpto.tieneTerraza();
	            String orientacion = dpto.getOrientacion();
	            double mts2Tot = dpto.getMts2Tot();
	            
	            sqlQuery = "UPDATE propiedades SET tipo_propiedad = ?, estado = ?, cant_dormitorios = ?, " +
	                    "cant_baños = ?, mts2tot = ?, balcon = ?, terraza = ?, cochera = ?, orientacion = ?, descripcion = ?, direccion = ?, " +
	                    "id_localidad = ?, precio = ? WHERE id_propiedad = ?";
		        statement = conn.prepareStatement(sqlQuery);
		        statement.setString(1, tipo);
		        statement.setString(2, estado);
		        statement.setInt(3, cant_dormitorios);
		        statement.setInt(4, cant_baños);
		        statement.setDouble(5, mts2Tot);
		        statement.setBoolean(6, balcon);
		        statement.setBoolean(7, terraza);
		        statement.setBoolean(8, cochera);
		        statement.setString(9, orientacion);
		        statement.setString(10, descripcion);
		        statement.setString(11, direccion);
		        statement.setInt(12, id_localidad);
		        statement.setDouble(13, precio);
		        statement.setInt(14, id_propiedad);
	        }
	        int rowsInserted = statement.executeUpdate();
	        return rowsInserted > 0;
	    } catch (SQLException e) {
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
	
	public static Propiedad getOne(Integer idPropiedad) {
		Connection conn = null;
		PreparedStatement statement = null; 
		ResultSet resultSet = null;
		Propiedad propiedad = null;
		try {
			conn = ConnectionClass.connect();
			String sqlQuery = "SELECT * FROM propiedades p WHERE p.id_propiedad = ?";
			statement = conn.prepareStatement(sqlQuery);
			statement.setInt(1, idPropiedad);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
            	String descripcion = resultSet.getString("descripcion");
            	int cant_dormitorios = resultSet.getInt("cant_dormitorios");
            	int cant_baños = resultSet.getInt("cant_baños");
            	boolean cochera = resultSet.getBoolean("cochera");
            	int id_localidad = resultSet.getInt("id_localidad");
            	String tipo = resultSet.getString("tipoPropiedad");
            	String estado = resultSet.getString("estado");
            	String direccion = resultSet.getString("direccion");
            	double precio = resultSet.getDouble("precio");
            	Localidad lActual = DataLocalidad.getOne(id_localidad);
				if ("Casa".equalsIgnoreCase(tipo)){
					int cant_pisos = resultSet.getInt("cant_pisos");
                	double mts2cubiertos = resultSet.getDouble("mts2_cubiertos");
                	double mts2totales = resultSet.getDouble("mts2_tot_terreno");
                	propiedad = new Casa(idPropiedad, cant_baños, cant_dormitorios, tipo, precio,
                			cochera, descripcion, lActual, direccion, estado, cant_pisos, mts2cubiertos, mts2totales);
				} else if ("Departamento".equalsIgnoreCase(tipo)) {
					boolean balcon = resultSet.getBoolean("balcon");
                	boolean terraza = resultSet.getBoolean("terraza");
                	String orientacion = resultSet.getString("orientacion");
                	double mts2 = resultSet.getDouble("mts2_tot");
                	propiedad = new Departamento(idPropiedad, cant_baños, cant_dormitorios, tipo, precio,
                			cochera, descripcion, lActual, direccion, estado, mts2, balcon, orientacion, terraza );
				}
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
		return propiedad;
	}
	
    public static List<Propiedad> getAllPropiedades() {
        List<Propiedad> listPropiedades = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conn = ConnectionClass.connect();
            String sqlQuery = "SELECT * FROM propiedades";
            statement = conn.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
            	int idActual = resultSet.getInt("id_propiedad");
            	String descripcion = resultSet.getString("descripcion");
            	int cant_dormitorios = resultSet.getInt("cant_dormitorios");
            	int cant_baños = resultSet.getInt("cant_baños");
            	boolean cochera = resultSet.getBoolean("cochera");
            	int id_localidad = resultSet.getInt("id_localidad");
            	String tipo = resultSet.getString("tipo_propiedad");
            	String estado = resultSet.getString("estado");
            	String direccion = resultSet.getString("direccion");
            	double precio = resultSet.getDouble("precio");
            	Localidad lActual = null;// DataLocalidad.getOne(id_localidad);
                if ("Casa".equalsIgnoreCase(tipo)) {
                	int cant_pisos = resultSet.getInt("cant_pisos");
                	double mts2cubiertos = resultSet.getDouble("mts2_cubiertos");
                	double mts2totales = resultSet.getDouble("mts2_tot_terreno");
                	Casa casa = new Casa(idActual, cant_baños, cant_dormitorios, tipo, precio,
                			cochera, descripcion, lActual, direccion, estado, cant_pisos, mts2cubiertos, mts2totales );
                	listPropiedades.add(casa);
                } else if ("Departamento".equalsIgnoreCase(tipo)) {
                	boolean balcon = resultSet.getBoolean("balcon");
                	boolean terraza = resultSet.getBoolean("terraza");
                	String orientacion = resultSet.getString("orientacion");
                	double mts2 = resultSet.getDouble("mts2_tot");
                	Departamento dpto = new Departamento(idActual, cant_baños, cant_dormitorios, tipo, precio,
                			cochera, descripcion, lActual, direccion, estado, mts2, balcon, orientacion, terraza );
                	listPropiedades.add(dpto);
                }
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

        return listPropiedades;
    }


	public static List<Propiedad> getAllPropiedades2() {
	    List<Propiedad> listPropiedades = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement propStmt = null;
	    PreparedStatement locStmt = null;
	    ResultSet propiedadResultSet = null;
	    ResultSet localidadResultSet = null;
	
	    try {
	        conn = ConnectionClass.connect();
	        String locQuery = "SELECT * FROM localidades";
	        locStmt = conn.prepareStatement(locQuery);
	        localidadResultSet = locStmt.executeQuery();
	     
	        Map<Integer, Localidad> localidadesMap = new HashMap<>();
	        while (localidadResultSet.next()) {
	            Localidad localidad = new Localidad();
	            localidad.setId(localidadResultSet.getInt("id_localidad"));
	            localidad.setDescripcion(localidadResultSet.getString("descripcion"));
	            localidadesMap.put(localidad.getId(), localidad);
	        }
	        
	        String propQuery = "SELECT * FROM propiedades";
	        propStmt = conn.prepareStatement(propQuery);
	        propiedadResultSet = propStmt.executeQuery();
	        
	        while (propiedadResultSet.next()) {
	            int idLocalidad = propiedadResultSet.getInt("id_localidad");
	            Localidad localidad = localidadesMap.get(idLocalidad);
	            if (localidad != null) {
	            	int idActual = propiedadResultSet.getInt("id_propiedad");
	            	String descripcion = propiedadResultSet.getString("descripcion");
	            	int cant_dormitorios = propiedadResultSet.getInt("cant_dormitorios");
	            	int cant_baños = propiedadResultSet.getInt("cant_baños");
	            	boolean cochera = propiedadResultSet.getBoolean("cochera");
	            	int id_localidad = propiedadResultSet.getInt("id_localidad");
	            	String estado = propiedadResultSet.getString("estado");
	            	String direccion = propiedadResultSet.getString("direccion");
	            	double precio = propiedadResultSet.getDouble("precio");
	            	Localidad lActual = DataLocalidad.getOne(id_localidad);
	                String tipoPropiedad = propiedadResultSet.getString("tipoPropiedad");
	                if ("Casa".equals(tipoPropiedad)) {
	                	int cant_pisos = propiedadResultSet.getInt("cant_pisos");
	                	double mts2cubiertos = propiedadResultSet.getDouble("mts2_cubiertos");
	                	double mts2totales = propiedadResultSet.getDouble("mts2_tot_terreno");
	                    Casa casa = new Casa(idActual, cant_baños, cant_dormitorios, tipoPropiedad, precio,
	                			cochera, descripcion, lActual, direccion, estado, cant_pisos, mts2cubiertos, mts2totales);
	                    listPropiedades.add(casa);
	                } else if ("Departamento".equals(tipoPropiedad)) {
	                	boolean balcon = propiedadResultSet.getBoolean("balcon");
	                	boolean terraza = propiedadResultSet.getBoolean("terraza");
	                	String orientacion = propiedadResultSet.getString("orientacion");
	                	double mts2 = propiedadResultSet.getDouble("mts2_tot");
	                    Departamento dpto = new Departamento(idActual, cant_baños, cant_dormitorios, tipoPropiedad, precio,
	                			cochera, descripcion, lActual, direccion, estado, mts2, balcon, orientacion, terraza );
	                    listPropiedades.add(dpto);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	 try {
	             if (localidadResultSet != null) {
	                 localidadResultSet.close();
	             }
	             if (propiedadResultSet != null) {
	            	 propiedadResultSet.close();
	             }
	             if (locStmt != null) {
	            	 locStmt.close();
	             }
	             if (propStmt != null) {
	            	 propStmt.close();
	             }
	             if (conn != null) {
	                 conn.close();
	             }
	         } catch (SQLException e) {
	             e.printStackTrace();
	         }
	    }
	    return listPropiedades;
	}
	
	public static List<Propiedad> getAllPropiedadesForCliente(int idCliente) {
	    List<Propiedad> listPropiedades = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement propStmt = null;
	    PreparedStatement locStmt = null;
	    ResultSet propiedadResultSet = null;
	    ResultSet localidadResultSet = null;
	
	    try {
	        conn = ConnectionClass.connect();
	        String locQuery = "SELECT * FROM localidades";
	        locStmt = conn.prepareStatement(locQuery);
	        localidadResultSet = locStmt.executeQuery();
	     
	        Map<Integer, Localidad> localidadesMap = new HashMap<>();
	        while (localidadResultSet.next()) {
	            Localidad localidad = new Localidad();
	            localidad.setId(localidadResultSet.getInt("id_localidad"));
	            localidad.setDescripcion(localidadResultSet.getString("descripcion"));
	            localidadesMap.put(localidad.getId(), localidad);
	        }
	        
	        String propQuery = "SELECT * FROM propiedades WHERE propiedades.id_cliente = ?";
	        propStmt = conn.prepareStatement(propQuery);
	        propStmt.setInt(1, idCliente);
	        propiedadResultSet = propStmt.executeQuery();
	        
	        while (propiedadResultSet.next()) {
	            int idLocalidad = propiedadResultSet.getInt("id_ciudad");
	            Localidad localidad = localidadesMap.get(idLocalidad);
	            if (localidad != null) {
	            	int idActual = propiedadResultSet.getInt("id_propiedad");
	            	String descripcion = propiedadResultSet.getString("descripcion");
	            	int cant_dormitorios = propiedadResultSet.getInt("cant_dormitorios");
	            	int cant_baños = propiedadResultSet.getInt("cant_baños");
	            	boolean cochera = propiedadResultSet.getBoolean("cochera");
	            	int id_localidad = propiedadResultSet.getInt("id_localidad");
	            	String estado = propiedadResultSet.getString("estado");
	            	String direccion = propiedadResultSet.getString("direccion");
	            	double precio = propiedadResultSet.getDouble("precio");
	            	Localidad lActual = DataLocalidad.getOne(id_localidad);
	                String tipoPropiedad = propiedadResultSet.getString("tipoPropiedad");
	                if ("Casa".equals(tipoPropiedad)) {
	                	int cant_pisos = propiedadResultSet.getInt("cant_pisos");
	                	double mts2cubiertos = propiedadResultSet.getDouble("mts2_cubiertos");
	                	double mts2totales = propiedadResultSet.getDouble("mts2_tot_terreno");
	                    Casa casa = new Casa(idActual, cant_baños, cant_dormitorios, tipoPropiedad, precio,
	                			cochera, descripcion, lActual, direccion, estado, cant_pisos, mts2cubiertos, mts2totales);
	                    listPropiedades.add(casa);
	                } else if ("Departamento".equals(tipoPropiedad)) {
	                	boolean balcon = propiedadResultSet.getBoolean("balcon");
	                	boolean terraza = propiedadResultSet.getBoolean("terraza");
	                	String orientacion = propiedadResultSet.getString("orientacion");
	                	double mts2 = propiedadResultSet.getDouble("mts2_tot");
	                    Departamento dpto = new Departamento(idActual, cant_baños, cant_dormitorios, tipoPropiedad, precio,
	                			cochera, descripcion, lActual, direccion, estado, mts2, balcon, orientacion, terraza );
	                    listPropiedades.add(dpto);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	 try {
	             if (localidadResultSet != null) {
	                 localidadResultSet.close();
	             }
	             if (propiedadResultSet != null) {
	            	 propiedadResultSet.close();
	             }
	             if (locStmt != null) {
	            	 locStmt.close();
	             }
	             if (propStmt != null) {
	            	 propStmt.close();
	             }
	             if (conn != null) {
	                 conn.close();
	             }
	         } catch (SQLException e) {
	             e.printStackTrace();
	         }
	    }
	    return listPropiedades;
	}
}