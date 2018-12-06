package Ventanas;

import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Clases.Articulo;


public class VentanaProductos {

		private JPanel panelOeste, panelFotos;
		private JPanel panelCentro;
		private JLabel lblFoto;
		
	private void cargarFotosArticulos(){
		
		String ruta = "Imagenes\\TiendaInformatica.jpg";
		ImageIcon im = new ImageIcon(ruta);
		im.setDescription(ruta);
		lblFoto = new JLabel(im);
		panelCentro.add(lblFoto);
	}
	
	private void cargarFotos(String nombre, String tipo){
		panelFotos.removeAll();
	//	LinkedList<String> lFotos = VentanaInicio.bd.obtenerRutasFotos(nombre, tipo);
//		for(int i=0;i<lFotos.size();i++){
//			String ruta = lFotos.get(i);
//			ImageIcon im = new ImageIcon(ruta);
//			im.setDescription(ruta);
//			JLabel lblFoto = new JLabel(im);
//			panelFotos.add(lblFoto);
		}
}


