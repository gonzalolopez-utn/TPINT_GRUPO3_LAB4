package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Cuenta;

public class CuentasDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "0000";
	private String dbname = "bdbancoint";
	
	

	
	
	
	public int eliminarCuenta(int id)
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int filas=0;
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host + dbname, user,pass);
			Statement st = cn.createStatement();
			String query = "UPDATE Cuentas SET estado=0 where idcuenta="+id;
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
	
	
	public int agregarCuenta(Cuenta cun)
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		int filas=0;
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host+ dbname, user,pass);
			Statement st = cn.createStatement();
			String query = "Insert into cuentas(idcuenta,saldo,fecha,cbu,estado,tipocuenta,usuarios_dni,usuarios_usuario) values "
					+ "('"+cun.getIdcuenta()+"','10000'+'"+cun.getFecha()+"','"+cun.getCbu()+"','"+cun.getEstado()+"','"+cun.getTipoCuenta()+"'.'"+cun.getDni()+"'.'"+cun.getUsuario()+")";
			
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
	
	
	public int modificarCuenta(Cuenta cun)
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		int filas=0;
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host+ dbname, user,pass);
			Statement st = cn.createStatement();
			String query = "UPDATE from Cuentas SET idcuenta=+ '"+cun.getIdcuenta()+",saldo,fecha,cbu,estado,tipocuenta,usuarios_dni,usuarios_usuario)" ;
					
			
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
	
	
	
	
	
	
	public ArrayList<Cuenta> obtenerCuentas() {
	
	
	
	try {Class.forName("com.mysql.cj.jdbc.Driver");
	} 
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
	Connection conn = null;
	try {
		conn = DriverManager.getConnection(host + dbname , user , pass);
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT idcuenta, saldo, fecha, cbu, estado, tipocuenta, usuarios_dni, usuarios_usuario FROM cuentas WHERE estado=1");
		
		while(rs.next()) {
			
			Cuenta cuenta = new Cuenta();
			
			
			cuenta.setIdcuenta(rs.getInt("idcuenta"));
			cuenta.setSaldo(rs.getFloat("saldo"));
			cuenta.setFecha(rs.getDate("fecha"));
			cuenta.setCbu(rs.getString("cbu"));
			cuenta.setEstado(rs.getInt("estado"));
			cuenta.setTipoCuenta(rs.getInt("tipocuenta"));
			cuenta.setDni(rs.getInt("usuarios_dni"));
			cuenta.setUsuario(rs.getString("usuarios_usuario"));
			
			lista.add(cuenta);
			
		}
	conn.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	} finally {}
	
	
	
	return lista;
	
	
	
	
}
	
	
	
};
