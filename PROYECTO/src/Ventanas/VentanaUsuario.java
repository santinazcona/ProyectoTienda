package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.*;

import Clases.Usuario;

public class VentanaUsuario extends JDialog implements ActionListener{
	
	private static final long serialVersionUID = 8799656478674716641L;
	private JTextField nombre;
	private JTextField apellidos;
	private JTextField direccion;
	private JTextField poblacion;
	private JTextField codigoPostal;
	private JTextField cuentaBancaria;
	private JTextField codigoUsuario;
	private JTextField passwordUsuario;
	
	private JButton bSalir;
	private JButton bCrear;
	
	private LinkedList<Usuario> lUsu;
	private Usuario uSelec;
	
	

	public VentanaUsuario(LinkedList<Usuario> lUsuarios, Usuario usu)  {
		
		lUsu = lUsuarios;
		uSelec = usu; 
	
		nombre = new JTextField(12);
		apellidos = new JTextField(20);
		direccion = new JTextField(12);
		poblacion = new JTextField(12);
		codigoPostal = new JTextField(6);
		cuentaBancaria = new JTextField(12);
		codigoUsuario = new JTextField(12);
		passwordUsuario = new JTextField(12);
		
		// Aspecto general de la ventana y formato de los componentes y contenedores
		this.setSize(600,300);
		this.setTitle( "Edición Datos de usuarios" );
		this.setMinimumSize( new Dimension( 600, 300 ));
		this.setAlwaysOnTop( true );
		this.setLocation( new Point(500,300) );
		this.setResizable(false);
		this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		
		bSalir = new JButton( "Salir" );
		bCrear = new JButton( "Crear" );
		
		bSalir.addActionListener(this);
		bCrear.addActionListener(this);
		
		Font fontBotones = new Font( "Arial", Font.BOLD, 16);
		for (JButton b : new JButton[] { bSalir, bCrear } )
			b.setFont( fontBotones );
		
		Font fontLabel = new Font( "Arial", Font.BOLD, 16);
		JLabel Titulo = new JLabel("DATOS DE USUARIO:");
		Titulo.setFont(fontLabel);
		
		// Creación de paneles
		JPanel panelTitulo = new JPanel();
		JPanel panelUsuario = new JPanel();
			JPanel panelDatos = new JPanel();
				JPanel panelNombre = new JPanel();
					JPanel pNombre = new JPanel();
					JPanel pApellidos = new JPanel();
					JPanel pCuenta = new JPanel();
					JPanel panelCodigo = new JPanel();
				JPanel panelDirección = new JPanel();
					JPanel pDireccion = new JPanel();
					JPanel pPoblacion = new JPanel();
					JPanel pPostal = new JPanel();
					JPanel panelPassword = new JPanel();
		JPanel pBotonera = new JPanel();
		
		
		// Layouts de contenedores
		getContentPane().setLayout( new BorderLayout() );
		
		panelTitulo.setLayout( new FlowLayout( FlowLayout.CENTER ) );
		
		panelUsuario.setLayout( new BoxLayout( panelUsuario, BoxLayout.Y_AXIS ) );
			panelDatos.setLayout(new BoxLayout( panelDatos, BoxLayout.X_AXIS ) );
				panelNombre.setLayout(new BoxLayout( panelNombre, BoxLayout.Y_AXIS ) );
					pNombre.setLayout( new FlowLayout( FlowLayout.LEFT ) );
					pApellidos.setLayout( new FlowLayout( FlowLayout.LEFT ) );
					pCuenta.setLayout( new FlowLayout( FlowLayout.LEFT ) );
					panelCodigo.setLayout( new FlowLayout( FlowLayout.LEFT ) );
				panelDirección.setLayout(new BoxLayout( panelDirección, BoxLayout.Y_AXIS ) );
					pDireccion.setLayout( new FlowLayout( FlowLayout.LEFT ) );
					pPoblacion.setLayout( new FlowLayout( FlowLayout.LEFT ) );
					pPostal.setLayout( new FlowLayout( FlowLayout.LEFT ) );
					panelPassword.setLayout( new FlowLayout( FlowLayout.LEFT ) );
				
		pBotonera.setLayout( new FlowLayout( FlowLayout.CENTER ) );

		
		
		
		// Asignación de componentes y contenedores a paneles
					
		panelTitulo.add( Titulo);
	
						pNombre.add( new JLabel( "Nombre :" ));
						pNombre.add( nombre );	
					
						pApellidos.add( new JLabel( "Apellidos :" ));
						pApellidos.add( apellidos );	
					
						pCuenta.add( new JLabel( "Nº Cuenta :" ));
						pCuenta.add( cuentaBancaria );	
						
						panelCodigo.add( new JLabel( "Codigo de Usuario :" ));
						panelCodigo.add( codigoUsuario );	
						
					panelNombre.add(pNombre);
					panelNombre.add(pApellidos);
					panelNombre.add(pCuenta);
					panelNombre.add(panelCodigo);
					
						pDireccion.add( new JLabel( "Dirección :" ));
						pDireccion.add( direccion );	
				
						pPoblacion.add( new JLabel( "Población :" ));
						pPoblacion.add( poblacion );	
				
						pPostal.add( new JLabel( "Código Postal :" ));
						pPostal.add( codigoPostal );	
						
						panelPassword.add( new JLabel( "Password de Usuario :" ));
						panelPassword.add( passwordUsuario );	
									
					panelDirección.add(pDireccion);
					panelDirección.add(pPoblacion);
					panelDirección.add(pPostal);
					panelDirección.add(panelPassword);
	
		
					
				
				panelDatos.add(panelNombre);
				panelDatos.add(panelDirección);
				
		panelUsuario.add(panelDatos);
			
		
		// Panel botonera
		
		pBotonera.setBackground( Color.GRAY );
				// botonera.setLayout( new FlowLayout() );     // todo panel tiene layout flow por defecto
		pBotonera.add( bCrear );
		pBotonera.add( bSalir );
	
				
				
		
				
		// Añadir paneles a principal
				getContentPane().setLayout( new BorderLayout() );
				
							
				getContentPane().add( panelTitulo, "North" );
				getContentPane().add( panelUsuario, "Center" );
				getContentPane().add( pBotonera, "South" );
				
			

	}
	
// Comprobar que existe el usuario
	public boolean comprobarUsuario(LinkedList<Usuario> lUsu, String  uUsuario){
		
		for (int i = 0; i < lUsu.size() ; i++){
			if (uUsuario.equals(lUsu.get(i).getCodigoUsuario()))
				return true;
		}
		return false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 
		if (e.getSource() == bCrear){
			
	//		if (Utilidades.isInteger(codigoPostal.getText()) && Utilidades.isInteger(cuentaBancaria.getText())){
				
				boolean compUsu = comprobarUsuario(lUsu,  codigoUsuario.getText()) ;
				if (compUsu){
					int n = JOptionPane.showConfirmDialog(
						    this,
						    "El Usuario ya existe\n"  + "¿Desea intentarlo de nuevo?",
						    "Nuevo Usuario",
						    JOptionPane.YES_NO_OPTION,
						    JOptionPane.QUESTION_MESSAGE);
					if (n==0){
						codigoUsuario.setText("");
					}else{
						uSelec = null;
						this.setVisible(false);
						dispose();
					}
				}else{
					uSelec.setNombre(nombre.getText());
					uSelec.setApellidos(apellidos.getText());
					uSelec.setDireccion(direccion.getText());
					uSelec.setPoblacion(poblacion.getText());
					uSelec.setCodigoPostal(Integer.parseInt(codigoPostal.getText()));
					uSelec.setCodigoUsuario(codigoUsuario.getText());
					uSelec.setCuentaBancaria(Integer.parseInt(cuentaBancaria.getText()));
					uSelec.setPasswordUsuario(passwordUsuario.getText());
					lUsu.add(uSelec);
					this.setVisible(false);
					dispose();
				}
				
			}else{
				
					JOptionPane.showMessageDialog(
					this,
					"El código Postal y la cuenta Bancaria\n"  + " deben ser numeros enteros",
					"Datos de Usuario",
					JOptionPane.WARNING_MESSAGE);
			}
				
		
		
		
		
		if (e.getSource() == bSalir){
			
			uSelec = null;
			this.setVisible(false);
			dispose();
			
		}
		
	}
	public static void main(String[] args) {
		
	//	VentanaUsuario p = new VentanaUsuario();
	//	p.setVisible(true);
		

	}

}
