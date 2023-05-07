package tp3;
//Q4
public class Etudiant extends Personne {

	String CNE;
	float nControle;
	float nExam;	

//Q5
	public Etudiant(String nom, String prenom, String dateNaissance, String cne,float nControlee,float nExaam) {
		super(nom, prenom, dateNaissance);
		CNE = cne ;
		nControle = nControlee;
		nExam = nExaam;
	}
	public void afficher() {
		super.afficher();
		System.out.println("CNE : "+CNE+"\nNote de Controle : "+nControle+"\nNote d'exam : "+nExam);		
	}

//Q7
	public float Moyenne() {
		float Moyenne = nExam * (float)0.75 +nControle * (float)0.25;
		return Moyenne;
	}
	public Etudiant() {
		super();
		CNE="rien";
		nControle=20;
		nExam=20;
	}
	
}

	

