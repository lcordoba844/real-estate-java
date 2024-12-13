<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Tarea"%>
<%@page import="model.User"%>
<%@page import="util.LoginGuardJsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ListarTareas</title>
		
		<%	
			User current_user = LoginGuardJsp.guardJsp(request, response, session);
		%>
				
	</head>
	<body>
		<jsp:include page="navbar.jsp" />
	    <div class="container mt-4">
	        <h1>Propiedad <%=request.getAttribute("idProp") %></h1>
	        <h2>Tareas</h2>
	        <div class="list-group">
	            <%
	                // Obtener la lista de propiedades desde el request
	                List<Tarea> listaTareas = (List<Tarea>) request.getAttribute("listaTareas");
	
	                // Validar que la lista no sea nula o vacía
	                if (listaTareas != null && !listaTareas.isEmpty()) {
	                    for (Tarea tarea : listaTareas) {
	            %>
	                        <div class="list-group-item">
	                            <h5 class="mb-1"><%= tarea.getDescripcion()  %></h5>
	                            <p class="mb-1">Estado de la tarea: <%= tarea.getEstado()  %></p>
	                            <small>Importe: $<%= tarea.getImporte() %></small>
	                            <p>Fecha: <%=tarea.getFecha_realizacion() %></p>
	                        </div>
	            <%
	                    }
	                } else {
	            %>
	                    <div class="list-group-item">
	                        <p class="mb-0 text-danger">No se encontraron tareas.</p>
	                    </div>
	            <%
	                }
	            %>
	        </div>
	        <div class="d-flex">
	        	<form action="calcularGastosServlet" method="post" class="mt-2 justify-content-right">
	            	<button type="submit" class="btn btn-primary" name="action" value="calcularGastos">Calcular Gastos</button>
 				</form>
	        </div>
	    </div>    
	</body>
</html>