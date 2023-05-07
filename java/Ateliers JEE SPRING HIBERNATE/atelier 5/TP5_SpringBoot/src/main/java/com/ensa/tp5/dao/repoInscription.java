package com.ensa.tp5.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ensa.tp5.entities.Reinscription;


public interface repoInscription extends JpaRepository<Reinscription, Long>{
	@Query("select e from Reinscription e where e.id_insc like :x")
	public Page<Reinscription> chercher(@Param("x")String mc, Pageable pageable);
	
}
