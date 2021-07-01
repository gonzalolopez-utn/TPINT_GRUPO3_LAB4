package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Cuenta;

public class CuentasDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "admina";
	private String pass = "Spartacus.2019";
	private String dbname = "bdbancoint";
	
	
	
	public ArrayList<Cuenta> obtenerCuentas() {


	try {Class.forName("com.mysql.cj.jdbc.Driver");
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	}

	ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
	Connection conn = null;
	try {
		conn = DriverManager.getConnection(host + dbname,user,pass);
		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("Select * FROM cuentas");
		
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
	
	
	
	
}};
