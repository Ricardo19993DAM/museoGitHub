package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	public ArrayList <Registrado> getRegistros() throws Exception{
		
		ArrayList <Registrado> registros = new ArrayList <Registrado>();
		this.openConnection();
		String select= "select * from registrado";
		ResultSet rs = stmt.executeQuery(select);
		while (rs.next()) {
			Registrado auxRegistrado=new Registrado(((Registrado) rs).getId(),((Registrado) rs).getPassword(),((Registrado) rs).getTipo());
			registros.add( auxRegistrado); // coches.add( rs.getString("matricula"));
		}
		rs.close();
		this.closeConnection();		
		return registros;
	}
	public void registrar(String idV,String passwdV,String nombreV, String dniV) throws Exception{
			String tipoV="Cliente";
			this.openConnection();
			String insert="insert into registrado (id,password,tipo) values('"+idV+"','"+passwdV+"', 'Cliente')";
			stmt.executeUpdate(insert);
			insert="insert into cliente (id,nombre,dni) values('"+idV+"','"+nombreV+"','"+dniV+"')";
			stmt.executeUpdate(insert);
			this.clone();
	}
	public ArrayList <Obra> getTodasLasObras() throws Exception {
		
		ArrayList <Obra> obras = new ArrayList <Obra>();
		this.openConnection();
		String select= "select * from obra";
		ResultSet rs = stmt.executeQuery(select);
		while (rs.next()) {
			Obra aux=new Obra();
			obras.add( aux); // coches.add( rs.getString("matricula"));
		}
		rs.close();
		this.closeConnection();		
		return obras;
	}
}
