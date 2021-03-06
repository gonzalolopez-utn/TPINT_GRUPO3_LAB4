package daoImpl;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class Conexion {
	 	public static Conexion instancia;
	    private Connection connection;

	    private Conexion()
	    {
	        try
	        {
				Class.forName("com.mysql.jdbc.Driver");// quitar si no es necesario
	            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdbancoint","root","root");
	            this.connection.setAutoCommit(false);
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }


	    public static Conexion getConexion()
	    {
	        if(instancia == null)
	        {
	            instancia = new Conexion();
	        }
	        return instancia;
	    }

	    public Connection getSQLConexion()
	    {
	        return this.connection;
	    }

	    public void cerrarConexion() throws IOException
	    {
	        try
	        {
	            this.connection.close();
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	        instancia = null;
	    }

}
