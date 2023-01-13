

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/connexion")
public class tp11qst extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		String html="";
		String username = request.getParameter("nameuser");
		String password = request.getParameter("password");
		
		String url = "jdbc:mysql://localhost:3306/users";

		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "");
			
			String sql = "select * from user where username='"+username+"' and password='"+password+"'";
			Statement stat = con.createStatement();
			ResultSet res = stat.executeQuery(sql);
			if(res.next()) {
			 html = "<html><head><title>connexion</title></head>"
						+ "<body> "
						+ "Nom d'utilisateur:"+username
						+"<br>Mot de passe :"+password
						+ "</body></html>"
						;
			}else {
				html = "<script> alert(\"Données incorrectes\");</script>";
			}
			stat.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PrintWriter wr= response.getWriter();
			wr.write(html);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

		
}

