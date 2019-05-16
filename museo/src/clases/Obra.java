package clases;

public class Obra {
	private String codObra;
	private String titulo;
	private String codCategoria;
	
	//Contructor
	public Obra(String codObra, String titulo, String codCategoria) {
		super();
		this.codObra = codObra;
		this.titulo = titulo;
		this.codCategoria = codCategoria;
	}
	public Obra() {
		super();
	}
	
	//Setters & getters
	public String getCodObra() {
		return codObra;
	}
	public void setCodObra(String codObra) {
		this.codObra = codObra;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCodCategoria() {
		return codCategoria;
	}
	public void setCodCategoria(String codCategoria) {
		this.codCategoria = codCategoria;
	}
	
}
