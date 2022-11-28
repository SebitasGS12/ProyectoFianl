package Clases;

public class Producto_Empleado {

	//Atributos Privados
	private int id_pro_emp ;
	private String id_emp ;
	private int id_pro; 
	private int stock;
	
	//Constructor
	public Producto_Empleado(int id_pro_emp, String id_emp, int id_pro, int stock) {
		this.id_pro_emp = id_pro_emp;
		this.id_emp = id_emp;
		this.id_pro = id_pro;
		this.stock = stock;
	}
	
	//Constructor vacio
	public Producto_Empleado() {
		
	}
	
	
	//Metodos Get y Set
	public int getId_pro_emp() {
		return id_pro_emp;
	}
	public void setId_pro_emp(int id_pro_emp) {
		this.id_pro_emp = id_pro_emp;
	}
	public String getId_emp() {
		return id_emp;
	}
	public void setId_emp(String id_emp) {
		this.id_emp = id_emp;
	}
	public int getId_pro() {
		return id_pro;
	}
	public void setId_pro(int id_pro) {
		this.id_pro = id_pro;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
