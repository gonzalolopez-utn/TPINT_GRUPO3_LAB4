package dominio;

import java.sql.ResultSet;
import java.util.List;

import dominio.Cliente;

public interface ClienteDao {
	boolean insert(Cliente cliente);
	boolean insertUsuario(Cliente cliente);
	boolean delete(Cliente cliente_a_eliminar);
	boolean modify(Cliente c);
	List<Cliente> readAll();
	Cliente getClientePorMail(String emailWeb, String passWeb);
	Cliente getClientePorDni(String dni);
}