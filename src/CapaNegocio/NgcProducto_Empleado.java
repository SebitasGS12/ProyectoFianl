package CapaNegocio;

import java.util.ArrayList;

import Clases.Producto_Empleado;
import Datos.clsConexionProducto_Empleado;

public class NgcProducto_Empleado {
	private clsConexionProducto_Empleado objProducto_Empleado;
	
	public NgcProducto_Empleado() {
		objProducto_Empleado = new clsConexionProducto_Empleado();
	}
	
	public ArrayList<Producto_Empleado> Lista() {
		return objProducto_Empleado.ListarProductoEmpleado();
	}
	
	public Producto_Empleado Buscar(int id){
		return objProducto_Empleado.BuscarProducto_Empleado(id);
	}
	
	public ArrayList<Producto_Empleado> BuscarIdEmp(String id){
		return objProducto_Empleado.ListarProducto_EmpleadoIDEmp(id);
	}
	
	
	public void Insertar(Producto_Empleado ObjPE) {
		objProducto_Empleado.InsertarProducto_Empleado(ObjPE);
	}
	
	public void Modificar(Producto_Empleado ObjPE) {
		objProducto_Empleado.ModificarProducto_Empleado(ObjPE);
	}
	
	public void Eliminar(int cod) {
		objProducto_Empleado.EliminarProducto_Empleado(cod);
	}
	
	public int CodigoAutogenerado() {
		
		int id = (Lista().get(tamanio()-1)).getId_pro_emp();
		
		if( tamanio()  == 0) {
			return 2001;
		}else {
			return id+1 ;
		}
			
	}

	private int tamanio() {
		return  Lista().size();
	}
}
