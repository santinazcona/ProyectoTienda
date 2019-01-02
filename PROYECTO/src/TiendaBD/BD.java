package TiendaBD;

import java.sql.*;
import java.util.ArrayList;

import Clases.Articulo;
import Clases.Carrito;
import Clases.Usuario;

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
	
    public static void crearTablas() {
    	ArrayList<String> tablas = new ArrayList<String>();
        
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
    	
    	tablas.add("CREATE TABLE IF NOT EXISTS articulos (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	cod int,\n"
                + "	nombre text,\n"
                + "	tipo text,\n"
                + "	foto text,\n"
                + "	precio real,\n"
                + "	cantidad int,\n"
                + "	descripcion text\n"
                + ");");
    	
    	tablas.add("CREATE TABLE IF NOT EXISTS compra (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	dnicliente text,\n"
                + "	codigoarticulo int,\n"
                + "	precio real\n"
                + ");");
    	
    	tablas.add("CREATE TABLE IF NOT EXISTS carrito (\n"
                + "	id integer PRIMARY KEY,\n"
    			+ " usuario TEXT,\n"
                + "	cod int,\n"
                + "	tipo TEXT,\n"
                + "	precio real\n"
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
    
    public static void cargarProductos() {
    	ArrayList<Articulo> articulos = new ArrayList<Articulo>();
    	articulos.add(new Articulo(111, "Tarjeta 1", "tarjeta", "tarj1.jpg", (float) 99.99, 5, "Tarjeta para Video Juegos"));
    	articulos.add(new Articulo(112, "Tarjeta 2", "tarjeta", "tarj2.jpg", (float) 190, 5, "Tarjeta para Diseno Grafico"));
    	articulos.add(new Articulo(113, "Tarjeta 3", "tarjeta", "tarj3.jpg", (float) 50, 5, "Tarjeta para Excel"));
    	
    	articulos.add(new Articulo(542, "Ordenador 1", "ordenador", "ord1.jpg", (float) 500, 5, "Ordenador para Video Juegos"));
    	articulos.add(new Articulo(543, "Ordenador 2", "ordenador", "ord2.jpg", (float) 700, 5, "Ordenador para Diseno Grafico"));
    	articulos.add(new Articulo(544, "Ordenador 3", "ordenador", "ord3.jpg", (float) 1500, 5, "Ordenador para Excel"));

    	for(Articulo art : articulos) {
    		insertarArticulo(art);
    	}
    	
    }
    
	public static ArrayList<Articulo> extraerArticulos(){
        String com = "SELECT * "
        		+ "FROM articulos";
        ArrayList<Articulo> tarjetas = new ArrayList<Articulo>();
        try {
        	Statement st = con.createStatement();
        	ResultSet rs = st.executeQuery(com);
            // loop through the result set
	        while (rs.next()) {
	        	tarjetas.add(new Articulo(
	        			rs.getInt(2),
	        			rs.getString(3),
	        			rs.getString(4),
	        			rs.getString(5),
	        			rs.getFloat(6),
	        			rs.getInt(7),
	        			rs.getString(8)
	        			));
	            }
	        return tarjetas;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
	    return null;
	}
	
	public static Articulo extraerArticulos(int CODIGO){
        String com = "SELECT * "
        		+ "FROM articulos "
        		+ "WHERE cod="+CODIGO;
        Articulo art = null;
        try {
        	Statement st = con.createStatement();
        	ResultSet rs = st.executeQuery(com);
            // loop through the result set
	        while (rs.next()) {
	        	art = new Articulo(
	        			rs.getInt(2),
	        			rs.getString(3),
	        			rs.getString(4),
	        			rs.getString(5),
	        			rs.getFloat(6),
	        			rs.getInt(7),
	        			rs.getString(8)
	        			);
	            }
	        return art;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
	    return null;
	}
	
	public static void insertarArticulo(Articulo art){
		String com = "insert into articulos (cod, nombre, tipo, foto, precio, cantidad, descripcion) values "
				+ "('"+art.getCod()+"', '"+art.getNombre()+"','"+art.getTipo()+"', '"+art.getFoto()+"', '"+art.getPrecio()+"', '"+art.getCantidad()+"',"
						+ " '"+art.getDescripcion()+"')";
		try {
			st.executeUpdate(com);	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void insertarArticuloCarrito(Usuario usu, Carrito carrito){
		String com = "insert into carrito (usuario, cod, tipo, precio) values "
				+ "('"+usu.getNombre()+"','"+carrito.getCod()+"', '"+carrito.getTipo()+"', '"+carrito.getPrecio()+"')";
		try {
			st.executeUpdate(com);	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
			
	public static boolean insertarUsuario(Usuario u){
		String com = "INSERT INTO usuarios( nombre, apellido, direccion, poblacion, codigopostal, codigo, password, cuentabancaria ) values ('"+u.getNombre()+"', '"+u.getApellidos()+"', '"+u.getDireccion()+"', '"+u.getPoblacion()+"', '"+u.getCodigoPostal()+"', '"+u.getCodigoUsuario()+"','"+u.getPasswordUsuario()+"','"+u.getCuentaBancaria()+"')";
		try {
			st.executeUpdate(com);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
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
                			rs.getInt(8));
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

	public static boolean revisarUsuarioExiste(Usuario temp) {
        String com = "SELECT COUNT(*) "
        		+ "FROM usuarios "
        		+ "WHERE nombre='"+temp.getNombre()+"'";
        int valor = 0;
        
        try {
        	Statement st = con.createStatement();
        	ResultSet rs = st.executeQuery(com);
            // loop through the result set
            while (rs.next()) {
                valor = rs.getInt(1);
                if(valor == 1) {
                	return true;
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
	}

	public static ArrayList<Carrito> extraerCarrito(Usuario usuario) {
        String com = "SELECT * "
        		+ "FROM carrito "
        		+ "WHERE usuario='"+usuario.getNombre()+"'";
        ArrayList<Carrito> carr = new ArrayList<Carrito>();
        try {
        	Statement st = con.createStatement();
        	ResultSet rs = st.executeQuery(com);
            // loop through the result set
	        while (rs.next()) {
	        	carr.add(new Carrito(
	        			rs.getInt(3),
	        			rs.getString(4),
	        			rs.getFloat(5),
	        			usuario.getNombre(),
	        			rs.getInt(1)));
	            }
	        return carr;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
	    return null;
	}

	public static void comprarArticulo(String dni, int codigoArticulo, float precio) {
		String com = "insert into compra (dnicliente, codigoarticulo, precio) values "
				+ "('"+dni+"','"+codigoArticulo+"', '"+precio+"')";
		try {
			st.executeUpdate(com);	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void borrarAritucloCarrito(int id) {
		String com = "DELETE FROM carrito WHERE id="+id;
		try {
			st.executeUpdate(com);	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}