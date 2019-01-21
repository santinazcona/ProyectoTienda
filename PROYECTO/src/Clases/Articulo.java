package Clases;

public class Articulo {

	private int cod;
	private String nombre;
	private String tipo;
	private String foto;
	private float precio;
	private int cantidad;
	private String descripcion;
	private String tag;
	
	public Articulo(int cod, String nombre, String tipo, String foto, float precio, int cantidad, String descripcion, String tag) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.tipo = tipo;
		this.foto = foto;
		this.precio = precio;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.tag = tag;
	}
	public Articulo(int cod, String tipo, float precio) {
		this.cod = cod;
		this.tipo = tipo;
		this.precio = precio;
	}
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
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
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
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	@Override
	public String toString() {
		return "Articulo [cod=" + cod + ", nombre=" + nombre + ", tipo=" + foto
				+ ", precio=" + precio + ", cantidad=" + cantidad + ", descripcion=" + descripcion + "]";
	}
	
	
}
