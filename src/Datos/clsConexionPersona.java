package Datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Clases.Empleado;
import Clases.Persona;

public class clsConexionPersona {

	// Campos o Atributos
	private String Driver = "com.mysql.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/bd_gci";
	private String Usuario = "root";
	private String Clave = "mysql";
	private static Connection cn; // Conexión Java - MySQL
	private Statement cmd; // Comando SQL
	private ResultSet rs; // Contenedor de filas
	private CallableStatement pa; // Uso de Store Procedure
	private ArrayList<Persona> Lista;

	//Metodo Constructor
	public clsConexionPersona() {
		try {
			Class.forName(Driver);
			cn = DriverManager.getConnection(URL, Usuario, Clave);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	//Metodo Listar
	
	public ArrayList<Persona> ListarPersona(){
		
		Lista = new ArrayList<>();
		String SQL = "call ListarPersona()";
		try {
			pa = cn.prepareCall(SQL);
			rs = pa.executeQuery();
			while (rs.next()) {
				Persona ObjP = new Persona(
						rs.getInt("Dni_Persona"),
						rs.getString("nombrePersona"),
						rs.getString("apellidosPersona"),
						rs.getString("correo"),
						rs.getInt("edad"),
						rs.getString("contraseña")
						);
				Lista.add(ObjP);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage() );
		}
		return Lista;
	}
	
	//Metodo Buscar DNI
	
	public Persona BuscarPersona(int dni) {
		Persona ObjP = null;
		
		try {
			pa = cn.prepareCall("call BuscarPersonaDNI(?)");
			pa.setInt(1, dni);
			rs = pa.executeQuery();
			if (rs.next()) {
				ObjP = new Persona(
						rs.getInt("Dni_Persona"),
						rs.getString("nombrePersona"),
						rs.getString("apellidosPersona"),
						rs.getString("correo"),
						rs.getInt("edad"),
						rs.getString("contraseña")
						);
				}
			}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ObjP;
		
	}
	
	// Método InsertarPersona
	public void InsertarPersona(Persona ObjP) {
					
		try {
			pa = cn.prepareCall("call InsertarPersona(?,?,?,?,?,?)");
			pa.setInt(1, ObjP.getDni_Persona());
			pa.setString(2, ObjP.getNombrePersona());
			pa.setString(3, ObjP.getApellidosPersona());
			pa.setString(4, ObjP.getCorreo());
			pa.setInt(5, ObjP.getEdad());
			pa.setString(6, ObjP.getContraseña());
			pa.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	// Método ModificarPersona
	public void ModificarPersona(Persona ObjP) {
		
		try {
			pa = cn.prepareCall("call ModificarPersona(?,?,?,?,?,?)");
			
			pa.setInt(1, ObjP.getDni_Persona());
			pa.setString(2, ObjP.getNombrePersona());
			pa.setString(3, ObjP.getApellidosPersona());
			pa.setString(4, ObjP.getCorreo());
			pa.setInt(5, ObjP.getEdad());
			pa.setString(6, ObjP.getContraseña());
			pa.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Método EliminarPersona
	public void EliminarPersona(int codigo) {
							
		try {
			pa = cn.prepareCall("call EliminarPersona(?)");
			pa.setInt(1, codigo);
			pa.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
}
