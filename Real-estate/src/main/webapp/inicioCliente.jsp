<%@page import="util.LoginGuardJsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Inicio</title>
		<!-- Bootstrap -->
	    <link href="bootstrap-4.4.1.css" rel="stylesheet">
		<!-- Java -->
		<%
			User current_user = LoginGuardJsp.guardJsp(request, response, session);
		%>
	</head>
	<body>
		<jsp:include page="navbar.jsp" />
	    <br>
	</body>
</html>