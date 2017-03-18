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
	
	public static String getNomProfil(Profil p){
		if(p.compareTo(ADMINISTRATEURBANQUE) == 0)
			return "ADMINISTRATEUR";
		else if(p.compareTo(AGENTCAISSE) == 0)
			return "CAISSE";
		else if(p.compareTo(AGENTCOMPTABLE) == 0)
			return "COMPTABLE";
		
		else	return "DIRECTEUR";
		
	}


}
