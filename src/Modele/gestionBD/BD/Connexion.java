package Modele.gestionBD.BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
 
	private static Connection cnx;
	
	public static Connection getConnection(){
		try{
			Class.forName(Variables.DRIVER);
			cnx = (Connection)DriverManager.getConnection("jdbc:mysql://"+Variables.SERVEUR+":"+Variables.PORT+"/"+Variables.NOMBD,Variables.USER,Variables.MOTDEPASS);
		}catch(Exception e){
			System.out.println("erreur connexion");
		}
		return cnx;
	}
	
	

 

}


