package Autre;

public class Salle {

	
	private Integer idSalle;
	private String nom;
	private Integer capaciteAcceuil;
	private String plageDispo;
	
	
	public Salle(Integer idSalle,
	
	String nom,
	Integer capaciteAcceuil,
	String plageDispo) {
		this.idSalle = idSalle;
		this.nom = nom;
		this.capaciteAcceuil = capaciteAcceuil;
		this.plageDispo = plageDispo;
		
				}


	public Integer getIdSalle() {
		return idSalle;
	}


	public String getNom() {
		return nom;
	}


	public Integer getCapaciteAcceuil() {
		return capaciteAcceuil;
	}


	public String getPlageDispo() {
		return plageDispo;
	}


	public void setIdSalle(Integer idSalle) {
		this.idSalle = idSalle;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setCapaciteAcceuil(Integer capaciteAcceuil) {
		this.capaciteAcceuil = capaciteAcceuil;
	}


	public void setPlageDispo(String plageDispo) {
		this.plageDispo = plageDispo;
	}
}
