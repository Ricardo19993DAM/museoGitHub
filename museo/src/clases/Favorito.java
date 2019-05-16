package clases;

public class Favorito {
	private String idCliente;
	private String idArtista;
	
	//Contructor
	public Favorito(String idCliente, String idArtista) {
		super();
		this.idCliente = idCliente;
		this.idArtista = idArtista;
	}
	public Favorito() {
		super();
	}
	
	//Setters & getters
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getIdArtista() {
		return idArtista;
	}
	public void setIdArtista(String idArtista) {
		this.idArtista = idArtista;
	}
	
}
