package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DbConnection
 */
@WebServlet("/DbConnection")
public class DbConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DbConnection() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/real-estate";
        String username = "root";
        String password = "admin";

        try {
            // Load the MySQL JDBC driver
        	Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Check if the connection is successful
            if (connection != null) {
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/conexionExitosa.html");
            	dispatcher.forward(request, response);
            }
            	
        } catch (ClassNotFoundException e) {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/errorDbConnection.html");
        	dispatcher.forward(request, response);
        } catch (SQLException e) {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/errorDbConnection.html");
        	dispatcher.forward(request, response);
        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
