package Clases;

public class Articulo {

	private int cod;
	private String nombre;
	private String tipo;
	private float precio;
	private int cantidad;
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public String toString() {
		return "Articulo [cod=" + cod + ", nombre=" + nombre + ", tipo=" + tipo
				+ ", precio=" + precio + ", cantidad=" + cantidad + "]";
	}
	
	
}
