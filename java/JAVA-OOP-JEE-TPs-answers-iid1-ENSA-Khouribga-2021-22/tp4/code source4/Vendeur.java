package tp4;

public class Vendeur extends Employe implements Salarie {
float chiffreAffaires;
	
	public Vendeur(String nom, String prenom, int age, String statut, String dateEmbauche,float chiffreAff) {
		super(nom, prenom, age, statut, dateEmbauche);
		chiffreAffaires = chiffreAff;
	}
	
	public String getNom() {
		return "Le vendeur : "+super.getNom();
	};
	
	float CalSalaire() {
		float somSal = 0;
		if (Statut.equalsIgnoreCase("vente en ligne")) {
			somSal = 0.3f*chiffreAffaires+600f; 
		}
		else if (Statut.equalsIgnoreCase("vente directe")) {
			somSal = 0.25f*chiffreAffaires+750f;
		}
		else {
			System.out.println("---------------entree invalide!---------------");
		}
		return somSal;
	}

	@Override
		public float CalcPrime(float salaire) {
			float prime = 0;
			if (chiffreAffaires > 50000) {
				prime = salaire * 0.02f; 
			}
			else if(chiffreAffaires > 100000) {
				prime = salaire * 0.05f;
			}
			return prime;
			}

	}
	


