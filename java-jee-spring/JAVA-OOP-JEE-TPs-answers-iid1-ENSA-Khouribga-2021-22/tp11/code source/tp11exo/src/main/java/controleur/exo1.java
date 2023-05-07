
package controleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Affichage
 */
@WebServlet("/Affichage")
public class exo1 extends HttpServlet {
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		
		String n = req.getParameter("nom");
		String p = req.getParameter("prenom");
		
		String html = "<html><head><title>Gestion des �tudiants</title></head>"
				+ "<body> "
				+ "Nom  :"+n+"<br>"
				+ "Pr�nom :"+p+"<br>"
				+ "</body></html>"
				;
		try {
			PrintWriter wr= res.getWriter();
			wr.write(html);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
