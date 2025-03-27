package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ManageSession")
public class ManageSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ManageSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String username = request.getParameter("txtName");
		String password = request.getParameter("txtPass");
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		String targetServlet = switch (action) {
	        case "logIn" -> "Login";
	        case "logOut" -> "Logout";
	        default -> null;
		};
	    RequestDispatcher dispatcher = request.getRequestDispatcher(targetServlet);
	    dispatcher.forward(request, response);
	}
	
}