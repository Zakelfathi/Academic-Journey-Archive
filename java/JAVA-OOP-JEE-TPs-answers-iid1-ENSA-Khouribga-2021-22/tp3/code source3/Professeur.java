package tp3;
//Q4
public class Professeur extends Personne {
		int ProfId;
		float Salaire;
		String Statut;
//Q5
	public Professeur(String nom, String prenom, String dateNaissance,int profid,float salaire,String statut) {
			super(nom, prenom, dateNaissance);
			ProfId = profid;
			Salaire = salaire;
			Statut = statut;
		}
	public void afficher() {
		super.afficher();
		System.out.println("identifiant professeur: "+ProfId+"\nSalaire : "+Salaire+"\nStatut: "+Statut);	
	}
//Q6

	public float calculeSalaire() {

	    if (Statut.equalsIgnoreCase("assistant")) {
	    	 Salaire+=(Salaire*(float)0.2);
	    }
	    else if(Statut.equalsIgnoreCase("habilite")) {
	    	 Salaire+=(Salaire*(float)0.5);
	    }
		return Salaire;
	}
	
	public Professeur() {
		super();
		ProfId = 0;
		Salaire = 0;
		Statut = "rien";
}
}