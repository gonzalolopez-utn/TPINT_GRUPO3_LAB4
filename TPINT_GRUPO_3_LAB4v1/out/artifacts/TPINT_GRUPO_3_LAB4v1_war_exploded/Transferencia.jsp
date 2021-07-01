<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transferencia</title>
</head>
<body>
<form action="">
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


<h1>Transferencia bancaria</h1>
<br />
<br />
Seleccione la cuenta de donde realizará la transferencia:  <select name="CuentasUsuario">
						<option value="1">Cuenta Bancaria 1</option>
						<option value="2">Cuenta Bancaria 2</option>
						<option value="3">Cuenta Bancaria 3</option>
					</select> 
<br />
<br />
Seleccione el tipo de cuenta a donde va a transferir:
		
		Cuenta Propia        <input type="radio" name="tecnologias" value="Java">
		Cuenta Ajena         <input type="radio" name="tecnologias" value="PHP">
		
<br />
<br />

Ingrese CBU: <input type="text" name="TransferenciaCBU"/>
				   <input type="submit" name="btnConfirmarTransferencia" value="Confirmar Transferencia"/>
<br />
<br />

<br />
<br />
</form>
</body>
</html>