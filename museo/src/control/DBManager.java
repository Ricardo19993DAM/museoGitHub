package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import clases.Artista;
import clases.Cliente;
import clases.Evento;
import clases.Obra;
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

	//Cuentas registradas
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
	public void registrar(String idV,String passwdV,String nombreV, String dniV) throws Exception{
		
		this.openConnection();
		String insert="insert into registrado (id,password,tipo) values('"+idV+"','"+passwdV+"', 'Cliente')";
		stmt.executeUpdate(insert);
		insert="insert into cliente (id,nombre,dni) values('"+idV+"','"+nombreV+"','"+dniV+"')";
		stmt.executeUpdate(insert);
		//this.clone();
		this.closeConnection();	
	}
	//get Id portero
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
	//regresar datos de un Registrado con su ID
	public Registrado getRegistradoById(String identificador) throws Exception{

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
	//Get array artistas
	public ArrayList <Artista> getArtistas() throws Exception{

		ArrayList <Artista> artistas = new ArrayList <Artista>();
		this.openConnection();
		String select= "select registrado.id id,password, tipo,nombre,dni,obraPrincipa,descripcion from registrado, cliente, artista where registrado.id=cliente.id and cliente.id=artista.id and registrado.id in(select id from artistas)";
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
	//Get array artistas de un eveneto
	public ArrayList <Artista> getArtistasDeEvento(String codEvento) throws Exception{

		ArrayList <Artista> artistas = new ArrayList <Artista>();
		this.openConnection();
		String select= "select registrado.id id,password, tipo,nombre,dni,obraPrincipa,descripcion from registrado, cliente, artista where registrado.id=cliente.id and cliente.id=artista.id and registrado.id in(select id from artistas)";
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
	
	
	//Eventos
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
	//Obra
	public ArrayList <Obra> getTodasLasObras() throws Exception {

		ArrayList <Obra> obras = new ArrayList <Obra>();
		this.openConnection();
		String select= "select * from obra";
		ResultSet rs = stmt.executeQuery(select);
		while (rs.next()) {
			Obra aux=new Obra(rs.getString("codObra"),rs.getString("titulo"), rs.getString("imagen"),rs.getString("codCategoria"));
			obras.add( aux); // coches.add( rs.getString("matricula"));
		}
		rs.close();
		this.closeConnection();		
		return obras;
	}
}
