package models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Etudiant implements Serializable {

	@Id 
	private long id_etudiant;
	private String nom;
	private String prenom;
	private String cin;
	@Transient
	@OneToMany(fetch = FetchType.LAZY)
	private List<Reinscription> reinscription;

	public Etudiant() {
		super();
	}

	
	public Etudiant(Long id,String nom, String prenom, String cin) {
		super();
		this.id_etudiant=id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
	}

	
	
	public long getId() {
		return id_etudiant;
	}

	public void setId(long id) {
		this.id_etudiant = id;
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

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public List<Reinscription> getReinscription() {
		return reinscription;
	}

	public void setReinscription(List<Reinscription> reinscription) {
		this.reinscription = reinscription;
	}


	@Override
	public String toString() {
		return "Etudiant [id_etudiant=" + id_etudiant + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin
				+ "]";
	}

	
	
}
