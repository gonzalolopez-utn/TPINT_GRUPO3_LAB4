<%@page import="dominio.Cuenta"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

		
					<button type="button" class="btn btn-primary" name="btnAgregarCuenta">Agregar
					</button>
				
				
				<form method="post" action="ServletCuentas">	
				<input type="submit" name="Listar" value="Listar">
				</form>
				
				<%
				ArrayList<Cuenta> listCuentas = null;
				if(request.getAttribute("ListaC")!=null){}
				listCuentas = (ArrayList<Cuenta>) request.getAttribute("ListaC");
				
				
				%>
				
				"<table class='table table-striped table-class' id= 'table-id'>
    	   		<tr>
    	       <th>Id Cuenta</th>
    	        <th>Saldo</th>
    	        <th>Fecha</th>
    	        <th>CBU</th>
    	       <th>Estado</th>
    	       <th>Tipo de cuenta</th>
    	       <th>DNI </th>
    	       <th>Nombre de usuario</th>
    	       </tr>
    	       <%	
    	       if(listCuentas!=null)
    	       for(Cuenta cun :listCuentas )	{
    	    	   %>
    	       
    	       <tr>
    	       <th>Id Cuenta</th>
    	       <th><% cun.getIdcuenta(); %></th>
    	        <th>Saldo</th>
    	        <th><% cun.getSaldo(); %></th>
    	        <th>Fecha</th>
    	        <th><% cun.getSaldo(); %></th>
    	        <th>CBU</th>
    	        <th><% cun.getCbu(); %></th>
    	       <th>Estado</th>
    	       <th><% cun.getEstado(); %></th>
    	       <th>Tipo de cuenta</th>
    	       <th><% cun.getTipoCuenta(); %></th>
    	       <th>DNI </th>
    	       <th><% cun.getDni(); %></th>
    	       <th>Nombre de usuario</th>
    	       <th><% cun.getUsuario(); %></th>
    	       </tr>
    	       <% }; %>
				</table>
</body>
</html>