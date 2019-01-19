package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;




import javax.swing.*;

import Clases.Usuario;






public class VentanaHacerCompra extends JFrame implements ActionListener  , MouseListener {
private static final long serialVersionUID = 8799656478674716640L;
	
	private JLabel nombre;
	private JLabel apellidos;
	private JLabel direccion;
	private JLabel poblacion;
	private JLabel codigoPostal;
	private JLabel tallatamaño;
	
	private JComboBox <String >tipoArticulo;
	
	private JTextField artSeleccionados;
	private JTextField precioPedido;
	
	private JTextField modelo;
	private JTextField actividad;
	private JTextField color;
	private JTextField talla;
	private JTextField precio;
	
	private JTextField existencias;
	private JTextField cantidad;

	private JScrollPane scrlPnlLista;
	
	
	private JButton bSalir;
	private JButton bAñadir;
	
	private JButton bCarrito;
	private JPanel pArticulo12;

	Usuario uDatos ;
	
	public VentanaHacerCompra(Usuario usuarioDatos)  {
	
		uDatos = usuarioDatos;
	
		nombre = new JLabel(uDatos.getNombre());
		apellidos = new JLabel(uDatos.getApellidos());
		direccion = new JLabel(uDatos.getDireccion());
		poblacion = new JLabel(uDatos.getPoblacion());
		codigoPostal = new JLabel( Integer.toString(uDatos.getCodigoPostal()));
		tallatamaño = new JLabel("Talleje" );
		tipoArticulo = new JComboBox<String>( new String[] { "Ordenadores"} );
	
	
		
		
		artSeleccionados = new JTextField(6);
		precioPedido = new JTextField(10);
		
		modelo = new JTextField(10);
		actividad = new JTextField(10);
		color = new JTextField(10);
		talla = new JTextField(8);
		precio = new JTextField(6);
		
		existencias = new JTextField(6);
		cantidad = new JTextField(6);
		
		artSeleccionados.setEditable(false);
		precioPedido.setEditable(false);
		
		modelo.setEditable(false);
		actividad.setEditable(false);
		color.setEditable(false);
		talla.setEditable(false);
		precio.setEditable(false);
		existencias.setEditable(false);
	
		
		
		
	
		
		// Aspecto general de la ventana y formato de componentes y contenedores
		this.setSize(1000,600);
		this.setTitle( "Preparación Pedido" );
	
		this.setAlwaysOnTop( true );
		this.setLocation( new Point(300,100) );
		this.setResizable(false);
		
		
		bAñadir = new JButton( "Añadir" );
		bSalir = new JButton( "Salir" );
		bCarrito = new JButton( "Ver Carrito de la Compra" );
		
		
		tipoArticulo.addActionListener(this);
		
		
		bCarrito.addActionListener(this);
		bAñadir.addActionListener(this);
		bSalir.addActionListener(this);

		
		bAñadir.setEnabled(false);
	
		Font fontBotones = new Font( "Arial", Font.BOLD, 16);
		for (JButton b : new JButton[] { bAñadir, bSalir } )
			b.setFont( fontBotones );
		
		Font fontLabel = new Font( "Arial", Font.BOLD, 16);
		JLabel Titulo = new JLabel("DATOS DE USUARIO:");
		JLabel Carrito = new JLabel ("Carrito de la compra");
		
		Titulo.setFont(fontLabel);
		Carrito.setFont(fontLabel);	
			
	
		 
		 scrlPnlLista = new JScrollPane();
			
			
	
			 
		// Creación de paneles
		JPanel panelTitulo = new JPanel();
			JPanel pUsuario = new JPanel();
				JPanel pTitulo = new JPanel();
				JPanel pNomUsu = new JPanel();
				JPanel pDirUsu = new JPanel();
				JPanel pDirUsu2 = new JPanel();
			JPanel pUsuario2 = new JPanel();
				JPanel pUsuario21 = new JPanel();
				JPanel pUsuario22 = new JPanel();
				JPanel pUsuario23 = new JPanel();
			JPanel pUsuario3 = new JPanel();
				JPanel pUsuario31 = new JPanel();
		JPanel panelPedido = new JPanel();
			JPanel pSeleccion = new JPanel();
			JPanel pArticulo = new JPanel();
					JPanel pArticulo11 = new JPanel();
					JPanel pArticulo11a = new JPanel();
					pArticulo12 = new JPanel();
					JPanel pArticulo13 = new JPanel();
					JPanel pArticulo14 = new JPanel();
	//		JPanel pCantidades = new JPanel();
					JPanel pCantidades1 = new JPanel();
					JPanel pCantidades2 = new JPanel();
					
		JPanel pBotonera = new JPanel();
		
		
		// Layouts de los contenedores
		getContentPane().setLayout( new BorderLayout() );
		
		panelTitulo.setLayout( new BoxLayout( panelTitulo, BoxLayout.X_AXIS) );
			pUsuario.setLayout( new BoxLayout( pUsuario, BoxLayout.Y_AXIS) );
				pTitulo.setLayout( new FlowLayout( FlowLayout.LEFT ) );
				pNomUsu.setLayout( new FlowLayout( FlowLayout.LEFT ) );
				pDirUsu.setLayout( new FlowLayout( FlowLayout.LEFT ) );
				pDirUsu2.setLayout( new FlowLayout( FlowLayout.LEFT ) );
			pUsuario2.setLayout( new BoxLayout( pUsuario2, BoxLayout.Y_AXIS) );
				pUsuario21.setLayout( new FlowLayout( FlowLayout.LEFT ) );
				pUsuario22.setLayout( new FlowLayout( FlowLayout.LEFT ) );
				pUsuario23.setLayout( new FlowLayout( FlowLayout.LEFT ) );
			pUsuario3.setLayout( new BoxLayout( pUsuario3, BoxLayout.Y_AXIS) );
				pUsuario31.setLayout( new FlowLayout( FlowLayout.CENTER ) );
		panelPedido.setLayout( new BoxLayout( panelPedido, BoxLayout.X_AXIS)   );
				pSeleccion.setLayout( new BorderLayout() );
				pArticulo.setLayout( new BoxLayout( pArticulo, BoxLayout.Y_AXIS) );
							pArticulo11.setLayout( new FlowLayout( FlowLayout.LEFT ) );
							pArticulo11a.setLayout( new FlowLayout( FlowLayout.LEFT ) );
							pArticulo12.setLayout( new FlowLayout( FlowLayout.LEFT ) );
							pArticulo13.setLayout( new FlowLayout( FlowLayout.LEFT ) );
							pArticulo14.setLayout( new FlowLayout( FlowLayout.LEFT ) );
	
							pCantidades1.setLayout( new FlowLayout( FlowLayout.LEFT ) );
							pCantidades2.setLayout( new FlowLayout( FlowLayout.LEFT ) );
							
		pBotonera.setLayout( new FlowLayout( FlowLayout.CENTER ) );

		
		
		
		// Asignación de componentes y contenedores a paneles
					
						pTitulo.add( Titulo);
	
						pNomUsu.add(nombre );
						pNomUsu.add(apellidos );
						pNomUsu.add(codigoPostal );
										
						pDirUsu.add(direccion);
						pDirUsu.add(codigoPostal);
						pDirUsu.add(poblacion);
				
						pDirUsu2.add(new JLabel ("Tipo Artículo"));
						pDirUsu2.add(tipoArticulo);
						
						
				
				pUsuario.add(pTitulo);
				pUsuario.add(pNomUsu);
				pUsuario.add(pDirUsu);
				pUsuario.add(pDirUsu2);
				
					pUsuario21.add(Carrito);
					pUsuario22.add(new JLabel ("Artículos Seleccionados"));
					pUsuario22.add(artSeleccionados);
					pUsuario23.add(new JLabel ("Precio Pedido     "));
					pUsuario23.add(precioPedido);
				pUsuario2.add(pUsuario21);
				pUsuario2.add(pUsuario22);
				pUsuario2.add(pUsuario23);
				
					pUsuario31.add(bCarrito);
				pUsuario3.add(pUsuario31);
			panelTitulo.add(pUsuario);
			panelTitulo.add(pUsuario2);
			panelTitulo.add(pUsuario3);
			
				pSeleccion.add(scrlPnlLista);
						pArticulo11.add(new JLabel ("Modelo      "));
						pArticulo11.add(modelo);
						pArticulo11a.add(new JLabel ("Actividad      "));
						pArticulo11a.add(actividad);
						pArticulo12.add(new JLabel ("Color           "));
						pArticulo12.add(color);
						pArticulo13.add(tallatamaño); 
						pArticulo13.add(talla);
						pArticulo14.add(new JLabel ("Precio         "));
						pArticulo14.add(precio);
					pArticulo.add(pArticulo11);
					pArticulo.add(pArticulo11a);
					pArticulo.add(pArticulo12);
					pArticulo.add(pArticulo13);
					pArticulo.add(pArticulo14);
						
					pCantidades1.add(new JLabel ("Existencias"));
					pCantidades1.add(existencias);
						
					pCantidades2.add(new JLabel ("Cantidad     "));
					pCantidades2.add(cantidad); 
					
					
					pArticulo.add(pCantidades1);
					pArticulo.add(pCantidades2);
					

			
			panelPedido.add(pSeleccion);
			panelPedido.add(pArticulo);
			

			
			
				
				
				
				
		// Panel botonera
		
		pBotonera.setBackground( Color.BLUE );
		
		// botonera.setLayout( new FlowLayout() );     // todo panel tiene layout flow por defecto
		pBotonera.add( bAñadir );
		pBotonera.add( bSalir );
				
				
		
				
		// Añadir paneles a principal
				getContentPane().setLayout( new BorderLayout() );
				
							
				getContentPane().add( panelTitulo, "North" );
				getContentPane().add( panelPedido, "Center" );
				getContentPane().add( pBotonera, "South" );
				
			

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	
	
	