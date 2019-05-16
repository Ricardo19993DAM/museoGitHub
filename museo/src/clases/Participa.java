package clases;

public class Participa {
	private String id;
	private String codEvento;
	
	//Contructor
	public Participa(String id, String codEvento) {
		super();
		this.id = id;
		this.codEvento = codEvento;
	}
	public Participa() {
		super();
	}
	
	//Setters & getters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodEvento() {
		return codEvento;
	}
	public void setCodEvento(String codEvento) {
		this.codEvento = codEvento;
	}
	
	
}
