package Modele.gestionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modele.gestionBD.BD.Connexion;

//import com.mysql.jdbc.Statement;

public class Client extends Personne {
	private int codeSecret;
    private Compte compte;
    private static Connection connect;
    
    public Client()
    {
    	this(null, null, "", 0, "", 0);
    }
    
	public Client(String nom, String prenom, String adresse, long cNI,
			String telephone, int codeSecret) {
		super(nom, prenom, adresse, cNI, telephone);
		this.codeSecret = codeSecret;
	}

	public int getCodeSecret() {
		return codeSecret;
	}

	public void setCodeSecret(int codeSecret) {
		this.codeSecret = codeSecret;
	}
	
	
	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public static void enregistrerClient(Client cl){
		try{
			connect=Connexion.getConnection();
			String req = "insert into client(nom, prenom, adresse, CNI, telephone,codeSecret, compte_numero) values(?,?,?,?,?,?,?)";
			PreparedStatement sta=connect.prepareStatement(req);
			sta.setString(1,cl.getNom());
			sta.setString(2,cl.getPrenom());
			sta.setString(3,cl.getAdresse());
			sta.setLong(4,cl.getCNI());
			sta.setString(5,cl.getTelephone());
			sta.setInt(6,cl.getCodeSecret());
			sta.setInt(7,cl.getCompte().getNumero());
			sta.execute();
			connect.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	public static Client getClient(int id){
		Client c= new Client();
		try{
			connect= Connexion.getConnection();
			String req = "select * from client where cni='"+id+"'";
			Statement s= connect.createStatement();
			ResultSet resultats=s.executeQuery(req);
			
			resultats.next();
			c.setNom(resultats.getString(2));
			c.setPrenom(resultats.getString(3));
			c.setAdresse(resultats.getString(4));
			c.setCNI(resultats.getLong(1));
			c.setTelephone(resultats.getString(5));
			c.setCodeSecret(resultats.getInt(6));
			c.setCompte(Compte.consulterCompte(resultats.getInt(7)));
			connect.close();
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return c;
	}
	
	public static ArrayList<Client> getAllClient(){
		ArrayList<Client> listClient = new ArrayList<Client>();
		
		try{
			connect= Connexion.getConnection();
			String req = "select * from client";
			Statement s= connect.createStatement();
			ResultSet resultats=s.executeQuery(req);
			
			while(resultats.next()){
				Client c= new Client();
				c.setNom(resultats.getString(2));
				c.setPrenom(resultats.getString(3));
				c.setAdresse(resultats.getString(4));
				c.setCNI(resultats.getLong(1));
				c.setTelephone(resultats.getString(5));
				c.setCodeSecret(resultats.getInt(6));
				c.setCompte(Compte.consulterCompte(resultats.getInt(7)));
				listClient.add(c);
			}
			connect.close();
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return listClient;
		
	}
	
	public static void supprimerClient(Client cl){
		try{
			connect=Connexion.getConnection();
			String req = "delete from Client where cni = ?";
			PreparedStatement sta=connect.prepareStatement(req);
			sta.setLong(1,cl.getCNI());
			sta.execute();
			connect.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	 
 
 
}
	public static boolean userExiste(String secret, String number){
		boolean c = false;
		try{
			System.out.println(number);
			//System.out.println(sec);
			
			connect= Connexion.getConnection();
			String req = "select count(*) from client where codesecret='"+secret+"' and compte_numero='"+number+"'";
			Statement s= connect.createStatement();
			ResultSet resultats=s.executeQuery(req);
			
			resultats.next();
			System.out.println(resultats.getInt(1));
			c = resultats.getInt(1) != 0 ;
			connect.close();
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return c; 
		
	}
	
	public static Client getCurrentClient(String secret, String number){
		Client c = new Client();
		try{
			System.out.println(number);
			//System.out.println(sec);
			
			connect= Connexion.getConnection();
			String req = "select * from client where codesecret='"+secret+"' and compte_numero='"+number+"'";
			Statement s= connect.createStatement();
			ResultSet resultats=s.executeQuery(req);
			
			resultats.next();
			System.out.println(resultats.getInt(1));
			c.setNom(resultats.getString(2));
			c.setPrenom(resultats.getString(3));
			c.setAdresse(resultats.getString(4));
			c.setCNI(resultats.getLong(1));
			c.setTelephone(resultats.getString(5));
			c.setCodeSecret(resultats.getInt(6));
			c.setCompte(Compte.consulterCompte(resultats.getInt(7)));
			
			
			connect.close();
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return c; 
		
	}

	public static Client getClientByCompte(Compte cpt){
		Client c = new Client();
		try{
			//System.out.println(number);
			//System.out.println(sec);
			
			connect= Connexion.getConnection();
			String req = "select * from client where compte_numero='"+cpt.getNumero()+"'";
			Statement s= connect.createStatement();
			ResultSet resultats=s.executeQuery(req);
			
			resultats.next();
			System.out.println(resultats.getInt(1));
			c.setNom(resultats.getString(2));
			c.setPrenom(resultats.getString(3));
			c.setAdresse(resultats.getString(4));
			c.setCNI(resultats.getLong(1));
			c.setTelephone(resultats.getString(5));
			c.setCodeSecret(resultats.getInt(6));
			c.setCompte(Compte.consulterCompte(resultats.getInt(7)));
			
			
			connect.close();
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return c; 
		
	}
	
	
}
