package dataAccessClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import model.User;

public class DataUser {
	
	public static String setNewUser(String user, String pass) {
        String username = user;
        String password = pass;
        if (username != null && password !=null) {
        	try {
        	boolean userExistent = validateExistance(username);
        		
        		
        	} catch (Exception e) {}
        	finally {}
        }
        return "el usuario...";
	}
	
	
	
	
	private static boolean validateExistance(String username) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			conn = ConnectionClass.Connect();
			String sqlQuery = "SELECT * FROM users u WHERE u.username = ?";
			statement = conn.prepareStatement(sqlQuery);
			statement.setString(1, username);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			
		} catch (ClassNotFoundException e) {
			
		} finally {return false;} 
	}




	public static User getUser(String username, String password) {
	    User currentUser = null;
	    Connection conn = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    try {
	    	conn = ConnectionClass.Connect();
	        String sqlQuery = "SELECT * FROM users u WHERE u.username = ? AND u.password = ?";
	        statement = conn.prepareStatement(sqlQuery);
	        statement.setString(1, username);
	        statement.setString(2, password);
	        resultSet = statement.executeQuery();
	        // Check if a user with the given username and password exists
	        if (resultSet.next()) {
	            // Create a new User object and populate it with data from the result set
	            currentUser = new User();
	            currentUser.setUsername(resultSet.getString("username"));
	            currentUser.setPassword(resultSet.getString("password"));
	        }
	    } catch (ClassNotFoundException e) {
	        // Handle ClassNotFoundException
	        e.printStackTrace();
	    } catch (SQLException e) {
	        // Handle SQLException
	        e.printStackTrace();
	    } finally {
	        // Close resources in a finally block to ensure they are closed even if an exception occurs
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
	            // Handle SQLException while closing resources
	            e.printStackTrace();
	        }
	    }
	    return currentUser;
	}
	
	
	
	
	
	
	
	
	
	

}
