package com.ensa.tp5;

import java.util.Date;
import com.ensa.tp5.entities.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ensa.tp5.dao.repoEtudiant;
import com.ensa.tp5.dao.repoInscription;

@SpringBootApplication
public class Tp5SpringBootApplication {

	public static void main(String[] args) {
		
	ApplicationContext context = SpringApplication.run(Tp5SpringBootApplication.class, args);
	
	repoEtudiant repEtudiant = context.getBean(repoEtudiant.class);
	
//	repEtudiant.save(new Etudiant("fth","zak","em@ail","s13416661",new Date(),"066666666"));
//	repEtudiant.save(new Etudiant("shhs","xd","em@ail","s13416661",new Date(),"066666666"));
//	repEtudiant.save(new Etudiant("sss","cd","em@ail","s13416661",new Date(),"066666666"));
//	repEtudiant.save(new Etudiant("dds","wq","em@ail","s13416661",new Date(),"066666666"));
	
	repEtudiant.findAll().forEach(e -> System.out.println(e.getId()));
	
	
//	repoInscription repInscription = context.getBean(repoInscription.class);
	
	
//	repInscription.findAll().forEach(i -> System.out.println(i.getId_insc()));


	
	
	
	}

}
