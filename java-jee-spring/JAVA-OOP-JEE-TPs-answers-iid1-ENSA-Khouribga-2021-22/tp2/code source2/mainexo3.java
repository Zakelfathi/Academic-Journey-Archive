package tp2;

import java.util.Scanner;
//Q5
public class mainexo3 {
		public static void main(String[] args) {
//Q7
			System.out.println("Saisir la taille du tableau des produits ");
			Scanner scan=new Scanner(System.in);
			Produit [] p = new Produit[scan.nextInt()];
			for (int i = 0 ; i< p.length ; i++) {
				p[i] = new Produit();
				System.out.println("\nCode :");
				p[i].setCode(scan.nextInt());
				System.out.println("prix : ");
				p[i].setPrix(scan.nextFloat());
				scan.nextLine();
				System.out.println("marque : ");
				p[i].Marque = scan.nextLine();
			
			}
			
//Q8
			/*
			System.out.println("------les details des elements du tableau sont------");
			for (int i = 0 ; i<p.length ; i++) {
				System.out.println("--------"+p[i].toString());
				} 
			
//Q9
						System.out.println("La somme des prix= "+CalcPrix(p));
			*/
// Q10 main
			
				for (int i = 0; i < p.length/2;i++) {
				for(int j = i+1; j< p.length;j++) {
					if (p[i].equals(p[j])) {
						System.out.println("Product["+i+"] = Product["+j+"]");
		}
	    }
	}
			
	}
	
//Q6	
		static float CalcPrix(Produit[] prod) {
			float somme = 0;
			for (int i = 0 ; i<prod.length ; i++) {
				somme += prod[i].getPrix();
			    }
			return somme;
			}

}
