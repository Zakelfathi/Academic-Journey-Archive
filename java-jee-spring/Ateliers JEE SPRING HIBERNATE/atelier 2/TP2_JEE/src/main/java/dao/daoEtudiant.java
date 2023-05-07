package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import models.Etudiant;
import models.Reinscription;

public class daoEtudiant implements mainEntity<Etudiant> {

	private EntityManager EM;
	
	public daoEtudiant(EntityManagerFactory eM) {
		super();
		EM = eM.createEntityManager();
	}

	public Etudiant submit(Etudiant e) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = EM.getTransaction();
		transaction.begin();
		try {
			EM.persist(e);
			transaction.commit();
		}catch(Exception exc) {
			transaction.rollback();
			System.out.println("operation updateEtudiant() n'a pas pu etre aboutie!");
			exc.printStackTrace();
		}
		return null;
	}

	public List<Etudiant> getAll() {
		// TODO Auto-generated method stub
		EntityTransaction transaction = EM.getTransaction();
		transaction.begin();
		try {
			Query req = EM.createQuery("select p from Etudiant p");
			transaction.commit();
			return req.getResultList();
		} catch (Exception exc) {
			transaction.rollback();
			System.out.println("operation getAll_Etudiant() n'a pas pu etre aboutie!");
			exc.printStackTrace();
		}
		return null;
	}
	
	public Etudiant getOneById(Long id) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = EM.getTransaction();
		transaction.begin();
		try {
			Etudiant e = EM.find(Etudiant.class, id);
			transaction.commit();
			return e;
		} catch (Exception exc) {
			transaction.rollback();
			System.out.println("operation getOneById() n'a pas pu etre aboutie!");
			exc.printStackTrace();
		}
		return null;
	}
	
	public Etudiant update(Etudiant e) {
		EntityTransaction transaction = EM.getTransaction();
		transaction.begin();
		try {
			EM.merge(e);

			// mettre à jour l'objet Etudiant dans tous les enregistrements de Reinscription
			Query query = EM.createQuery("SELECT r FROM Reinscription r WHERE r.etudiant = :etudiant");
			query.setParameter("etudiant", e);
			List<Reinscription> reinscriptions = query.getResultList();
			for (Reinscription r : reinscriptions) {
				r.setEtudiant(e);
				EM.merge(r);
			}

			transaction.commit();
			return e;
		} catch (Exception exc) {
			transaction.rollback();
			System.out.println("operation update() n'a pas pu etre aboutie!");
			exc.printStackTrace();
		}
		return null;
	}

	public void delete(Long id) {
	    EntityTransaction transaction = EM.getTransaction();
	    transaction.begin();
	    try {
	        Etudiant etudiant = EM.find(Etudiant.class, id);
	        Query query = EM.createQuery("SELECT r FROM Reinscription r WHERE r.etudiant.id_etudiant = :id");
	        query.setParameter("id", id);
	        List<Reinscription> reinscriptions = query.getResultList();
	        for (Reinscription reinscription : reinscriptions) {
	            EM.remove(reinscription);
	        }
	        EM.remove(etudiant);
	        transaction.commit();
	    } catch (Exception exc) {
	        transaction.rollback();
	        System.out.println("Une erreur est survenue lors de la suppression de l'étudiant");
	        exc.printStackTrace();
	    }
	}
	
	public List<Etudiant> getEtudiantsByNiveau(String niveau) {
	    List<Etudiant> etudiants = new ArrayList<>();
	    TypedQuery<Reinscription> query = EM.createQuery(
	        "SELECT r FROM Reinscription r WHERE r.niveau = :niveau",
	        Reinscription.class);
	    query.setParameter("niveau", niveau);
	    List<Reinscription> reinscriptions = query.getResultList();
	    for (Reinscription r : reinscriptions) {
	        etudiants.add(r.getEtudiant());
	    }
	    return etudiants;
	}


	
}
