package Clases;

public class Tarjetas extends Articulo{
	
	private String Modelo;
	private String Marca;
	private int TipoTarjeta;
	private String Prestaciones;
	
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
	public int getTipoTarjeta() {
		return TipoTarjeta;
	}
	public void setTipoTarjeta(int tipoTarjeta) {
		TipoTarjeta = tipoTarjeta;
	}
	public String getPrestaciones() {
		return Prestaciones;
	}
	public void setPrestaciones(String prestaciones) {
		Prestaciones = prestaciones;
	}
	
	
	@Override
	public String toString() {
		return "Tarjetas [Modelo=" + Modelo + ", Marca=" + Marca + ", TipoTarjeta=" + TipoTarjeta + ", Prestaciones="
				+ Prestaciones + "]";
	}
	
	

}


