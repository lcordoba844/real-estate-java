<%@page import="util.LoginGuardJsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Nueva Propiedad</title>
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
	    	<h1>Nueva Propiedad</h1>
	    	<br>
	    	<% if (request.getAttribute("idCliente") != null) { %>
	    	<form action="PropiedadServlet" method="post">
	    		<input type="hidden" name="idCliente" value=<%=request.getAttribute("idCliente")%>>>
	    		<% } else { %>
	    			<div class="form-group">
					    <label for="idPropietario">idPropietario</label>
					    <input type="text" class="form-control" id="idPropietario" name="idPropietario" required>
				  </div>
				 <% } %>
				  <div class="form-group">
				    <label for="nombre">Casa o Departamento:</label>
				    <input type="text" class="form-control" id="tipo_propiedad" name="tipo_propiedad" required>
				  </div>
				  <div class="form-group">
				    <label for="cant_baños">Cantidad de baños:</label>
				    <input type="text" class="form-control" id="cant_baños" name="cant_baños" required>
				  </div>
				  <div class="form-group">
				    <label for="cant_dormitorios">Cantidad de dormitorios:</label>
				    <input type="text" class="form-control" id="cant_dormitorios" name="cant_dormitorios" required>
				  </div>
				  <div class="form-group">
				    <label for="precio">Precio:</label>
				    <input type="number" class="form-control" id="precio" name="precio" required>
				  </div>
				  <div class="form-group">
				    <label for="cochera">Cochera:</label>
				    <input type="checkbox" class="form-control" id="cochera" name="cochera" value="true" required>
				  </div>
				  <div class="form-group">
				    <label for="descripcion">Descripcion:</label>
				    <input type="text" class="form-control" id="descripcion" name="descripcion" required>
				  </div>
				  <div class="form-group">
				    <label for="estado">Estado:</label>
				    <input type="text" class="form-control" id="estado" name="estado" required>
				  </div><div class="form-group">
				    <label for="orientacion">Orientacion:</label>
				    <input type="text" class="form-control" id="orientacion" name="orientacion" required>
				  </div>
				  <button type="submit" class="btn btn-primary" name="action" value="altaPropiedad">Aceptar</button>
			</form>
	    </div>
	</body>
</html>