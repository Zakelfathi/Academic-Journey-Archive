// EX1
package tp5;
// Q1
public class Personne {
		int code;
		String nom, prenom;
		
		//Q2
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
	
		
		//Q3
		public Personne(int code,String nom, String prenom) {
			this.code=code;
			this.prenom=prenom;
			this.nom=nom;
		}
		
		
		//Q4
		@Override
		public String toString() {
			return "\nPersonne \n[code=" + code + ", nom=" + nom + ", prenom=" + prenom + "] \n";
			
		}
		
		
		
		
		
}
