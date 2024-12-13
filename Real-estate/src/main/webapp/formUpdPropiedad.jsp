<%@page import="util.LoginGuardJsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import="model.Propiedad" %>
<%@ page import="model.Casa" %>
<%@ page import="model.Departamento" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Modificar Propiedad</title>
		<!-- Bootstrap -->
	    <link href="bootstrap-4.4.1.css" rel="stylesheet">
		<!-- Java -->
		<%
			User current_user = LoginGuardJsp.guardJsp(request, response, session);
			
			
			Propiedad propiedad = (Propiedad) request.getAttribute("propiedad");
		%>
	</head>
	<body>
		<jsp:include page="navbar.jsp" />
	    <br>
	    <div class="container">
	    	<h1>Modificar Propiedad</h1>
	    	<br>
	    	<% if (request.getAttribute("idCliente") != null) { %>
	    	<form action="PropiedadServlet" method="post">
	    		<input type="hidden" name="idCliente" value=<%=request.getAttribute("idCliente")%>>>
	    		<% } else { %>
	    			<div class="form-group">
					    <label for="idPropietario">idPropietario</label>
					    <input type="text" class="form-control" id="idPropietario" name="idPropietario" value="<%=propiedad.getId_propietario() %>" required>
				  </div>
				 <% } %>
				  <div class="form-group">
				    <label for="nombre">Casa o Departamento:</label>
				    <input type="text" class="form-control" id="tipo_propiedad" name="tipo_propiedad" value="<%=propiedad.getTipo_propiedad()%>" required>
				  </div>
				  <div class="form-group">
				    <label for="cant_baños">Cantidad de baños:</label>
				    <input type="text" class="form-control" id="cant_baños" name="cant_baños" value="<%=propiedad.getCant_baños() %>" required>
				  </div>
				  <div class="form-group">
				    <label for="cant_dormitorios">Cantidad de dormitorios:</label>
				    <input type="text" class="form-control" id="cant_dormitorios" name="cant_dormitorios" value="<%= propiedad.getCant_dormitorios()%>" required>
				  </div>
				  <div class="form-group">
				    <label for="precio">Precio:</label>
				    <input type="number" class="form-control" id="precio" name="precio" value="<%=propiedad.getPrecio() %>" required>
				  </div>
				  <div class="form-group">
				    <label for="cochera">Cochera:</label>
				    <input type="checkbox" class="form-control" id="cochera" name="cochera" value="true" value="<%=propiedad.tieneCochera() %>" required>
				  </div>
				  <div class="form-group">
				    <label for="descripcion">Descripcion:</label>
				    <input type="text" class="form-control" id="descripcion" name="descripcion" value="<%=propiedad.getDescripcion() %>" required>
				  </div>
				  <div class="form-group">
				    <label for="estado">Estado:</label>
				    <input type="text" class="form-control" id="estado" name="estado" value="<%=propiedad.getEstado() %>" required>
				  </div><div class="form-group">
				    <label for="orientacion">Orientacion:</label>
				    <input type="text" class="form-control" id="orientacion" name="orientacion" value="<%=propiedad.getOrientacion() %>" required>
				  </div>
				  <button type="submit" class="btn btn-primary" name="action" value="modificarPropiedad">Aceptar</button>
			</form>
	    </div>
	</body>
</html>