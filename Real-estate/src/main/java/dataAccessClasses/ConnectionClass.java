package dataAccessClasses;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectionClass {
	
	private static Connection conn = null;
	
	public static Connection Connect() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/inmobiliaria","root","admin");
		return conn;
	}
}
