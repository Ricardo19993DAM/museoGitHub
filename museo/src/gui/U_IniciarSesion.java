package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class U_IniciarSesion extends JDialog {
	private JTextField textId;
	private JTextField textContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					U_IniciarSesion dialog = new U_IniciarSesion();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public U_IniciarSesion() {
		setBounds(100, 100, 799, 568);
		getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(209, 207, 60, 20);
		getContentPane().add(lblId);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setBounds(209, 238, 60, 20);
		getContentPane().add(lblContrasena);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(279, 207, 195, 20);
		getContentPane().add(textId);
		
		textContrasena = new JTextField();
		textContrasena.setColumns(10);
		textContrasena.setBounds(279, 238, 195, 20);
		getContentPane().add(textContrasena);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(109, 428, 160, 36);
		getContentPane().add(btnRegistrar);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setBounds(504, 428, 160, 36);
		getContentPane().add(btnIniciarSesion);

	}

}
