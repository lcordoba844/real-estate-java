package util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

public class LoginGuardJsp {	
	
	public static User guardJsp(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		User current_user = (User) session.getAttribute("current_user");
		if(current_user == null) {
			response.sendRedirect("./index.jsp");
			return null;
		} 
		return current_user;
	}
}
