package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSesionRegistro = new JButton("Iniciar Sesion / Registrarse");
		btnSesionRegistro.setBounds(30, 22, 170, 29);
		contentPane.add(btnSesionRegistro);
		
		JButton btnVerObras = new JButton("Ver Obras");
		btnVerObras.setBounds(309, 190, 160, 36);
		contentPane.add(btnVerObras);
		
		JButton btnVerEventos = new JButton("Ver Eventos");
		btnVerEventos.setBounds(309, 237, 160, 36);
		contentPane.add(btnVerEventos);
		
		JButton btnVerArtista = new JButton("Ver Artista");
		btnVerArtista.setBounds(309, 284, 160, 36);
		contentPane.add(btnVerArtista);
	}
}
