package tp2;

import java.util.Scanner;

public class tabex2 {

	public static void main(String[] args) {
		System.out.println("entrer la taille! ");
		Scanner Z = new Scanner(System.in);
		int n; 
		n=Z.nextInt();
		Scanner p = new Scanner(System.in);
		System.out.println("entrer les elemets du tableau");
		int [] tab  = new int [n];
		for(int i = 0 ; i < n ;i++ ) {
		 tab[i] = p.nextInt();
		
	}
		tabexo2 e= new tabexo2();
		e.afficherelement(tab);
		p.close();
		Z.close();
		
}
}