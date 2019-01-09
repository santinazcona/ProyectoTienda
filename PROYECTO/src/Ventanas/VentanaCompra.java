package Ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCompra extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VentanaCompra() {
		setTitle("Haz tu compra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
	//	Image img = new ImageIcon(this.getClass().getResource("")).getImage();
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaInicio abrirVentana1 = new VentanaInicio();
				abrirVentana1.setVisible(true);
				VentanaCompra.this.dispose();
			}
		});
		
		JButton butonCarrito = new JButton("Ver Carrito");
		butonCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaVerCarrito abrirVentana2 = new VentanaVerCarrito(null);
				abrirVentana2.setVisible(true);
				VentanaCompra.this.dispose();
			}
		});
		butonCarrito.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		butonCarrito.setBounds(33, 21, 156, 39);
		contentPane.add(butonCarrito);
		
		JButton botonHacerCompra = new JButton("Comprar");
		botonHacerCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaHacerCompra abrirVentana3 = new VentanaHacerCompra(null);
				abrirVentana3.setVisible(true);
				VentanaCompra.this.dispose();
				
			}
		});
		botonHacerCompra.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		botonHacerCompra.setBounds(271, 21, 156, 39);
		contentPane.add(botonHacerCompra);
		botonVolver.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		botonVolver.setBounds(506, 21, 156, 39);
		contentPane.add(botonVolver);
//		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 692, 340);
		contentPane.add(label);
	}
}



