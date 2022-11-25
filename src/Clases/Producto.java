package Clases;

public class Producto {

	//Atributos Privados
	private int idProducto;
	private String nom_pro;
	private double precio;
	private String detalle;
	
	//Constructor
	//	Constructor con todos los datos
	public Producto(int idProducto, String nom_pro ,  double precio, String detalle) {
		this.idProducto = idProducto;
		this.nom_pro = nom_pro;
		this.precio = precio;
		this.detalle = detalle;
	}
	
	//	Constructor sin detalle o descripcion
	public Producto(int idProducto, String nom_pro ,  double precio) {
		this.idProducto = idProducto;
		this.nom_pro = nom_pro;
		this.precio = precio;
	}
	
	
	
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNom_pro() {
		return nom_pro;
	}

	public void setNom_pro(String nom_pro) {
		this.nom_pro = nom_pro;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	 
	
	
	
	
	
	
	
	
	
	
}
