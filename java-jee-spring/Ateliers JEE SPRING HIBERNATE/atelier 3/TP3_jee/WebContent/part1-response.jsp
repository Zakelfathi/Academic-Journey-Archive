<!DOCTYPE html>
<%@ page import="models.*"%>

<html>
<head>
<link rel="stylesheet" href="css/styleAffichage.css">
<title>my Response</title>
</head>
<body>
	<div class="login-box">
		<div class="input-group">
			<div class="user-box">
				<h1>
					<strong>PRENOM:</strong>
					<%=((Etudiant) request.getAttribute("Etudiant")).getFirstName()%>
				</h1>
			</div>
			<div class="user-box">
				<h1>
					<strong>NOM:</strong>
					<%=((Etudiant) request.getAttribute("Etudiant")).getLastName()%></h1>
			</div>
			<div class="user-box">
				<h1>
					<strong>EMAIL:</strong>
					<%=((Etudiant) request.getAttribute("Etudiant")).getEmail()%></h1>
			</div>
			<div class="user-box">
				<h1>
					<strong>CNE:</strong>
					<%=((Etudiant) request.getAttribute("Etudiant")).getCne()%></h1>
			</div>
			<div class="user-box">
				<h1>
					<strong>DATE DE NAISSANCE:</strong>
					<%=((Etudiant) request.getAttribute("Etudiant")).getdNaiss()%>
				</h1>
			</div>
			<div class="user-box">
				<h1>
					<strong>TELEPHONE:</strong>
					<%=((Etudiant) request.getAttribute("Etudiant")).getTele()%></h1>
			</div>
			<div>

				<a href="part1-form.jsp"> <input type="submit" value="revenir">
				</a>
			</div>
		</div>
	</div>
</body>
</html>
