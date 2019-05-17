package clases;

public class Obra {
	private String codObra;
	private String titulo;
	private String imagen;
	private String codCategoria;
	private String id;
	
	//Contructor
	public Obra(String codObra, String titulo, String imagen, String codCategoria,String id) {
		super();
		this.codObra = codObra;
		this.titulo = titulo;
		this.imagen = imagen;
		this.codCategoria = codCategoria;
		this.id = id;
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
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
