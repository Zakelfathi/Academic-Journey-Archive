package com.part2.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etudiant.beans.Etudiant;
import com.inscription.beans.inscriptionBeans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/part2Servlet")
public class part2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieve the first name and last name and email from myForm.jsp
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String cne = request.getParameter("cne");
		String tele = request.getParameter("tele");
		String dNaiss = request.getParameter("dNaiss");
		String dInscription = request.getParameter("dInscription");
		String cycle = request.getParameter("cycle");
		String nbrAnneeInscription = request.getParameter("nbrAnneeInscription");
		String groupe = request.getParameter("groupe");
		String niveau = request.getParameter("niveau");
		String filiere = request.getParameter("filiere");

		// Create a new instance of the Etudiant and populate its properties
		Etudiant Etudiant = new Etudiant();
		Etudiant.setFirstName(firstName);
		Etudiant.setLastName(lastName);
		Etudiant.setEmail(email);
		Etudiant.setTele(tele);
		Etudiant.setdNaiss(dNaiss);
		Etudiant.setCne(cne);

		inscriptionBeans inscription = new inscriptionBeans();
		inscription.setCycle(cycle);
		inscription.setdInscription(dInscription);
		inscription.setEtudiant(Etudiant);
		inscription.setFiliere(filiere);
		inscription.setGroupe(groupe);
		inscription.setNbrAnneeInscription(nbrAnneeInscription);
		inscription.setNiveau(niveau);

		// Store the Etudiant in the request object
		request.setAttribute("inscription", inscription);

		// Forward the request to the myResponse.jsp page
		request.getRequestDispatcher("/part2-response.jsp").forward(request, response);
	}

}