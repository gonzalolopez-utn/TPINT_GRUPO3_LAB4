<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedido prestamo</title>
</head>
<body>
<h1>Sesion como usuario: placeholder</h1>

<table class="table">
		<thead class="thead-dark">
		</thead>
		<tbody>
			<tr>
				<td>
					<button type="submit" class="btn btn-primary">Pedido
						Prestamo
					</button>
				</td>
				<td>
					<button type="submit" class="btn btn-primary">Pago
						Prestamo</button>
					</td>
				<td><button type="submit" class="btn btn-primary">Ver
						Historial</button></td><!-- Listo -->
				<td><button type="submit" class="btn btn-primary">Transferencias</button></td> 
				<td><button type="submit" class="btn btn-primary">Ver
						Informacion</button></td>
				<td>
				<button type="submit" class="btn btn-primary">Ver Cuentas</button></td><!-- ver fran -->
				<td>
				
				

			</tr>
	</table>

<h1>Pedido de Préstamo</h1>
<br />
<br />
<form action="get">
Seleccione la cantidad de dinero requerida:  <input type="text" name="txtMontoPrestamo">
<br />
<br />
Seleccione la cantidad de cuotas:  <select name="CuotasPrestamo">
						<option value="1">1</option>
						<option value="2">3</option>
						<option value="3">6</option>
						<option value="4">12</option>
						<option value="5">18</option>
						<option value="6">24</option>
					</select> 
<br />
<br />
Seleccione la cuenta en donde se depositara el préstamo:  <select name="CuentasUsuario">
						<option value="1">Cuenta Bancaria 1</option>
						<option value="2">Cuenta Bancaria 2</option>
						<option value="3">Cuenta Bancaria 3</option>
					</select> 
<br />
<br />					
<input type="submit" name="btnAceptar" value="Aceptar"/>

<br />
</form>

</body>
</html>