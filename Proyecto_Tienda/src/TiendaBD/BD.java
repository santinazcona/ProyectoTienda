
	package TiendaBD;

	import java.sql.*;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

	public class BD {
		
			private static Connection con;
			private static Statement st;
			private static ResultSet rs;

			public void conectar(){
				try {
					Class.forName( "org.sqlite.JDBC" );
					con = DriverManager.getConnection( "jdbc:sqlite:BD" );
					st = con.createStatement();
				}catch(Exception e){
					System.out.println("No se ha conectado");
					e.printStackTrace();
				}
			}
			
			public void insertarUsuario(){
				String com = "";
				try{
				try {
					com = "create table usuarios( Nick STRING, DNI STRING, TarjetaCredito STRING, Direccion STRING, Email STRING, Contrasenia INT )";
					st.executeUpdate( com );
				} catch (SQLException e) {}
				com = "select * from usuarios where Nick = 'pepe'";
				rs = st.executeQuery( com );
				if (!rs.next()) {
					com = "insert into usuarios ( Nick, DNI, TarjetaCredito, Direccion, Email,  Contrasenia ) values ('admin', 'admin', 'admin', 'admin', 'admin', '4566756')";
					st.executeUpdate( com );
				}
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
	
			public void insertarArticulo(int cod, String nombre, String tipo, String precio, int cantidad){
				String com = "";
				try{
				try {
					com = "create table articulos( cod INT, nombre STRING, tipo STRING, precio STRING, cantidad INT )";
					st.executeUpdate( com );
				} catch (SQLException e) {}
				com = "select * from articulos where cod = 'A001'";
				rs = st.executeQuery( com );
				if (!rs.next()) {
					com = "insert into usuarios ( Nick, DNI, TarjetaCredito, Direccion, Email,  Contrasenia ) values ('admin', 'admin', 'admin', 'admin', 'admin', '4566756')";
					st.executeUpdate( com );
				}
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
//			public static void main(String[] args) throws ClassNotFoundException {
//				String com = "";
//				try {
//					Class.forName( "org.sqlite.JDBC" );
//					con = DriverManager.getConnection( "jdbc:sqlite:BD" );
//					st = con.createStatement();
//					try {
//						com = "create table usuarios( Nick STRING, DNI STRING, TarjetaCredito STRING, Direccion STRING, Email STRING, Contrasenia INT )";
//						st.executeUpdate( com );
//					} catch (SQLException e) {}
//					com = "select * from usuarios where Nick = 'pepe'";
//					rs = st.executeQuery( com );
//					if (!rs.next()) {
//						com = "insert into usuarios ( Nick, DNI, TarjetaCredito, Direccion, Email,  Contrasenia ) values ('admin', 'admin', 'admin', 'admin', 'admin', '4566756')";
//						st.executeUpdate( com );
//					}
//				}catch (SQLException|ClassNotFoundException e) {
//					System.out.println( "Último comando: " + com );
//					e.printStackTrace();
//			}
//			}
	}

				
			


