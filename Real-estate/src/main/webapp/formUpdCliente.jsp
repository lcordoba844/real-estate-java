<%@page import="util.LoginGuardJsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import="model.Cliente" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Modificar Cliente</title>
		<!-- Bootstrap -->
	    <link href="bootstrap-4.4.1.css" rel="stylesheet">
		<!-- Java -->
		<%
			User current_user = LoginGuardJsp.guardJsp(request, response, session);
		
			Cliente clienteActual = (Cliente) request.getAttribute("clienteAModificar");
			
		%>
	</head>
	<body>
		<jsp:include page="navbar.jsp" />
	    <br>
	    <div class="container">
	    	<h1>Modificar Cliente</h1>
	    	<form action="ClienteServlet" method="post">
				  <div class="form-group">
				    <label for="nombre">Nombre:</label>
				    <input type="text" class="form-control" id="nombre" name="nombre" value="<%=clienteActual.getNombre() %>">
				  </div>
				  <div class="form-group">
				    <label for="nombre">Apellido:</label>
				    <input type="text" class="form-control" id="apellido" name="apellido" value="<%=clienteActual.getApellido()%>">
				  </div>
				  <div class="form-group">
				    <label for="telefono">Teléfono:</label>
				    <input type="tel" class="form-control" id="telefono" name="telefono" value="<%=clienteActual.getTelefono()%>">
				  </div>
				  <div class="form-group">
				    <label for="mail">Correo electrónico:</label>
				    <input type="email" class="form-control" id="mail" name="mail" value="<%=clienteActual.getMail()%>">
				  </div>
				  <input type="hidden" name="idCliente" value="<%= clienteActual.getId_cliente() %>">
				  <button type="submit" class="btn btn-primary" name="action" value="modificarCliente">Editar</button>
			</form>
	    </div>
	</body>
</html>