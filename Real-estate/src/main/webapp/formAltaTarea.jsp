<%@page import="util.LoginGuardJsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Nueva Tarea</title>
		<!-- Bootstrap -->
	    <link href="bootstrap-4.4.1.css" rel="stylesheet">
		<!-- Java -->
		<%
			User current_user = LoginGuardJsp.guardJsp(request, response, session);
		
			String idProp = (String) request.getParameter("idProp");
		%>
	</head>
	<body>
		<jsp:include page="navbar.jsp" />
	    <br>
	    <div class="container">
	    	<h1>Asignar Tarea</h1>
	    	<form action="TareaServlet" method="post">
	    		<input type="hidden" name="idProp" value=<%=idProp %>>
				  <input type="hidden" name="idPropiedad" value="2">
				  <div class="form-group">
				    <label for="descripcion">Descripcion:</label>
				    <input type="text" class="form-control" id="descripcion" name="descripcion" required>
				  </div>
				  <div class="form-group">
				    <label for="estado">Estado (PENDIENTE/REALIZADO):</label>
				    <input type="text" class="form-control" id="estado" name="estado" required>
				  </div>
				  <div class="form-group">
				    <label for="pagado">Pagado: </label>
				    <input type="checkbox" class="form-control" id="pagado" name="pagado" value="true">
				  </div>
				  <div class="form-group">
				    <label for="fecha_asignacion">Fecha asignacion:</label>
				    <input type="date" class="form-control" id="fecha_asignacion" name="fecha_asignacion">
				  </div>
				  <div class="form-group">
				    <label for="fecha_pago">Fecha pago:</label>
				    <input type="date" class="form-control" id="fecha_pago" name="fecha_pago">
				  </div>
				  <div class="form-group">
				    <label for="fecha">Fecha realizado:</label>
				    <input type="date" class="form-control" id="fecha_realizado" name="fecha_realizado">
				  </div>
				  <div class="form-group">
				    <label for="importe">Importe:</label>
				    <input type="number" class="form-control" id="importe" name="importe" required>
				  </div>
				  <button type="submit" class="btn btn-primary" name="action" value="asignarTarea">Asignar</button>
			</form>
	    </div>
	</body>
</html>