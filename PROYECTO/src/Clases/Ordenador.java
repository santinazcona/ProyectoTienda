package Clases;

public class Ordenador extends Articulo {
	
	private String Modelo;
	private String Marca;
	private int Tama�o;
	private String Especificaciones;
	
	public String getModelo() {
		return Modelo;
	}
	
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public int getTama�o() {
		return Tama�o;
	}
	public void setTama�o(int tama�o) {
		Tama�o = tama�o;
	}
	public String getEspecificaciones() {
		return Especificaciones;
	}
	public void setEspecificaciones(String especificaciones) {
		Especificaciones = especificaciones;
	}
	
	
	

	@Override
	public String toString() {
		return "Ordenador [Modelo=" + Modelo + ", Marca=" + Marca + ", Tama�o=" + Tama�o + ", Especificaciones="
				+ Especificaciones + "]";
	}
}


