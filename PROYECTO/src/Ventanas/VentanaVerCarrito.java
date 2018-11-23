package Ventanas;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class VentanaVerCarrito extends JDialog implements ActionListener  , MouseListener {
	
	private JLabel nombre;
	private JLabel apellidos;
	private JLabel direccion;
	private JLabel poblacion;
	private JLabel codigoPostal;
	
	private JTextField codigoArt;
	private JTextField cantidadArt;
	private JTextField precioArt;
	
	

	
	private JScrollPane scrlPnlLista;
	
	
	private JButton bContinuar;
	private JButton bEliminar;
	private JButton bModificar;
	private JButton bCrear;
	

	public VentanaVerCarrito()  {
	

		
		
		// Aspecto general de la ventana y formato de componentes y contenedores
		this.setSize(1000,600);
		this.setTitle( "Contenido Carrito de la Compra" );
	
		this.setAlwaysOnTop( true );
		this.setLocation( new Point(300,100) );
		this.setResizable(false);
		this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		
		codigoArt = new JTextField(20);
		cantidadArt = new JTextField(6);
		precioArt = new JTextField(6);
		
		
		codigoArt.setEditable(false);
		precioArt.setEditable(false);
		
		
		bContinuar = new JButton( "Continuar comprando" );
		bEliminar = new JButton( "Borrar" );
		bModificar = new JButton( "Modificar" );
		bCrear = new JButton( "Procesar Pedido" );
	
		Font fontBotones = new Font( "Arial", Font.BOLD, 16);
		for (JButton b : new JButton[] { bContinuar,bEliminar, bModificar, bCrear } )
			b.setFont( fontBotones );
		
		Font fontLabel = new Font( "Arial", Font.BOLD, 16);
		JLabel Titulo = new JLabel("DATOS DE USUARIO:");
		Titulo.setFont(fontLabel);
		
				
					
					
		// Creación de paneles
		JPanel panelTitulo = new JPanel();
			JPanel pUsuario = new JPanel();
				JPanel pTitulo = new JPanel();
				JPanel pNomUsu = new JPanel();
				JPanel pDirUsu = new JPanel();
				JPanel pDirUsu2 = new JPanel();
		JPanel panelPedido = new JPanel();
			JPanel pSeleccion = new JPanel();	
			JPanel pArticulo = new JPanel();
				JPanel pArticulo11 = new JPanel();
				JPanel pArticulo12 = new JPanel();
				JPanel pArticulo13 = new JPanel();
		JPanel pBotonera = new JPanel();
		
		
		// Layouts de contenedores
		getContentPane().setLayout( new BorderLayout() );
		
		panelTitulo.setLayout( new BoxLayout( panelTitulo, BoxLayout.X_AXIS) );
			pUsuario.setLayout( new BoxLayout( pUsuario, BoxLayout.Y_AXIS) );
				pTitulo.setLayout( new FlowLayout( FlowLayout.LEFT ) );
				pNomUsu.setLayout( new FlowLayout( FlowLayout.LEFT ) );
				pDirUsu.setLayout( new FlowLayout( FlowLayout.LEFT ) );
				pDirUsu2.setLayout( new FlowLayout( FlowLayout.LEFT ) );
			
		panelPedido.setLayout( new BoxLayout( panelPedido, BoxLayout.X_AXIS)   );
				pSeleccion.setLayout( new BorderLayout() );
				pArticulo.setLayout( new BoxLayout( pArticulo, BoxLayout.Y_AXIS) );
				pArticulo11.setLayout( new FlowLayout( FlowLayout.LEFT ) );
				pArticulo12.setLayout( new FlowLayout( FlowLayout.LEFT ) );
				pArticulo13.setLayout( new FlowLayout( FlowLayout.LEFT ) );
		pBotonera.setLayout( new FlowLayout( FlowLayout.CENTER ) );

		
		
		
		// Asignación de componentes y contenedores a paneles
					
						pTitulo.add( Titulo);
	
						pNomUsu.add(nombre );
						pNomUsu.add(apellidos );
						pNomUsu.add(codigoPostal );
										
						pDirUsu.add(direccion);
						pDirUsu.add(codigoPostal);
						pDirUsu.add(poblacion);
				
				
				pUsuario.add(pTitulo);
				pUsuario.add(pNomUsu);
				pUsuario.add(pDirUsu);
			
			panelTitulo.add(pUsuario);
		
				pSeleccion.add(scrlPnlLista);
						
			
			panelPedido.add(pSeleccion);
		
			pSeleccion.add(scrlPnlLista);
			pArticulo11.add(new JLabel ("Codigo Artículo :    "));
			pArticulo11.add(codigoArt);
			pArticulo12.add(new JLabel ("Precio :                  "));
			pArticulo12.add(precioArt);
			pArticulo13.add(new JLabel ("Cantidad :                "));
			pArticulo13.add(cantidadArt);
		
		pArticulo.add(pArticulo11);
		pArticulo.add(pArticulo12);
		pArticulo.add(pArticulo13);


panelPedido.add(pSeleccion);
panelPedido.add(pArticulo);
			
				
				
				
				
		// Panel botonera
		
		pBotonera.setBackground( Color.BLUE );
		
		// botonera.setLayout( new FlowLayout() );     // todo panel tiene layout flow por defecto
		pBotonera.add( bContinuar );
		pBotonera.add( bEliminar );
		pBotonera.add( bModificar );
		pBotonera.add( bCrear );
		
				
				
		
				
		// Añadir paneles a principal
				getContentPane().setLayout( new BorderLayout() );
				
							
				getContentPane().add( panelTitulo, "North" );
				getContentPane().add( panelPedido, "Center" );
				getContentPane().add( pBotonera, "South" );
				
			

	}
	
	

	
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
	

		}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
