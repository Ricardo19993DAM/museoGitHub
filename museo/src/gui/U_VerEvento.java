package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;

public class U_VerEvento extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					U_VerEvento dialog = new U_VerEvento();
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
	public U_VerEvento() {
		setBounds(100, 100, 813, 574);
		getContentPane().setLayout(null);
		
		JLabel lbl_1 = new JLabel("Aristas");
		lbl_1.setBounds(86, 102, 46, 14);
		getContentPane().add(lbl_1);
		
		JList list = new JList();
		list.setBounds(86, 128, 171, 222);
		getContentPane().add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(267, 128, 17, 222);
		getContentPane().add(scrollBar);
		
		JButton btnVerPerfil = new JButton("Ver Perfil");
		btnVerPerfil.setBounds(294, 125, 160, 36);
		getContentPane().add(btnVerPerfil);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(550, 128, 184, 153);
		getContentPane().add(calendar);
		
		JLabel lbl_3 = new JLabel("Clientes:");
		lbl_3.setBounds(550, 328, 56, 14);
		getContentPane().add(lbl_3);
		
		JLabel lblArtistas = new JLabel("Artistas: ");
		lblArtistas.setBounds(550, 303, 56, 14);
		getContentPane().add(lblArtistas);
		
		JButton button = new JButton("Ver Perfil");
		button.setBounds(574, 428, 160, 36);
		getContentPane().add(button);
		
		JLabel lblRespuestaA = new JLabel("RespuestaA");
		lblRespuestaA.setBounds(607, 303, 79, 14);
		getContentPane().add(lblRespuestaA);
		
		JLabel lblRespuestaC = new JLabel("RespuestaC");
		lblRespuestaC.setBounds(607, 328, 79, 14);
		getContentPane().add(lblRespuestaC);

	}
}
