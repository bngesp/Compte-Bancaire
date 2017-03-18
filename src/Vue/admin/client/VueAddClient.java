package Vue.admin.client;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Modele.gestionBD.Client;
import Modele.gestionBD.Compte;

public class VueAddClient extends JPanel {
	private JTextField cni;
	private JTextField nom;
	private JTextField prenom;
	private JTextField telephone;
	private JTextField adresse;
	private JPasswordField code;
	private VueClientAdmin parent;

	/**
	 * Create the panel.
	 */
	public VueAddClient(VueClientAdmin p) {
		parent = p;
		setLayout(new GridLayout(10, 0, 10, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		
		JLabel lblIdentificationCni = new JLabel("Identification CNI:");
		panel_2.add(lblIdentificationCni);
		
		cni = new JTextField();
		panel_2.add(cni);
		cni.setColumns(20);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		
		JLabel lblNomClient = new JLabel("Nom Client :         ");
		panel_3.add(lblNomClient);
		
		nom = new JTextField();
		panel_3.add(nom);
		nom.setColumns(20);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		
		JLabel lblPrenomClient = new JLabel("Prenom Client :     ");
		panel_4.add(lblPrenomClient);
		
		prenom = new JTextField();
		panel_4.add(prenom);
		prenom.setColumns(20);
		
		JPanel panel_5 = new JPanel();
		add(panel_5);
		
		JLabel lblTlphone = new JLabel("Téléphone             ");
		panel_5.add(lblTlphone);
		
		telephone = new JTextField();
		panel_5.add(telephone);
		telephone.setColumns(20);
		
		JPanel panel_6 = new JPanel();
		add(panel_6);
		
		JLabel lblAdresse = new JLabel("Adresse :               ");
		panel_6.add(lblAdresse);
		
		adresse = new JTextField();
		panel_6.add(adresse);
		adresse.setColumns(20);
		
		JPanel panel_7 = new JPanel();
		add(panel_7);
		
		JLabel lblCodeSecret = new JLabel("Code Secret      ");
		panel_7.add(lblCodeSecret);
		
		code = new JPasswordField();
		code.setEchoChar('*');
		code.setColumns(20);
		panel_7.add(code);
		
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel lblCompte = new JLabel("Numéro de Compte :                  ");
		panel.add(lblCompte);
		
		JComboBox<Integer> numCompte = new JComboBox<Integer>();
		numCompte.setModel(new DefaultComboBoxModel<Integer>(Compte.getListeCompteSansClient()));
		panel.add(numCompte);
		
		JPanel panel_8 = new JPanel();
		add(panel_8);
		
		JButton btnAnnuler = new JButton("Annuler");
		panel_8.add(btnAnnuler);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Client c = new Client(
						nom.getText(), 
						prenom.getText(), 
						adresse.getText(), 
						Long.parseLong(cni.getText()), 
						telephone.getText(), 
						Integer.parseInt(new String(code.getPassword())));
				c.setCompte(Compte.consulterCompte((Integer)numCompte.getSelectedItem()));
				parent.addClient(c);
				//c.enregistrerClient();
			}
		});
		panel_8.add(btnEnregistrer);

	}

}
