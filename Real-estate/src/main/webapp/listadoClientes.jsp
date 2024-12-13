<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Cliente"%>
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
	    <div class="container mt-4">
	        <h1>Clientes</h1>
	        <% String clienteTieneProp = (String) request.getAttribute("errorMessage");
	            	if( clienteTieneProp != null) {%>
	            		<b>No se puede eliminar. <%=clienteTieneProp %> </b>
	            	<% } %>
	        <div class="list-group">
	            <%
	                // Obtener la lista de propiedades desde el request
	                List<Cliente> listaClientes = (List<Cliente>) request.getAttribute("listaClientes");
	
	                // Validar que la lista no sea nula o vacía
	                if (listaClientes != null && !listaClientes.isEmpty()) {
	                    for (Cliente c : listaClientes) {
	            %>
             <div class="list-group-item">
                 <h5 class="mb-1">Nombre: <%= c.getNombre() %> <%= c.getApellido() %> </h5>
                 <p class="mb-1">Telefono: <%= c.getTelefono() %></p>
                 <small>Mail: <%= c.getMail() %></small>
                 <div class= "d-flex gap-2">
                 	<div class="mr-2">
                   <form action="PropiedadServlet" method="get">
                   	<input type="hidden" name="idCliente" value="<%=c.getId_cliente() %>">
                   	<button type="submit" class="btn btn-primary" name="action" value="listarPropiedadesCliente">Sus Propiedades</button>
                   </form>
                  </div>
                  <div class="mr-2">
                   <form action="ClienteServlet">
                   	<input type="hidden" name="idCliente" value="<%=c.getId_cliente() %>">
                   	<button type="submit" class="btn btn-primary" name="action" value="derivarAUpdJsp">Modificar</button>
                   </form>
                  </div>
                  <div>
                   <form action="ClienteServlet" method="post">
                   	<input type="hidden" name="idCliente" value="<%=c.getId_cliente() %>"> 
                   	<button type="submit" class="btn btn-outline-danger" name="action" value="confirmarEliminacion">Eliminar</button>
                   </form>
                  </div>
                 </div>
             </div>
	            <%
	                    }
	                } else {
	            %>
	                    <div class="list-group-item">
	                        <p class="mb-0 text-danger">No se encontraron clientes.</p>
	                    </div>
	            <%
	                }
	            %>
	        </div>
	        <div class="d-flex justify-content-end mt-2 mr-4">
	            <form action="formAltaCliente.jsp">
	            	<button type="submit" class="btn btn-primary" name="action" value="altaCliente">Nuevo Cliente</button>
	            </form>
	        </div>
	    </div>    
	</body>
</html>