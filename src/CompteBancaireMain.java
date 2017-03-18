import java.awt.EventQueue;

import Vue.VueConnexion;

public class CompteBancaireMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueConnexion frame = new VueConnexion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
