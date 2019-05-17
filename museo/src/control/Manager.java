package control;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import clases.Artista;
import clases.Cliente;
import clases.Evento;
import clases.Obra;
import clases.Registrado;

public class Manager {
	//Registrado
	public ArrayList<Registrado> getRegistros() throws Exception {
		DBManager dbManager = new DBManager();
		ArrayList<Registrado> registrados = dbManager.getRegistros();
		return registrados;
	}
	public void registrar(String idV,String passwdV,String nombreV, String dniV) throws Exception{
		
		DBManager dbManager = new DBManager();
		dbManager.registrar(idV, passwdV, nombreV, dniV);
	}
	//get Id portero
	public String getIdPortero() throws Exception{
		DBManager dbManager = new DBManager();
		return dbManager.getIdAdministrador();
	}
	//get Id administrador
	public String getIdAdministrador() throws Exception{
		DBManager dbManager = new DBManager();
		return dbManager.getIdPortero();
	}
	
	//regresar datos de un Registrado con su ID
	public Registrado getRegistradoById(String identificador) throws Exception{
		DBManager dbManager = new DBManager();	
		return dbManager.getRegistradoById(identificador);
	}
	/*actualizar datos registrado*/
	
	//Clientes
	//Get array clientes
	public ArrayList <Cliente> getClientes() throws Exception{
		DBManager dbManager = new DBManager();	
		return dbManager.getClientes();
	}
	/*actualizar datos cliente*/
	/*get datos by id*/
	//Artista
	//Get array artistas
	public ArrayList <Artista> getArtistas() throws Exception{
		DBManager dbManager = new DBManager();	
		return dbManager.getArtistas();
	}
	//Get array artistas de un evento
	public ArrayList <Artista> getArtistasDeEvento(String codEvento) throws Exception{
		DBManager dbManager = new DBManager();	
		return dbManager.getArtistasDeEvento(codEvento);
	}
	/*actualizar datos artista*/
	/*get datos by id artista*/
	//Evento
	
				/*dame datos de un! evento*/
	public ArrayList <Evento> getEventos() throws Exception{
		DBManager dbManager = new DBManager();
		ArrayList <Evento> eventos = dbManager.getEventos();
		return eventos;
	}
	
	public void setEvento(String codEvento,int mc, int ma, int cc, int ca,LocalDate fecha) throws Exception{
		DBManager dbManager = new DBManager();
		dbManager.setEvento(codEvento, mc, ma, cc, ca, fecha);
	}
	
	public void actualizarEvento(String codEvento,int mc, int ma,LocalDate fecha) throws Exception{
		DBManager dbManager = new DBManager();
		dbManager.actualizarEvento(codEvento, mc, ma, fecha);
	}
	public int getContEventos() throws Exception{
		DBManager dbManager = new DBManager();
		int resu = dbManager.getContEventos();
		return resu;
	}
	public void sumarCont(String codEvento, String tipo) throws Exception{
		DBManager dbManager = new DBManager();
		dbManager.sumarCont(codEvento, tipo);
	}
	
	//Obra
	public ArrayList <Obra> getTodasLasObras() throws Exception {
		DBManager dbManager = new DBManager();	
		return dbManager.getTodasLasObras();
	}
}
