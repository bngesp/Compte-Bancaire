package Vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controleur.CtlConnexionClient;
import Modele.gestionBanque.MdlConnexionClient;

public class VueConnexionClient extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VueConnexionClient dialog = new VueConnexionClient();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VueConnexionClient() {
		setTitle("Connexion");
		setType(Type.POPUP);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setFont(new Font("Dialog", Font.PLAIN, 14));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 376, 234);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panel2 = new JPanel();
		contentPanel.add(panel2);
	
	
		JPanel panel1 = new JPanel();
		contentPanel.add(panel1);
	
		JLabel lblNumeroDeCompte = new JLabel("Numero de compte");
		panel1.add(lblNumeroDeCompte);
	
		textField = new JTextField();
		panel1.add(textField);
		textField.setColumns(16);

		JPanel panel3 = new JPanel();
		contentPanel.add(panel3);
		JLabel lblCodeSecret = new JLabel("Code secret           ");
		panel3.add(lblCodeSecret);
		passwordField = new JPasswordField();
		passwordField.setColumns(16);
		passwordField.setEchoChar('*');
		panel3.add(passwordField);
	
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton okButton = new JButton("OK");
		//okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CtlConnexionClient(VueConnexionClient.this, new MdlConnexionClient(new String(passwordField.getPassword()), textField.getText()))
				.actionPerformed(e);;
				
			}
		});
	
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CtlConnexionClient(VueConnexionClient.this, new MdlConnexionClient(new String(passwordField.getPassword()), textField.getText()))
				.actionPerformed(e);;
				
			}
		});
		//cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		
			
		
	}
	
	public String getSecret(){return new String(this.passwordField.getPassword());}
	public String getNumero(){return textField.getText();}

}
