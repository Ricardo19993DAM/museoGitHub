package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollBar;

public class U_BuscarArtista extends JDialog {
	private JTextField textNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					U_BuscarArtista dialog = new U_BuscarArtista();
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
	public U_BuscarArtista() {
		setBounds(100, 100, 813, 561);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setBounds(134, 83, 46, 14);
		getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(190, 80, 334, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(544, 72, 160, 36);
		getContentPane().add(btnBuscar);
		
		JList list = new JList();
		list.setBounds(190, 138, 314, 222);
		getContentPane().add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(514, 138, 17, 222);
		getContentPane().add(scrollBar);
		
		JButton btnVerPerfil = new JButton("Ver Perfil");
		btnVerPerfil.setBounds(544, 384, 160, 36);
		getContentPane().add(btnVerPerfil);

	}
}
