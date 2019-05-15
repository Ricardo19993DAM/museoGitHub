package clases;

public class Categoria {
	private String codCategoria;
	private String codCategoriaProviniente;
	
	//Constructor
	public Categoria(String codCategoria, String codCategoriaProviniente) {
		super();
		this.codCategoria = codCategoria;
		this.codCategoriaProviniente = codCategoriaProviniente;
	}

	public Categoria() {
		super();
	}
	
	//Setters & getters

	public String getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(String codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getCodCategoriaProviniente() {
		return codCategoriaProviniente;
	}

	public void setCodCategoriaProviniente(String codCategoriaProviniente) {
		this.codCategoriaProviniente = codCategoriaProviniente;
	}
	
		
	
	
}
