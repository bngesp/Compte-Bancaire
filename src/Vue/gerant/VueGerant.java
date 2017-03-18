package Vue.gerant;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Modele.gestionBD.Gerant;
import Modele.gestionBanque.ModelListerClient;
import Modele.gestionBanque.ModelListerCompte;
import Modele.gestionBanque.ModelListerGerant;

public class VueGerant extends JPanel {
	JPanel panel;
	JButton btnModifierButton;
	JButton btnAjouterGerant;
	JButton btnFermetGerant;
	JButton btnListerGerant;
	JButton btnInformations;
	VueListeGerant listeGerant;
	VueModifierGerant modifGerant;
	VueAddGerant addGerant = new VueAddGerant(this);
	Gerant selectGerant=new Gerant();

	/**
	 * Create the panel.
	 */
	public VueGerant() {
		//if(listeCompte == null )
		//initListeCompte();
		modifGerant = new VueModifierGerant(this, selectGerant);
		listeGerant = new VueListeGerant(this);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {135, 25, 285, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 255));
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JLabel label = new JLabel("Menu Gerant");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Sitka Text", Font.BOLD, 17));
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		btnAjouterGerant = new JButton("Ajouter Gerant");
		panel_3.add(btnAjouterGerant);
		btnAjouterGerant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addGerant = new VueAddGerant(VueGerant.this);
				((CardLayout)panel.getLayout()).show(panel, "add");
				
			}
		});
		
		btnModifierButton = new JButton("Modifier Gerant");
		btnModifierButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout)panel.getLayout()).show(panel, "modif");
			}
		});
		panel_3.add(btnModifierButton);
		
		btnFermetGerant = new JButton("Supprimer Gerant ");
		panel_3.add(btnFermetGerant);
		btnFermetGerant.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = listeGerant.getTable().getSelectedRow();
				((ModelListerGerant)listeGerant.getTable().getModel()).removeGerant(index);//.getCompteAt(index);
				JOptionPane.showMessageDialog(VueGerant.this, "Gerant supprimer avec succes");
				updateListe();
			
			}
		});
		
		btnListerGerant = new JButton("Lister Gerant  ");
		panel_3.add(btnListerGerant);
		
		
		btnInformations = new JButton("Informations   ");
		panel_3.add(btnInformations);
		btnInformations.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = listeGerant.getTable().getSelectedRow();
				selectGerant=((ModelListerGerant)listeGerant.getTable().getModel()).getGerantAt(index);
				//Client c1 = Client.getClientByCompte(selectClient);
				if(selectGerant.getPrenom() != null)
					JOptionPane.showMessageDialog(VueGerant.this, "CNI : "+selectGerant.getCNI()+"\n"
							+ "Nom : "+selectGerant.getNom()+"\n"
									+ "Prenom : "+selectGerant.getPrenom()+"\n"
											+ "Telephone : "+selectGerant.getTelephone()+"\n"
													+ "Adresse : "+selectGerant.getAdresse()+"\n"
															+ "Login : "+selectGerant.getLogin()+"\n"
																+" mot de passe : " +selectGerant.getPassword()
																	+ "Profil : "+selectGerant.getProfil());
				else 
					JOptionPane.showMessageDialog(VueGerant.this, "ce compte ce compte n'est associé a un client");
			}
		});
		
		panel = new JPanel(new CardLayout());
		panel.add(addGerant, "add");
		panel.add(listeGerant, "liste");
		panel.add(modifGerant,"modif");
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		btnListerGerant.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				listerCompte();
				//((CardLayout)panel.getLayout()).show(panel, "liste");
			}
		});

	}
	public void desactiveBouton(){
		btnInformations.setEnabled(false);
		btnFermetGerant.setEnabled(false);
		btnModifierButton.setEnabled(false);
	}
	
	public void activerBouton(){
		btnInformations.setEnabled(true);
		btnFermetGerant.setEnabled(true);
		btnModifierButton.setEnabled(true);
	}

	public void listerCompte(){
		desactiveBouton();
		((CardLayout)panel.getLayout()).show(panel, "liste");
	}
	
	public void addGerant(Gerant c){
		((ModelListerGerant)listeGerant.getTable().getModel()).addGerant(c);
		listerCompte();
	}
	
	public void updateListe(){
		listeGerant.getTable().setModel(new ModelListerGerant());// = 
	}
	public Gerant getSelectGerant() {
		return selectGerant;
	}
	public void setSelectGerant(Gerant selectCompte) {
		this.selectGerant = selectCompte;
		modifGerant.setClient(selectCompte);
	}
	
	
}
