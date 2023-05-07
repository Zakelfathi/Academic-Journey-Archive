package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transaction;

import models.Etudiant;
import models.Reinscription;

public class daoReinscription implements mainEntity<Reinscription>{

	private EntityManager EM;
	
	public daoReinscription(EntityManagerFactory eM) {
		super();
		EM = eM.createEntityManager();
	}

	public Reinscription submit(Reinscription ent) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = EM.getTransaction();
		transaction.begin();
		try {
			EM.persist(ent);
			transaction.commit();
		} catch (Exception exc) {
			transaction.rollback();
			System.out.println("operation submit() n'a pas pu etre aboutie!");
			exc.printStackTrace();
		}
		return null;
	}

	public List<Reinscription> getAll() {
		// TODO Auto-generated method stub
		EntityTransaction transaction = EM.getTransaction();
		transaction.begin();
		try {
			Query req = EM.createQuery("select r from Reinscription r");
			transaction.commit();
			return req.getResultList();
			
		} catch (Exception exc) {
			transaction.rollback();
			System.out.println("operation submit() n'a pas pu etre aboutie!");
			exc.printStackTrace();
		}
		return null;
	}

	public Reinscription getOneById(Long id) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = EM.getTransaction();
		transaction.begin();
		try {
			Reinscription r = EM.find(Reinscription.class, id);
			transaction.commit();
			return r;
			
		} catch (Exception exc) {
			transaction.rollback();
			System.out.println("operation getOneById() n'a pas pu etre aboutie!");
			exc.printStackTrace();
		}
		return null;
	}

	public Reinscription update(Reinscription reinscription) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = EM.getTransaction();
		transaction.begin();
		try {
			EM.merge(reinscription);
			transaction.commit();
			return reinscription;
			
		} catch (Exception exc) {
			transaction.rollback();
			System.out.println("operation update() n'a pas pu etre aboutie!");
			exc.printStackTrace();
		}
		return null;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		EntityTransaction Transaction = EM.getTransaction();
		Transaction.begin();
		try {
			Reinscription reinscription = EM.find(Reinscription.class, id);
			EM.remove(reinscription);
			Transaction.commit();

		} catch (Exception e) {
			Transaction.rollback();
			e.printStackTrace();
		}
		
	}
	

	public List<Reinscription> getReinscriptionByIdEtudiant(long id_etudiant) {
		   EntityTransaction transaction = EM.getTransaction();
		   transaction.begin();
		   try {
		       Query req = EM.createQuery("SELECT r FROM Reinscription r WHERE r.etudiant.id_etudiant =:id_etudiant");
		       req.setParameter("id_etudiant", id_etudiant);
		       List<Reinscription> reinscriptions = req.getResultList();
		       transaction.commit();
		       return reinscriptions;
		   } catch (Exception exc) {
		       transaction.rollback();
		       System.out.println("operation getReinscriptionByEtudiantId() n'a pas pu être aboutie!");
		       exc.printStackTrace();
		   }
		   return null;
		}







	



}
