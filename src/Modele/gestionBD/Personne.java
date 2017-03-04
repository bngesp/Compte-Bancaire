package Modele.gestionBD;

public class Personne {
	private String nom;
	private String prenom;
	private String adresse;
	private long CNI;
	private String telephone;
	
	
	
	public Personne(String nom, String prenom, String adresse, long cNI,
			String telephone) {
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	

}
