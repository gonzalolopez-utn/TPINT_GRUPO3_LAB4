package interfaz;

import java.sql.SQLException;

import dominio.Usuario;

public interface IUsuarioDao {
    Boolean validate(Usuario usuario) throws SQLException;

}
