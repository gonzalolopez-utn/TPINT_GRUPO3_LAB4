<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="get" action="ServletLogin">

		<h2>
			Ingrese su nombre de usuario: <input type="text"
				name="txtNombreUsuario">
		</h2>
		<h2>
			Ingrese su contraseña: <input type="text" name="txtContra"><br>
		</h2>
		<input type="submit" name="btnIngresar" value="Ingresar">

	</form>

</body>
</html>