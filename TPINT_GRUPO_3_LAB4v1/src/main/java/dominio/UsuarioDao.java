package dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daoImpl.Conexion;

import java.sql.Connection;


import interfaz.IUsuarioDao;

public class UsuarioDao implements IUsuarioDao {
<<<<<<< HEAD
	private static final String validate = "SELECT u.idTiposUsuario From Usuarios as u inner Join TipoUsuario as tipo on tipo.idTiposUsuario = u.idTiposUsuario where u.Usuario = ? and u.Contraseña = ? and u.Estado = 1";
=======
	private static final String validate = "SELECT u.idTipoUsuario From Usuarios as u inner Join TipoUsuario as tipo on tipo.idTipoUsuario = u.idTipoUsuario where u.Usuario = ? and u.Contra = ? and u.Estado = 1 ";
>>>>>>> b7d04c4 (test)

    public String validate(Usuario usuario) throws SQLException {
    	String result = null;
        PreparedStatement statement;
        ResultSet resultSet = null; //Guarda el resultado de la query
        try
        {
            Connection conexion = Conexion.getConexion().getSQLConexion();
            statement = conexion.prepareStatement(validate);
            statement.setString(1, usuario.getUsuario());
            statement.setString(2, usuario.getContra());
            resultSet = statement.executeQuery();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
	     while(resultSet.next()) {
		        result = resultSet.getString(1);
		    }
	            if(result == null){
	                return "3";
                }
			  else return result;
    }
    
}
