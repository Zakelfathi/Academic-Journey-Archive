package tp4;

public class Agent extends Employe implements Salarie{
	
	int nProjet = 0,nHeure = 0,nUnite = 0;
	public Agent(String nom, String prenom, int age, String Statut, String datedembauche,int NProjet,int NHeure,int NUnite) {
		super(nom, prenom, age, Statut, datedembauche);
		nProjet = NProjet;
		nHeure= NHeure;
		nUnite = NUnite;
	}
	
	float CalSalaire() {
		float sal = 0;
		if (Statut.equals("chef de projet")){
			sal = nProjet*5000 +400f; 
		}
		else if (Statut.equals("ingenieur")) {
			sal = nHeure*300;
		}
		else if (Statut.equals("technicien")){
			sal = nUnite*70;
		}
		else{
			System.out.println("---------ERREUR A L'ENTREE!---------");
		}	
		return sal;
	}

	@Override
	public float CalcPrime(float sal) {
		float prime = 0;
		if (Statut.equals("technicien") && nHeure > 240) {
				prime = sal * 0.02f;
		}
		else {
			System.out.println("aucune prime");
		}
		return prime;
	}
	

}
