package Modele.gestionBD;

import Modele.gestionBD.BD.Connexion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Compte {
	private int numero;
	private double solde;
	private double decouvert;
	private static Connection connect;
	
	
	
	public Compte(){
		this(0, 0, 0);
	}
	public Compte(int Numero){
		this.numero = Numero;
	}
	public Compte(int numero, double solde, double decouvert) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.decouvert = decouvert;
	}
	public Compte( double solde, double decouvert) {

		this.solde = solde;
		this.decouvert = decouvert;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public double getDecouvert() {
		return decouvert;
	}
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	public void depot(double somme)
	{
		double soldeinit = this.solde;
		this.solde+=somme;
		updateCompte();
		Historique.ajouterHistorique(soldeinit, this.solde, new Date(System.currentTimeMillis()), this.getNumero());
	
	}

	public void debit(double somme){
		if(this.solde < somme) throw new IllegalArgumentException();
		double soldeinit = this.solde;
		this.solde-=somme;
		updateCompte();
		Historique.ajouterHistorique(soldeinit, this.solde, new Date(System.currentTimeMillis()), this.getNumero());
	}
	
	public void updateCompte(){
		try{
			connect=Connexion.getConnection();
			String req = "update compte set solde = ?, decouvert = ? where numero = ?";
			PreparedStatement sta=connect.prepareStatement(req);
			sta.setDouble(1,this.getSolde());
			sta.setDouble(2,this.getDecouvert());
			sta.setInt(3,this.getNumero());
			sta.execute();
			connect.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static int ouvrirCompte(Compte cmp){
		try{
			connect=Connexion.getConnection();
			String req = "insert into compte(solde, decouvert) values(?,?)";
			PreparedStatement sta=connect.prepareStatement(req);
			sta.setDouble(1,cmp.getSolde());
			sta.setDouble(2,cmp.getDecouvert());
			sta.execute();
			connect.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		return Compte.getLastNumber();
	}
	public static Compte consulterCompte(int numero){
		connect=Connexion.getConnection();
		String req = "select * from compte where numero="+numero;
		Statement s;
		Compte cpt = new Compte();
		try {
			s = connect.createStatement();
			ResultSet resultats=s.executeQuery(req);
			resultats.next();
			cpt.setNumero(resultats.getInt(1));
			cpt.setSolde(resultats.getLong(2));
			cpt.setDecouvert(resultats.getLong(3));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cpt;
		
	}
	public static int getLastNumber(){
		connect=Connexion.getConnection();
		String req = "select count(*) from compte";
		Statement s;
		int val=0;
		try {
			s = connect.createStatement();
			ResultSet resultat = s.executeQuery(req);
			resultat.next();
			val = resultat.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return val;
		
	}
	public static boolean fermerCompte(int numero){
		boolean b=true;
		try{
			connect=Connexion.getConnection();
			String req = "delete from compte where numero = ?";
			PreparedStatement sta=connect.prepareStatement(req);
			sta.setInt(1,numero);
			b=sta.execute();
			connect.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return b;
	}
	
	public static ArrayList<Compte> getListeCompte(){
		ArrayList<Compte> listClient = new ArrayList<Compte>();
		
		try{
			connect= Connexion.getConnection();
			String req = "select * from compte";
			Statement s= connect.createStatement();
			ResultSet resultats=s.executeQuery(req);
			
			while(resultats.next()){
				Compte c= new Compte();
				c.setNumero(resultats.getInt(1));
				c.setSolde(resultats.getDouble(2));
				c.setDecouvert(resultats.getDouble(3));
				//c.setCompte(Compte.consulterCompte(resultats.getInt(6)));
				listClient.add(c);
			}
			connect.close();
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return listClient;
	}
	
	
	public static Integer []  getListeCompteSansClient(){
		ArrayList<Integer> listClient = new ArrayList<Integer>();
		
		try{
			connect= Connexion.getConnection();
			String req = "SELECT numero FROM Compte where numero not in (select numero from compte inner join client on client.compte_numero=compte.numero)";
			Statement s= connect.createStatement();
			ResultSet resultats=s.executeQuery(req);
			
			while(resultats.next()){
				//Compte c= new Compte();
				//c.setNumero(resultats.getInt(1));
				listClient.add(resultats.getInt(1));
			}
			connect.close();
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		Integer[] codes = new Integer[listClient.size()];
		int i =0;
		for(int c : listClient)
			codes[i++]=c;
		return codes;
		//return (Integer[])listClient.;
	}
	
}
