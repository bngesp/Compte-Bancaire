package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;

import Controleur.CtlConnexion;
import Modele.gestionBD.Profil;
import Modele.gestionBanque.MdlConnexion;

public class VueConnexion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueConnexion frame = new VueConnexion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VueConnexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("application de gestion de Comptes Bancaires");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Sitka Text", Font.BOLD, 12));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
		
		JLabel lblLogin = new JLabel("Login            ");
		panel_1.add(lblLogin);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(25);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		panel_1.add(lblMotDePasse);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(25);
		panel_1.add(passwordField);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(1,3
				));
		
		JLabel lblProfil = new JLabel("Profil                                        ");
		panel_2.add(lblProfil);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Profil.values()));
		panel_2.add(comboBox);
		
		JButton btnQuitter = new JButton("Quitter");
		panel_1.add(btnQuitter);
		btnQuitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				VueConnexion.this.dispose();
			}
		});
		
		JButton btnConnexion = new JButton("Connexion");
		panel_1.add(btnConnexion);

		btnConnexion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				new CtlConnexion(VueConnexion.this, new MdlConnexion(textField.getText(),new String (passwordField.getPassword()),comboBox.getSelectedItem().toString())
				).authentification();
			}
		});

	}

}
