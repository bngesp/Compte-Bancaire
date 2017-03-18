package Vue.gerant;

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
import Modele.gestionBD.Gerant;
import Modele.gestionBD.Profil;

public class VueAddGerant extends JPanel {
	private JTextField cni;
	private JTextField nom;
	private JTextField prenom;
	private JTextField telephone;
	private JTextField adresse;
	private JPasswordField code;
	private VueGerant parent;
	private JTextField login;

	/**
	 * Create the panel.
	 */
	public VueAddGerant(VueGerant p) {
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
		
		JLabel lblNomClient = new JLabel("Nom Gerant :         ");
		panel_3.add(lblNomClient);
		
		nom = new JTextField();
		panel_3.add(nom);
		nom.setColumns(20);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		
		JLabel lblPrenomClient = new JLabel("Prenom Gerant :     ");
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
		
		JLabel lblLogin = new JLabel("Login                   ");
		panel_7.add(lblLogin);
		
		login = new JTextField();
		panel_7.add(login);
		login.setColumns(20);
		
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel lblCodeSecret = new JLabel("Mot de passe     ");
		panel.add(lblCodeSecret);
		
		code = new JPasswordField();
		panel.add(code);
		code.setEchoChar('*');
		code.setColumns(20);
		
		JPanel panel_8 = new JPanel();
		add(panel_8);
		
		JLabel lblCompte = new JLabel("Profil du Gérant                 ");
		panel_8.add(lblCompte);
		
		JComboBox<String> numCompte = new JComboBox<String>();
		numCompte.setModel(new DefaultComboBoxModel(Profil.values()));

		panel_8.add(numCompte);
		//numCompte.setModel(new DefaultComboBoxModel<Integer>(Compte.getListeCompteSansClient()));
		
		JPanel panel_9 = new JPanel();
		add(panel_9);
		
		JButton btnAnnuler = new JButton("Annuler");
		panel_9.add(btnAnnuler);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		panel_9.add(btnEnregistrer);
		btnEnregistrer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Gerant c = new Gerant(
						nom.getText(), 
						prenom.getText(), 
						adresse.getText(), 
						Long.parseLong(cni.getText()), 
						telephone.getText(),
						login.getText(),
						new String(code.getPassword()),
						numCompte.getSelectedItem().toString()
						);
				//c.setCompte(Compte.consulterCompte((Integer)numCompte.getSelectedItem()));
				parent.addGerant(c);
				//c.enregistrerClient();
			}
		});

	}

}
