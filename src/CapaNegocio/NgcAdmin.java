package CapaNegocio;


import Clases.Admin;
import Datos.clsConexionAdmin;

public class NgcAdmin {

	private clsConexionAdmin ObjAdmin;
	
	public NgcAdmin() {	
		
		ObjAdmin = new clsConexionAdmin();
		
	}
	public Admin BuscarDNI(int Dni){
		return ObjAdmin.BuscarAdmin(Dni);
	}
}
