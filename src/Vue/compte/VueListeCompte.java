package Vue.compte;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modele.gestionBanque.ModelListerCompte;

import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.ListSelectionModel;

public class VueListeCompte extends JPanel {
	private JTable table;
	public static ModelListerCompte modelListe;
	private VueCompte parent;
	//private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public VueListeCompte(VueCompte p) {
		this.parent = p;
		if(modelListe==null)
			modelListe = new ModelListerCompte();
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
				
				parent.setSelectCompte(((ModelListerCompte)table.getModel()).getCompteAt(table.getSelectedRow()));
				parent.activerBouton();
			}
		});

	}
	
	public JTable getTable(){
		return this.table;
	}
	
	
	
	

}
