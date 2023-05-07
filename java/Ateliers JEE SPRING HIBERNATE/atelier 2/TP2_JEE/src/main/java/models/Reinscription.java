package models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Reinscription implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_inscription;
	private String date;
	private String groupe;
	private String niveau;
	private String cycle;
	
	@ManyToOne
	private Etudiant etudiant;
	
	
	public Reinscription() {
		super();
	}

	public Reinscription(String date, String groupe, String niveau, String cycle, Etudiant etudiant) {
		super();
		this.date = date;
		this.groupe = groupe;
		this.niveau = niveau;
		this.cycle = cycle;
		this.etudiant = etudiant;
	}

	public long getId() {
		return id_inscription;
	}

	public void setId(long id) {
		this.id_inscription = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	@Override
	public String toString() {
		return "Reinscription [id_inscription=" + id_inscription + ", date=" + date + ", groupe=" + groupe + ", niveau="
				+ niveau + ", cycle=" + cycle + "]";
	}
	
	
	
	
	
}
