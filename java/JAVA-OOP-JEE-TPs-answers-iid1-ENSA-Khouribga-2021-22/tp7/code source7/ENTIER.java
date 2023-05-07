package tp7;

public class ENTIER {
	int A;
	// constructeur avec parametre
	public ENTIER(int A) {
		super();
		this.A=A;
		}
	
	
	double division(ENTIER diviseur) {
		double div=0;
		try {
				div=this.A/diviseur.A;
		}catch(ArithmeticException e) {
			System.out.println("Division impossible!");
			}
		return div;
		}
	
	
	
	
	
	
}
