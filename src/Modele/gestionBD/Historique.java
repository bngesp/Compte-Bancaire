package Modele.gestionBD;

import Modele.gestionBD.BD.Connexion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Historique {
	private int id;
	private double soldeInitial;
	private double soldeFinal;
	private Date date;
	private Compte compte;
	private static Connection connect;
	public Historique() {
		
	}	
	
	public Historique(int id, double soldeInitial, double soldeFinal,
			Date date, Compte compte) {
		super();
		this.id = id;
		this.soldeInitial = soldeInitial;
		this.soldeFinal = soldeFinal;
		this.date = date;
		this.compte = compte;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSoldeInitial() {
		return soldeInitial;
	}
	public void setSoldeInitial(double soldeInitial) {
		this.soldeInitial = soldeInitial;
	}
	public double getSoldeFinal() {
		return soldeFinal;
	}
	public void setSoldeFinal(double soldeFinal) {
		this.soldeFinal = soldeFinal;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	public static void ajouterHistorique(double soldeinit, double soldefin, Date date, int cpt){
		try{
			connect=Connexion.getConnection();
			String req = "insert into historique(solde_initial, solde_final, date, numero_compte) values(?,?,?,?)";
			PreparedStatement sta=connect.prepareStatement(req);
			sta.setDouble(1,soldeinit);
			sta.setDouble(2,soldefin);
			sta.setDate(3,date);
			sta.setInt(4,cpt);
			sta.execute();
			connect.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	

	public static ArrayList<Historique> getAllHistorique(int numeroCompte){
		ArrayList<Historique> histo= new ArrayList<Historique>();
		
		try{
			connect = Connexion.getConnection();
			String req = "select * from historique where numero_compte = "+numeroCompte;
			Statement s= connect.createStatement();
			ResultSet resultats=s.executeQuery(req);
			
			while(resultats.next()){
				Historique c= new Historique();
				c.setId(resultats.getInt(1));
				c.setSoldeInitial(resultats.getDouble(2));
				c.setSoldeFinal(resultats.getDouble(3));
				c.setDate(resultats.getDate(4));
				c.setCompte(Compte.consulterCompte(resultats.getInt(5)));
				histo.add(c);
			}
			connect.close();
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return histo;
	}
	
}
