package Clases;

public class Usuario   { 
	
	
	//Atributos de la clase
	private String nombre;
	private String apellidos;
	private String direccion;
	private String poblacion;
	private int codigoPostal;
	private String codigoUsuario;
	private String passwordUsuario;
	private int cuentaBancaria;
	
	
	//Constructores de la clase
	
	public Usuario() {
		super();
		
	}
	
	public Usuario(String nombre, String apellidos, String direccion,
			String poblacion, int codigoPostal, String passwordUsuario, String codigoUsuario,
			int cuentaBancaria) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.codigoPostal = codigoPostal;
		this.codigoUsuario = codigoUsuario;
		this.passwordUsuario = passwordUsuario;
		this.cuentaBancaria = cuentaBancaria;
	}
	
	
	//Getters and Setters de la clase
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public int getCuentaBancaria() {
		return cuentaBancaria;
	}
	public void setCuentaBancaria(int cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	public String getPasswordUsuario() {
		return passwordUsuario;
	}
	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}
	

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", poblacion=" + poblacion
				+ ", codigoPostal=" + codigoPostal + ", codigoUsuario="
				+ codigoUsuario + ", passwordUsuario=" + passwordUsuario
				+ ", cuentaBancaria=" + cuentaBancaria + "]";
	}

}
