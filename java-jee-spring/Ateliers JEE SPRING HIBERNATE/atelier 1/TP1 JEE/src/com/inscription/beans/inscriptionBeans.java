package com.inscription.beans;

import com.etudiant.beans.Etudiant;

public class inscriptionBeans {

	private static Etudiant etudiant;
	private static String dInscription;
	private static String niveau;
	private static String filiere;
	private static String groupe;
	private static String cycle;
	private static String nbrAnneeInscription;
	
	
	public static Etudiant getEtudiant() {
		return etudiant;
	}
	public static void setEtudiant(Etudiant etudiant) {
		inscriptionBeans.etudiant = etudiant;
	}
	public static String getdInscription() {
		return dInscription;
	}
	public static void setdInscription(String dInscription) {
		inscriptionBeans.dInscription = dInscription;
	}
	public static String getNiveau() {
		return niveau;
	}
	public static void setNiveau(String niveau) {
		inscriptionBeans.niveau = niveau;
	}
	public static String getFiliere() {
		return filiere;
	}
	public static void setFiliere(String filiere) {
		inscriptionBeans.filiere = filiere;
	}
	public static String getGroupe() {
		return groupe;
	}
	public static void setGroupe(String groupe) {
		inscriptionBeans.groupe = groupe;
	}
	public static String getCycle() {
		return cycle;
	}
	public static void setCycle(String cycle) {
		inscriptionBeans.cycle = cycle;
	}
	public static String getNbrAnneeInscription() {
		return nbrAnneeInscription;
	}
	public static void setNbrAnneeInscription(String nbrAnneeInscription) {
		inscriptionBeans.nbrAnneeInscription = nbrAnneeInscription;
	}
	


	
}
