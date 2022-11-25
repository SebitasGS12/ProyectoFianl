package CapaNegocio;


import java.util.ArrayList;


import Clases.Persona;
import Datos.clsConexionPersona;


public class NgcPersona {

	private clsConexionPersona ObjPersona;
	
	public NgcPersona() {
		ObjPersona = new clsConexionPersona();
	}
	
	public ArrayList<Persona> Lista() {
		return ObjPersona.ListarPersona();
	}
	
	public Persona BuscarDNI(int Dni){
		return ObjPersona.BuscarPersona(Dni);
	}
	
	public void Insertar(Persona ObjP) {
		ObjPersona.InsertarPersona(ObjP);
	}
	
	public void Modificar(Persona ObjP) {
		ObjPersona.ModificarPersona(ObjP);
	}
	
	public void Eliminar(int cod) {
		ObjPersona.EliminarPersona(cod);
	}
	
	
	

}
