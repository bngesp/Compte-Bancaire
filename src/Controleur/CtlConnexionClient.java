package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modele.gestionBanque.MdlConnexionClient;
import Vue.VueClient;
import Vue.VueConnexionClient;

public class CtlConnexionClient{
	
	public static int NBTENTATIVE=3;
	private VueConnexionClient vue; 
	private MdlConnexionClient model;
	
	public CtlConnexionClient(VueConnexionClient vue, MdlConnexionClient m){
		this.vue = vue; 
		this.model = m; 
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("OK")){
			if(NBTENTATIVE == 0){
				JOptionPane.showMessageDialog(vue, "Vous avez effectué plus de trois tentives ressayer ultérieument");
				vue.dispose();
				System.exit(0);
			}
			if(this.model.authentificationClient())
			{
				NBTENTATIVE=3;
				vue.setVisible(false);
				new VueClient(this.model.getClientConnecte());
				
			}
			else{
				NBTENTATIVE--;
				JOptionPane.showMessageDialog(vue, "Erreur d'authentifiaction il vous reste "+NBTENTATIVE+" tentatives!!. Vueillez ressayer");
			}	
		}else if(e.getActionCommand().equals("Cancel")){
			JOptionPane.showMessageDialog(vue, "Merci d'avoir utiliser notre application");
			vue.dispose();
			System.exit(0);
		}
	}

}
