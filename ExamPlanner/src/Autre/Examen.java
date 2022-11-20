package Autre;

public class Examen {

	Integer id;
	String titre,durée,idfilliere;


public Integer getId() {
		return id;
	}


	public String getTitre() {
		return titre;
	}


	public String getDurée() {
		return durée;
	}


	public String getIdfilliere() {
		return idfilliere;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public void setDurée(String durée) {
		this.durée = durée;
	}


	public void setIdfilliere(String idfilliere) {
		this.idfilliere = idfilliere;
	}


public Examen(Integer id ,String titre , 
		String durée , String idfilliere) {
	this.id = id;
	this.titre = titre;
	this.durée = durée;
	this.idfilliere= idfilliere;
}


public Examen(String titre, String durée) {
	this.titre = titre;
	this.durée = durée;
}
}
