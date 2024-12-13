<%@page import="util.LoginGuardJsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Alta Cliente</title>
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
	    <div class="container">
	    	<h1>Alta Cliente</h1>
	    	<form action="ClienteServlet" method="post">
				  <div class="form-group">
				    <label for="nombre">Nombre:</label>				    
				    <input type="text" class="form-control" id="nombre" name="nombre" required>
				  </div>
				  <div class="form-group">
				    <label for="nombre">Apellido:</label>
				    <input type="text" class="form-control" id="apellido" name="apellido" required>
				  </div>
				  <div class="form-group">
				    <label for="telefono">Teléfono:</label>
				    <input type="tel" class="form-control" id="telefono" name="telefono" required>
				  </div>
				  <div class="form-group">
				    <label for="mail">Correo electrónico:</label>
				    <input type="email" class="form-control" id="mail" name="mail" required>
				  </div>
				  <button type="submit" class="btn btn-primary" name="action" value="altaCliente">Crear</button>
			</form>
	    </div>
	</body>
</html>