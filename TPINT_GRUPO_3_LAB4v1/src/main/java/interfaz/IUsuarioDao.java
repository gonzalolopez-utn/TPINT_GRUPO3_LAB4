package interfaz;

import java.sql.SQLException;

import dominio.Usuario;

public interface IUsuarioDao {
    String validate(Usuario usuario) throws SQLException;

}
