package Modele.gestionBanque;

import Modele.gestionBD.Client;

public class MdlConnexionClient {
	private String secret; 
	private String numero;
	public static Client c = new Client();
	
	public MdlConnexionClient(String s, String n){
		this.secret =s; 
		this.numero= n;
	}
	
	public boolean authentificationClient(){
		return Client.userExiste(secret, numero);
	}
	
	public Client getClientConnecte(){
		return Client.getCurrentClient(secret, numero);
	}
}
