
import java.awt.EventQueue;

import Vue.client.VueConnexionClient;

public class CompteBancaireClientMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueConnexionClient frame = new VueConnexionClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
