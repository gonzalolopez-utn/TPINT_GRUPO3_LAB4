<%@ page import="dominio.Cliente" %>
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
<h2>ABML CLIENTES</h2>

<table class="table">
		<thead class="thead-dark">
		</thead>
		<tbody>
			<tr>
				<td>
					<form action="AMBClientes.jsp" method="get">
					<input type="submit"  name="btnAgregarCli" value="Agregar">
					</form>
				</td>
				<td>
					<form action="AMBClientes.jsp">
					<input type="submit" value="Modificar" name="btnModifCli">
					</form>
					</td>
				<td>
					<form action=""><button type="submit" class="btn btn-primary" name="btnEliminCli">Eliminar</button></form></td>
				<td>
					<form action=""><button type="submit" class="btn btn-primary" name="btnModifCli">Listar</button></form></td>

			</tr>
	</table>
<br><br>
<% if (request.getParameter("btnAgregarCli")!=null)
{%>
<form action="ServletClientes" method="get">
	DNI: <input type="number" required name="txtDNI"/>
	<br>
	CUIL: <input type="number" required name="txtCuil"/>
	<br>
	Nombre: <input type="text" required name="txtNombreCli"/>
	<br>
	Apellido: <input type="text" required name="txtApellido"/>
	<br>
	Sexo :
	Masculino        <input type="radio" name="rbtnSexo" value="Masculino">
	Femenino         <input type="radio" name="rbtnSexo" value="Femenino">
	<br>
	Nacionalidad: <input type="text" required name="txtNacionalidad"/>
	<br>
	Fecha de nacimiento: <input type="date" required name="txtfecNac"/>
	<br>
	Dirección: <input type="text" required name="txtDireccion"/>
	<br>
	Localidad: <input type="text" required name="txtLocalidad"/>
	<br>
	Provincia: <select name="Provincia">
	<option value="Buenos Aires">Buenos Aires</option>
	<option value="Cordoba">Cordoba</option>
	<option value="Santa fe">Santa fe</option>
</select>
	<br>
	Correo: <input type="email" required name="txtCorreo"/>
	<br>
	Teléfono: <input type="number" required name="txtTelefono"/>
	<br>

	<h3>Asignar Usuario al nuevo cliente:</h3>
	Usuario: <input type="text" required name="txtUsuario"/> <br>
	Contraseña: <input type="text" required name="txtPass"/>
	<br>
	<button type="submit" class="btn btn-primary" name="aceptarCliente">Aceptar </button>
</form>
<%} %>

<% if(request.getParameter("Creado")!=null)
{%>
<%	if (request.getParameter("Creado").toString().equals("true"))
{%>
<h1>Se creo el usuario con exito</h1>

<% }%>
<%}%>





<% if (request.getParameter("btnModifCli")!=null)
	{%>

	<form action="ServletClientes" method="post">
		<input type="text" name="txtVerificarDni">
		<input type="submit" name="validarCliente" value="Validar cliente">
	</form>
<%} %>

<% if (request.getAttribute("ClienteValidado")!=null)

{	Cliente cliente = (Cliente) request.getAttribute("ClienteValidado");
%>


	<form action="ServletClientes" method="post">
	DNI: <input type="text" name="txtDNI" value="<%= cliente.getDni() %>" readonly>
	<br>
	CUIL: <input type="text" name="txtCuil" value="<%= cliente.getCuil() %>"/>
		<br>
		Nombre: <input type="text" name="txtNombreCli" value="<%= cliente.getNombre() %>"/>
	<br>
	Apellido: <input type="text" name="txtApellido" value="<%= cliente.getApellido() %>"/>
	<br>
	Sexo :		
			Masculino        <input type="radio" name="rbtnSexo" value="Masculino">
			Femenino         <input type="radio" name="rbtnSexo" value="Femenino">
	<br>
	Nacionalidad: <input type="text" name="txtNacionalidad" value="<%= cliente.getNacionalidad() %>"/>
	<br>	
	Fecha de nacimiento: <input type="text" name="txtfecNac" value="<%= cliente.getFechaNac() %>"/>
	<br>	
	Dirección: <input type="text" name="txtDireccion" value="<%= cliente.getDireccion() %>"/>
	<br>		
	Localidad: <input type="text" name="txtLocalidad" value="<%= cliente.getLocalidad() %>"/>
	<br>
	Provincia: <select name="Provincia">
							<option value="Buenos Aires">Buenos Aires</option>
							<option value="Cordoba">Cordoba</option>
							<option value="Santa fe">Santa fe</option>
						</select> 
	<br>
	Correo: <input type="text" name="txtCorreo" value="<%= cliente.getCorreoElectronico() %>"/>
	<br>
	Teléfono: <input type="text" name="txtTelefono" value="<%= cliente.getTelefono() %>"/>
		<br>
		<input type="submit" name="btnModificarCliente" value="Modificar">
	<br></form>
<%} %>

<% if(request.getParameter("ClienteModificado")!=null)
{%>
<%	if (request.getParameter("ClienteModificado").toString().equals("true"))
{%>
<h1>Se creo el usuario con exito</h1>

<% }%>
<%}%>
</body>
</html>