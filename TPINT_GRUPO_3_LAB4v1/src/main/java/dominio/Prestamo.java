package dominio;

public class Prestamo {
	private String Cliente;
	private String Fecha;
	private float Importe;
	private float ImporteInteres;
	private int PlazoMeses;
	private float MontoMes;
	private int Cuotas;
	private int IdPrestamo;
	private int Estado;
	
	
	
	public Prestamo() {
		super();
	}
	
	
	
	public Prestamo(String cliente, String fecha, float importe, float importeInteres, int plazoMeses, float montoMes,
			int cuotas, int idPrestamo, int estado) {
		super();
		Cliente = cliente;
		Fecha = fecha;
		Importe = importe;
		ImporteInteres = importeInteres;
		PlazoMeses = plazoMeses;
		MontoMes = montoMes;
		Cuotas = cuotas;
		IdPrestamo = idPrestamo;
		Estado = estado;
	}



	public String getCliente() {
		return Cliente;
	}
	public void setCliente(String cliente) {
		Cliente = cliente;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public float getImporte() {
		return Importe;
	}
	public void setImporte(float importe) {
		Importe = importe;
	}
	public float getImporteInteres() {
		return ImporteInteres;
	}
	public void setImporteInteres(float importeInteres) {
		ImporteInteres = importeInteres;
	}
	public int getPlazoMeses() {
		return PlazoMeses;
	}
	public void setPlazoMeses(int plazoMeses) {
		PlazoMeses = plazoMeses;
	}
	public float getMontoMes() {
		return MontoMes;
	}
	public void setMontoMes(float montoMes) {
		MontoMes = montoMes;
	}
	public int getCuotas() {
		return Cuotas;
	}
	public void setCuotas(int cuotas) {
		Cuotas = cuotas;
	}
	public int getIdPrestamo() {
		return IdPrestamo;
	}
	public void setIdPrestamo(int idPrestamo) {
		IdPrestamo = idPrestamo;
	}
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int estado) {
		Estado = estado;
	}



	@Override
	public String toString() {
		return "Prestamo [Cliente=" + Cliente + ", Fecha=" + Fecha + ", Importe=" + Importe + ", ImporteInteres="
				+ ImporteInteres + ", PlazoMeses=" + PlazoMeses + ", MontoMes=" + MontoMes + ", Cuotas=" + Cuotas
				+ ", IdPrestamo=" + IdPrestamo + ", Estado=" + Estado + "]";
	}
	
	

	
	

}
