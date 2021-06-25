package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.PrestamoDao;
import dominio.Prestamo;
public class PrestamoDaoImpl implements PrestamoDao {

	private static final String insert = "INSERT INTO prestamos(cliente, fecha, importe, importeinteres, plazopago, montopormes, numcoutas, idprestamo, estado) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "UPDATE prestamos SET estado = ? WHERE idprestamo = ?";
	private static final String readall = "SELECT * FROM prestamos";
	private static final String update = "UPDATE prestamos SET cliente = ?, fecha = ?, importe = ?, importeinteres = ?, plazopago = ?, montopormes = ?, numcuotas = ?, idprestamo = ?, estado = ?"+ " where idprestamo = ?";
	public Boolean Insert(Prestamo prestamo) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			
			statement.setString(1,  prestamo.getCliente());
			statement.setString(2, prestamo.getFecha());
			statement.setFloat(3, prestamo.getImporte());
			statement.setFloat(4, prestamo.getImporteInteres());
			statement.setInt(5, prestamo.getPlazoMeses());
			statement.setFloat(6, prestamo.getMontoMes());
			statement.setInt(7, prestamo.getCuotas());
			statement.setInt(8, prestamo.getIdPrestamo());
			statement.setInt(9, prestamo.getEstado());

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

	public Boolean Modify(Prestamo prestamo, int IdPrestamo) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setString(1,  prestamo.getCliente());
			statement.setString(2, prestamo.getFecha());
			statement.setFloat(3, prestamo.getImporte());
			statement.setFloat(4, prestamo.getImporteInteres());
			statement.setInt(5, prestamo.getPlazoMeses());
			statement.setFloat(6, prestamo.getMontoMes());
			statement.setInt(7, prestamo.getCuotas());
			statement.setInt(8, prestamo.getIdPrestamo());
			statement.setInt(9, prestamo.getEstado());
			
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

	public Boolean Delete(Prestamo prestamo) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			prestamo.setEstado(0);
			statement.setInt(1, prestamo.getEstado());
			statement.setInt(2, prestamo.getIdPrestamo());
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

	public List<Prestamo> ReadAll() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Prestamo> prestamo = new ArrayList<Prestamo>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				prestamo.add(getPrestamo(resultSet));
				
			} 
		
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return prestamo;
	}

	private Prestamo getPrestamo(ResultSet resultSet) throws SQLException
	{	
		Prestamo c = new Prestamo();
		c.setCliente(resultSet.getString("cliente"));
		c.setFecha(resultSet.getString("fecha"));
		c.setImporte(resultSet.getFloat("importe"));
		c.setImporteInteres(resultSet.getFloat("importeinteres"));
		c.setPlazoMeses(resultSet.getInt("plazopago"));
		c.setMontoMes(resultSet.getFloat("montopormes"));
		c.setCuotas(resultSet.getInt("numcuotas"));
		c.setIdPrestamo(resultSet.getInt("idprestamo"));
		c.setEstado(resultSet.getInt("estado"));
	
		
		return c;
	}
	
}
