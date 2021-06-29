<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Historial</title>
<style>
.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
}

.pagination a.active {
  background-color: dodgerblue;
  color: white;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>

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

<h1>Historial</h1>
Seleccione la cuenta que desea consultar:  <select name="CuentasUsuario">
						<option value="1">Cuenta Bancaria 1</option>
						<option value="2">Cuenta Bancaria 2</option>
						<option value="3">Cuenta Bancaria 3</option>
					</select> 

<table>
  <tr>
    <th>Fecha</th>
    <th>Detalle</th>
    <th>Tipo de movimiento</th>
    <th>Importe</th>
  </tr>
  <tr>
    <td>11-4-2021</td>
    <td>Pago a cliente 22094</td>
     <td>Pago de préstamo</td>
      <td>-$100.02</td>
  </tr>
  <tr>
    <td>16-5-2021</td>
    <td>Alta de cuenta. </td>
     <td>Alta de cuenta.</td>
      <td>$10000.00</td>
  </tr>
</table>
<div class="pagination">
  <a href="#">&laquo;</a>
  <a href="#">1</a>
  <a class="active" href="#">2</a>
  <a href="#">3</a>
  <a href="#">4</a>
  <a href="#">5</a>
  <a href="#">6</a>
  <a href="#">&raquo;</a>
</div>
</body>
</html>