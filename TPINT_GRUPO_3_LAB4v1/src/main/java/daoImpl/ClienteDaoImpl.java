package daoImpl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import dominio.Cliente;
import dominio.Cuenta;
import dominio.ClienteDao;

public class ClienteDaoImpl implements dominio.ClienteDao
{
	private static final String insert = "INSERT INTO clientes(dni, cuil, nombre, apellido, sexo, nacionalidad, fechanac, direccion, localidad, provincia, correo, telefono) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String insertUsuario = "INSERT INTO Usuarios(usuario, contra, estado, dni, idtiposusuario) VALUES(?, ?, ?, ?, ?)";
	private static final String delete = "UPDATE clientes SET estado = ? where Dni = ?";
	private static final String readall = "SELECT * FROM clientes";
	private static final String readByMail = "Select * from clientes where correo = ? and password = ?";
	private static final String update = "UPDATE clientes SET cuil = ?, nombre = ?, apellido = ?, sexo = ?, nacionalidad = ?, fechanac = ?, direccion = ?, localidad = ?, provincia = ?, correo = ?, telefono = ? where dni = ?";
	private static final String Provincia = null;
	private static final String readUserForDni = "SELECT dni, cuil, nombre, apellido, sexo, nacionalidad, fechanac, direccion, localidad, provincia, correo, telefono from clientes where dni = ?";
	private Date fecha;

	public boolean insert(Cliente cliente)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, cliente.getDni());
			statement.setString(2, cliente.getCuil());
			statement.setString(3, cliente.getNombre());
			statement.setString(4, cliente.getApellido());
			statement.setString(5, cliente.getSexo());
			statement.setString(6, cliente.getNacionalidad());
			statement.setString(7, cliente.getFechaNac());
			statement.setString(8, cliente.getDireccion());
			statement.setString(9, cliente.getLocalidad());
			statement.setString(10, cliente.getProvincia());
			statement.setString(11, cliente.getCorreoElectronico());
			statement.setString(12, cliente.getTelefono());

			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return isInsertExitoso;
	}

	public boolean insertUsuario(Cliente cliente)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insertUsuario);
			statement.setString(1, cliente.getUsuario().getUsuario());
			statement.setString(2, cliente.getUsuario().getContra());
			statement.setInt(3,1);
			statement.setString(4, cliente.getDni());
			statement.setInt(5,2);

			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return isInsertExitoso;
	}



	public boolean delete(Cliente cliente)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			cliente.setEstado(0);
			statement.setInt(1, cliente.getEstado());
			statement.setString(2, cliente.getDni());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	public boolean modify(Cliente cliente) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setString(1, cliente.getCuil());
			statement.setString(2, cliente.getNombre());
			statement.setString(3, cliente.getApellido());
			statement.setString(4, cliente.getSexo());
			statement.setString(5, cliente.getNacionalidad());
			statement.setString(6, cliente.getFechaNac());
			statement.setString(7, cliente.getDireccion());
			statement.setString(8, cliente.getLocalidad());
			statement.setString(9, cliente.getProvincia());
			statement.setString(10, cliente.getCorreoElectronico());
			statement.setString(11, cliente.getTelefono());
			statement.setString(12, cliente.getDni());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}

	///Busca el cliente por mail y contrase�a.
	///Si el cliente no existe, por constructor
	///Genera un cliente con "Sin Correo" y "Sin password"
	///Para utilizarlo en el login.
	public Cliente getClientePorMail(String emailWeb, String passWeb) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		ResultSet resultSet; //Guarda el resultado de la query
		try {
			// Esta variable la inicialize para que no tire error, pero hay que ver.
			//String readByMail = null;
			
			statement = conexion.getSQLConexion().prepareStatement(readByMail);
			statement.setString(1, emailWeb);
			statement.setString(2, passWeb);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {

				return getCliente(resultSet);
			}
			
		} catch (Exception e) {
			return new Cliente();
		}
		
		return new Cliente();
			
	}

	@Override
	public Cliente getClientePorDni(String dni) {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		Cliente cliente = new Cliente();
		Conexion conexion = Conexion.getConexion();
		try
		{
			statement = conexion.getSQLConexion().prepareStatement(readUserForDni);
			statement.setString(1, dni);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				cliente.setDni(resultSet.getString(1));
				cliente.setCuil(resultSet.getString(2));
				cliente.setNombre(resultSet.getString(3));
				cliente.setApellido(resultSet.getString(4));
				cliente.setSexo(resultSet.getString(5));
				cliente.setNacionalidad(resultSet.getString(6));
				cliente.setFechaNac(resultSet.getString(7));
				cliente.setDireccion(resultSet.getString(8));
				cliente.setLocalidad(resultSet.getString(9));
				cliente.setProvincia(resultSet.getString(10));
				cliente.setCorreoElectronico(resultSet.getString(11));
				cliente.setTelefono(resultSet.getString(12));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return cliente;
	}

	public List<Cliente> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				clientes.add(getCliente(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return clientes;
	}
	
	
	public Cliente getCliente(ResultSet resultSet) throws SQLException
	{
		
		int Dni = Integer.parseInt(resultSet.getString("dni"));
		String Cuil = resultSet.getString("cuil");
		String Nombre = resultSet.getString("nombre");
		String Apellido = resultSet.getString("apellido");
		String Sexo = resultSet.getString("sexo");
		String Nacionalidad = resultSet.getString("nacionalidad");
		String FechaNac = resultSet.getString("fechanac");
		String Direccion = resultSet.getString("direccion");
		String Localidad = resultSet.getString("localidad");
		String Provincia = resultSet.getString("provincia");
		String CorreoElectronico = resultSet.getString("correo");
		String Telefono = resultSet.getString("telefono");
		String Usuario = resultSet.getString("usuario");
		String Password = resultSet.getString("password");
		int TipoUsuario = resultSet.getInt("tipousuario");
		int Estado = resultSet.getInt("estado");
		
		//return new Cliente(Nombre, Apellido, Sexo, Nacionalidad, CorreoElectronico, Telefono, Usuario, Password, Cuil, Dni, FechaNac, Localidad, Provincia, Direccion, TipoUsuario, Estado);
		return null;
	}
	
	

}