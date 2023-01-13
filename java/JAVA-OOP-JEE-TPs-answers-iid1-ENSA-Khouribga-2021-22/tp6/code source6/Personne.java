package tp6;

public class Personne {

	int code,age;
	String nom;
	//constructeur avec parametres pour initialiser les attributs
	public Personne(int code, int age,String nom) {
		this.code=code;
		this.nom=nom;
		this.age=age;	
	}
// Getters & Setters
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
// redifinition de la methode d'affichage
	@Override
	public String toString() {
		return "Personne [code=" + code + ", age=" + age + ", nom=" + nom + "]\n";
	}
	
	
	
	
	
	
	
	
	
}
