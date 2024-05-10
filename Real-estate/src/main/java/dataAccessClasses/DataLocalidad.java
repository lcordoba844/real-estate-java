package dataAccessClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Localidad;

public class DataLocalidad {
	
	public List<Localidad> getAllLocalidades() throws SQLException {
		List<Localidad> listLocalidades = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    try {
	    	conn = ConnectionClass.connect();
	    	String sqlQuery = "SELECT * FROM localidades l";
	    	statement = conn.prepareStatement(sqlQuery);
	    	resultSet = statement.executeQuery();
	    	
	    	while (resultSet.next()) {
	    		Localidad locActual = new Localidad();
	    		locActual.setId(resultSet.getInt("id_localidad"));
	    		locActual.setDescripcion(resultSet.getString("descripcion"));
	    		listLocalidades.add(locActual);
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
	    return listLocalidades;
	}
	
	public static Localidad getOne(Integer id) {
	    Connection conn = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    try {
	        conn = ConnectionClass.connect();
	        String sqlQuery = "SELECT * FROM localidades l WHERE l.id_localidad = ?";
	        statement = conn.prepareStatement(sqlQuery);
	        statement.setInt(1, id);
	        resultSet = statement.executeQuery();
	        
	        if (resultSet.next()) {
	        	Localidad l = new Localidad();
	        	l.setId(resultSet.getInt("id_localidad"));
	        	l.setDescripcion(resultSet.getString("descripcion"));
	        	return l;
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
	
	public static Localidad getFromDescription(String descripcion) {
	    Connection conn = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    try {
	        conn = ConnectionClass.connect();
	        String sqlQuery = "SELECT * FROM localidades l WHERE l.descripcion = ?";
	        statement = conn.prepareStatement(sqlQuery);
	        statement.setString(1, descripcion);
	        resultSet = statement.executeQuery();
	        
	        if (resultSet.next()) {
	        	Localidad l = new Localidad();
	        	l.setId(resultSet.getInt("id_ciudad"));
	        	l.setDescripcion(resultSet.getString("descripcion"));
	        	return l;
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
	
	public static boolean addNewLocalidad(Localidad nuevaLocalidad) throws SQLException {
	    Connection conn = null;
	    PreparedStatement statement = null;
	    boolean success = false; 
	    
	    try {
	        conn = ConnectionClass.connect();
	        Localidad lExiste = getFromDescription(nuevaLocalidad.getDescripcion());
	        if (lExiste == null) { 
	            String sqlQuery = "INSERT INTO localidades (descripcion) VALUES (?)";
	            statement = conn.prepareStatement(sqlQuery);
	            statement.setString(1, nuevaLocalidad.getDescripcion());
	            statement.executeUpdate();
	            success = true; 
	        } else {
	            success = false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        success = false;
	    } finally {
	        if (statement != null) {
	            statement.close();
	        }
	        if (conn != null) {
	            conn.close();
	        }
	    }
	    
	    return success;
	}
	
	
	public static boolean updateLocalidad(Localidad l, String nuevaDescripcion) throws SQLException {
	    Connection conn = null;
	    PreparedStatement statement = null;
	    boolean success = false; 
	    int id = l.getId();
	    try {
	    	conn = ConnectionClass.connect();
	    	String sqlQuery = "UPDATE localidades l SET (descripcion) = ? WHERE l.id_localidad = ?";
	    	statement = conn.prepareStatement(sqlQuery);
	    	statement.setString(1, nuevaDescripcion);
	    	statement.setInt(2, id);
	    	statement.executeUpdate();
	    	success = true;
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	success = false;
	    } finally {
	    	if (statement != null) {
	            statement.close();
	        }
	        if (conn != null) {
	            conn.close();
	        }
	    }
	    return success;
	}
	
}
