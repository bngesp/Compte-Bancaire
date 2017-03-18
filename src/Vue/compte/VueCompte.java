package Vue.compte;

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

import Modele.gestionBD.Client;
import Modele.gestionBD.Compte;
import Modele.gestionBanque.ModelListerCompte;

public class VueCompte extends JPanel {
	JPanel panel;
	JButton btnModifierButton;
	JButton btnAjouterCompte;
	JButton btnFermetCompte;
	JButton btnListerComptes;
	JButton btnInformations;
	VueListeCompte listeCompte;
	VueModifierCompte modifCompte;
	Compte selectCompte=new Compte();

	/**
	 * Create the panel.
	 */
	public VueCompte() {
		//if(listeCompte == null )
		//initListeCompte();
		modifCompte = new VueModifierCompte(this, selectCompte);
		listeCompte = new VueListeCompte(this);
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
		
		JLabel label = new JLabel("Options");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Sitka Text", Font.BOLD, 17));
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		btnAjouterCompte = new JButton("Ajouter Compte");
		panel_3.add(btnAjouterCompte);
		btnAjouterCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((CardLayout)panel.getLayout()).show(panel, "add");
				
			}
		});
		
		btnModifierButton = new JButton("Modifier Compte");
		btnModifierButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout)panel.getLayout()).show(panel, "modif");
			}
		});
		panel_3.add(btnModifierButton);
		
		btnFermetCompte = new JButton("Fermet Compte ");
		panel_3.add(btnFermetCompte);
		btnFermetCompte.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = listeCompte.getTable().getSelectedRow();
				((ModelListerCompte)listeCompte.getTable().getModel()).removeCompte(index);//.getCompteAt(index);
				JOptionPane.showMessageDialog(VueCompte.this, "Compte fermer avec succes");
				updateListe();
				listerCompte();
			/*	;
				//Client c1 = Client.getClientByCompte(c);
				if(Compte.fermerCompte(c.getNumero())){
					JOptionPane.showMessageDialog(VueCompte.this, "Compte fermer avec succes");
					updateListe();
					listerCompte();
				}
				else 
					JOptionPane.showMessageDialog(VueCompte.this, "erreur survenue lors de la fermeture");
			*/
			}
		});
		
		btnListerComptes = new JButton("Lister Comptes  ");
		panel_3.add(btnListerComptes);
		
		
		btnInformations = new JButton("Informations     ");
		panel_3.add(btnInformations);
		btnInformations.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = listeCompte.getTable().getSelectedRow();
				selectCompte=((ModelListerCompte)listeCompte.getTable().getModel()).getCompteAt(index);
				Client c1 = Client.getClientByCompte(selectCompte);
				if(c1.getPrenom() != null)
					JOptionPane.showMessageDialog(VueCompte.this, "ce compte appartient a : "+c1.getPrenom()+" "+c1.getNom());
				else 
					JOptionPane.showMessageDialog(VueCompte.this, "ce compte ce compte n'est associé a un client");
			}
		});
		
		panel = new JPanel(new CardLayout());
		panel.add(new VueAddCompte(this), "add");
		panel.add(listeCompte, "liste");
		panel.add(modifCompte,"modif");
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		btnListerComptes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				listerCompte();
				//((CardLayout)panel.getLayout()).show(panel, "liste");
			}
		});

	}
	public void desactiveBouton(){
		btnInformations.setEnabled(false);
		btnFermetCompte.setEnabled(false);
		btnModifierButton.setEnabled(false);
	}
	
	public void activerBouton(){
		btnInformations.setEnabled(true);
		btnFermetCompte.setEnabled(true);
		btnModifierButton.setEnabled(true);
	}

	public void listerCompte(){
		desactiveBouton();
		((CardLayout)panel.getLayout()).show(panel, "liste");
	}
	
	public void addCompte(Compte c){
		((ModelListerCompte)listeCompte.getTable().getModel()).addCompte(c);
		listerCompte();
	}
	
	public void updateListe(){
		listeCompte.getTable().setModel(new ModelListerCompte());// = 
	}
	public Compte getSelectCompte() {
		return selectCompte;
	}
	public void setSelectCompte(Compte selectCompte) {
		this.selectCompte = selectCompte;
		modifCompte.setCompte(selectCompte);
	}
	
	
}
