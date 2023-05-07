package com.Etudiant.bean;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionEvent;
@ManagedBean
@SessionScoped
public class Etudiant {
		
		private Long id;
		private String firstName;
		private String lastName;
		private String email;
		private String cne;
		private String dNaiss;
		private String tele;
		public List<Etudiant> listEtudiants = new ArrayList<Etudiant>();
		

		public Etudiant() {
			super();
		}

		public Etudiant(String firstName, String lastName, String email, String cne, String dNaiss, String tele) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.cne = cne;
			this.dNaiss = dNaiss;
			this.tele = tele;
		}
		
		public void saveEtudiant() {
			Etudiant e = new Etudiant(firstName, lastName, email, cne, dNaiss, tele);
	        listEtudiants.add(e);
		}
		  public void clearForm() {
		       listEtudiants.clear();
		    }
		public List<Etudiant> getListEtudiants() {
			return listEtudiants;
		}


		public void setListEtudiants(List<Etudiant> listEtudiants) {
			this.listEtudiants = listEtudiants;
		}

		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCne() {
			return cne;
		}

		public void setCne(String cne) {
			this.cne = cne;
		}

		public String getdNaiss() {
			return dNaiss;
		}

		public void setdNaiss(String dNaiss) {
			this.dNaiss = dNaiss;
		}

		public String getTele() {
			return tele;
		}

		public void setTele(String tele) {
			this.tele = tele;
		}
	}

