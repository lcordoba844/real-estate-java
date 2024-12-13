<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Propiedad"%>
<%@page import="model.User"%>
<%@page import="model.Cliente"%>
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
	    <div class="container mt-4">
	    	<% 
	    		if ((Cliente) request.getAttribute("clienteActual") != null) {
	    			Cliente clienteActual = (Cliente) request.getAttribute("clienteActual");
	    			int idCliente = clienteActual.getId_cliente();
	    			%>
	    			<h1>Propiedades de <%=clienteActual.getNombre() %> </h1>
	    	<%
	    		} else {	    		    	
	    	%>
	    	<h1>Todas las Propiedades</h1>
	    	<% 
	    	} 
	    	%>
	    	
	        
	        <div class="list-group">
	            <%
	                // Obtener la lista de propiedades desde el request
	                List<Propiedad> listaPropiedades = (List<Propiedad>) request.getAttribute("listaPropiedades");
	
	                // Validar que la lista no sea nula o vacía
	                if (listaPropiedades != null && !listaPropiedades.isEmpty()) {
	                    for (Propiedad propiedad : listaPropiedades) {
	            %>
	                        <div class="list-group-item">
	                            <h5 class="mb-1">Propiedad <%=propiedad.getId_propiedad() %></h5>
	                            <p class="mb-1"><%= propiedad.getCant_dormitorios() %> habitaciones</p>
	                            <p class="mb-1"><%= propiedad.getDescripcion()  %></p>
	                            <p class="mb-1"><%= propiedad.getTipo_propiedad()  %></p>
	                            <small>Precio: $<%= propiedad.getPrecio() %></small>
	                            <p>PropietarioID: <%=propiedad.getId_propietario() %></p>
	                            <div class="d-flex gap-2">
		                            <form action="TareaServlet" method="get" class="mr-2">	 
		                            	<button type="submit" class="btn btn-primary" name="idPropiedad" value="<%=propiedad.getId_propiedad() %>">Listar Tareas</button>
		                            </form>
		                            <form action="formAltaTarea.jsp?idProp=<%=propiedad.getId_propiedad() %>">
		                            	<button type="submit" class="btn btn-primary">Asignar Tarea</button>
		                            </form>
		                            <form action="PropiedadServlet" method="post" class="ml-2">	 
		                            	<input type="hidden" name="idPropiedad" value="<%=propiedad.getId_propiedad() %>">
		                            	<button type="submit" class="btn btn-primary" name="action" value="aFormUpdPropiedad">Modificar Propiedad</button>
		                            </form>
		                            <form action="PropiedadServlet" method="post" class="ml-2">
		                            	<button type="submit" class="btn btn-outline-danger" name="action" value="eliminarPropiedad">Eliminar Propiedad</button>
		                            </form>
	                            </div>
	                        </div>	                        
	            <%
	                    }
	                } else {
	            %>
	                    <div class="list-group-item">
	                        <p class="mb-0 text-danger">No se encontraron propiedades.</p>
	                    </div>
	            <%
	                }
	            %>
	        </div>
	        <div class="mt-2 mb-2">
	           	<form action="PropiedadServlet" method="post">
	            	<button type="submit" class="btn btn-primary" name="action" value="aFormAltaPropiedad">Nueva Propiedad</button>
	            </form>
           </div>
	    </div>    
	</body>
</html>