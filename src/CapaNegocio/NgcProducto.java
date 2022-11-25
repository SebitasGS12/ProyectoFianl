package CapaNegocio;


import java.util.ArrayList;


import Clases.Producto;
import Datos.clsConexionProducto;


public class NgcProducto{

	private clsConexionProducto ObjProducto;
	
	public NgcProducto() {
		ObjProducto = new clsConexionProducto();
	}
	
	public ArrayList<Producto> Lista() {
		return ObjProducto.ListarProducto();
	}
	
	public Producto Buscar(int id){
		return ObjProducto.BuscarProducto(id);
	}
	
	public void Insertar(Producto ObjP) {
		ObjProducto.InsertarProducto(ObjP);
	}
	
	public void Modificar(Producto ObjP) {
		ObjProducto.ModificarProducto(ObjP);
	}
	
	public void Eliminar(int cod) {
		ObjProducto.EliminarProducto(cod);
	}
	
	
	

}
