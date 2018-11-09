package Ventanas;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class VentanaLogin extends JDialog implements ActionListener {

	private static final long serialVersionUID = 8799656478674716639L;
	private JTextField nombre;
	private JTextField password;
	private JButton bAceptar; 
	private JButton bNuevo; 
	private JButton bSalir; 

	
	public VentanaLogin () {
		
	
		nombre = new JTextField(12);
		password = new JPasswordField(12);
		
		// Aspecto general de la ventana y formato de los componentes y contenedores
		this.setSize(300,140);
		this.setTitle( "Control de usuarios" );
		this.setMinimumSize( new Dimension( 100, 50 ));
		this.setAlwaysOnTop( true );
		this.setLocation( new Point(500,300) );
		this.setResizable(false);
		this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		
		bAceptar = new JButton( "Aceptar" );
		bNuevo = new JButton( "Nuevo Usuario" );
		bSalir = new JButton( "Salir" );
		
		bAceptar.addActionListener(this);
		bNuevo.addActionListener(this);
		bSalir.addActionListener(this);
		
		Container panelContenidos = new JPanel();
		panelContenidos.setLayout(new BoxLayout(panelContenidos,BoxLayout.Y_AXIS));
				
		posicionaLinea( panelContenidos, "               Usuario:", nombre, Color.GRAY );
		posicionaLinea( panelContenidos, "Código Usuario:", password, Color.GRAY  );
		
		
		// Panel botonera
		Container botonera = new JPanel();	
		botonera.setBackground( Color.LIGHT_GRAY );
		// botonera.setLayout( new FlowLayout() );     // todo panel tiene layout flow por defecto
		botonera.add( bNuevo );
		botonera.add( bAceptar );
		botonera.add( bSalir );
		
		// Añadir paneles a principal
		getContentPane().setLayout( new BorderLayout() );
		getContentPane().add( panelContenidos, "Center" );
		getContentPane().add( botonera, "South" );
	}
	
	private void posicionaLinea( Container p, String etiqueta, Component campo, Color Colour ) {
		JPanel tempPanel = new JPanel();
		tempPanel.setBackground(Colour);
		tempPanel.setLayout( new FlowLayout(FlowLayout.CENTER) );
		tempPanel.add( new JLabel( etiqueta ) );
		tempPanel.add( campo );
		p.add( tempPanel );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	
	
