package tp2;
// Q1 IMPLEMENTATION DE LA CLASSE
public class Produit{
		private int Code;
		public String Marque;
		private float Prix;
	
//Q2	SANS PARAMETRES
	public Produit() {
			Code = 1;
			Marque = "noMarques";
			Prix = 1;
	    }
//Q2 AVEC PARAMETRES
	public Produit(int C,String M,float P) {
	    Code = C;
	    Marque = M;
	    Prix = P;
	    }

//Q3 REDEFINITION DE LA METHODE toString
	public String toString() {
		return "Code : "+Code+"\nMarque : "+Marque+"\nPrix : "+Prix;
	}
	

//Q4 getters and setters
	public int getCode() {
		return Code;
	}
	public void setCode(int code) {
		Code = code;
	}
	public float getPrix() {
		return Prix;
	}
	public void setPrix(float prix) {
		Prix = prix;
	}
	
//Q10
	public boolean equals(Produit P) {
		if (this.Prix == P.Prix && this.Marque.equals(P.Marque) && this.Code == P.Code) {
			return true;
		}
		else {
			return false;
		}
	}

	
}