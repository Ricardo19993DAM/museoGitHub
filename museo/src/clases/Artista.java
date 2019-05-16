package clases;

public class Artista extends Cliente{
	private String obraPrincipal;
	private String descripcion;
	
	//Contructores 
	
	
	public Artista(String obraPrincipal, String descripcion) {
		super();
		this.obraPrincipal = obraPrincipal;
		this.descripcion = descripcion;
	}

	public Artista() {
		super();
	}
	//Setters & getters

	public String getObraPrincipal() {
		return obraPrincipal;
	}

	public void setObraPrincipal(String obraPrincipal) {
		this.obraPrincipal = obraPrincipal;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
