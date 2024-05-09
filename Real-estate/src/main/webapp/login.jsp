<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <title>Login Test</title>
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap -->
    <link href="bootstrap-4.4.1.css" rel="stylesheet">
	</head>
	<body>
	    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	      <a class="navbar-brand" href="./index.html">InmobiliariaP</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	      </button>
	      <div class="collapse navbar-collapse" id="navbarSupportedContent">
	        <ul class="navbar-nav mr-auto">
	          <li class="nav-item active">
	            <a class="nav-link" href="./index.html">Inicio<span class="sr-only">(current)</span></a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="./contacto.html">Contacto</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="./quienesSomos.html">Quiénes Somos</a>
	          </li>
	          <li class="nav-item dropdown">
	            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Propiedades</a>
	            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	              <a class="dropdown-item" href="#">Acción</a>
	              <a class="dropdown-item" href="#">Otra acción</a>
	              <div class="dropdown-divider"></div>
	              <a class="dropdown-item" href="#">Otra cosa</a>
	            </div>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link disabled" href="#">CargarCasas</a>
	          </li>
	        </ul>
	 	    <form action="login.jsp" method="post" class="form-inline my-2 my-lg-0">
		    	<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Iniciar Sesión</button>
		    </form>
	      </div>
	    </nav>
		<div class="container mt=3">
	    	<div class="col-lg-4">
			    <h1 class="text-center">Inicia Sesión</h1>
			    <form action="ManageSession" method="post">
			    <table>
				    <tr>
				    	<td>Usuario</td>
				    	<td><input	type="text" name="txtName" size="40"></td>
				    </tr>
				    <tr>
				    	<td>Contraseña</td>
				    	<td><input type="password" name="txtPass" size="40"></td>
				    </tr>
				    <tr>
				    	<td><button type="submit" name="action" value="logIn">Log In</button></td>
				    	<td><a href="homePage.html">Olvidaste tu contraseña?</a>		    	
				    </tr>
				    <tr>
				    	<td><button type="submit" name="action" value="createAccount">Create an account.</button></td>
				    </tr>    
			    </table>	
			    </form>
		    </div>
		</div>    
	</body>
</html>