package tp3;
//Q1
public class Personne {
	String Nom, Prenom, dateNaissance;

//Q2	
	public Personne(String nom, String prenom, String DateNaissance) {
		super();
		Nom = nom;
		Prenom = prenom;
		dateNaissance = DateNaissance;
}

//Q3	
	public void afficher() {
		System.out.println("\nNom : "+ Nom+"\nPrenom : "+ Prenom +"\ndate de naissance : "+ dateNaissance);
	}

	public Personne() {
		this.Prenom="Rien";
		this.Nom="rien";
		this.dateNaissance="00/00/0000";
	}
	
}
