package com.ensa.tp5.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ensa.tp5.entities.Etudiant;

public interface repoEtudiant extends JpaRepository<Etudiant, Long> {
@Query("select e from Etudiant e where e.firstName like :x")
	public Page<Etudiant> chercher(@Param("x")String mc, Pageable pageable);
	
	
}
