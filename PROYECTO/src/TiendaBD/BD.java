package TiendaBD;

import java.sql.*;
import java.util.LinkedList;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Clases.Articulo;
import Clases.Usuario;
import Clases.Compra;

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

//			public void insertarUsuario(String nombre, String apellidos,String direccion, String poblacion,int CP, String CodigoUsuario, String passwordUsuario,int CuentaBancaria){
//				String com = "insert into usuarios ( nombre, apellidos, direccion, poblacion, CP,  CodigoUsuario,passwordUsuario,CuentaBancaria ) values ('"+nombre+"', '"+apellidos+"', '"+direccion+"', '"+poblacion+"', '"+CP+"', '"+CodigoUsuario+"','"+passwordUsuario+"','"+CuentaBancaria+"')";
//				try {
//						st.executeUpdate(com);
//				
//				}catch (SQLException e) {
//					e.printStackTrace();
//				}
//	}
	
			public void insertarArticulo(int cod, String nombre, String tipo, String precio, int cantidad){
				String com = "insert into articulo ( cod, nombre, tipo, precio, cantidad ) values ('"+cod+"', '"+nombre+"', '"+tipo+"', '"+precio+"', '"+cantidad+"')";
				try {
						st.executeUpdate(com);
						
				}catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			
		public void insertarUsuario(LinkedList<Usuario> usuario){
		
			for(int i=0;i<usuario.size();i++){
				Usuario u = usuario.get(i);
				String com = "INSERT INTO usuarios( nombre, apellidos, direccion, poblacion, CP, CodigoUsuario,passwordUsuario,CuentaBancaria ) values ('"+u.getNombre()+"', '"+u.getApellidos()+"', '"+u.getDireccion()+"', '"+u.getPoblacion()+"', '"+u.getCodigoPostal()+"', '"+u.getCodigoUsuario()+"','"+u.getPasswordUsuario()+"','"+u.getCuentaBancaria()+"')";
				try {
					st.executeUpdate(com);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		public void modificarUnidadesArticulo(int codigo, int unidades){
			String com= "UPDATE articulo SET unidades=unidades-"+unidades+" WHERE codigo="+codigo;
			try {
				st.executeUpdate(com);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void modificarContraseñaUsuario(String CodigoUsuario, String passwordUsuario){
			String com= "UPDATE usuarios SET passwordUsuario="+passwordUsuario+" WHERE CodigoUsuario="+CodigoUsuario;
			try {
				st.executeUpdate(com);
			} catch (SQLException e) {
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

				
			

	
	