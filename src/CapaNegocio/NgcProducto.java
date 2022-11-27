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
	
	public int CodigoAutogenerado() {
		
		int id = (Lista().get(tamanio()-1)).getIdProducto();
		
		if( tamanio()  == 0) {
			return 1001;
		}else {
			return id+1 ;
		}
			
	}
	
	private int tamanio() {
		return  Lista().size();
	}
	
	public ArrayList<Producto> FiltroID() {
		return ObjProducto.OrdenarID();
	}
	public ArrayList<Producto> FiltroNombre() {
		return ObjProducto.OrdenarNombre();
	}
	public ArrayList<Producto> FiltroPrecio() {
		return ObjProducto.OrdenarPrecio();
	}
	public ArrayList<Producto> filtroDetalle() {
		return ObjProducto.OrdenarDetalle();
	}
	

}
