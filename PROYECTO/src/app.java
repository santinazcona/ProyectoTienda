import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import Clases.Usuario;
import Gmail.GmailQuickStart;
import TiendaBD.BD;
import Ventanas.VentanaCrear;
import Ventanas.VentanaImagen;
import Ventanas.VentanaProductos;
import Ventanas.VentanaUsuario;
import Ventanas.VentanaVerCarrito;

public class app {

	public static JDialog frame;
	public static JPanel panelPrincipal = new JPanel(new CardLayout());
	public static JPanel VentanaLogin; 
	public static JPanel VentanaInicio;
	public static Usuario usuario = null;
	private static GmailQuickStart gmailqs = new GmailQuickStart();
    private static Timer timer;
    private static final int DELAY = 1000;
    private static final int FINAL = 10;
    private static Set<MouseMotionListener> mouseMotionListeners;
    private static int counter = 0;
    
    private static AtomicBoolean INACTIVIDAD = new AtomicBoolean(false);
    
	private static int createAndShowGUI() {
		RatonListener rl = new RatonListener();
		rl.execute();
		INACTIVIDAD.set(false);
		//bases de datos
		BD.conectar();
		BD.crearTablas();
		//BD.cargarProductos();
		
		VentanaLogin = new VentanaLogin();
		VentanaInicio = new VentanaInicio(gmailqs);
        //Create and set up the window.
        frame = new JDialog();
        frame.setModal(true);
        //imagen de fondo
        frame.setContentPane(new VentanaImagen());
        //agregamos ventana de inicio
        panelPrincipal.add(VentanaLogin, "login");
        panelPrincipal.add(VentanaInicio, "inicio");
        
        CardLayout cardLayout = (CardLayout) app.panelPrincipal.getLayout();
        cardLayout.show(app.panelPrincipal, "login");
        
        frame.add(panelPrincipal);
        //preparamos jframe
        frame.pack();
        frame.setVisible(true);

        rl.cancel(true);
        
        return 1;
    }

    public static void main(String[] args) throws InvocationTargetException, InterruptedException {

        javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
            	int empezar = 1;
            	while(INACTIVIDAD.get() || empezar == 1) {
            		empezar = 0;
            		createAndShowGUI();
            	}
            }
        });
        System.exit(0);
    }
    
   static class RatonListener extends SwingWorker<Integer, String> {
        @Override
        protected Integer doInBackground() throws Exception {
        	counter = 0;
            timer = new Timer(DELAY, new ActionListener() {
                private Point lastPoint = MouseInfo.getPointerInfo().getLocation();

                /* called every DELAY milliseconds to fetch the
                 * current mouse coordinates */

                public synchronized void actionPerformed(ActionEvent e) {
                    Point point = MouseInfo.getPointerInfo().getLocation();

                    if (!point.equals(lastPoint)) {
                        fireMouseMotionEvent(point);
                        counter = 0;
                    } else {
                        counter++;
                        System.out.println("Contador segundos: " + counter);
                        if(counter > FINAL) {
                        	//System.out.println("Termino...");
                        	stop();
                        	INACTIVIDAD.set(true);
                        	
                            Window[] children = Window.getWindows();
                            for (Window win : children) {
                                if (win instanceof JDialog) {
                                    win.dispose();
                                }
                            }
                        	
                        }
                    }

                    lastPoint = point;
                }
            });
            mouseMotionListeners = new HashSet<MouseMotionListener>();
            
            start();
            
            return 1;
        }
        
	    public void start() {
	        timer.start();
	    }

	    public void stop() {
	        timer.stop();
	        frame.dispose();
	    }
        
        protected void fireMouseMotionEvent(Point point) {
            synchronized (mouseMotionListeners) {
                for (final MouseMotionListener listener : mouseMotionListeners) {
                    final MouseEvent event =
                        new MouseEvent(frame, MouseEvent.MOUSE_MOVED, System.currentTimeMillis(),
                                       0, point.x, point.y, 0, false);

                    SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                listener.mouseMoved(event);
                            }
                        });
                }
            }
        }
    };

	public static GmailQuickStart getGmailqs() {
		return gmailqs;
	}

	public static void setGmailqs(GmailQuickStart gmailqs) {
		app.gmailqs = gmailqs;
	}
	
	
}

class VentanaLogin extends JPanel implements ActionListener {

	private static final long serialVersionUID = 8799656478674716639L;
	private JTextField nombre;
	private JTextField password;
	private JButton bAceptar; 
	private JButton bNuevo; 
	private JButton bSalir; 

	public VentanaLogin() {
		this.setLayout(new FlowLayout());

		nombre = new JTextField(12);
		password = new JPasswordField(12);
		
		bAceptar = new JButton( "Aceptar" );
		bNuevo = new JButton( "Nuevo Usuario" );
		bSalir = new JButton( "Salir" );
		
		bAceptar.addActionListener(this);
		bNuevo.addActionListener(this);
		bSalir.addActionListener(this);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(Color.GRAY);
		
		GroupLayout layout = new GroupLayout(panelLogin);
		panelLogin.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		JLabel jlblNombre = new JLabel( "Nombre" );
		JLabel jlblContrasena = new JLabel( "Contrasena" );
		
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGroup(layout.createParallelGroup().
            addComponent(jlblNombre).addComponent(jlblContrasena));
		hGroup.addGroup(layout.createParallelGroup().
            addComponent(nombre).addComponent(password));
		layout.setHorizontalGroup(hGroup);
				   
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
		            addComponent(jlblNombre).addComponent(nombre));
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
		            addComponent(jlblContrasena).addComponent(password));
		layout.setVerticalGroup(vGroup);
		
		//set nombre y contrasena
		nombre.setText("manu");
		password.setText("hola");
		
		// Panel botonera
		Container botonera = new JPanel();	
		botonera.setBackground( Color.LIGHT_GRAY );
		// botonera.setLayout( new FlowLayout() );     // todo panel tiene layout flow por defecto
		botonera.add( bNuevo );
		botonera.add( bAceptar );
		botonera.add( bSalir );
		
		// Añadir paneles a principal
		this.setLayout( new BorderLayout() );
		this.add( panelLogin, BorderLayout.CENTER );
		this.add( botonera, BorderLayout.SOUTH );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bAceptar) {
			String nom = nombre.getText().trim();
			String pass = password.getText().trim();
			Usuario temp = BD.revisarUsuario(nom, pass);
			
			if(temp != null) {
				app.usuario = temp;
	            CardLayout cardLayout = (CardLayout) app.panelPrincipal.getLayout();
	            cardLayout.show(app.panelPrincipal, "inicio");
			}
		} else if(e.getSource() == bSalir) {
			 System.exit(0);
		} else if(e.getSource() == bNuevo) {
			VentanaCrear vc = new VentanaCrear();
			vc.setVisible(true);
		}
	}
}

class VentanaInicio extends JPanel {
	private GmailQuickStart gmailqs;
	private static final long serialVersionUID = 1L;

	public VentanaInicio(GmailQuickStart gmailqs) {
		this.gmailqs = gmailqs;
		this.setLayout(new BorderLayout());
		this.setBackground(Color.GRAY);
		
		JLabel lblNewLabel = new JLabel("Bienvenido", SwingConstants.CENTER);
		lblNewLabel.setOpaque(false);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(97, 44, 232, 63);
		this.add(lblNewLabel, BorderLayout.NORTH);
		
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(Color.GRAY);
		panelBotones.setLayout(new FlowLayout());
		
		JButton botonProductos = new JButton("Productos");
		botonProductos.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		botonProductos.setBounds(292, 269, 156, 39);
		botonProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                VentanaProductos productos = new VentanaProductos(app.usuario);
		                productos.setVisible(true);
		            }
		        });
			}
		});
		panelBotones.add(botonProductos);
		
		
		JButton botonCompras = new JButton("Carrito de Compras");
		botonCompras.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		botonCompras.setBounds(524, 269, 156, 39);
		botonCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		            	VentanaVerCarrito abrirVentana2 = new VentanaVerCarrito(app.usuario, gmailqs);
						abrirVentana2.setVisible(true);
		            }
		        });
			}
		});
		panelBotones.add(botonCompras);
		
		JButton botonCliente = new JButton("Cliente");
		botonCliente.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		botonCliente.setBounds(56, 269, 156, 39);
		botonCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaUsuario abrirVentana3 = new VentanaUsuario(app.usuario);
				abrirVentana3.setVisible(true);
			}
		});
		panelBotones.add(botonCliente);
		
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		botonSalir.setBounds(56, 269, 156, 39);
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.usuario = null;
	            CardLayout cardLayout = (CardLayout) app.panelPrincipal.getLayout();
	            cardLayout.show(app.panelPrincipal, "login");
			}
		});
		panelBotones.add(botonSalir);
		
		
		this.add(panelBotones, BorderLayout.CENTER);
	}

}