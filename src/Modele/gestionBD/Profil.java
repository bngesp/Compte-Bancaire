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
	
	public static Profil getProfil(String profil){
		if(profil.equals("ADMINISTRATEUR"))
			return ADMINISTRATEURBANQUE;
		else if(profil.equals("CAISSE"))
			return AGENTCAISSE;
		else if(profil.equals("COMPTABLE"))
			return AGENTCOMPTABLE;
		else	return DIRECTEURBANQUE;
		
		
	}
	


}
