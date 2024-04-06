<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sesion Iniciada</title>
	</head>
	<body>
		<h3>Sesion iniciada correctamente. Bienvenido, <%= (String) session.getAttribute("username") %> </h3>

		<form action="ManageSession" method="get">
		<table>
			<tr>
				<td>Si desea cerrar sesion de click presione el siguiente boton</td>
			</tr>
			<tr>
				<td><button type="submit">LogOut</button></td>
			</tr>
		</table>
		</form>
	</body>
</html>