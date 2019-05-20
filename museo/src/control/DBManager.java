package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import clases.Artista;
import clases.Cliente;
import clases.Entrada;
import clases.Evento;
import clases.Favorito;
import clases.Obra;
import clases.Participa;
import clases.Registrado;

public class DBManager {
	private Connection con;
	private Statement stmt;
	
	// Para acceder a la bases de datos
	private void openConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/museo";
		con = DriverManager.getConnection(url, "rpl", "123");
		stmt = con.createStatement();
	}
	// para cerrar la base de datos
	private void closeConnection() throws SQLException {
		stmt.close();
		con.close();
	}
	/*REGISTRADOS*/
	
	public ArrayList <Registrado> getRegistros() throws Exception{

		ArrayList <Registrado> registros = new ArrayList <Registrado>();
		this.openConnection();
		String select= "select * from registrado";
		ResultSet rs = stmt.executeQuery(select);
		while (rs.next()) {
			Registrado auxRegistrado=new Registrado(rs.getString("id"),rs.getString("password"),rs.getString("tipo"));
			registros.add( auxRegistrado); // coches.add( rs.getString("matricula"));
		}
		rs.close();
		this.closeConnection();		
		return registros;
	}

	
	
	//regresar datos de un Registrado con su ID
		public Registrado getRegistradoById(String identificador) throws Exception{
			//añadir si existe o no
			Registrado reg=null;
			this.openConnection();
			String select= "select * from registrado where id='"+identificador+'"';
			ResultSet rs = stmt.executeQuery(select);
			while (rs.next()) {
				reg=new Registrado(rs.getString("id"),rs.getString("password"),rs.getString("tipo"));
			}
			rs.close();
			this.closeConnection();		
			return reg;
		}
		public void actualizarRegistroMinimo(String idV,String passwordV,String antiguoId) throws Exception {

			this.openConnection();
			String update="Update registrado set id='"+idV+"', passwordV='"+passwordV+"' where id='"+antiguoId+"'";
			stmt.executeUpdate(update);
			this.closeConnection();	
		}
	/*PORTERO*/

	public String getIdPortero() throws Exception{

		String resu="portero";
		this.openConnection();
		String select= "select id from portero";
		ResultSet rs = stmt.executeQuery(select);
		while (rs.next()) {
			resu=rs.getString("id");
		}
		rs.close();
		this.closeConnection();		
		return resu;
	}
	
	public ArrayList<String> getEntradasHoy() throws Exception{
		ArrayList <String> eventos = new ArrayList <String>();
		this.openConnection();
		String select= "select dni,codigo from evento,cliente where evento.id=cliente.id and DATE_FORMAT(fecha, '%Y-%m-%d')='"+LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		ResultSet rs = stmt.executeQuery(select);
		while (rs.next()) {
			String auxEntrada=rs.getString("dni")+" - "+rs.getString("codigo");
			eventos.add( auxEntrada); // coches.add( rs.getString("matricula"));
		}
		rs.close();
		this.closeConnection();		
		return eventos;
		
	} 
	/*ADMINISTRADOR*/
	//get Id administrador
	public String getIdAdministrador() throws Exception{

		String resu="admin";
		this.openConnection();
		String select= "select id from administador";
		ResultSet rs = stmt.executeQuery(select);
		while (rs.next()) {
			resu=rs.getString("id");
		}
		rs.close();
		this.closeConnection();		
		return resu;
	}
	/*CLIENTE*/
	public Cliente geClienteById(String idV) throws Exception {
		this.openConnection();
		String select= "select * from cliente where id='"+idV+"'";
		ResultSet rs = stmt.executeQuery(select);
		Cliente auxCliente = null;
		while (rs.next()) {
			auxCliente=new Cliente(rs.getString("nombre"),rs.getString("dni"));
		}
		rs.close();
		this.closeConnection();		
		return auxCliente;
	}
	public void registrar(String idV,String passwdV,String nombreV, String dniV) throws Exception{
		
		this.openConnection();
		String insert="insert into registrado (id,password,tipo) values('"+idV+"','"+passwdV+"', 'Cliente')";
		stmt.executeUpdate(insert);
		insert="insert into cliente (id,nombre,dni) values('"+idV+"','"+nombreV+"','"+dniV+"')";
		stmt.executeUpdate(insert);
		//this.clone();
		this.closeConnection();	
	}
	//Actualizar
	public void actualizarRegistroCliente(String idV,String passwordV,String nombreV, String dniV,String antiguoId) throws Exception {

		this.openConnection();
		String update="Update cliente set id='"+idV+"', passwordV='"+passwordV+"', nombre='"+nombreV+"', dni='"+dniV+"' where id='"+antiguoId+"'";
		stmt.executeUpdate(update);
		this.closeConnection();	
	}
	public void clienteToArtista(String idV,String obraPrincipalV,String descV) throws Exception {
		this.openConnection();
		String insert="insert into artista (id,obraPrincipal,descripcion) values('"+idV+"','"+obraPrincipalV+"','"+descV+"')";
		stmt.executeUpdate(insert);
		String update="Update registrado set tipo='Artista' where id='"+idV+"'";
		stmt.executeUpdate(update);
		this.closeConnection();
	}
	public void altaCliente(String idV) throws Exception {
		this.openConnection();
		String delete="delete registrado where id='"+idV+"'";
		stmt.executeUpdate(delete);
		this.closeConnection();
	}
	//Get array clientes
	public ArrayList <Cliente> getClientes() throws Exception{

		ArrayList <Cliente> clientes = new ArrayList <Cliente>();
		this.openConnection();
		String select= "select registrado.id id,password, tipo,nombre,dni from registrado, cliente where registrado.id=cliente.id and registrado.id in(select id from clientes)";
		ResultSet rs = stmt.executeQuery(select);
		while (rs.next()) {
			Cliente auxC=new Cliente();
			auxC.setDatos(rs.getString("id"), rs.getString("password"), rs.getString("tipo"), rs.getString("nombre"), rs.getString("dni"));
			clientes.add(auxC);
		}
		rs.close();
		this.closeConnection();		
		return clientes;
	}
	/*ARTISTA*/
	//Get array artistas
	public ArrayList <Artista> getArtistas() throws Exception{

		ArrayList <Artista> artistas = new ArrayList <Artista>();
		this.openConnection();
		String select= "select registrado.id id,password, tipo,nombre,dni,obraPrincipal,descripcion from registrado, cliente, artista where registrado.id=cliente.id and cliente.id=artista.id and registrado.id in(select id from artistas)";
		ResultSet rs = stmt.executeQuery(select);
		while (rs.next()) {
			Artista auxC=new Artista();
			auxC.setDatos(rs.getString("id"), rs.getString("password"), rs.getString("tipo"), rs.getString("nombre"), rs.getString("dni"),rs.getString("obraPrincipal"),rs.getString("descripcion"));
			artistas.add(auxC);
		}
		rs.close();
		this.closeConnection();		
		return artistas;
	}
	//Get array artistas de un evento
	public ArrayList <Artista> getArtistasDeEvento(String codEvento) throws Exception{

		ArrayList <Artista> artistas = new ArrayList <Artista>();
		this.openConnection();
		String select= "select registrado.id id,password, tipo,nombre,dni,obraPrincipal,descripcion from registrado, cliente, artista where registrado.id=cliente.id and cliente.id=artista.id and registrado.id in(select id from participa)";
		ResultSet rs = stmt.executeQuery(select);
		while (rs.next()) {
			Artista auxC=new Artista();
			auxC.setDatos(rs.getString("id"), rs.getString("password"), rs.getString("tipo"), rs.getString("nombre"), rs.getString("dni"),rs.getString("obraPrincipal"),rs.getString("descripcion"));
			artistas.add(auxC);
		}
		rs.close();
		this.closeConnection();		
		return artistas;
	}
	//Get array artista por nombre
	public ArrayList <Artista> getArtistasNombre(String nombre) throws Exception{

		ArrayList <Artista> artistas = new ArrayList <Artista>();
		this.openConnection();
		//String select= "select registrado.id id,password, tipo,nombre,dni,obraPrincipal,descripcion from registrado, cliente, artista where registrado.id=cliente.id and cliente.id=artista.id and registrado.id in(select id from artistas)";
		PreparedStatement pstmt= con.prepareStatement("select registrado.id id,password, tipo,nombre,dni,obraPrincipal,descripcion from registrado, cliente, artista where registrado.id=cliente.id and cliente.id=artista.id and registrado.id in(select id from artistas) and lower(nombre)=lower('?')");
		//ResultSet rs = stmt.executeQuery(select);
		pstmt.setString(1,nombre);
		//PROVISIONAL
		ResultSet rs=pstmt.executeQuery();
		while (rs.next()) {
			Artista auxC=new Artista();
			auxC.setDatos(rs.getString("id"), rs.getString("password"), rs.getString("tipo"), rs.getString("nombre"), rs.getString("dni"),rs.getString("obraPrincipal"),rs.getString("descripcion"));
			artistas.add(auxC);
		}
		rs.close();
		this.closeConnection();		
		return artistas;
	}
	public void actualizarPerfilArtista(String idV,String descV,String obraPrincipal) throws Exception {
		this.openConnection();
		String update="Update artista set descV='"+descV+"' , obraPrincipal='"+obraPrincipal+"'";
		stmt.executeUpdate(update);
		this.closeConnection();
	}
	public Artista getArtistaById(String idV) throws Exception {
		this.openConnection();
		String select= "select * from artista where id='"+idV+"'";
		ResultSet rs = stmt.executeQuery(select);
		Artista auxArtista = null;
		while (rs.next()) {
			auxArtista=new Artista(rs.getString("obraPrincipal"),rs.getString("descripcion"));
		}
		rs.close();
		this.closeConnection();		
		return auxArtista;
	}
	/*PARTICIPA*/
	public ArrayList<Participa> getParticipacionesById(String idV) {
		return null;
		
	}
	
	/*EVENTO*/
	//DUDA, A LA HORA DE INSERTAR UN DATO DATE SE TIENE QUE TRANSFORMAR TO_DATE O SE PUEDE ENVIAR DIRECTAMENTE LA VARIABLE COMO STA DESDE JAVA?
	public ArrayList <Evento> getEventos() throws Exception{

		ArrayList <Evento> eventos = new ArrayList <Evento>();
		this.openConnection();
		String select= "select * from evento";
		ResultSet rs = stmt.executeQuery(select);
		while (rs.next()) {
			Evento auxEvento=new Evento(rs.getString("codEvento"),rs.getInt("maxClientes"),rs.getInt("maxArtistas"),rs.getInt("contClientes"),rs.getInt("contArtistas"),rs.getDate("fecha").toLocalDate());
			eventos.add( auxEvento); // coches.add( rs.getString("matricula"));
		}
		rs.close();
		this.closeConnection();		
		return eventos;
	}
	public void setEvento(String codEvento,int mc, int ma, int cc, int ca,LocalDate fecha) throws Exception{
	
		this.openConnection();
		String insert="insert into evento (codEvento,maxClientes,maxArtistas,contClientes,contArtistas,fecha) values('"+codEvento+"',"+mc+","+ma+","+cc+","+","+ca+","+fecha+")";
		stmt.executeUpdate(insert);
		//this.clone();
		this.closeConnection();	
	}
	public void actualizarEvento(String codEvento,int mc, int ma,LocalDate fecha) throws Exception{
	
		this.openConnection();
		String update="update evento set maxClientes="+mc+", maxArtistas="+ma+",fecha="+fecha+" where codEvento='"+codEvento+"'";
		stmt.executeUpdate(update);
		//this.clone();
		this.closeConnection();	
	}
	public int getContEventos() throws Exception{

		int resu = 0;
		this.openConnection();
		//Cuento cuantas hay ya que no permitimos que se puedan borrar
		String select= "select count(*) cantidad from evento";
		ResultSet rs = stmt.executeQuery(select);
		while (rs.next()) {
			resu=rs.getInt("cantidad");
		}
		rs.close();
		this.closeConnection();		
		return resu;
	}
	public void sumarCont(String codEvento, String tipo) throws Exception{
		String update;
		if (tipo.equalsIgnoreCase("cliente")) {
			update="update evento set contClientes="+1+"+contClientes where codEvento='"+codEvento+"'";
		}else {
			update="update evento set contArtistas="+1+"+contArtistas where codEvento='"+codEvento+"'";
		}
		this.openConnection();
		stmt.executeUpdate(update);
		//this.clone();
		this.closeConnection();	
	}
	/*PARTICIPA*/
	public void setParticipa(String id,String codEvento) throws Exception {
		String insert="insert into participa (id,codEvento) values ('"+id+"','"+codEvento+"')";
		this.openConnection();
		stmt.executeUpdate(insert);
		this.closeConnection();
	}
	/*public ArrayList<Entrada> getMisEntradas(String idV) throws Exception{
		ArrayList <Entrada> entradas = new ArrayList <Entrada>();
		this.openConnection();
		String select= "select * from entrada where id='"+idV+"'";
		ResultSet rs = stmt.executeQuery(select);
		while (rs.next()) {
			Entrada auxEntrada=new Entrada(rs.getString("id"),rs.getString("codEvento"),rs.getString("codigo"));
			entradas.add( auxEntrada); // coches.add( rs.getString("matricula"));
		}
		rs.close();
		this.closeConnection();		
		return entradas;
	}*/
	/*ENTRADA*/
	public void comprarEntrada(String idV, String codEventoV,String codigo) throws Exception {
		String insert="insert into entrada (id,codEvento,codigo) values('"+idV+"','"+codEventoV+"','"+codigo+"')";
		this.openConnection();
		stmt.executeUpdate(insert);
		this.closeConnection();
	}
	public ArrayList<Entrada> getMisEntradas(String idV) throws Exception{
		ArrayList <Entrada> entradas = new ArrayList <Entrada>();
		this.openConnection();
		String select= "select * from entrada where id='"+idV+"'";
		ResultSet rs = stmt.executeQuery(select);
		while (rs.next()) {
			Entrada auxEntrada=new Entrada(rs.getString("id"),rs.getString("codEvento"),rs.getString("codigo"));
			entradas.add( auxEntrada); // coches.add( rs.getString("matricula"));
		}
		rs.close();
		this.closeConnection();		
		return entradas;
	}
	/*OBRA*/
	//Obra
	public ArrayList <Obra> getTodasLasObras() throws Exception {

		ArrayList <Obra> obras = new ArrayList <Obra>();
		this.openConnection();
		String select= "select * from obra";
		ResultSet rs = stmt.executeQuery(select);
		while (rs.next()) {
			Obra aux=new Obra(rs.getString("codObra"),rs.getString("titulo"), rs.getString("imagen"),rs.getString("codCategoria"),rs.getString("id"));
			obras.add( aux); // coches.add( rs.getString("matricula"));
		}
		rs.close();
		this.closeConnection();		
		return obras;
	}
	public ArrayList <Obra> getTodasLasObrasArtista(String id) throws Exception {

		ArrayList <Obra> obras = new ArrayList <Obra>();
		this.openConnection();
		String select= "select * from obra where id='"+id+"'";
		ResultSet rs = stmt.executeQuery(select);
		while (rs.next()) {
			Obra aux=new Obra(rs.getString("codObra"),rs.getString("titulo"), rs.getString("imagen"),rs.getString("codCategoria"),rs.getString("id"));
			obras.add( aux); // coches.add( rs.getString("matricula"));
		}
		rs.close();
		this.closeConnection();		
		return obras;
	}
	public void setObra(String codObra, String codCategoria,String id, String imagen, String titulo) throws Exception {
		String insert="insert into obra (codObra,codCategoria,id,imagen,titulo) values('"+codObra+"','"+codCategoria+"','"+id+"','"+imagen+"','"+titulo+"')";
		this.openConnection();
		stmt.executeUpdate(insert);
		this.closeConnection();
	}
	/*CATEGORIA*/
	//existeCategoria
	public void setCategoria(String categoria) throws Exception {
		String insert="insert into categoria (codCategoria) values('"+categoria+"')";
		this.openConnection();
		stmt.executeUpdate(insert);
		this.closeConnection();
	}
	public void setCategoria(String categoria,String categoriaP) throws Exception {
		String insert="insert into categoria (codCategoria,codCategoriaProveniente) values('"+categoria+"','"+categoriaP+"')";
		this.openConnection();
		stmt.executeUpdate(insert);
		this.closeConnection();
	}
	/*FAVORITO*/
	public void setFavorito(String idV,String favorito) throws Exception {
		String insert="insert into favorito (codCliente,codArtista) values('"+idV+"','"+favorito+"')";
		this.openConnection();
		stmt.executeUpdate(insert);
		this.closeConnection();
	}
	public ArrayList <Favorito> getMisFavoritos(String idV) throws Exception{
		ArrayList <Favorito> favoritos = new ArrayList <Favorito>();
		this.openConnection();
		String select= "select * from favoritos where idCliente='"+idV+"'";
		ResultSet rs = stmt.executeQuery(select);
		while (rs.next()) {
			Favorito aux=new Favorito(rs.getString("codCliente"),rs.getString("codArtista"));
			favoritos.add( aux); // coches.add( rs.getString("matricula"));
		}
		rs.close();
		this.closeConnection();		
		return favoritos;
	}
}
