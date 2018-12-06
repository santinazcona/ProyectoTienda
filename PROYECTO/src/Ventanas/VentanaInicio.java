package Ventanas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private VentanaImagen panelFondo;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaInicio() {
		panelFondo = new VentanaImagen();
		setTitle("PC_Makers");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Container contenedor = getContentPane();
		contenedor.add(panelFondo);
		panelFondo.setLayout(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
//		Image img = new ImageIcon(this.getClass().getResource("/TiendaInformatica.jpg")).getImage();
		
		JButton botonProductos = new JButton("Productos");
		botonProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaProductos abrirVentana1 = new VentanaProductos();
		//		abrirVentana1.setVisible(true);
				VentanaInicio.this.dispose();
				
			}
		});
		
		JButton botonCompras = new JButton("Compras");
		botonCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaCompra abrirVentana2 = new VentanaCompra();
				abrirVentana2.setVisible(true);
				VentanaInicio.this.dispose();
			}
		});
		botonCompras.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		botonCompras.setBounds(524, 269, 156, 39);
		contentPane.add(botonCompras);
		botonProductos.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		botonProductos.setBounds(292, 269, 156, 39);
		contentPane.add(botonProductos);
		
		JButton botonCliente = new JButton("Cliente");
		botonCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//			VentanaUsuario abrirVentana3 = new VentanaUsuario();
//				abrirVentana3.setVisible(true);
				VentanaInicio.this.dispose();
			}
		});
		botonCliente.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		botonCliente.setBounds(56, 269, 156, 39);
		contentPane.add(botonCliente);
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setOpaque(false);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(97, 44, 232, 63);
		contentPane.add(lblNewLabel);
//		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 732, 346);
		contentPane.add(label);
	}
}


