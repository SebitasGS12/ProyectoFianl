package Clases;
import  java.util.Date;
public class Venta {
	
	//Atributos
	private int codigo;
	private String Nombre;
	private String Unidad;
	
	private double Cantidad;
	private double PrecioUnitario;
	private String Fecha;

	//Constructores
	public Venta(int codigo, String nombre, String unidad, double cantidad, double precioUnitario, String fecha) {
		this.codigo = codigo;
		Nombre = nombre;
		Unidad = unidad;
		Cantidad = cantidad;
		PrecioUnitario = precioUnitario;
		Fecha = fecha;
	}



	public Venta() {
	}



	//Métodos de lectura y escritura 

	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getNombre() {
		return Nombre;
	}



	public void setNombre(String nombre) {
		Nombre = nombre;
	}



	public double getCantidad() {
		return Cantidad;
	}



	public void setCantidad(double cantidad) {
		Cantidad = cantidad;
	}



	public String getUnidad() {
		return Unidad;
	}



	public void setUnidad(String unidad) {
		Unidad = unidad;
	}



	public double getPrecioUnitario() {
		return PrecioUnitario;
	}



	public void setPrecioUnitario(double precioUnitario) {
		PrecioUnitario = precioUnitario;
	}



	public String getFecha() {
		return Fecha;
	}



	public void setFecha(String fecha) {
		Fecha = fecha;
	}



	//Métodos Adicionales
	
	public double SubTotal(){
		return this.Cantidad*this.PrecioUnitario;
	}

	public double IGV(){
		return SubTotal()*0.18;
	}
	public double ImportePagar(){
		return SubTotal()+IGV();
	}
	
	
	
	

}
