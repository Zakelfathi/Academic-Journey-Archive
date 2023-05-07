package com.ensa.tp5.entities;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Reinscription implements Serializable {
	@Id
	@GeneratedValue
	private Long id_insc;
	@ManyToOne
	private Etudiant etudiant;
	private String dInscription;
	private String niveau;
	private String filiere;
	private String groupe;
	private String cycle;
	private String nbrAnneeInscription;

	public Reinscription() {
		super();
	}

	public Reinscription(Etudiant etudiant, String dInscription, String niveau, String filiere, String groupe,
			String cycle, String nbrAnneeInscription) {
		super();
		this.etudiant = etudiant;
		this.dInscription = dInscription;
		this.niveau = niveau;
		this.filiere = filiere;
		this.groupe = groupe;
		this.cycle = cycle;
		this.nbrAnneeInscription = nbrAnneeInscription;
	}

	public Long getId_insc() {
		return id_insc;
	}

	public void setId_insc(Long id_insc) {
		this.id_insc = id_insc;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public String getdInscription() {
		return dInscription;
	}

	public void setdInscription(String dInscription) {
		this.dInscription = dInscription;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getNbrAnneeInscription() {
		return nbrAnneeInscription;
	}

	public void setNbrAnneeInscription(String nbrAnneeInscription) {
		this.nbrAnneeInscription = nbrAnneeInscription;
	}
	
	

}
