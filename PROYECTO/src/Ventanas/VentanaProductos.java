package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

import Clases.Articulo;
import Clases.Carrito;
import Clases.Usuario;
import TiendaBD.BD;


public class VentanaProductos extends JFrame {
	private static final long serialVersionUID = -3742512995086784159L;
	private JLabel photographLabel = new JLabel();
    private JToolBar buttonBar = new JToolBar();
    
    private JButton btnBuscar = new JButton("Buscar Producto");
    private JLabel jlbldesc = new JLabel("",SwingConstants.CENTER);
    
    private int CODIGO = 0;
    private String TIPO = "";
     
    private MissingIcon placeholderIcon = new MissingIcon();

	private String imagedir = System.getProperty("user.dir") + "/imagenes/productos/";
	private String[] imageCaptions;
	private String[] imageFileNames;
	
	private ArrayList<Articulo> articulos = new ArrayList<Articulo>();

	
    /**
     * Constructor por defecto
     */
    public VentanaProductos(Usuario usu) {
    	
    	articulos = BD.extraerArticulos();
    	
    	int productosTotal = articulos.size();
    	
    	imageCaptions = new String[productosTotal];
    	imageFileNames = new String[productosTotal];
    	
    	int contador = 0;
    	for(Articulo artc : articulos) {
    		imageCaptions[contador] = "<html>"
    						+ "<p>Tipo: Tarjeta</p>"
    						+ "<p>Codigo: "+artc.getCod() + "</p>"
    						+ "<p>Desc: "+artc.getDescripcion() + "</p>"
    						+ "<p>Precio: " + artc.getPrecio()+"</p>"
    						+ "</html>";
    		imageFileNames[contador] = artc.getFoto();
    		contador++;
    	}
    	
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Ventana de Productos");
        
        JPanel jpanel1 = new JPanel();
        jpanel1.setLayout(new BorderLayout());
        jlbldesc.setFont(new Font("Serif", Font.BOLD, 18));
        jpanel1.add(jlbldesc, BorderLayout.CENTER);
        
        //boton buscar
    	btnBuscar.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			VentanaBuscador abrirBuscador = new VentanaBuscador(articulos);
    			abrirBuscador.setVisible(true);
    		} 
		});
        
        jpanel1.add(btnBuscar, BorderLayout.NORTH);

        
        // Label para mostrar las imagenes
        photographLabel.setVerticalTextPosition(JLabel.BOTTOM);
        photographLabel.setHorizontalTextPosition(JLabel.CENTER);
        photographLabel.setHorizontalAlignment(JLabel.CENTER);
        photographLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
         
      
        buttonBar.add(Box.createGlue());
        buttonBar.add(Box.createGlue());
        
        //compra
        JPanel panelCompra = new JPanel();
        panelCompra.setLayout(new FlowLayout());
        JButton carrito = new JButton("Agregar a Carrito");
        carrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        if(CODIGO == 0 || TIPO.equals("")) {
					JOptionPane.showMessageDialog(null,
							"Seleccione un articulo!",
							"Error",
							JOptionPane.ERROR_MESSAGE);
					return;
		        }
		        Articulo art = BD.extraerArticulos(CODIGO);
		        //Creamos carrito
		        Carrito carrito = new Carrito(art.getCod(), art.getNombre(), art.getTipo(), art.getFoto(), art.getPrecio(), art.getCantidad(), art.getDescripcion(), art.getTag(), usu.getNombre());
		        BD.insertarArticuloCarrito(usu, carrito);
		        
				JOptionPane.showMessageDialog(null,
						"Articulo ha sido agregado a su carrito de compras!",
						"Articulo agregado",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
        
        
        panelCompra.add(carrito);
        
         
        add(jpanel1,  BorderLayout.NORTH);
        add(buttonBar, BorderLayout.SOUTH);
        add(photographLabel, BorderLayout.CENTER);
        add(panelCompra, BorderLayout.EAST);
         
        setSize(500, 400);
         
        // centrar en pantalla
        setLocationRelativeTo(null);
         
     
        loadimages.execute();
    }
     
    /**
     * SwingWorker class 
     * 
     *
     * We use Void as the first SwingWroker 
     * 
     */
    private SwingWorker<Void, ThumbnailAction> loadimages = new SwingWorker<Void, ThumbnailAction>() {
         
        /**
         * Creates full size and thumbnail versions of the target image files.
         */
        @Override
        protected Void doInBackground() throws Exception {
            for (int i = 0; i < imageCaptions.length; i++) {
                ImageIcon icon;
                icon = createImageIcon(imagedir + imageFileNames[i], imageCaptions[i]);
                 
                ThumbnailAction thumbAction;
                if(icon != null){
                     
                    ImageIcon thumbnailIcon = new ImageIcon(getScaledImage(icon.getImage(), 32, 32));
                     
                    thumbAction = new ThumbnailAction(icon, thumbnailIcon, imageCaptions[i]);
                     
                }else{
                    
                    thumbAction = new ThumbnailAction(placeholderIcon, placeholderIcon, imageCaptions[i]);
                }
                publish(thumbAction);
            }
         
            return null;
        }
         
        /**
         * Process all loaded images.
         */
        @Override
        protected void process(List<ThumbnailAction> chunks) {
            for (ThumbnailAction thumbAction : chunks) {
                JButton thumbButton = new JButton(thumbAction);
               
                buttonBar.add(thumbButton, buttonBar.getComponentCount() - 1);
            }
        }
    };
     
    /**
     * Creates an ImageIcon if the path is valid.
     * @param String - resource path
     * @param String - description of the file
     */
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
     * Resizes an image using a Graphics2D object backed by a BufferedImage.
     * @param srcImg - source image to scale
     * @param w - desired width
     * @param h - desired height
     * @return - the new resized image
     */
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }
     
    /**
     * Action class that shows the image specified in it's constructor.
     */
    private class ThumbnailAction extends AbstractAction{
         
        /**
		 * 
		 */
		private static final long serialVersionUID = -2913735980025052815L;
		/**
         *The icon if the full image we want to display.
         */
        private Icon displayPhoto;
         
        /**
         * @param Icon - The full size photo to show in the button.
         * @param Icon - The thumbnail to show in the button.
         * @param String - The descriptioon of the icon.
         */
        public ThumbnailAction(Icon photo, Icon thumb, String desc){
            displayPhoto = photo;
         
            putValue(SHORT_DESCRIPTION, desc);
           
            putValue(LARGE_ICON_KEY, thumb);
        }
         
        /**
         *
         */
        public void actionPerformed(ActionEvent e) {
            photographLabel.setIcon(displayPhoto);
            String texto = getValue(SHORT_DESCRIPTION).toString();
            jlbldesc.setText(texto);
            
            texto = texto.replaceAll("<html>|</html>|</p>", "");
            String[] split = texto.split("<p>");
            String codigo_temp = split[2];
            String tipo_temp = split[1];
            
            codigo_temp = codigo_temp.substring(codigo_temp.indexOf(":")+1, codigo_temp.length()).trim();
            tipo_temp = tipo_temp.substring(tipo_temp.indexOf(":")+1, tipo_temp.length()).trim();

            CODIGO = Integer.parseInt(codigo_temp);
            TIPO = tipo_temp;
            
        }
    }
}


	



