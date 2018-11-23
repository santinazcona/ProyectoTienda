package Clases;

public class Ordenador extends Articulo {
	
	private String Modelo;
	private String Marca;
	private int Tamaño;
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
	public int getTamaño() {
		return Tamaño;
	}
	public void setTamaño(int tamaño) {
		Tamaño = tamaño;
	}
	public String getEspecificaciones() {
		return Especificaciones;
	}
	public void setEspecificaciones(String especificaciones) {
		Especificaciones = especificaciones;
	}
	
	
	

	@Override
	public String toString() {
		return "Ordenador [Modelo=" + Modelo + ", Marca=" + Marca + ", Tamaño=" + Tamaño + ", Especificaciones="
				+ Especificaciones + "]";
	}
}


