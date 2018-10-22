package Clases;

public class Compra {
	
	private String DNICliente;
	private int CodArticulo;
	private double PrecioT;
	
	public Compra(String dNICliente, int codArticulo, double precioT) {
		super();
		DNICliente = dNICliente;
		CodArticulo = codArticulo;
		PrecioT = precioT;
	}

	public String getDNICliente() {
		return DNICliente;
	}

	public void setDNICliente(String dNICliente) {
		DNICliente = dNICliente;
	}

	public int getCodArticulo() {
		return CodArticulo;
	}

	public void setCodArticulo(int codArticulo) {
		CodArticulo = codArticulo;
	}

	public double getPrecioT() {
		return PrecioT;
	}

	public void setPrecioT(double precioT) {
		PrecioT = precioT;
	}

	@Override
	public String toString() {
		return "Compra [DNICliente=" + DNICliente + ", CodArticulo="
				+ CodArticulo + ", PrecioT=" + PrecioT + "]";
	}
	
	
	

}


