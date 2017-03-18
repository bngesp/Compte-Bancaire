package Vue.admin.client;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Modele.gestionBanque.ModelListerClient;
import Modele.gestionBanque.ModelListerCompte;

public class VueListeClient extends JPanel {
	private JTable table;
	public static ModelListerClient modelListe;
	private VueClientAdmin parent;
	//private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public VueListeClient(VueClientAdmin p) {
		this.parent = p;
		//if(modelListe==null)
			modelListe = new ModelListerClient();
		table = new JTable(modelListe);
		//table.setTableHeader();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		//table.setModel();
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.setAutoCreateRowSorter(true);
		add(new JScrollPane(table));
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				//if()
				
				parent.setSelectClient(((ModelListerClient)table.getModel()).getClientAt(table.getSelectedRow()));
				parent.activerBouton();
			}
		});

	}
	
	public JTable getTable(){
		return this.table;
	}
	
	
	
	

}
