<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver Cuentas</title>
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
<h1>Mis cuentas</h1>
					
<table>
  <tr>
    <th>Fecha</th>
    <th>Saldo</th>
    <th>cbu</th>
    <th>Tipo de cuenta</th>
  </tr>
  <tr>
    <td>11-4-2021</td><td>-$100.02</td>
     <td>0002253665552636</td>
      <td>Caja de ahorro</td>
  </tr>
  <tr>
    <td>16-5-2021</td>
    <td>$10000.00 </td>
     <td>0005262336655485</td>
      <td>Cuenta Corriente</td>
  </tr>
</table>


<h1>Solicitar cuenta nueva</h1>
Seleccione el tipo de cuenta que desea:  <select name="CuentasTipo">
						<option value="1">Caja de ahorro</option>
						<option value="2">Cuenta Corriente</option>
						
					</select> 
<br />
<br />					
<input type="submit" name="btnSolicitarCuenta" value="Solicitar Cuenta"/>

<br />
</body>
</html>