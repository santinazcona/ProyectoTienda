package Clases;

import java.io.Serializable;

/**
 * En esta clase se definen los atributos de Almac�n: art�culo almacenado, posici�n en el almac�n, cantidad de art�culo existente.
 * @author Manuel del Hoyo Sanz
 *
 */
public class Almac�n implements Serializable{
	
	//Atributos de la clase
	
	private String articuloAlmacenado;
	private int posicionEnElALmacen;
	private int cantidadArticuloExistente;
	


	//Constructores de la clase
	
	public Almac�n(String articuloAlmacenado, int posicionEnElALmacen,
			int cantidadArticuloExistente) {
		super();
		this.articuloAlmacenado = articuloAlmacenado;
		this.posicionEnElALmacen = posicionEnElALmacen;
		this.cantidadArticuloExistente = cantidadArticuloExistente;
	}
	public Almac�n() {
		super();
		
		
		//Getters and Setters
		
	}
	public String getArticuloAlmacenado() {
		return articuloAlmacenado;
	}
	public void setArticuloAlmacenado(String articuloAlmacenado) {
		this.articuloAlmacenado = articuloAlmacenado;
	}
	public int getPosicionEnElALmacen() {
		return posicionEnElALmacen;
	}
	public void setPosicionEnElALmacen(int posicionEnElALmacen) {
		this.posicionEnElALmacen = posicionEnElALmacen;
	}
	public int getCantidadArticuloExistente() {
		return cantidadArticuloExistente;
	}
	public void setCantidadArticuloExistente(int cantidadArticuloExistente) {
		this.cantidadArticuloExistente = cantidadArticuloExistente;
	}
	}