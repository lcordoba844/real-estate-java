<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Propiedad"%>
<%@page import="model.User"%>
<%@page import="util.LoginGuardJsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ListarTodasPropiedades</title>
		
		<%	
			User current_user = LoginGuardJsp.guardJsp(request, response, session);
		%>
				
	</head>
	<body>
		<jsp:include page="navbar.jsp" />
		<p>si esto se imprime es porque anda;<p>
	</body>
</html>