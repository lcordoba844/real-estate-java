<%@page import="util.LoginGuardJsp"%>
<%@page import="model.User"%>
<%@page import="model.Propiedad"%>
<%@page import="model.Cliente"%>
<%@page import="model.Tarea"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
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
	    	<% if (current_user != null) { %>	    
		   <h5>Tu tipo de usuario es <%=current_user.getRol() %>.</h5>
		   <%} %>
		   <div class="row">
				<div class="col-md-4 mb-3">
				<h3>Clientes</h3>
					<div>
						<form action="ClienteServlet" method="get" class="mb-2">
						    <input type="hidden" name="action" value="listarClientes">
						    <button type="submit" class="btn btn-primary">Listar Clientes</button>
						</form>
						<form action="formAltaCliente.jsp" class="mb-2">
						    <input type="hidden" name="action" value="altaCliente">
						    <button type="submit" class="btn btn-primary">Nuevo Cliente</button>
						</form>
						<form action="ClienteServlet" method="get" class="mb-2">
						    <input type="hidden" name="action" value="bajaCliente">
						    <button type="submit" class="btn btn-primary">Eliminar Cliente</button>
						</form>
						<form action="ClienteServlet" method="post" class="mb-2">
						    <input type="hidden" name="action" value="modificarCliente">
						    <input type="hidden" name="idCliente" value="1">
						    <button type="submit" class="btn btn-primary">Modificar Cliente</button>
						</form>
					</div>
			   </div>
			   <div class="col-md-4 mb-3">
				   <h3>Tareas</h3>
				   <div>
						<form action="TareaServlet" method="get" class="mb-2">
						    <input type="hidden" name="action" value="listarTareas">
						    <input type="hidden" name="idPropiedad" value="1">
						    <button type="submit" class="btn btn-primary">Listar Tareas</button>
						</form>
						<form action="formAltaTarea" class="mb-2">
						    <input type="hidden" name="action" value="asignarTarea">			    
						    <button type="submit" class="btn btn-primary">Asignar Tarea</button>
						</form>
						<form action="TareaServlet" method="post" class="mb-2">
						    <input type="hidden" name="action" value="modificarTarea">
						    <input type="hidden" name="idTarea" value="1">	
						    <button type="submit" class="btn btn-primary">Modificar Tarea</button>
						</form>
						<form action="TareaServlet" method="post" class="mb-2">
						    <input type="hidden" name="action" value="completarTarea">
						    <input type="hidden" name="idTarea" value="1">			    
						    <button type="submit" class="btn btn-primary">Completar Tarea</button>
						</form>
						<form action="TareaServlet" method="post" class="mb-2">
						    <input type="hidden" name="action" value="bajaTarea">
						    <input type="hidden" name="idTarea" value="1">	
						    <button type="submit" class="btn btn-primary">Baja Tarea</button>
						</form>
					</div>
				</div>
				<div class="col-md-4 mb-3">
				<h3>Propiedades</h3>
					<div>
						<form action="PropiedadServlet" method="get" class="mb-2">
							<input type="hidden" name="action" value="listarTodasPropiedades">
							<button type="submit" class="btn btn-primary">Listar Propiedades</button>
						</form>
						<form action="formAltaPropiedad.jsp" class="mb-2">
						    <input type="hidden" name="action" value="aFromAltaPropiedad">
						    <button type="submit" class="btn btn-primary">Alta Propiedad</button>
						</form>
						<form action="PropiedadServlet" method="get" class="mb-2">
						    <input type="hidden" name="action" value="listarTodasPropiedades">
						    <button type="submit" class="btn btn-primary">Eliminar Propiedad</button>
						</form>
						<form action="PropiedadServlet" method="get" class="mb-2">
						    <input type="hidden" name="action" value="listarTodasPropiedades">
						    <button type="submit" class="btn btn-primary">Modificar Propiedad</button>
						</form>
				   </div>
				</div>
		   </div>
		</div>
	</body>
</html>