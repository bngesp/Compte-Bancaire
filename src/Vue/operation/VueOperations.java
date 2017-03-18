package Vue.operation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Modele.gestionBD.Client;
import Modele.gestionBD.Compte;
import Modele.gestionBD.Historique;
import Modele.gestionBanque.ModelListerClient;
import Modele.gestionBanque.ModelListerCompte;
import Modele.gestionBanque.ModelListerOperations;
import Vue.client.VueClient;

public class VueOperations extends JPanel {
	JPanel panel;
	JButton btnDebit;
	JButton btnRetrait;
	JButton btnListeOperation;
	VueListeOperation listeOperation;
	//VueMo modifCompte;
	Client selectClient=new Client();
	private JButton button;

	/**
	 * Create the panel.
	 */
	public VueOperations() {
		
		listeOperation = new VueListeOperation(this);
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
		
		JLabel label = new JLabel("Options Opérations");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Sitka Text", Font.BOLD, 17));
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		btnListeOperation = new JButton("     Lister      ");
		panel_3.add(btnListeOperation);
		btnListeOperation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				desactiveBouton();
				((CardLayout)panel.getLayout()).show(panel, "liste");
				
			}
		});
		
		btnDebit = new JButton("      Dépot     ");
		btnDebit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = listeOperation.getTable().getSelectedRow();
				selectClient=((ModelListerOperations)listeOperation.getTable().getModel()).getClientAt(index);
				String solde=JOptionPane.showInputDialog(VueOperations.this, "entre le montant que vous voulez deposer");
				//solde.matches();
				if(solde != null){
					try{
						selectClient.getCompte().depot(Integer.parseInt(solde));
						JOptionPane.showMessageDialog(VueOperations.this, "votre compte a éte crédité avec succes");
						
					}catch(NumberFormatException n){
						JOptionPane.showMessageDialog(VueOperations.this, "ce montant "+solde+" n'est pas valide");
						
					}
					catch(IllegalArgumentException a){
						JOptionPane.showMessageDialog(VueOperations.this, "le solde de votre compte est inferieur à la valeur saisie");
					}
					
				}
			}
		});
		panel_3.add(btnDebit);
		
		btnRetrait = new JButton("    Retrait     ");
		panel_3.add(btnRetrait);
		button = new JButton("Historique");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = listeOperation.getTable().getSelectedRow();
				selectClient=((ModelListerOperations)listeOperation.getTable().getModel()).getClientAt(index);
				ArrayList<Historique> histo = Historique.getAllHistorique(selectClient.getCompte().getNumero());
				String tex="historique : \n";
				for(Historique h:histo)
				{
					tex+= h.getSoldeFinal()-h.getSoldeInitial() < 0 ? "débit\t" : "crédité\t";
					tex+="solde finale : "+h.getSoldeFinal()+"\t";
					tex+="le "+h.getDate()+"\n";
				}
				JOptionPane.showMessageDialog(VueOperations.this, tex, "historique compte", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		panel_3.add(button);
		btnRetrait.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = listeOperation.getTable().getSelectedRow();
				selectClient=((ModelListerOperations)listeOperation.getTable().getModel()).getClientAt(index);
				if(selectClient.getPrenom() != null){
					String solde=JOptionPane.showInputDialog(VueOperations.this, "entre le montant que vous voulez retirer");
					//solde.matches();
					if(solde != null){
							try{
								selectClient.getCompte().debit(Integer.parseInt(solde));
								JOptionPane.showMessageDialog(VueOperations.this, "compte debité avec succes");
								
							}catch(NumberFormatException n){
								JOptionPane.showMessageDialog(VueOperations.this, "ce montant "+solde+" n'est pas valide");
								
							}
							catch(IllegalArgumentException a){
								JOptionPane.showMessageDialog(VueOperations.this, "le solde de votre compte est inferieur à la valeur saisie");
							}
					}
				}
				
			}
		});
		
		
		
	
		
		panel = new JPanel(new CardLayout());
		panel.add(listeOperation, "liste");
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		desactiveBouton();

	}
	public void desactiveBouton(){
		btnRetrait.setEnabled(false);
		btnDebit.setEnabled(false);
		button.setEnabled(false);
	}
	
	public void activerBouton(){
		btnRetrait.setEnabled(true);
		btnDebit.setEnabled(true);
		button.setEnabled(true);

	}

	public void listerCompte(){
		desactiveBouton();
		((CardLayout)panel.getLayout()).show(panel, "liste");
	}
	
	
	public Client getSelectOperation() {
		return selectClient;
	}
	public void setSelectOperation(Client selectCompte) {
		this.selectClient = selectCompte;
	
	}
	
	
}
