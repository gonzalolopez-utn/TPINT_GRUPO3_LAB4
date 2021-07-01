<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1>Bienvenido ADMINISTRADOR!</h1>



	Seleccione que desea hacer:

	<table class="table">
		<thead class="thead-dark">
		</thead>
		<tbody>
			<tr>
				<td>
					<button type="submit" class="btn btn-primary">ABML CLIENTES
					</button>
				</td>
				<td>
					<button type="submit" class="btn btn-primary">ABML CUENTAS</button>
					</td>
				<td><button type="submit" class="btn btn-primary">Autorización Prestamos</button></td>
				<td><button type="submit" class="btn btn-primary">Informes</button></td> 

			</tr>
	</table>

<br>
<h2>ABML CUENTAS</h2>

<table class="table">
		<thead class="thead-dark">
		</thead>
		<tbody>
			<tr>
				<td>
					<button type="submit" class="btn btn-primary" name="btnAgregarCuenta">Agregar
					</button>
				</td>
				<td>
					<button type="submit" class="btn btn-primary" name="btnModifCuenta">Modificar</button>
					</td>
				<td><button type="submit" class="btn btn-primary" name="btnEliminCuenta">Eliminar</button></td>
				<td><button type="submit" class="btn btn-primary" name="btnModifCuenta">Listar</button></td> 

			</tr>
	</table>
<br><br>	
saldo inicial: <input type="text" name="txtSaldo"/>
<br>
Fecha: <input type="text" name="txtfecha"/>
<br>
CBU: <input type="text" name="txtfecha"/>
<br>
Estado :
		
		Activa        <input type="radio" name="rbtnSexo" value="Masculino">
		Inactiva         <input type="radio" name="rbtnSexo" value="Femenino">
		
<br>
Tipo de cuenta: <select name="tCuentasUsuario">
						<option value="Cuenta Corriente">Cuenta Corriente</option>
						<option value="Caja de ahorro 1">Caja de ahorro 1</option>
						<option value="Caja de ahorro 2">Caja de ahorro 2</option>
					</select>
<br><br><br>					
<button type="submit" class="btn btn-primary" name="btnaceptarcuenta">Aceptar</button>					
</body>
</html>