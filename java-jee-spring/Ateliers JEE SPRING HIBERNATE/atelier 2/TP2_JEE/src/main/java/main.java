import java.awt.Window.Type;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.daoEtudiant;
import dao.daoReinscription;
import models.Etudiant;
import models.Reinscription;

public class main {
	
	public main(EntityManagerFactory entityManagerFactory) {
		
	}

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UP_CAT");
		
		daoEtudiant etdDao = new daoEtudiant(entityManagerFactory);
		daoReinscription reinscDao = new daoReinscription(entityManagerFactory);
		
		
//		
		//QUESTION 6
		Etudiant e1 = new Etudiant(44L,"EL FATHI", "ZAKARIA", "Z111111");
		Etudiant e2 = new Etudiant(60L,"ZAHIDI", "LAMYAE", "Q111111");
		Etudiant e3 = new Etudiant(88L,"OUADRASSI", "ZIAD", "ZT14555");
		Etudiant e4 = new Etudiant(56L,"TALIB", "ABDO", "W516668");

		etdDao.submit(e1);		
		etdDao.submit(e2);
		etdDao.submit(e3);
		etdDao.submit(e4);



		
		Reinscription r1 = new Reinscription("06/11/2022", "S4", "7", "M6", e1);
		Reinscription r2 = new Reinscription("06/11/2021", "S3", "2", "M5", e1);
		Reinscription r3 = new Reinscription("06/11/2019", "S1", "3", "M3", e1);
		Reinscription r4 = new Reinscription("06/11/2021", "S5", "4", "M8", e2);
		Reinscription r5 = new Reinscription("06/11/2021", "S3", "3", "M9", e4);

		

		reinscDao.submit(r1);
		reinscDao.submit(r2);
		reinscDao.submit(r3);
		reinscDao.submit(r4);
		reinscDao.submit(r5);



		
		
		
		//Question 7: Recuperation de la liste des etudiants
		System.out.println("____________________\n Liste des Etudiants:\n");
		List<Etudiant> etudiants = etdDao.getAll();
		for(Etudiant e : etudiants) {
			System.out.println("Id: " + e.getId() + ", Nom: " + e.getNom() + ", Prenom: " + e.getPrenom() + ", CIN: " + e.getCin());
		}
		System.out.println("____________________");
		
		
		//Question 8
		Etudiant etud = etdDao.getOneById(44L);
	    List<Reinscription> reinscriptions = reinscDao.getReinscriptionByIdEtudiant(etud.getId());
	    if (reinscriptions != null && !reinscriptions.isEmpty()) {
	        System.out.println("Reinscriptions de l'étudiant avec l'ID " + etud.getId() + ":");
	        for (Reinscription reinscription : reinscriptions) {
	            System.out.println(reinscription.toString());
	        }
	    } else {
	        System.out.println("Aucune reinscription trouvée pour l'étudiant avec l'ID " + etud.getId());
	    }
	
		
	    //QUESTION 9
		System.out.println("_____________________________");
		Etudiant etud60 = etdDao.getOneById(60L);
		etdDao.delete(etud60.getId());
		System.out.println("methode de suppression terminee!");
	    

		//QUESTION 10
		System.out.println("_____________________________");
		Etudiant etud88 = etdDao.getOneById(88L);
		etud88.setCin("C44444");
		etdDao.update(etud88);
		System.out.println("methode de modification terminee!");

		
		//QUESTION 11
		System.out.println("_____________________________");
		List<Etudiant> etudiantsNiveau3 = etdDao.getEtudiantsByNiveau("3");
		System.out.println("Liste des étudiants en 3ème année :");
		for (Etudiant etudiant : etudiantsNiveau3) {
		    System.out.println(etudiant.toString());
		}
		System.out.println("methode terminee!");


		entityManagerFactory.close();
	}

}
