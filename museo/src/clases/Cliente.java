package clases;

public class Cliente extends Registrado {
	private String nombre;
	private String dni;
	
	//Contructor
	public Cliente(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		
		
		//prueba fvf
	}

	public Cliente() {
		super();
	}

	//Settger & getters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
}
