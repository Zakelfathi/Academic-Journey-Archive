
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Etudiant;

import dao.etudiantLocal;

import javax.servlet.annotation.WebServlet;

@WebServlet("/part1Servlet")
public class part1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	etudiantLocal EL;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

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
		Etudiant etudiant = new Etudiant();

		etudiant.setFirstName(firstName);
		etudiant.setLastName(lastName);
		etudiant.setEmail(email);
		etudiant.setTele(tele);
		etudiant.setdNaiss(dNaiss);
		etudiant.setCne(cne);

		EL.submit(etudiant);

		// Store the Etudiant in the request object
		request.setAttribute("Etudiant", etudiant);

		// Forward the request to the myResponse.jsp page
		request.getRequestDispatcher("part1-response.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("part1-form.jsp").forward(request, response);
	}

}