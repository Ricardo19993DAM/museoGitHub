package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class U_Registrar extends JDialog {
	private JTextField textId;
	private JTextField textContrasena;
	private JTextField textDni;
	private JTextField textNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					U_Registrar dialog = new U_Registrar();
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
	public U_Registrar() {
		setBounds(100, 100, 815, 571);
		getContentPane().setLayout(null);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(259, 200, 195, 20);
		getContentPane().add(textId);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblId.setBounds(164, 203, 69, 14);
		getContentPane().add(lblId);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblContrasena.setBounds(164, 234, 69, 14);
		getContentPane().add(lblContrasena);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDni.setBounds(164, 259, 69, 14);
		getContentPane().add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setBounds(164, 284, 69, 14);
		getContentPane().add(lblNombre);
		
		textContrasena = new JTextField();
		textContrasena.setColumns(10);
		textContrasena.setBounds(259, 231, 195, 20);
		getContentPane().add(textContrasena);
		
		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(259, 256, 195, 20);
		getContentPane().add(textDni);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(259, 281, 195, 20);
		getContentPane().add(textNombre);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(73, 444, 160, 36);
		getContentPane().add(btnVolver);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(522, 444, 160, 36);
		getContentPane().add(btnRegistrar);

	}

}
