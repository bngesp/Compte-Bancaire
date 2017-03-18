package Vue.admin.client;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Modele.gestionBD.Client;

public class VueModifierClient extends JPanel {
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private VueClientAdmin parent;
	private Client client;

	/**
	 * Create the panel.
	 */
	public VueModifierClient(VueClientAdmin p, Client c) {
		parent = p;
		client = c;
		setLayout(new GridLayout(10, 0, 10, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		
		JLabel lblIdentificationCni = new JLabel("Identification CNI:");
		panel_2.add(lblIdentificationCni);
		
		textField = new JTextField();
		textField.setText(client.getCNI()+"");
		panel_2.add(textField);
		textField.setColumns(20);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		
		JLabel lblNomClient = new JLabel("Nom Client :         ");
		panel_3.add(lblNomClient);
		
		textField_1 = new JTextField();
		textField.setText(client.getNom());
		panel_3.add(textField_1);
		textField_1.setColumns(20);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		
		JLabel lblPrenomClient = new JLabel("Prenom Client :     ");
		panel_4.add(lblPrenomClient);
		
		textField_2 = new JTextField();
		textField_2.setText(client.getPrenom());
		panel_4.add(textField_2);
		textField_2.setColumns(20);
		
		JPanel panel_5 = new JPanel();
		add(panel_5);
		
		JLabel lblTlphone = new JLabel("Téléphone             ");
		panel_5.add(lblTlphone);
		
		textField_3 = new JTextField();
		textField_3.setText(client.getTelephone());
		panel_5.add(textField_3);
		textField_3.setColumns(20);
		
		JPanel panel_6 = new JPanel();
		add(panel_6);
		
		JLabel lblAdresse = new JLabel("Adresse :               ");
		panel_6.add(lblAdresse);
		
		textField_4 = new JTextField();
		textField_4.setText(client.getAdresse());
		panel_6.add(textField_4);
		textField_4.setColumns(20);
		
		JPanel panel_8 = new JPanel();
		add(panel_8);
		
		JButton btnAnnuler = new JButton("Annuler");
		panel_8.add(btnAnnuler);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		panel_8.add(btnEnregistrer);

	}

}
