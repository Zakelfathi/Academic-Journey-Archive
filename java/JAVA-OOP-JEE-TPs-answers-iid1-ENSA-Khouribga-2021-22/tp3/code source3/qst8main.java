package tp3;

import java.util.Scanner;

public class qst8main {
		static Scanner sc = new Scanner(System.in);
		public static void main(String[] args) {
			/*
			System.out.println("---------saisir le nombre des etudiants---------");
			int n = Integer.parseInt(sc.nextLine());
			Etudiant [] etudTab = new Etudiant[n];
			for (int i = 0 ; i<n ; i++) {
				System.out.println("pour l'etudiant "+(i+1)+":");
			etudTab[i] = new Etudiant("", "", "", "", 0, 0);
				System.out.println("nom : ");
				etudTab[i].Nom = sc.nextLine();
				System.out.println("prenom : ");
				etudTab[i].Prenom = sc.nextLine();
				System.out.println("date de naissance: ");
				etudTab[i].dateNaissance = sc.nextLine();
				System.out.println("CNE: ");
				etudTab[i].CNE = sc.nextLine();
				System.out.println("note du controle : ");
				etudTab[i].nControle = Float.parseFloat(sc.nextLine());
				System.out.println("note d'examen: ");
				etudTab[i].nExam = Float.parseFloat(sc.nextLine());
			
			}
				
			//test des methodes afficher et moyenne
		for(int i=0;i<n;i++) {	etudTab[i].afficher();
			System.out.println("la moyenne generale d'etudiant "+etudTab[i].Nom+" est "+etudTab[i].Moyenne());
		}
			*/
			System.out.println("saisir le nombre des Profs");
			int k = Integer.parseInt(sc.nextLine());
			Professeur [] P = new Professeur[k];
			for (int i = 0 ; i<k ; i++) {
				System.out.println("pour le prof "+(i+1)+": \n");
				P[i] = new Professeur("", "", "", 0, 0, "");
				System.out.println("nom: ");
				P[i].Nom = sc.nextLine();
				System.out.println("prenom : ");
				P[i].Prenom = sc.nextLine();
				System.out.println("date de naissance: ");
				P[i].dateNaissance = sc.nextLine();
				System.out.println("ID prof : ");
				P[i].ProfId = Integer.parseInt(sc.nextLine());
				System.out.println("salaire : ");
				P[i].Salaire = Float.parseFloat(sc.nextLine());
				System.out.println("statut: ");
				P[i].Statut= sc.nextLine();
			}
			
			float somme=0;
			for(int i=0;i<P.length;i++) {
				somme+=P[i].Salaire;
			}
			System.out.println("la somme des salaires est :" + somme);
			
			float minSalaire=P[0].Salaire;
			int pos=0;
			for(int i=1;i<P.length;i++) {
				if(minSalaire > P[i].Salaire) {
					minSalaire=P[i].Salaire;
					pos=i;
				}
				}
			System.out.println("le salaire le plus bas est celui de "+P[pos].Nom+" avec "+minSalaire);
			
			
			/*
			//test des methodes afficher et calculeSalaire
			for(int i=0;i<k;i++) {
				P[i].afficher();
				System.out.println("son salaire est de :"+P[i].calculeSalaire());
			}
			*/
			
//Q11
		//	System.out.println("La moyenne pour les 10 premiers etudiants : "+CalMoy(etudTab,0,10));
			
//Q13
			
		}
//Q9
		
		static float CalMoy(Etudiant [] etudTab,int debut,int fin) {
			float somme = 0;
			if (debut >= 0 && fin <= etudTab.length) {
			for (int i = debut ; i< fin ;i++) {
				somme = somme + etudTab[i].Moyenne();
			}
		}
			else {
				System.out.println("start or end out of range !!");
			}
			return somme/fin-debut;
		}
		
		
	}


