package Modele.gestionBD;

public enum Profil {

	ADMINISTRATEURBANQUE ("ADMINISTRATEUR"),
	AGENTCAISSE("CAISSE"),
	AGENTCOMPTABLE("COMPTABLE"),
	DIRECTEURBANQUE ("DIRECTEUR");
	
	private String name = "";
	   
	  //Constructeur
	Profil(String name){
	    	this.name = name;
	    }
	   
	public String toString(){
	    return name;
	}


}
