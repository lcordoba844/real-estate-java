package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccessClasses.DataUser;
import util.PasswordHashing;
import util.UserAlreadyExistsException;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateAccount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getAttribute("username");
		String passNotHashed = (String) request.getAttribute("password");
		String pass = PasswordHashing.hashPassword(passNotHashed);
		
		try {
		DataUser.addNewUser(username, pass);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		dispatcher.forward(request,response);
		} catch (UserAlreadyExistsException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
