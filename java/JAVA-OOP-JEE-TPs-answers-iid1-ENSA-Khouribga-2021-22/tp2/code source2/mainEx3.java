package tp2;

import java.util.Scanner;

//Q5
public class mainEx3 {
	
	public static void main(String[] args) {
		//Q7
	System.out.println("entrer la taille de votre tableau : ")	;
	Scanner s= new Scanner(System.in);
	Produit [] T =new Produit[s.nextInt()];
	for (int i=0; i<T.length;i++) {
		T[i].setPrix (new Produit(s.nextInt())));
		}
	System.out.println(CalcPrix(T));
	}

//Q6-1
	public static double CalcPrix(Produit [] T ) {
		double sommePrix=0;
		for (int i =0;i<T.length;i++) {
			sommePrix+=T[i].getPrix();
		}
	return sommePrix;	
	}
}
