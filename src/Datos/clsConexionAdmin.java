package Datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Clases.Admin;




public class clsConexionAdmin {
	// Campos o Atributos
	private String Driver = "com.mysql.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/bd_gci";
	private String Usuario = "root";
	private String Clave = "mysql";
	private static Connection cn; // Conexión Java - MySQL
	private Statement cmd; // Comando SQL
	private ResultSet rs; // Contenedor de filas
	private CallableStatement pa; // Uso de Store Procedure
	private ArrayList<Admin> Lista;

	//Metodo Constructor
	public clsConexionAdmin() {
		try {
			Class.forName(Driver);
			cn = DriverManager.getConnection(URL, Usuario, Clave);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public Admin BuscarAdmin(int dni) {
		Admin ObjA = null;
		
		try {
			pa = cn.prepareCall("call BuscarAdminDNI(?)");
			pa.setInt(1, dni);
			rs = pa.executeQuery();
			if (rs.next()) {
				ObjA = new Admin(
						rs.getInt("dni_admin"),
						rs.getString("ID_admin")
						);
				}
			}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ObjA;
		
	}
	
	
}
