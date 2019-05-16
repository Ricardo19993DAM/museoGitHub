package clases;

public class Registrado implements Usuario {
	private String id;
	private String password;
	private String tipo;
	
	//Contructor
	public Registrado(String id, String password, String tipo) {
		super();
		this.id = id;
		this.password = password;
		this.tipo = tipo;
	}
	public Registrado() {
		super();
	}
	
	//Setters & getters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
