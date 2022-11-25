package Clases;


public class Empleado extends Persona {

	private String ID_Emp;
	private String Puesto;
	
	
	//Constructor

	
	public Empleado(String iD_Emp, String puesto,int dni_Persona) {
		super(dni_Persona);
		ID_Emp = iD_Emp;
		Puesto = puesto;
	}



	public String getID_Emp() {
		return ID_Emp;
	}


	public String getPuesto() {
		return Puesto;
	}


	public void setID_Emp(String iD_Emp) {
		ID_Emp = iD_Emp;
	}


	public void setPuesto(String puesto) {
		Puesto = puesto;
	}

	

	
	
	
	
		
	
	
}
