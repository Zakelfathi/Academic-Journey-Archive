package tp6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ex3 {

	public static void main(String[] args) {
		
		Set<Integer> entierInitial=new HashSet();
		entierInitial.add(2);
		entierInitial.add(7);
		entierInitial.add(9);
		entierInitial.add(88);
		entierInitial.add(101);
		
		
		Set<Integer> entierFinal=new TreeSet();
		Iterator<Integer> it = entierInitial.iterator();
		while (it.hasNext()) {
		 int n=it.next();
		   if (n %2 !=0) {
			   entierFinal.add(n);
		   }
		}
		System.out.println("la liste initiale: "+entierInitial );
		System.out.println("la liste finale: ");
		Iterator <Integer> it2= entierFinal.iterator();
		while(it2.hasNext()) {
			System.out.print(it2.next()+",");
		}
	}	

}
