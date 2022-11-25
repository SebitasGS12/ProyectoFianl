package Clases;

public class Admin extends Persona {

	private String ID_Admin ;

	//Constructor
	
	public Admin(int dni_Persona,String iD_Admin) {
		super(dni_Persona);
		ID_Admin = iD_Admin;
	}

	//Getters y Setters
	
	public String getID_Admin() {
		return ID_Admin;
	}

	public void setID_Admin(String iD_Admin) {
		ID_Admin = iD_Admin;
	}
		
}
