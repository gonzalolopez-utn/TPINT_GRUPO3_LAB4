package dominio;

public class Cliente {
	private String Nombre;
	private String Apellido;
	private String Sexo;
	private String Nacionalidad;
	private String CorreoElectronico;
	private String Telefono;
	private String Cuil;
	private String Dni;
	private String FechaNac;
	private String Localidad;
	private String Provincia;
	private String Direccion;
	private int TipoUsuario;
	private int Estado;
	private Usuario usuario;
	
	
	public Cliente()
	{
		super();
		CorreoElectronico = "Sin correo";
		Estado = 1;
		TipoUsuario = 1;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Cliente(String nombre, String apellido, String sexo, String nacionalidad, String correoElectronico, String telefono, String cuil, String dni, String fechaNac, String localidad, String provincia, String direccion, int tipoUsuario, int estado, Usuario usuario) {
		Nombre = nombre;
		Apellido = apellido;
		Sexo = sexo;
		Nacionalidad = nacionalidad;
		CorreoElectronico = correoElectronico;
		Telefono = telefono;
		Cuil = cuil;
		Dni = dni;
		FechaNac = fechaNac;
		Localidad = localidad;
		Provincia = provincia;
		Direccion = direccion;
		TipoUsuario = tipoUsuario;
		Estado = estado;
		this.usuario = usuario;
	}

	// Getters and Setters
	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getApellido() {
		return Apellido;
	}


	public void setApellido(String apellido) {
		Apellido = apellido;
	}


	public String getSexo() {
		return Sexo;
	}


	public void setSexo(String sexo) {
		Sexo = sexo;
	}


	public String getNacionalidad() {
		return Nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}


	public String getCorreoElectronico() {
		return CorreoElectronico;
	}


	public void setCorreoElectronico(String correoElectronico) {
		CorreoElectronico = correoElectronico;
	}


	public String getTelefono() {
		return Telefono;
	}


	public void setTelefono(String telefono) {
		Telefono = telefono;
	}


	public String getCuil() {
		return Cuil;
	}


	public void setCuil(String cuil) {
		Cuil = cuil;
	}


	public String getDni() {
		return Dni;
	}


	public void setDni(String dni) {
		Dni = dni;
	}


	public String getFechaNac() {
		return FechaNac;
	}


	public void setFechaNac(String fechaNac) {
		FechaNac = fechaNac;
	}


	public String getLocalidad() {
		return Localidad;
	}


	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}


	public String getProvincia() {
		return Provincia;
	}


	public void setProvincia(String provincia) {
		Provincia = provincia;
	}


	public String getDireccion() {
		return Direccion;
	}


	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	
	public int getTipoUsuario() {
		return TipoUsuario;
	}


	public void setTipoUsuario(int tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}


	public int getEstado() {
		return Estado;
	}


	public void setEstado(int estado) {
		Estado = estado;
	}

	

}
