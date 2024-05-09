package dataAccessClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Propiedad;

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
	        	List<Propiedad> listadoPropiedades = new ArrayList<>();
	        	listadoPropiedades = DataPropiedad.getAllPropiedadesForCliente(id);
	        	c.setMis_propiedades(listadoPropiedades);
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
}
