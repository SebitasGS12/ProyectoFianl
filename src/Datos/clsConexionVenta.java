package Datos;

import java.beans.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import Clases.Venta;

public class clsConexionVenta {
	private String Driver="com.mysql.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/bd_gci";
	private String Usuario="root";
	private String Clave="mysql";
	private static Connection cn; //Conexion Java-MSQL 
	private Statement cmd;//Comando SQL 
	private ResultSet rs;//Contenedor de filas 
	private CallableStatement pa;//N os ayuda con los procedimientos almancenados de MSQL 
	private ArrayList<Venta> Lista;//
	
	// Método Constructor
	public clsConexionVenta() {
		try {
	         Class.forName(Driver);
	         cn = DriverManager.getConnection(URL, Usuario, Clave);
	      }

	      catch (Exception e) {
	         System.out.println(e.getMessage());
	      }
	}
	
	//Método Listar Ventas
	public ArrayList<Venta>ListarVentas(){
		Lista=new ArrayList<>();
		String SQL="call ListarVentas()";
		try{
			pa=cn.prepareCall(SQL);
			rs=pa.executeQuery();
			while(rs.next()){
				Venta ObjV=new Venta(
						rs.getInt("IdVenta"), 
						rs.getString("Nombre"), 
						rs.getString("Unidad"),
						rs.getDouble("Cantidad"), 
						rs.getDouble("PrecioUnit"), 
						rs.getString("Fecha"));
				Lista.add(ObjV);
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return Lista;
	}
	
	//Método Buscar Venta
	public ArrayList<Venta> BuscarVentas(String FechaD,String FechaH){
		
		try{
			Lista=new ArrayList<>();
			pa=cn.prepareCall("call BuscarVenta(?,?)");
			pa.setString(1, FechaD);
			pa.setString(2, FechaH);
			rs=pa.executeQuery();
			while(rs.next()){
				Venta ObjV=new Venta(rs.getInt("IdVenta"), 
						rs.getString("Nombre"), 
						rs.getString("Unidad"), 
						rs.getDouble("Cantidad"), 
						rs.getDouble("PrecioUnit"), 
						rs.getString("Fecha"));
				Lista.add(ObjV);
			}
			
		}
		catch(Exception e){
			//System.out.println(e.getMessage());
		}
		return Lista;
	}
	
	//Método para Insertar Venta 
	public void InsertarVenta(Venta ObjV){
		try {
            pa = cn.prepareCall("call InsertarVenta(?,?,?,?,?)");
            pa.setString(1, ObjV.getNombre());
            pa.setDouble(2, ObjV.getCantidad());
            pa.setString(3, ObjV.getUnidad());
            pa.setDouble(4, ObjV.getPrecioUnitario());
            pa.setString(5, ObjV.getFecha());
            pa.executeUpdate();
         }
         catch (Exception e) {
            System.out.println(e.getMessage());
         }
	}
	
	//Método para modificar Venta
	public void ModificarVenta(Venta ObjV){
		try {
            pa = cn.prepareCall("call ModificarVenta(?,?,?,?,?,?)");
            pa.setInt(1, ObjV.getCodigo());
            pa.setString(2, ObjV.getNombre());
            pa.setString(3, ObjV.getUnidad());
            pa.setDouble(4, ObjV.getCantidad());
            pa.setDouble(5, ObjV.getPrecioUnitario());
            pa.setString(6, ObjV.getFecha());
            pa.executeUpdate();
         }
         catch (Exception e) {
            System.out.println(e.getMessage());
         }
	}
	
	//Método para eliminar Venta
	public void EliminarVenta(int codigo){
		try {
            pa = cn.prepareCall("call EliminarVenta(?)");
            pa.setInt(1, codigo);
            pa.executeUpdate();
         }
         catch (Exception e) {
            System.out.println(e.getMessage());
         }

	}
}
	
	
	


