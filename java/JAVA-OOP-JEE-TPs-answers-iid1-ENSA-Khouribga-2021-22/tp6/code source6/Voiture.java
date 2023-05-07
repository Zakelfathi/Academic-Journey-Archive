package tp6;

public class Voiture implements Comparable <Voiture> {

	String marque,matricule;
	int puissance;

	public Voiture(String marque,String matricule, int puissance) {
		this.marque=marque;
		this.matricule=matricule;
		this.puissance=puissance;
	}

	
// la methode d'affichage toString()
	@Override
	public String toString() {
		return "Voiture [marque=" + marque + ", matricule=" + matricule + ", puissance=" + puissance + "]\n";
	}
// Getter & Setters de la classe
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	} 
	

	@Override
	public int compareTo(Voiture v) {
		if (this.getPuissance() < v.getPuissance()) {
			return 1;
		}else {
		return -1;
		
	}}}

