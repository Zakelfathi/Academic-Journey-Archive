package tp2;

import java.util.Scanner;

public class mainEx2quest1 {

	public static void main(String[] args) {
		System.out.println("entrer la taille: ");
		Scanner s=new Scanner(System.in);
		int n;
		n=s.nextInt();
		int[] tab = new int[n];
		    for (int i=0;i<n;i++) {
		    	System.out.println("entrer l\'element : "+(i+1));
		    	tab[i]=s.nextInt();	
		    }
		    s.close();
    Tableau T = new Tableau();
    T.afficheTab(tab);
		
	}

}
