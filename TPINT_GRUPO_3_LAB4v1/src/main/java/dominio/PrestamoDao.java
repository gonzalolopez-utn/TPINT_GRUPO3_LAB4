package dominio;

import java.util.List;

import dominio.Prestamo;
public interface PrestamoDao {
	public Boolean Insert(Prestamo prestamo);
	public Boolean Modify(Prestamo prestamo, int IdPrestamo);
	public Boolean Delete(Prestamo prestamo);
	public List<Prestamo> ReadAll();
	
}
