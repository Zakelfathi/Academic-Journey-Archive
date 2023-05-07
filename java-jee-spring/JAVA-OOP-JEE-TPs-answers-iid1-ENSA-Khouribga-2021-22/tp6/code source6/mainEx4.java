package tp6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class mainEx4 {

	public static void main(String[] args) {
	// instanciation d'un HashSet de nom voiture
		HashSet <Voiture> voiture=new HashSet<Voiture>();
		// ajout de qlq elements
		voiture.add(new Voiture("Nissan","15 A 38773",82));
		voiture.add(new Voiture("Dacia","18 B 83993",99));
		voiture.add(new Voiture("Mercedes","15 A 38773",83));
		voiture.add(new Voiture("Volvo","15 A 38773",38));
		voiture.add(new Voiture("Renault","15 A 38773",30));
		// affichage de la liste 'voiture'
		//System.out.println("------la liste initiale------\n"+voiture);
		System.out.println("---------------------------------------");
		//copie
		
		Set<Voiture> voiture2=new TreeSet<>(voiture); 
		//System.out.println("---------la liste TreeSet resultante----------\n"+ voiture2);
		 /*
   
	//le temps
		long avantH, apresH,avantT, apresT;
		avantH=System.nanoTime();;
		for(Voiture i : voiture) {
			System.out.println(i);
		}
		apresH=System.nanoTime();;
		System.out.println("le temps est :"+ (apresH-avantH));
	
		avantT=System.nanoTime();;
		for(Voiture i : voiture2) {
			System.out.println(i);
		}
		apresT=System.nanoTime();
		System.out.println("le temps est :"+ (apresT-avantT));

		System.out.println("---------------------------------------");
		
	*/	
		// ajouter leus deux list dans une 3eme
		LinkedHashSet <Voiture> voiture3=new LinkedHashSet(voiture2); 
		voiture3.addAll(voiture);
//		System.out.println(voiture3);
		System.out.println("---------------------------------------");
 
		
		//transformer la liste en tableau
		Object[] tab = voiture3.toArray();
		for(int i=0;i<tab.length;i++) {
			System.out.println(tab[i]);
		}
		System.out.println("-------------------FIN!--------------------");
		
	}
	
		
		
	}


