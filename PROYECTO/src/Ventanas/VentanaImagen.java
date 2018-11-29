package Ventanas;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class VentanaImagen extends javax.swing.JPanel {
	public VentanaImagen(){
		this.setSize(750, 387);
	}
	
	
	public void paintComponent (Graphics g){
		Dimension tamanio = getSize();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/TiendaInformatica.jpg"));
		g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}