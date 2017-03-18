package Modele.gestionBanque;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Modele.gestionBD.Gerant;
import Modele.gestionBD.Gerant;

public class ModelListerGerant extends AbstractTableModel{
	
	private ArrayList<Gerant> clients = new ArrayList<Gerant>();
	private final String[] entete = new String[]{
			"CNI", "Nom ", "Prenom", "profil" 
	};
	
	public ModelListerGerant(){
		super();
		this.clients = Gerant.getAllGerant();
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
			case 3 : return clients.get(rowIndex).getProfil().toString();
			default : return null;
		}
		
		//return null;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class[] columnTypes = new Class[] {
				Long.class, String.class, String.class, String.class 
			};
		return columnTypes[columnIndex];	
	}

	public void addGerant(Gerant c){
		Gerant.ajouterGerant(c);
		clients.add(c);
		this.fireTableRowsInserted(clients.size()-1, clients.size()-1);
	}
	
	public void removeGerant(int rowIndex){
		Gerant c = clients.get(rowIndex);//C.getClient(rowIndex);
		Gerant.supprimerGerant(c);
		//Compte.fermerCompte(c.getNumero());
		clients.remove(rowIndex);
		this.fireTableRowsDeleted(rowIndex, rowIndex);
		
	}
	public Gerant getGerantAt(int index){
		return this.clients.get(index);
	}
}
