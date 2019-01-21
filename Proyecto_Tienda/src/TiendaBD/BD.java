
	package TiendaBD;

	import java.sql.*;
	import java.util.Vector;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import javax.swing.table.DefaultTableModel;
	import Clases.Cliente;

	public class BD {
		
			private static Connection con;
			private static Statement st;
			private static ResultSet rs;

//					try {
//						com = "create table Usuario( nick STRING, pass STRING )";
//						s.executeUpdate( com );
//					} catch (SQLException e) {} 
//					com = "select * from Cliente where nick = 'Paco'";
//					rs = s.executeQuery( com );
//					if (!rs.next()) {
//						com = "insert into Cliente ( nick, Contrasenia ) values ('Paco', 'vivaelvino')";
//						s.executeUpdate( com );
//					}
//					anyadirUsuarios();
//
//				} catch (SQLException|ClassNotFoundException e) {
//					System.out.println( "Último comando: " + com );
//					 e.printStackTrace();
//				}
//			}
			
			public static void main(String[] args) throws ClassNotFoundException {
				String com = "";
				try {
					Class.forName( "org.sqlite.JDBC" );
					con = DriverManager.getConnection( "jdbc:sqlite:BD" );
					st = con.createStatement();
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
				}catch (SQLException|ClassNotFoundException e) {
					System.out.println( "Último comando: " + com );
					e.printStackTrace();
			}
			}
	}

				
			


