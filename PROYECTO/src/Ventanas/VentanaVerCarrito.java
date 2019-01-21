package Ventanas;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.mail.internet.MimeMessage;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Clases.Carrito;
import Clases.Usuario;
import Gmail.GmailQuickStart;
import TiendaBD.BD;


public class VentanaVerCarrito extends JDialog implements ActionListener {
	private static final long serialVersionUID = -3107600749621459429L;
	
	private GmailQuickStart gmailqs;
	
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

	public VentanaVerCarrito(Usuario usuario, GmailQuickStart gmailqs)  {
		this.usuario = usuario;
		this.gmailqs = gmailqs;
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
		rellenarTabla();
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
	
	private void rellenarTabla() {
		//encontramos carrito de usuario
		ArrayList<Carrito> lista = BD.extraerCarrito(usuario);
		data = new Object[lista.size()][columnNames.length];
		for(int i = 0; i < lista.size(); i++) {
				data[i][0] = lista.get(i).getId();
				data[i][1] = lista.get(i).getCod();
				data[i][2] = lista.get(i).getTipo();
				data[i][3] = lista.get(i).getPrecio();
				
				modeloTabla.addRow(data[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bContinuar) {
			dispose();
		}
		if(e.getSource() == bComprar) {
			if(modeloTabla.getRowCount() > 0) {
				StringBuilder sb_factura = new StringBuilder();
				sb_factura.append("Factura\n");
				sb_factura.append("Usuario: " + usuario.getNombre() + "\n");
				sb_factura.append("+++++++++++++++++++++++++++++++++++++\n\n");
				double precioTotal = 0.0;
				for (int i = 0; i < modeloTabla.getRowCount(); i++) {
					BD.comprarArticulo(usuario.getCodigoUsuario(),
							Integer.parseInt(modeloTabla.getValueAt(i, 1).toString()),
							Float.parseFloat(modeloTabla.getValueAt(i, 3).toString())
							);
					BD.borrarAritucloCarrito(Integer.parseInt(modeloTabla.getValueAt(i, 0).toString()));

					sb_factura.append("Codigo Producot: " + Integer.parseInt(modeloTabla.getValueAt(i, 1).toString())+"\n");
					sb_factura.append("Descripcion: " + modeloTabla.getValueAt(i, 2) + "\n");
					double precio = Double.parseDouble(modeloTabla.getValueAt(i, 3).toString());
					precioTotal += precio;
					sb_factura.append("Precio : " + precio + "\n");
					sb_factura.append("---------------------------------\n");
				}
				sb_factura.append("\nTotal : " + precioTotal + "\n");
				//fecha de hoy
				SimpleDateFormat formatoFecha = new SimpleDateFormat("ddMMyyyyHHmmss");
				Date fechaHoy = new Date();
				String fechaHoy_str = formatoFecha.format(fechaHoy);
				//escribimos factura a archivo texto
				PrintWriter writer = null;
				try {
					writer = new PrintWriter("facturas/"+usuario.getNombre()+"factura_"+fechaHoy_str+".txt", "UTF-8");
					writer.write(sb_factura.toString());
				} catch(Exception ex) {
					ex.printStackTrace();
				} finally {
					writer.close();
				}
				//enviamos correo
				MimeMessage email = gmailqs.createEmail("manu.prog3.proyecto@gmail.com",
						"manu.prog3.proyecto@gmail.com",
						"Factura Electronica",
						sb_factura.toString());
				
				if(email != null) {
					try {
						gmailqs.sendMessage("manu.prog3.proyecto@gmail.com", email);
					} catch(Exception ex) {
						ex.printStackTrace();
						System.out.println("no se envio correo...");
					}
				}
				JOptionPane.showMessageDialog(null,
						"Su compra ha sido procesada con exito!",
						"Compra",
						JOptionPane.PLAIN_MESSAGE);
				dispose();
			}
		}
	}
}
