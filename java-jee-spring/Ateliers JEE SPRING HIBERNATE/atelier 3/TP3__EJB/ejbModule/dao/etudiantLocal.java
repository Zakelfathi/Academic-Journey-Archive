package dao;

import javax.ejb.Local;

import models.Etudiant;

@Local
public interface etudiantLocal {

	public Etudiant submit(Etudiant etudiant);
	public Etudiant getOneById(Long id);
	
}
