package util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

public class LoginGuardJsp {	
	
	public static User guardJsp(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		User current_user = null;
		if(session.getAttribute("current_user") != null) {
			current_user = (User) session.getAttribute("current_user");
		} else {
			response.sendRedirect("./index.jsp");
		}
		return current_user;
	}
}
