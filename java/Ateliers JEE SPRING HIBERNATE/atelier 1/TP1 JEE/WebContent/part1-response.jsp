<!DOCTYPE html>
<%@ page import="com.etudiant.beans.Etudiant"%>
<!-- Importe la classe Etudiant -->

<html>
<head>
<link rel="stylesheet" href="css/styleAffichage.css">
<!-- Importe la feuille de style CSS -->
<title>my Response</title>
<!-- Titre de la page HTML -->
</head>
<body>
	<div class="login-box">
		<!-- Définit une boîte pour le contenu -->
		<div class="input-group">
			<div class="user-box">
				<h1>
					<strong>PRENOM:</strong>
					<%=((Etudiant) request.getAttribute("Etudiant")).getFirstName()%>
				</h1>
				<!-- Récupère et affiche le prénom de l'étudiant -->
			</div>
			<div class="user-box">
				<h1>
					<strong>NOM:</strong>
					<%=((Etudiant) request.getAttribute("Etudiant")).getLastName()%></h1>
				<!-- Récupère et affiche le nom de l'étudiant -->
			</div>
			<div class="user-box">
				<h1>
					<strong>EMAIL:</strong>
					<%=((Etudiant) request.getAttribute("Etudiant")).getEmail()%></h1>
				<!-- Récupère et affiche l'email de l'étudiant -->
			</div>
			<div class="user-box">
				<h1>
					<strong>CNE:</strong>
					<%=((Etudiant) request.getAttribute("Etudiant")).getCne()%></h1>
				<!-- Récupère et affiche le CNE de l'étudiant -->
			</div>
			<div class="user-box">
				<h1>
					<strong>DATE DE NAISSANCE:</strong>
					<%=((Etudiant) request.getAttribute("Etudiant")).getDNaiss()%>
				</h1>
				<!-- Récupère et affiche la date de naissance de l'étudiant -->
			</div>
			<div class="user-box">
				<h1>
					<strong>TELEPHONE:</strong>
					<%=((Etudiant) request.getAttribute("Etudiant")).getTele()%></h1>
				<!-- Récupère et affiche le numéro de téléphone de l'étudiant -->
			</div>
		</div>
	</div>
</body>
</html>