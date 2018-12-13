package TiendaBD;

import java.sql.*;
import java.util.ArrayList;
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
	private static final String DIR_PROYECTO = System.getProperty("user.dir");
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	
	public static void conectar() {
		try {
			Class.forName( "org.sqlite.JDBC" );
			con = DriverManager.getConnection( "jdbc:sqlite:"+DIR_PROYECTO+"/BD.db" );
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
	
    public void crearTablas() {
    	ArrayList<String> tablas = new ArrayList<String>();
    	
    	tablas.add("CREATE TABLE IF NOT EXISTS articulos (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	nombre text,\n"
                + "	tipo text,\n"
                + " precio real,\n"
                + " cantidad int"
                + ");");
        
    	tablas.add("CREATE TABLE IF NOT EXISTS usuarios (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	nombre text,\n"
                + "	apellido text,\n"
                + "	direccion text,\n"
                + "	poblacion text,\n"
                + "	codigopostal int,\n"
                + "	codigo text,\n"
                + "	password text,\n"
                + "	cuentabancaria text\n"
                + ");");
    	
    	tablas.add("CREATE TABLE IF NOT EXISTS usuarios (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	nombre text,\n"
                + "	apellido text,\n"
                + "	direccion text,\n"
                + "	poblacion text,\n"
                + "	codigopostal int,\n"
                + "	codigo text,\n"
                + "	password text,\n"
                + "	cuentabancaria int\n"
                + ");");
    	
        try {
            // create a new table
        	for(String str : tablas) {
        		st.execute(str);
        	}
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
	
	public void insertarArticulo(int cod, String nombre, String tipo, String precio, int cantidad){
		String com = "insert into articulos ( cod, nombre, tipo, precio, cantidad ) values ('"+cod+"', '"+nombre+"', '"+tipo+"', '"+precio+"', '"+cantidad+"')";
		try {
				st.executeUpdate(com);
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
			
	public void insertarUsuario(LinkedList<Usuario> usuario){
		
		for(int i=0;i<usuario.size();i++){
			Usuario u = usuario.get(i);
			String com = "INSERT INTO usuarios( nombre, apellidos, direccion, poblacion, codigopostal, codigo, password, cuentabancaria ) values ('"+u.getNombre()+"', '"+u.getApellidos()+"', '"+u.getDireccion()+"', '"+u.getPoblacion()+"', '"+u.getCodigoPostal()+"', '"+u.getCodigoUsuario()+"','"+u.getPasswordUsuario()+"','"+u.getCuentaBancaria()+"')";
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
	
//    + "	nombre text,\n"
//    + "	apellido text,\n"
//    + "	direccion text,\n"
//    + "	poblacion text,\n"
//    + "	codigopostal int,\n"
//    + "	codigo text,\n"
//    + "	password text,\n"
//    + "	cuentabancaria text\n"
    public static Usuario revisarUsuario(String nombre, String password){
        String com = "SELECT COUNT(*),nombre,apellido,direccion,poblacion,codigopostal,codigo,cuentabancaria "
        		+ "FROM usuarios "
        		+ "WHERE nombre='"+nombre+"' AND password='"+password+"'";
        int valor = 0;
        
        try {
        	Statement st = con.createStatement();
        	ResultSet rs = st.executeQuery(com);
            // loop through the result set
            while (rs.next()) {
                valor = rs.getInt(1);
                if(valor == 1) {
                	return new Usuario(rs.getString(2),
                			rs.getString(3),
                			rs.getString(4),
                			rs.getString(5),
                			rs.getInt(6),
                			rs.getString(7),
                			, rs.getInt(8));
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
	
    public void selArticulo(){
        String com = "SELECT id, name, capacity FROM articulos";
        
        try {
             rs = st.executeQuery(com);
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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

