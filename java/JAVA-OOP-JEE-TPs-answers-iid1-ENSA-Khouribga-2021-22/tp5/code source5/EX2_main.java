package tp5;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class EX2_main {

	public static void main(String[] args) {
		//Q1
		 LinkedList liste1 = new LinkedList();
		 liste1.add(3);
		 liste1.add(6);
		 liste1.add(83);
		 liste1.add(33);
		 liste1.add(322);
		 liste1.add(13);
		 liste1.add(3);
		 liste1.add(9);
		 System.out.println("la liste initiale est:"+liste1);
		 Scanner sc=new Scanner(System.in);
		  //Q2
		System.out.println("inserer l position et la valeur");
		
		int i=sc.nextInt();
		Integer n=sc.nextInt();
		while(i>liste1.size()) {
			System.out.println("position invalide!\n entrer la position a nouveau:");
			 i=sc.nextInt();
		}
		liste1.add(i,n);
		System.out.println("la nouvelle liste est :"+liste1);
		
		
		//Q3
		System.out.println("entrer l'element du debut: ");
		liste1.addFirst(sc.nextInt());
		System.out.println("entrer l'element a la fin: ");
		liste1.addLast(sc.nextInt());
		System.out.println("la nouvelle liste est :"+liste1);

		
		//Q4
			System.out.println("la liste en utilisant les iterateurs");
		Iterator <Integer> it= liste1.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+",");
		}
		
			
		
		//Q5
			System.out.println("------la liste en utilisant une boucle for------");

		for(int j=0; j<liste1.size(); j++)
	      {
	    	  System.out.print(liste1.get(j)+",");
	      }
	      
		
		
		//Q6
			System.out.println("la premiere position contient:"+liste1.getFirst());
			System.out.println("la derniere position contient:"+liste1.getLast());
		
		
		//Q7
		System.out.println("entrer l'indice de l'element a supprimer");
		liste1.remove(sc.nextInt());
		System.out.println("la nouvelle liste est"+liste1);
		
		
		
		//Q8
		
		LinkedList liste2= new LinkedList();
		Collections.reverse(liste1);
		liste2.addAll(liste1);
		System.out.println("la 2eme liste est :"+ liste2);
		
	}
}
