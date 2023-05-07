package dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import models.Etudiant;


@Stateless
@LocalBean
public class EtudiantImplementation implements etudiantLocal {

	
	public EtudiantImplementation() {
		super();
	}

	@PersistenceContext(unitName = "TP3_EJB")
	EntityManager EM;
	
	@Override
	public Etudiant submit(Etudiant etudiant) {
		// TODO Auto-generated method stub
		EM.persist(etudiant);
		return etudiant;
	}

	@Override
	public Etudiant getOneById(Long id) {
		// TODO Auto-generated method stub
		Etudiant e = EM.find(Etudiant.class, id);
		return e ;
	}
	

	
	
}
