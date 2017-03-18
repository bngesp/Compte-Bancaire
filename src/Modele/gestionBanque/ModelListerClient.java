package Modele.gestionBanque;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Modele.gestionBD.Client;
import Modele.gestionBD.Compte;

public class ModelListerClient extends AbstractTableModel{
	
	private ArrayList<Client> clients = new ArrayList<Client>();
	private final String[] entete = new String[]{
			"CNI", "Nom ", "Prenom", "Numéro Compte" 
	};
	
	public ModelListerClient(){
		super();
		this.clients = Client.getAllClient();
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
			case 0 : return clients.get(rowIndex).getCNI();
			case 1 : return clients.get(rowIndex).getNom();
			case 2 : return clients.get(rowIndex).getPrenom();
			case 3 : return clients.get(rowIndex).getCompte().getNumero();
			default : return null;
		}
		
		//return null;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class[] columnTypes = new Class[] {
				Long.class, String.class, String.class, Integer.class 
			};
		return columnTypes[columnIndex];	
	}

	public void addClient(Client c){
		Client.enregistrerClient(c);
		clients.add(c);
		this.fireTableRowsInserted(clients.size()-1, clients.size()-1);
	}
	
	public void removeClient(int rowIndex){
		Client c = clients.get(rowIndex);//C.getClient(rowIndex);
		Client.supprimerClient(c);
		//Compte.fermerCompte(c.getNumero());
		clients.remove(rowIndex);
		this.fireTableRowsDeleted(rowIndex, rowIndex);
		
	}
	public Client getClientAt(int index){
		return this.clients.get(index);
	}
}
