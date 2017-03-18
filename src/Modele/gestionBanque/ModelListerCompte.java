package Modele.gestionBanque;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Modele.gestionBD.Client;
import Modele.gestionBD.Compte;

public class ModelListerCompte extends AbstractTableModel{
	
	private ArrayList<Compte> clients = new ArrayList<Compte>();
	private final String[] entete = new String[]{
			"numero compte", "solde ", "Decouvert" 
	};
	
	public ModelListerCompte(){
		super();
		this.clients = Compte.getListeCompte();
	}

	

	@Override
	public int getRowCount() {
		
		return this.clients.size();
	}

	@Override
	public int getColumnCount() {
		
		return entete.length;
	}

	
	@Override
	public String getColumnName(int column) {
		
		return entete[column];
	}



	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
			case 0 : return clients.get(rowIndex).getNumero();
			case 1 : return clients.get(rowIndex).getSolde();
			case 2 : return clients.get(rowIndex).getDecouvert();
			//case 3 : return clients.get(rowIndex).getPrenom();
			default : return null;
		}
		
		//return null;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class[] columnTypes = new Class[] {
				Integer.class, Double.class, Double.class, 
			};
		return columnTypes[columnIndex];	
	}

	public void addCompte(Compte c){
		//Client.enregistrerClient(c);
		Compte.ouvrirCompte(c);
		clients.add(c);
		this.fireTableRowsInserted(clients.size()-1, clients.size()-1);
	}
	
	public void removeCompte(int rowIndex){
		Compte c = clients.get(rowIndex);//C.getClient(rowIndex);
		//Client.supprimerClient(c);
		Compte.fermerCompte(c.getNumero());
		clients.remove(rowIndex);
		this.fireTableRowsDeleted(rowIndex, rowIndex);
		
	}
	public Compte getCompteAt(int index){
		return this.clients.get(index);
	}
}
