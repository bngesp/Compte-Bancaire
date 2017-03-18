package Vue.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modele.gestionBD.Client;
import Modele.gestionBD.Compte;
import Modele.gestionBD.Historique;

import javax.swing.SwingConstants;

public class VueClient extends JFrame{

	
	JButton btnSolde;
	JButton btnRetrait;
	JButton btnHistorique;
	JButton btnDepot;
	Client client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] a){
		new VueClient(Client.getCurrentClient("1234", "1"));
	}

	
	/**
	 * Create the application.
	 */
	public VueClient(Client c) {
		this.client=c;
		initialize();
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//this = new JFrame();
		this.setTitle("Client");
		this.setBounds(100, 100, 475, 525);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		this.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBienvenue = new JLabel("      Bienvenue <dynamic> <dynamic>");
		lblBienvenue.setForeground(Color.BLUE);
		lblBienvenue.setFont(new Font("Sitka Text", Font.BOLD, 15));
		panel.add(lblBienvenue);
		
		JButton btnDeconnexion = new JButton("");
		btnDeconnexion.setBorder(null);
		btnDeconnexion.setToolTipText("deconnexion");
		btnDeconnexion.setIcon(new ImageIcon(VueClient.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-error.png")));
		panel.add(btnDeconnexion, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		this.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 2));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		btnSolde = new JButton("");
		btnSolde.setIcon(new ImageIcon(VueClient.class.getResource("/Vue/images/solde.jpg")));
		btnSolde.setToolTipText(" solde de votre compte");
		
		panel_2.add(btnSolde);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		btnRetrait = new JButton("");
		btnRetrait.setToolTipText("retirer de l'argent");
		btnRetrait.setIcon(new ImageIcon(VueClient.class.getResource("/Vue/images/retrait.jpg")));
		panel_3.add(btnRetrait);
		
		
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		btnHistorique = new JButton("");
		btnHistorique.setIcon(new ImageIcon(VueClient.class.getResource("/Vue/images/historique.jpg")));
		btnHistorique.setToolTipText("historique de votre compte");
		panel_4.add(btnHistorique);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		btnDepot = new JButton("");
		btnDepot.setToolTipText("deposer de l'argent");
		btnDepot.setIcon(new ImageIcon(VueClient.class.getResource("/Vue/images/depot.jpg")));
		panel_5.add(btnDepot);
		
		//ajout des listener
		btnSolde.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(VueClient.this, "le solde de votre compte est : "+client.getCompte().getSolde());
				
			}
		});
		
		btnRetrait.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String solde=JOptionPane.showInputDialog(VueClient.this, "entre le montant que vous voulez retirer");
				//solde.matches();
				if(solde != null){
						try{
							client.getCompte().debit(Integer.parseInt(solde));
							JOptionPane.showMessageDialog(VueClient.this, "compte debité avec succes");
							
						}catch(NumberFormatException n){
							JOptionPane.showMessageDialog(VueClient.this, "ce montant "+solde+" n'est pas valide");
							
						}
						catch(IllegalArgumentException a){
							JOptionPane.showMessageDialog(VueClient.this, "le solde de votre compte est inferieur à la valeur saisie");
						}
				}
				
				
			}
		});
	
		btnDepot.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String solde=JOptionPane.showInputDialog(VueClient.this, "entre le montant que vous voulez deposer");
				//solde.matches();
				if(solde != null){
					try{
						client.getCompte().depot(Integer.parseInt(solde));
						JOptionPane.showMessageDialog(VueClient.this, "votre compte a éte crédité avec succes");
						
					}catch(NumberFormatException n){
						JOptionPane.showMessageDialog(VueClient.this, "ce montant "+solde+" n'est pas valide");
						
					}
					catch(IllegalArgumentException a){
						JOptionPane.showMessageDialog(VueClient.this, "le solde de votre compte est inferieur à la valeur saisie");
					}
					
				}
				
				
				
			}
		});

		btnHistorique.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Historique> histo = Historique.getAllHistorique(client.getCompte().getNumero());
				String tex="historique : \n";
				for(Historique h:histo)
				{
					tex+= h.getSoldeFinal()-h.getSoldeInitial() < 0 ? "débit\t" : "crédité\t";
					tex+="solde finale : "+h.getSoldeFinal()+"\t";
					tex+="le "+h.getDate()+"\n";
				}
				JOptionPane.showMessageDialog(VueClient.this, tex, "historique compte", JOptionPane.INFORMATION_MESSAGE);
			}
		});

}
	
	public Client getClientConnecte(){return this.client;}
	public void setClientConnecte(Client c){this.client=c;}

}
