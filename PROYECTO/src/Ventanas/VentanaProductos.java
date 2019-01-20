package Ventanas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;


public class VentanaProductos extends JFrame {
	private static final long serialVersionUID = -3742512995086784159L;
	private JLabel photographLabel = new JLabel();
    private JToolBar buttonBar = new JToolBar();
    private JLabel jlbldesc = new JLabel("",SwingConstants.CENTER);
     

	private String imagedir = System.getProperty("user.dir") + "/imagenes/productos/";
	private String[] imageCaptions = {"Foto1","Foto2","Foto3","Foto4"};
	private String[] imageFileNames = {"prod1.png","prod2.jpg","prod3.jpg","prod4.jpg"};
     
 
    public VentanaProductos() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Ventana de Productos");
        jlbldesc.setFont(new Font("Serif", Font.BOLD, 18));
         
        // A label para mostrar la imagen
        photographLabel.setVerticalTextPosition(JLabel.BOTTOM);
        photographLabel.setHorizontalTextPosition(JLabel.CENTER);
        photographLabel.setHorizontalAlignment(JLabel.CENTER);
        photographLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
         

        buttonBar.add(Box.createGlue());
        buttonBar.add(Box.createGlue());
         
        add(jlbldesc,  BorderLayout.NORTH);
        add(buttonBar, BorderLayout.SOUTH);
        add(photographLabel, BorderLayout.CENTER);
         
        setSize(400, 300);
         
        // centra la imagen
        setLocationRelativeTo(null);
         
        // empieza la carga de la SwingWorker
        loadimages.execute();
    }
     
    /**
     * SwingWorker class que carga la imagen en el fondo
     * Utilizamos el void como el primer parametro de SwingWorker porque no necesitamos returns
     */
    private SwingWorker<Void, ThumbnailAction> loadimages = new SwingWorker<Void, ThumbnailAction>() {
         

        protected Void doInBackground() throws Exception {
            for (int i = 0; i < imageCaptions.length; i++) {
                ImageIcon icon;
                icon = createImageIcon(imagedir + imageFileNames[i], imageCaptions[i]);
                 
                ThumbnailAction thumbAction;
                if(icon != null){
                     
                    ImageIcon thumbnailIcon = new ImageIcon(getScaledImage(icon.getImage(), 32, 32));
                     
                    thumbAction = new ThumbnailAction(icon, thumbnailIcon, imageCaptions[i]);
                     
                }else{
                  
                }
            }

            return null;
        }
         
        /**
         * Procesa todas las imagenes cargadas.
         */
        @Override
        protected void process(List<ThumbnailAction> chunks) {
            for (ThumbnailAction thumbAction : chunks) {
                JButton thumbButton = new JButton(thumbAction);
                buttonBar.add(thumbButton, buttonBar.getComponentCount() - 1);
            }
        }
    };
     

    protected ImageIcon createImageIcon(String path,
            String description) {
    	try {
    		ImageIcon temp = new ImageIcon(path, description);
    		Image image = temp.getImage();
    		Image newimg = image.getScaledInstance(250, 250,  java.awt.Image.SCALE_SMOOTH);  
    		return new ImageIcon(newimg);
    	} catch(Exception e) {
    		System.out.println("No se encontro imagen " + path);
    	}
    	return null;
    }
     
    /**
     * Resizes de la imagen.
     * srcImg la imagen para re-escalar
     * w la anchura querida
     * h la altura querida
     * @return la imagen
     */
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }
     
 
    private class ThumbnailAction extends AbstractAction{
         

		private static final long serialVersionUID = -2913735980025052815L;
		/**
         *El icono es la imagen principal que queremos mostrar
         */
        private Icon displayPhoto;
         
        /**
         * La imagen completa para enseñar en el boton.
         * The thumbnail para enseñar el icono.
         * The descriptioon de la imagen.
         */
        public ThumbnailAction(Icon photo, Icon thumb, String desc){
            displayPhoto = photo;
             
            putValue(SHORT_DESCRIPTION, desc);
             

            putValue(LARGE_ICON_KEY, thumb);
        }
         

        public void actionPerformed(ActionEvent e) {
            photographLabel.setIcon(displayPhoto);
            jlbldesc.setText(getValue(SHORT_DESCRIPTION).toString());
        }
    }
}


	


