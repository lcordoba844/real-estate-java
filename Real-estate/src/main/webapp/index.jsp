<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>Gestion Alquiler</title>
	    <!-- Bootstrap -->
	    <link href="bootstrap-4.4.1.css" rel="stylesheet">
	    <script src="js]/bootstrap-4.4.1.js"></script>

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
		        	<a class="nav-link disabled" href="./contacto.html">Propiedades</a>
		        </li>
		        <li class="nav-item">
		            <a class="nav-link disabled" href="#">Clientes</a>
		        </li>
		        </ul>
		 	    <form action="index.jsp" method="post" class="form-inline my-2 my-lg-0">
			    	<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Iniciar Sesión</button>
			    </form>
		    </div>
		</nav>
		<div class="container mt-5">
			<div class="row justify-content-center">
		        <div class="col-lg-4">
		            <h2 class="text-center mb-4">Iniciar Sesion</h2>
		            <form action="ManageSession" method="post">
		                <div class="form-group">
		                    <label for="txtName">Usuario</label>
		                    <input type="text" class="form-control" id="txtName" name="txtName" placeholder="Ingrese su usuario" required>
		                </div>
		                <div class="form-group">
		                    <label for="txtPass">Contraseña</label>
		                    <input type="password" class="form-control" id="txtPass" name="txtPass" placeholder="Ingrese su contraseña" required>
		                </div>
		                <button type="submit" class="btn btn-primary" name="action" value="logIn">Iniciar Sesión</button>
		                <a href="#######" class="ml-2">Olvidaste tu contraseña?</a>
		                <button type="submit" class="btn btn-link" name="action" value="createAccount">Crear una cuenta</button>
		            </form>
		        </div>
		    </div>
		</div>
	</body>
		<script src="js/jquery-3.4.1.min.js"></script>
	    <script src="js/popper.min.js"></script>
</html>