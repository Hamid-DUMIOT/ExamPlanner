package Autre;

public class Examen {

	Integer id;
	String titre,dur�e,idfilliere;


public Integer getId() {
		return id;
	}


	public String getTitre() {
		return titre;
	}


	public String getDur�e() {
		return dur�e;
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


	public void setDur�e(String dur�e) {
		this.dur�e = dur�e;
	}


	public void setIdfilliere(String idfilliere) {
		this.idfilliere = idfilliere;
	}


public Examen(Integer id ,String titre , 
		String dur�e , String idfilliere) {
	this.id = id;
	this.titre = titre;
	this.dur�e = dur�e;
	this.idfilliere= idfilliere;
}


public Examen(String titre, String dur�e) {
	this.titre = titre;
	this.dur�e = dur�e;
}
}
