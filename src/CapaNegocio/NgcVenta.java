package CapaNegocio;

import java.util.ArrayList;

import Datos.clsConexionVenta;
import Clases.Venta;

public class NgcVenta {
	private clsConexionVenta ObjVenta;

	public NgcVenta() {
		ObjVenta = new clsConexionVenta();
	}
	//Cambiando los nombres a los métodos de la clase Datos
	public ArrayList<Venta>Lista(){
		return ObjVenta.ListarVentas();
	}
	public ArrayList<Venta>Buscar(String FechaD,String FechaH){
		return ObjVenta.BuscarVentas(FechaD, FechaH);
	}
	public void Insertar(Venta ObjV){
		ObjVenta.InsertarVenta(ObjV);
	}
	public void Modificar(Venta ObjV){
		ObjVenta.ModificarVenta(ObjV);
	}
	public void Eliminar(int codigo){
		ObjVenta.EliminarVenta(codigo);
	}
	
	

}
