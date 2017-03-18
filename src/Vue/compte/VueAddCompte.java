package Vue.compte;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.JTextField;

import Modele.gestionBD.Compte;

import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VueAddCompte extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static VueCompte parent;

	/**
	 * Create the panel.
	 */
	public VueAddCompte(VueCompte p) {
		if(parent == null)
			parent = p;
		setLayout(new GridLayout(14, 0, 0, 0));
		
		JPanel panel_5 = new JPanel();
		add(panel_5);
		
		JPanel panel = new JPanel();
		add(panel);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		
		JLabel lblSoldeDeparte = new JLabel("Solde Departe :    ");
		panel_2.add(lblSoldeDeparte);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(15);
		
		JLabel lblSoldeDparte = new JLabel("Solde d\u00E9parte :           ");
		
		textField = new JTextField();
		textField.setColumns(16);
		
		//panel_2.setLayout();
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		
		JLabel lblDecouvert = new JLabel("Decouvert      :     ");
		panel_3.add(lblDecouvert);
		
		textField_2 = new JTextField();
		textField_2.setColumns(15);
		panel_3.add(textField_2);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		
		JButton btnAnnuler = new JButton("Annuler");
		panel_4.add(btnAnnuler);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String solde = textField_1.getText();
				String decouvert = textField_2.getText();
				try{
					//Compte.ouvrirCompte();
					parent.addCompte(new Compte(Double.parseDouble(solde), Double.parseDouble(decouvert)));
					JOptionPane.showMessageDialog(VueAddCompte.this, "compte ajoute avec succes");
					//parent.updateListe();
					//parent.listerCompte();
					
				}catch(NumberFormatException n){
					JOptionPane.showMessageDialog(VueAddCompte.this, "erreur veuillez verificier ce que vous avez saisi !!");
				}
				
				
				
			}
		});
		panel_4.add(btnEnregistrer);

	}

}
