package Datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import Clases.Producto;

public class clsConexionProducto {

	
	private String Driver = "com.mysql.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/bd_gci";
	private String Usuario = "root";
	private String Clave = "mysql";
	private static Connection cn; // Conexión Java - MySQL
	private Statement cmd; // Comando SQL
	private ResultSet rs; // Contenedor de filas
	private CallableStatement pa; // Uso de Store Procedure
	private ArrayList<Producto> Lista;
	
	//Metodo Constructor
	
	public clsConexionProducto() {
		try {
			Class.forName(Driver);
			cn = DriverManager.getConnection(URL, Usuario, Clave);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	//Metodo Listar
	
		public ArrayList<Producto> ListarProducto(){
			
			Lista = new ArrayList<>();
			String SQL = "call ListarProducto()";
			try {
				pa = cn.prepareCall(SQL);
				rs = pa.executeQuery();
				while (rs.next()) {
					Producto ObjP = new Producto(
							rs.getInt("ID_pro"),
							rs.getString("nombre"),
							rs.getDouble("precioU"),
							rs.getString("detalle")
							);
					Lista.add(ObjP);
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage() );
			}
			return Lista;
		}
		
		//Metodo BuscarProducto
		public Producto BuscarProducto(int id) {
			Producto ObjP = null;
			
			try {
				pa = cn.prepareCall("call BuscarProducto(?)");
				pa.setInt(1, id);
				rs = pa.executeQuery();
				if (rs.next()) {
					ObjP = new Producto(
							rs.getInt("ID_pro"),
							rs.getString("nombre"),
							rs.getDouble("precioU"),
							rs.getString("detalle")
							);
					}
				}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return ObjP;
			
		}
		
		// Método InsertarProducto
		public void InsertarProducto(Producto ObjP) {
						
			try {
				pa = cn.prepareCall("call InsertarProducto(?,?,?,?)");
				pa.setInt(1, ObjP.getIdProducto());
				pa.setString(2, ObjP.getNom_pro());
				pa.setDouble(3, ObjP.getPrecio());
				pa.setString(4, ObjP.getDetalle());
				
				pa.executeUpdate();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
			
		
		// Método ModificarProducto
		public void ModificarProducto(Producto ObjP) {
							
			try {
				pa = cn.prepareCall("call ModificarProducto(?,?,?,?)");
				pa.setInt(1, ObjP.getIdProducto());
				pa.setString(2, ObjP.getNom_pro());
				pa.setDouble(3, ObjP.getPrecio());
				pa.setString(4, ObjP.getDetalle());
				pa.executeUpdate();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		// Método EliminarProducto
		public void EliminarProducto(int codigo) {
								
			try {
				pa = cn.prepareCall("call EliminarProducto(?)");
				pa.setInt(1, codigo);
				pa.executeUpdate();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	
	
	
	

}
