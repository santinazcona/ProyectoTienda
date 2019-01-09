package Ventanas;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Clases.Carrito;
import Clases.Usuario;
import TiendaBD.BD;


public class VentanaVerCarrito extends JDialog implements ActionListener {
	private static final long serialVersionUID = -3107600749621459429L;
	
	private JButton bContinuar = new JButton( "Continuar comprando" );
	private JButton bEliminar = new JButton( "Borrar" );
	private JButton bModificar = new JButton( "Modificar");
	private JButton bComprar = new JButton( "Procesar Pedido" );
	private Object[][] data;
	DefaultTableModel modeloTabla;
	JTable jtable;
	
	private Usuario usuario;
	
	String[] columnNames = {"Id",
			"Codigo",
            "Tipo",
            "Precio"};

	public VentanaVerCarrito(Usuario usuario)  {
		this.usuario = usuario;
		// Aspecto general de la ventana y formato de componentes y contenedores
		this.setSize(1000,600);
		this.setTitle( "Contenido Carrito de la Compra" );
		this.setAlwaysOnTop( false );
		this.setLocation( new Point(300,100) );
		this.setResizable(false);
		this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		
		JPanel pDatos = new JPanel();
		pDatos.setLayout(new FlowLayout());
		JLabel labelNombre = new JLabel("Bienvenido a tu carrito, " + usuario.getNombre());
		pDatos.add(labelNombre);
		
		JPanel pLista = new JPanel();
		jtable = new JTable();
		modeloTabla = (DefaultTableModel) jtable.getModel();
		modeloTabla.setColumnIdentifiers(columnNames);
		jtable.setModel(modeloTabla);
		jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtable.setPreferredScrollableViewportSize(new Dimension(500, 70));
		jtable.setFillsViewportHeight(true);
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(jtable);
        //Add the scroll pane to this panel.
        pLista.add(scrollPane);
		
		JPanel pBotonera = new JPanel();
		bContinuar.addActionListener(this);
		bEliminar.addActionListener(this);
		bModificar.addActionListener(this);
		bComprar.addActionListener(this);
	
		Font fontBotones = new Font( "Arial", Font.BOLD, 16);
		for (JButton b : new JButton[] { bContinuar, bEliminar, bModificar, bComprar } ) {
			b.setFont( fontBotones );
		}
		pBotonera.setBackground( Color.BLUE );
		// botonera.setLayout( new FlowLayout() );     // todo panel tiene layout flow por defecto
		pBotonera.add( bContinuar );
		pBotonera.add( bEliminar );
		pBotonera.add( bModificar );
		pBotonera.add( bComprar );

		// Añadir paneles a principal
		getContentPane().setLayout( new BorderLayout() );
		
		getContentPane().add(pDatos, BorderLayout.NORTH);
		getContentPane().add(pLista, BorderLayout.CENTER);
		getContentPane().add(pBotonera, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
