package com.ensa.tp5.entities;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.*;

@Entity
public class Etudiant implements Serializable{
	@Id @GeneratedValue
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	@NotNull
	@Size(min=10,max=10)
	private String cne;
	private String dNaiss;
	@Size(min=10,max=10)
	private String tele;
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
