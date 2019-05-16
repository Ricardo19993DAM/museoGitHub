package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;

public class U_VerObra extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					U_VerObra dialog = new U_VerObra();
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
	public U_VerObra() {
		setBounds(100, 100, 450, 300);

	}

}
