package clases;

import java.time.LocalDate;

import control.Manager;

public class Evento {
	private String codEvento;
	private int maxClientes;
	private int maxArtistas;
	private int contClientes;
	private int contArtistas;
	private LocalDate fecha;
	
	//Contructor
	public Evento(String codEvento, int maxClientes, int maxArtistas, int contClientes, int contArtistas,
			LocalDate fecha) {
		super();
		this.codEvento = codEvento;
		this.maxClientes = maxClientes;
		this.maxArtistas = maxArtistas;
		this.contClientes = contClientes;
		this.contArtistas = contArtistas;
		this.fecha = fecha;
	}
	public Evento() {
		super();
	}
	
	//Setters & getters
	public String getCodEvento() {
		return codEvento;
	}
	public void setCodEvento(String codEvento) {
		this.codEvento = codEvento;
	}
	public int getMaxClientes() {
		return maxClientes;
	}
	public void setMaxClientes(int maxClientes) {
		this.maxClientes = maxClientes;
	}
	public int getMaxArtistas() {
		return maxArtistas;
	}
	public void setMaxArtistas(int maxArtistas) {
		this.maxArtistas = maxArtistas;
	}
	public int getContClientes() {
		return contClientes;
	}
	public void setContClientes(int contClientes) {
		this.contClientes = contClientes;
	}
	public int getContArtistas() {
		return contArtistas;
	}
	public void setContArtistas(int contArtistas) {
		this.contArtistas = contArtistas;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String generarCodigo() {
		Manager manager=new Manager();
		int resu=0;
		try {
			resu=manager.getContEventos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resu+=1;
		return "E-"+resu;
		
	}
	
}
