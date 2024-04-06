package dataAccessClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import model.User;

public class DataUser {
	
	
	
	public static User getUser(String user, String pass) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/real-estate";
        String usernameDb = "root";
        String passwordDb = "admin";
        ResultSet resultSet = null;
        User current_user = new User();
		try {
			 // Load the MySQL JDBC driver
        	Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(jdbcUrl, usernameDb, passwordDb);
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM USERS WHERE USERS.username = ?1 AND USERS.password = ?2";
            resultSet = statement.executeQuery(sqlQuery);
            current_user.setUsername(resultSet.getString("username"));
            current_user.setPassword(resultSet.getString("password")); 
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			
		}
		return current_user;
	}
	
	
	
	
	public static User getUser2(String username, String password) {
	    String jdbcUrl = "jdbc:mysql://localhost:3306/real-estate";
	    String usernameDb = "root";
	    String passwordDb = "admin";
	    User currentUser = null;
	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = DriverManager.getConnection(jdbcUrl, usernameDb, passwordDb);
	       
	        // Prepare the SQL query with placeholders for parameters
	        String sqlQuery = "SELECT * FROM USERS U WHERE U.username = ? AND U.password = ?";
	        statement = connection.prepareStatement(sqlQuery);
	        
	        // Set the parameters for the prepared statement
	        statement.setString(1, username);
	        statement.setString(2, password);
	        System.out.println(username + password);
	        
	        // Execute the query
	        resultSet = statement.executeQuery();
	        
	        // Check if a user with the given username and password exists
	        if (resultSet.next()) {
	            // Create a new User object and populate it with data from the result set
	            currentUser = new User();
	            currentUser.setUsername(resultSet.getString("username"));
	            currentUser.setPassword(resultSet.getString("password"));
	            // You can populate other fields of the User object here
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
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            // Handle SQLException while closing resources
	            e.printStackTrace();
	        }
	    }
	    return currentUser;
	}
	
	
	
	
	
	
	
	
	
	

}
