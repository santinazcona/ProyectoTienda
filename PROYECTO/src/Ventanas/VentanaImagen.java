package Ventanas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class VentanaImagen extends JPanel {
	private static final String DIR_PROYECTO = System.getProperty("user.dir");
	private static final long serialVersionUID = -6113160396371828965L;
	private BufferedImage image;

    public VentanaImagen() {
        try {
            image = ImageIO.read(new FileInputStream(DIR_PROYECTO + "/imagenes/TiendaInformatica.jpg"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }  
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }
}