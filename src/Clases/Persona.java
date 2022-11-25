package Clases;


public class Persona {
	//Atributos Privados
	private int Dni_Persona;
	private String nombrePersona;
	private String apellidosPersona;
	private String correo;
	private int edad;
	private String contraseña ;

	//Constructor

	public Persona(int dni_Persona, String nombrePersona, String apellidosPersona, String correo, int edad,String contraseña) {
		Dni_Persona = dni_Persona;
		this.nombrePersona = nombrePersona;
		this.apellidosPersona = apellidosPersona;
		this.correo = correo;
		this.edad = edad;
		this.contraseña = contraseña;
	}
	
	public Persona(int dni_Persona, String nombrePersona, String apellidosPersona) {
		this.Dni_Persona = dni_Persona;
		this.nombrePersona = nombrePersona;
		this.apellidosPersona = apellidosPersona;
	}

	
	public Persona(int dni_Persona) {
		this.Dni_Persona = dni_Persona;
	}
	public Persona() {
		
	}

	

	//Metodos Getters and setters
	public int getDni_Persona() {
		return Dni_Persona;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public String getApellidosPersona() {
		return apellidosPersona;
	}

	public String getCorreo() {
		return correo;
	}

	public int getEdad() {
		return edad;
	}

	public void setDni_Persona(int dni_Persona) {
		Dni_Persona = dni_Persona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public void setApellidosPersona(String apellidosPersona) {
		this.apellidosPersona = apellidosPersona;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	
	
	
	
	
	
}
