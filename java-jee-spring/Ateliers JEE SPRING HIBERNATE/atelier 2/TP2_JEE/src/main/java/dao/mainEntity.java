package dao;

import java.util.List;

import javax.persistence.Entity;

import models.Etudiant;

public interface mainEntity<entity>{
	
	public entity submit(entity ent);
	public List<entity> getAll();
	public entity getOneById(Long id);
	public entity update(entity ent);
	public void delete(Long id);
}

