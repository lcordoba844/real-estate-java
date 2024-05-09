package dataAccessClasses;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectionClass {
	
	private static Connection conn = null;
	
	public static Connection connect() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/inmobiliaria","root","admin");
		return conn;
	}
}
