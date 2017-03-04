package Modele.gestionBD;

import Modele.gestionBD.BD.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Gerant extends Personne {
	private String login;
	private String password;
	private Profil profil;
	

	private static Connection connect;
	
	public Gerant(String nom, String prenom, String adresse, long cNI,
			String telephone, String login, String password) {
		super(nom, prenom, adresse, cNI, telephone);
		this.login = login;
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Profil getProfil() {
		return profil;
	}
	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public static void supprimerGerant(Gerant gr){
	try{
		connect=Connexion.getConnection();
		String req = "delete from gerant where cni="+gr.getCNI();
		connect.createStatement().execute(req);
		connect.close();
	}catch(SQLException e){
		System.out.println(e.getMessage());
	}
}
	public static void afficherInfoGerant(String pseudo){
		try{
			connect= Connexion.getConnection();
			String req = "select * from gerant where pseudo='"+pseudo+"'";
			Statement s= connect.createStatement();
			ResultSet resultats=s.executeQuery(req);
			while(resultats.next()){
				for (int i=1;i<=3;i++)
					System.out.println(resultats.getString(i) +" ");
				System.out.println();
			}
			connect.close();
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public static void 	ajouterGerant(Gerant gr){
		try{
			connect=Connexion.getConnection();
			String req = "insert  into gerant(nom, prenom, adresse, CNI, telephone,login, passsword,profil) values(?,?,?,?,?,?,?,?)";
			PreparedStatement sta=connect.prepareStatement(req);
			sta.setString(1,gr.getNom());
			sta.setString(2,gr.getPrenom());
			sta.setString(3,gr.getAdresse());
			sta.setLong(4,gr.getCNI());
			sta.setString(5,gr.getTelephone());
			sta.setString(6,gr.getLogin());
			sta.setString(7,gr.getPassword());
			sta.setString(8,gr.getProfil().toString());
			sta.execute();
			connect.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	 
	
	
	}
	
	public static boolean existeGerant(String login, String pass, String profil)
	{
		try{
			Connection connect=Connexion.getConnection();
			String req = "select count(*) from gerant where login=? and password=? and profil=?";
			PreparedStatement sta=connect.prepareStatement(req);
			sta.setString(1,login);
			sta.setString(2,pass);
			sta.setString(3,profil);
			ResultSet resultat=sta.executeQuery();
			
			resultat.next();
			return resultat.getInt(1) != 0;
		}catch(SQLException e){
			System.out.println(e.getMessage());
			return false;
		}
		
	}
}
