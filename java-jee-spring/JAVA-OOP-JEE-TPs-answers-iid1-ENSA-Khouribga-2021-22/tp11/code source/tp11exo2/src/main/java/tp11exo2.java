import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class tp11exo2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		String cne =request.getParameter("cne");	
		String nom =request.getParameter("nom");	
		String prenom =request.getParameter("prenom");	
		String ville =request.getParameter("ville");	
		String daten =request.getParameter("daten");
		String bourse =request.getParameter("bourse");	
		
		String html = "<html><head><title>Gestion des étudiants</title></head>"
				+ "<body> "
				+ "CNE :"+cne+"<br>"
				+ "Nom  :"+nom+"<br>"
				+ "Prénom :"+prenom+"<br>"
				+ "Ville :"+ville+"<br>"
				+ "date de naissance :"+daten+"<br>"
				+ "Bourse :"+bourse+"<br>"
				+ "</body></html>"
				;
		try {
			PrintWriter wr= response.getWriter();
			wr.write(html);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	}