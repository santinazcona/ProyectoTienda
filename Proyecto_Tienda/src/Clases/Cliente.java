package Clases;

public class Cliente {
	private String Nick;
	private String DNI;
	private String TarjetaCredito;
	private String Direccion;
	private String Email;
	private String Contrasenia;
	public String getNick() {
		return Nick;
	}
	public void setNick(String nick) {
		Nick = nick;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getTarjetaCredito() {
		return TarjetaCredito;
	}
	public void setTarjetaCredito(String tarjetaCredito) {
		TarjetaCredito = tarjetaCredito;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getContrasenia() {
		return Contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		Contrasenia = contrasenia;
	}
	
	@Override
	public String toString() {
		return "Cliente [Nick=" + Nick + ", DNI=" + DNI
				+ ", TarjetaCredito=" + TarjetaCredito + ", Direccion="
				+ Direccion + ", Email=" + Email + ", Contrasenia="
				+ Contrasenia + "]";
	}

	
}


