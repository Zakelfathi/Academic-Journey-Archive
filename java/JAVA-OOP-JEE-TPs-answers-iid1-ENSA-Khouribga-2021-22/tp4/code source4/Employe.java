package tp4;

public abstract class Employe {
	String Nom;
	String Prenom;
	int Age;
	String Statut;
	String dateEmbauche;
	
	public Employe(String nom, String prenom, int age, String statut, String date) {
		super();
		Nom = nom;
		Prenom = prenom;
		Age = age;
		Statut = statut;
		dateEmbauche = date;
	}

	abstract float CalSalaire();
	
	public String getNom() {
		return Nom + "\t" +Prenom;
	}
	public int getAge() {
		return Age;
	}	
}
