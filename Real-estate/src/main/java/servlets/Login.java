package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataAccessClasses.DataUser;
import model.User;
import util.PasswordHashing;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getAttribute("username");
		String passNotHashed = (String) request.getAttribute("password");
		String pass = PasswordHashing.hashPassword(passNotHashed);
		try {
				User current_user = DataUser.getUser(username, pass);
				if (current_user.getUsername() != null) {
					HttpSession session = request.getSession(true);
					session.setAttribute("current_user", current_user);
					RequestDispatcher dispatcher = request.getRequestDispatcher("inicioCliente.jsp");
					dispatcher.forward(request,response);
				} 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
