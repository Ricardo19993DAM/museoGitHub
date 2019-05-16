package clases;

public class Entrada {
	private String id;
	private String codEvento;
	private String codigo;
	
	//Contructor
	public Entrada(String id, String codEvento, String codigo) {
		super();
		this.id = id;
		this.codEvento = codEvento;
		this.codigo = codigo;
	}
	public Entrada() {
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
}
