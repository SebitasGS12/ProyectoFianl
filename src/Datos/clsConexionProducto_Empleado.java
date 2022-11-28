package Datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import Clases.Producto_Empleado;

public class clsConexionProducto_Empleado {
	private String Driver = "com.mysql.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/bd_gci";
	private String Usuario = "root";
	private String Clave = "mysql";
	private static Connection cn; // Conexión Java - MySQL
	private Statement cmd; // Comando SQL
	private ResultSet rs; // Contenedor de filas
	private CallableStatement pa; // Uso de Store Procedure
	private ArrayList<Producto_Empleado> Lista;
	
	//Metodo Constructor
	
	public clsConexionProducto_Empleado() {
		try {
			Class.forName(Driver);
			cn = DriverManager.getConnection(URL, Usuario, Clave);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	//Metodo Listar
	
	public ArrayList<Producto_Empleado> ListarProductoEmpleado(){
		
		Lista = new ArrayList<>();
		String SQL = "call ListarProducto_Empleado()";
		try {
			pa = cn.prepareCall(SQL);
			rs = pa.executeQuery();
			while (rs.next()) {
				Producto_Empleado ObjPE = new Producto_Empleado(
						rs.getInt("ID_Pro_Emp"),
						rs.getString("ID_Emp"),
						rs.getInt("ID_Pro"),
						rs.getInt("stock")
						);
				Lista.add(ObjPE);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage() );
		}
		return Lista;
	}
	
	//Metodo BuscarProducto_Empleado
	public Producto_Empleado BuscarProducto_Empleado(int id) {
		Producto_Empleado ObjPE = null;
		
		try {
			pa = cn.prepareCall("call BuscarProducto_Empleado(?)");
			pa.setInt(1, id);
			rs = pa.executeQuery();
			if (rs.next()) {
				ObjPE = new Producto_Empleado(
						rs.getInt("ID_Pro_Emp"),
						rs.getString("ID_Emp"),
						rs.getInt("ID_Pro"),
						rs.getInt("stock")
						);
				}
			}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ObjPE;
		
	}
	
	//Metodo Listar Producto_Empleado segun Id Empleado
	public ArrayList<Producto_Empleado> ListarProducto_EmpleadoIDEmp(String id) {
		Lista = new ArrayList<>();
		String SQL = "call ListarProducto_EmpleadoIDEmp(?)";
		try {
			pa = cn.prepareCall(SQL);
			pa.setString(1,id);
			rs = pa.executeQuery();
			while (rs.next()) {
				Producto_Empleado ObjPE = new Producto_Empleado(
						rs.getInt("ID_Pro_Emp"),
						rs.getString("ID_Emp"),
						rs.getInt("ID_Pro"),
						rs.getInt("stock")
						);
				Lista.add(ObjPE);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage() );
		}
		return Lista;
		
	}
	// Método InsertarProducto_Empleado
	public void InsertarProducto_Empleado(Producto_Empleado ObjPE) {
					
		try {
			pa = cn.prepareCall("call InsertarProducto_Empleado(?,?,?,?)");
			pa.setInt(1, ObjPE.getId_pro_emp());
			pa.setString(2, ObjPE.getId_emp());
			pa.setInt(3, ObjPE.getId_pro());
			pa.setInt(4, ObjPE.getStock());
			
			pa.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
			
		
		// Método ModificarProducto_Empleado
	public void ModificarProducto_Empleado(Producto_Empleado ObjPE) {
						
		try {
			pa = cn.prepareCall("call ModificarProducto_Empleado(?,?,?,?)");
			pa.setInt(1, ObjPE.getId_pro_emp());
			pa.setString(2, ObjPE.getId_emp());
			pa.setInt(3, ObjPE.getId_pro());
			pa.setInt(4, ObjPE.getStock());
			pa.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Método EliminarProducto_Empleado
	public void EliminarProducto_Empleado(int codigo) {
							
		try {
			pa = cn.prepareCall("call EliminarProducto_Empleado(?)");
			pa.setInt(1, codigo);
			pa.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


}
