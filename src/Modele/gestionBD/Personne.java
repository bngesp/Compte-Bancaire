package Modele.gestionBD;

public class Personne {
	private String nom;
	private String prenom;
	private String adresse;
	private long CNI;
	private long telephone;
	
	
	
	public Personne(String nom, String prenom, String adresse, long cNI,
			long telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		CNI = cNI;
		this.telephone = telephone;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public long getCNI() {
		return CNI;
	}
	public void setCNI(long cNI) {
		CNI = cNI;
	}
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
	

}
