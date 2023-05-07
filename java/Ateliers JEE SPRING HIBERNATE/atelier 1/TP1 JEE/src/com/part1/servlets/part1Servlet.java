package com.part1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etudiant.beans.Etudiant;

import javax.servlet.annotation.WebServlet;

@WebServlet("/part1Servlet")
public class part1Servlet extends HttpServlet {
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
  
    
        // Create a new instance of the Etudiant and populate its properties
        Etudiant Etudiant = new Etudiant();
        Etudiant.setFirstName(firstName);
        Etudiant.setLastName(lastName);
        Etudiant.setEmail(email);
        Etudiant.setTele(tele);
        Etudiant.setdNaiss(dNaiss);
        Etudiant.setCne(cne);

       
        
        // Store the Etudiant in the request object
        request.setAttribute("Etudiant", Etudiant);
        
        // Forward the request to the myResponse.jsp page
        request.getRequestDispatcher("/part1-response.jsp").forward(request, response);
    }

}