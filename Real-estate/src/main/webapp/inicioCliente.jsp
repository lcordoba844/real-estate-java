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
			User current_user = null;
		 	User.Rol rol = null;
			if(session.getAttribute("current_user") != null) {
				current_user = (User) session.getAttribute("current_user");	
				rol = (User.Rol) current_user.getTipoUser();
			} else {
				response.sendRedirect("./index.jsp");
			}
		%>
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	      <a class="navbar-brand" href="./index.jsp">GestAlq</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	      </button>
	      <div class="collapse navbar-collapse" id="navbarSupportedContent">
	        <ul class="navbar-nav mr-auto">
	          <li class="nav-item active">
	            <a class="nav-link" href="./index.jsp">Inicio</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="#">ListarPropiedades</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="#"></a>
	          </li>
	        </ul>
	 	    <form action="Logout" method="post" class="form-inline my-2 my-lg-0">
		    	<button class="btn btn-outline-danger my-2 my-sm-0" type="submit">LogOut</button>
		    </form>
	      </div>
	    </nav>
	    <br>
		<div class="container">
			<% if (User.Rol.ADMIN == rol) {
				
				
			}
			%>
		</div>
	</body>
</html>