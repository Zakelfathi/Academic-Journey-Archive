package com.etudiant.beans;

public class Etudiant {
	// Définition des propriétés de l'étudiant
	private static String firstName; // prénom
	private static String lastName; // nom de famille
	private static String email; // adresse e-mail
	private static String cne; // Code National de l'Etudiant
	private static String dNaiss; // date de naissance
	private static String tele; // numéro de téléphone

	// Accesseur pour le prénom
	public String getFirstName() {
		return firstName;
	}
	
	// Mutateur pour le prénom
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	// Accesseur pour le nom de famille
	public String getLastName() {
		return lastName;
	}
	
	// Mutateur pour le nom de famille
	public void setLastName(String lastName) {
		Etudiant.lastName = lastName;
		// Utilisation de "Etudiant." pour accéder à la variable statique lastName
		// plutôt qu'à la variable d'instance "this.lastName"
	}
	
	// Accesseur pour l'adresse e-mail
	public String getEmail() {
		return email;
	}
	
	// Mutateur pour l'adresse e-mail
	public void setEmail(String email) {
		Etudiant.email = email;
	}
	
	// Accesseur pour la date de naissance
	public String getDNaiss() {
		return dNaiss;
	}
	
	// Mutateur pour la date de naissance
	public void setdNaiss(String dNaiss) {
		this.dNaiss = dNaiss;
	}
	
	// Mutateur pour le Code National de l'Etudiant
	public void setCne(String cne) {
		this.cne = cne;
	}
	
	// Accesseur pour le Code National de l'Etudiant
	public String getCne() {
		return cne;
	}

	// Accesseur pour le numéro de téléphone
	public String getTele() {
		return tele;
	}
	
	// Mutateur pour le numéro de téléphone
	public void setTele(String tele) {
		this.tele = tele;
	}
}
