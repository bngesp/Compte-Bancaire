package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.CardLayout;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public Main() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/Vue/images/logo.jpg")));
		setResizable(false);
		//setIconImage(new ImageIcon("images/logo.jpg").getImage());
		setTitle("Application de gestion de comptes bancaires");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 478);
		setVisible(true);
		addMenu();
		
		
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Separator.highlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.activeCaption);
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("application de gestion de Comptes Bancaires");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 23));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "name_133045877247657");
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1));
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(Main.class.getResource("/Vue/images/logo.jpg")));
		panel_3.add(label);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.window);
		panel_4.add(panel_5);
		
		JLabel label_1 = new JLabel("Bienvenue");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		panel_5.add(label_1);
		
		JLabel label_2 = new JLabel("Ce logiciel va vous permettre de gérer ");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(label_2);
		
		JLabel label_3 = new JLabel("l’ensemble de vos comptes bancaires et d’effectuer ");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(label_3);
		
		JLabel label_4 = new JLabel("un suivi budgétaire de vos recettes et dépenses");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(label_4);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		
		JButton button = new JButton("Demarrer");
		button.setForeground(new Color(65, 105, 225));
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBackground(Color.GREEN);
		panel_6.add(button);
	}
	
	public void addMenu(){
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAccueil = new JMenu("Accueil");
		mnAccueil.setMnemonic('A');
		menuBar.add(mnAccueil);
		
		JMenu mnAction = new JMenu("Comptes");
		mnAction.setMnemonic('c');
		menuBar.add(mnAction);
		
		JMenuItem mntmLister = new JMenuItem("Lister");
		mntmLister.setHorizontalAlignment(SwingConstants.CENTER);
		mntmLister.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mnAction.add(mntmLister);
		
		JMenuItem mntmModifier = new JMenuItem("Modifier");
		mntmModifier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mnAction.add(mntmModifier);
		
		JMenuItem mntmFermer = new JMenuItem("Fermer");
		mntmFermer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnAction.add(mntmFermer);
		
		JMenu mnClients = new JMenu("Clients");
		mnClients.setMnemonic('l');
		menuBar.add(mnClients);
		
		JMenuItem mntmLister_1 = new JMenuItem("Lister");
		mnClients.add(mntmLister_1);
		
		JMenuItem mntmAjouter = new JMenuItem("Ajouter");
		mnClients.add(mntmAjouter);
		
		JMenuItem mntmModifier_1 = new JMenuItem("Modifier");
		mnClients.add(mntmModifier_1);
		
		JMenuItem mntmSupprimer = new JMenuItem("Supprimer");
		mnClients.add(mntmSupprimer);
		
		JMenu mnOprations = new JMenu("Op\u00E9rations");
		mnOprations.setMnemonic('o');
		menuBar.add(mnOprations);
		
		JMenuItem mntmDepot = new JMenuItem("depot");
		mntmDepot.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		mnOprations.add(mntmDepot);
		
		JMenuItem mntmRetrait = new JMenuItem("retrait");
		mntmRetrait.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		mnOprations.add(mntmRetrait);
		
		JMenuItem mntmConsultation = new JMenuItem("consultation");
		mnOprations.add(mntmConsultation);
		
		JMenuItem mntmHistorique = new JMenuItem("historique");
		mnOprations.add(mntmHistorique);
		
		JMenu mnAPropos = new JMenu("A propos");
		mnAPropos.setMnemonic('p');
		menuBar.add(mnAPropos);
		
		JMenu mnAide = new JMenu("Aide ?");
		mnAide.setMnemonic('i');
		menuBar.add(mnAide);
	}


}
