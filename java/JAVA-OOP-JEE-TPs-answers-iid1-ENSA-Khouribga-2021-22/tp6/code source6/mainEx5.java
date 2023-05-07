package tp6;


import java.util.Enumeration;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class mainEx5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList <Personne> pers=new ArrayList();
		pers.add(new Personne(112,16,"rabie"));
		pers.add(new Personne(442,32,"med"));
		pers.add(new Personne(921,11,"hmama"));
		pers.add(new Personne(212,55,"zack"));
		pers.add(new Personne(726,18,"zaid"));
		System.out.println("------les element du ArrayList sont:\n"+pers);
		System.out.println("------------------------");
	
		//Scanner sc=new Scanner(System.in);
		//System.out.println("");
		
		ArrayList<String> ListeNom=new ArrayList();
		Hashtable<Integer,String> MapPersonne =new Hashtable();
		
		for(int i=0;i<pers.size();i++) {
			if((pers.get(i)).age>=20) {
				ListeNom.add((pers.get(i)).nom);
			}
			else {
				 	MapPersonne.put((pers.get(i)).code,pers.get(i).nom);
			}
		}
		/*
		// Q2
		
		System.out.print("--------ListeNom :");
		Iterator <String> it= ListeNom.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+",");
		}
		
		
		//Q3
		 Enumeration MapPers;
		 MapPers = MapPersonne.elements();
		 System.out.print("--------MapPersonne :" );
		 while (MapPers.hasMoreElements()) {
	         System.out.print(MapPers.nextElement()+","); 
		 		}
				System.out.println("\n---------------------------------------------");
	*/
		
		//Q4
			/*	
				
				System.out.println("-------entrer le code a rechercher:   ");
				int tempCode= sc.nextInt();
				boolean existe=false;
					for(int i=0;i<MapPersonne.size();i++) {
						if(MapPersonne.containsKey(tempCode)) existe=true;
					}
					if (existe==true) System.out.println("------le code est bien existant!------"); 
					else System.out.println("------le code n\'est pas existant!------");  
					
					System.out.println("---------------------------------------------");
				
		//Q5
				
				
			System.out.println("entrer le nom a rechercher:   ");
			String tempNom= sc.next();
			boolean exist=false;
				for(int i=0;i<MapPersonne.size();i++) {
					if(MapPersonne.containsValue(tempNom)) exist=true;
				}
			if(exist=true)	System.out.println("-----------NOM EXISTANT!-----------");
			else System.out.println("------ Ce nom n'existe pas--------");
				System.out.println("---------------------------------------------");
				*/	
				
		//Q6
				Map<Integer,String> CopiePersonne =new HashMap();	
				CopiePersonne.putAll(MapPersonne);
				System.out.println("---------CopiePersonne:"+CopiePersonne);
				
		//Q7
				System.out.println("-----------affichage En utilisant entrySet()-----------");
				for(Map.Entry<Integer,String> e:CopiePersonne.entrySet()) {
					System.out.println("Cle:"+e.getKey()+"\t\t\t\t\t\t Valeur:"+e.getValue());
					
				}
				
				
		//Q8
				double t2 = System.nanoTime();
				System.out.println("------------CopiePersonne---------\n"+CopiePersonne);
				double t1 = System.nanoTime();
				System.out.println("====CopiePersonne took: "+(t1-t2)+"====");			
					
				double a2 = System.nanoTime();
				System.out.println("------------MapPersonne---------\n"+CopiePersonne);
				double a1 = System.nanoTime();
				System.out.println("====MapPersonne took: "+(a1-a2)+"====");			
					
				
}}
