package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataAccessClasses.DataUser;
import model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getAttribute("username");
		String pass = (String) request.getAttribute("password");
		try {
				User current_user = DataUser.getUser2(username, pass);
				if (current_user.getUsername() != null) {
					HttpSession session = request.getSession(true);
					session.setAttribute("username", username);
					RequestDispatcher dispatcher = request.getRequestDispatcher("sesionIniciada.jsp");
					dispatcher.forward(request,response);
				} 
		}
		catch (Exception e) {
			response.sendRedirect("errorDbConnection.html");
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
