package Autre;

public class Etudiant {

	

	public String getNom() {
		return nom;
	}




	public String getPrenom() {
		return prenom;
	}




	public int getNumEtu() {
		return numetu;
	}




	public String getFiliere() {
		return filiere;
	}




	public String getAnnee() {
		return annee;
	}







	public void setNom(String nom) {
		this.nom = nom;
	}




	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	public void setNumEtu(int numEtu) {
		numetu = numEtu;
	}




	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}




	public void setAnnee(String année) {
		this.annee = année;
	}



	




	


private Integer id;
	private String nom;
	private String prenom;
	private Integer numetu;
	private String filiere;
	private String annee;
	
	
	
	
    public Etudiant(Integer i, String nom,String prenom,Integer numetu,String filiere,
    		String annee) {
    	this.id = i;
    	this.nom = nom;
    	this.prenom = prenom;
    	this.numetu = numetu;
    	this.filiere = filiere;
    	this.annee = annee;
    }




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}
}
