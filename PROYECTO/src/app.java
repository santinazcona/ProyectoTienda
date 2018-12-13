import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Clases.Usuario;
import TiendaBD.BD;
import Ventanas.VentanaCompra;
import Ventanas.VentanaImagen;
import Ventanas.VentanaProductos;
import Ventanas.VentanaUsuario;

public class app {

	public static JPanel panelPrincipal = new JPanel(new CardLayout());
	public static JPanel VentanaLogin = new VentanaLogin();
	public static JPanel VentanaInicio = new VentanaInicio();
	public static Usuario usuario = null; 
	
	private static void createAndShowGUI() {
		BD.conectar();
        //Create and set up the window.
        JFrame frame = new JFrame("FrameDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //imagen de fondo
        frame.setContentPane(new VentanaImagen());
        //agregamos ventana de inicio
        panelPrincipal.add(VentanaLogin, "login");
        panelPrincipal.add(VentanaInicio, "inicio");
        frame.add(panelPrincipal);
        //preparamos jframe
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
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
		panelLogin.setLayout(new BoxLayout(panelLogin, BoxLayout.Y_AXIS));
		
		JPanel jplNombre = new JPanel();
		jplNombre.setBackground(Color.GRAY);
		jplNombre.setLayout(new FlowLayout());
		jplNombre.add(new JLabel( "Nombre" ));
		jplNombre.add(nombre);
		
		JPanel jplContrasena = new JPanel();
		jplContrasena.setBackground(Color.GRAY);
		jplContrasena.setLayout(new FlowLayout());
		jplContrasena.add(new JLabel( "Contrasena" ));
		jplContrasena.add(password);
		
		panelLogin.add(jplNombre);
		panelLogin.add(jplContrasena);
		
		jplNombre.setAlignmentX(Component.LEFT_ALIGNMENT);
		jplContrasena.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		
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
			System.out.println("salir");
		} else if(e.getSource() == bNuevo) {
			System.out.println("nuevo");
		}
	}
}

class VentanaInicio extends JPanel {
	private static final long serialVersionUID = 1L;

	public VentanaInicio() {
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
		                VentanaProductos productos = new VentanaProductos();
		                productos.setVisible(true);
		            }
		        });
			}
		});
		panelBotones.add(botonProductos);
		
		
		JButton botonCompras = new JButton("Compras");
		botonCompras.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		botonCompras.setBounds(524, 269, 156, 39);
		botonCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
						VentanaCompra abrirVentana2 = new VentanaCompra();
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
		
		this.add(panelBotones, BorderLayout.CENTER);
	}


}
