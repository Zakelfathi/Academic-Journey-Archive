package tp5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import java.util.ArrayList;

public class mainTest {
//Q7 
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// on cree cinq Personnes(instanciation de cinq objets de type Personnes)
		Personne p1 =new Personne (1,"El fathi","zakaria");
		Personne p2 =new Personne (2,"Lahmama","fz");
		Personne p3 =new Personne (3,"saidi","said");
		Personne p4 =new Personne (4,"gnoumi","simo");
		Personne p5 =new Personne (5,"rachdi","halima");
		
		// ajout des elements dans la liste
		PersonneService personneServ = new PersonneService();
		personneServ.save(p1);
		personneServ.save(p2);
		personneServ.save(p3);
		personneServ.save(p4);
		personneServ.save(p5);
		
		//affichage de la liste des Personnes
		System.out.println("---------la liste initiale: \n"+personneServ);
		
		// recherche d'un element avec son code ID
		System.out.println("---------entrer l'ID de l'element a rechercher: ---------");
		System.out.println(personneServ.findById(sc.nextInt()));
	
		//modification des informations d'une Personne
		System.out.println("---------entrer l'ID de l'element a mettre a jour!: \n ");
		personneServ.update(personneServ.findById(sc.nextInt()));
		
		// affichage de la liste finale des Personnes
		System.out.println("---------la liste modifiee: \n"+personneServ);
	}


}
