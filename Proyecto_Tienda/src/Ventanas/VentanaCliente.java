package Ventanas;

import java.util.LinkedList;

import Clases.Articulo;
import Clases.Compra;


public class VentanaCliente {
	public static LinkedList<Compra> carrito = new LinkedList<Compra> ();

	public static int buscarArticulo(int codigo){
		boolean enc=false;
		int pos=0;
		while(!enc && pos<carrito.size()){
			if(carrito.get(pos).getCodArticulo()==codigo)
				enc=true;
			else
				pos++;
		}
		if(enc)
			return pos;
		else return -1;
	}
	

}
