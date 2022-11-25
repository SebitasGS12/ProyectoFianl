package CapaNegocio;

import java.util.ArrayList;

import Clases.Empleado;
import Datos.clsConexionVendedores;

public class NgcEmpleado {

	private clsConexionVendedores ObjEmp;
	
	
	public NgcEmpleado() {
		ObjEmp = new clsConexionVendedores();
	}
	
	public ArrayList<Empleado> Lista() {
		return ObjEmp.ListarVendedores();
	}

	public Empleado BuscarID(String cod){
		return ObjEmp.BuscarEmpleado(cod);
	}
	public Empleado BuscarDNI(int Dni){
		return ObjEmp.BuscarEmpleado(Dni);
	}
	
	public void Insertar(Empleado Emp) {
		ObjEmp.InsertarEmpleados(Emp);
		
	}
	
	public void Modificar(Empleado Emp) {
		ObjEmp.ModificarVendedores(Emp);
	}
	
	public void Eliminar(String cod) {
		ObjEmp.EliminarVendedores(cod);
	}
	
	public int tamanio() {
		return  Lista().size();
		
	}
	
	public String CodigoAutogenerado() {
		
		int id = Integer.parseInt(Lista().get(tamanio()-1).getID_Emp());
		
		if( tamanio()  == 0) {
			return "111";
		}else {
			
			return ""+(id+1);
			  
			
		}
		
	}
	
}
