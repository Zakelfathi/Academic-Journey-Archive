<!DOCTYPE html>
<%@ page import="com.etudiant.beans.Etudiant"%>
<%@ page import="com.inscription.beans.inscriptionBeans"%>

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
					<%=((inscriptionBeans) request.getAttribute("inscription")).getEtudiant().getFirstName()%>
				</h1>
			</div>
			<div class="user-box">
				<h1>
					<strong>NOM:</strong>
					<%=((inscriptionBeans) request.getAttribute("inscription")).getEtudiant().getLastName()%></h1>
			</div>
			<div class="user-box">
				<h1>
					<strong>EMAIL:</strong>
					<%=((inscriptionBeans) request.getAttribute("inscription")).getEtudiant().getEmail()%></h1>
			</div>
			<div class="user-box">
				<h1>
					<strong>CNE:</strong>
					<%=((inscriptionBeans) request.getAttribute("inscription")).getEtudiant().getCne()%></h1>
			</div>
			<div class="user-box">
				<h1>
					<strong>DATE DE NAISSANCE:</strong>
					<%=((inscriptionBeans) request.getAttribute("inscription")).getEtudiant().getDNaiss()%>
			</div>
			<div class="user-box">
				<h1>
					<strong>TELEPHONE:</strong>
					<%=((inscriptionBeans) request.getAttribute("inscription")).getEtudiant().getTele()%></h1>
			</div>
			<div class="user-box">
				<h1>
					<strong>Date inscription:</strong>
					<%=((inscriptionBeans) request.getAttribute("inscription")).getdInscription()%></h1>
			</div>
			<div class="user-box">
				<h1>
					<strong>Niveau:</strong>
					<%=((inscriptionBeans) request.getAttribute("inscription")).getNiveau()%></h1>
			</div>
			<div class="user-box">
				<h1>
					<strong>Filiere:</strong>
					<%=((inscriptionBeans) request.getAttribute("inscription")).getFiliere()%></h1>
			</div>
			<div class="user-box">
				<h1>
					<strong>Groupe:</strong>
					<%=((inscriptionBeans) request.getAttribute("inscription")).getGroupe()%></h1>
			</div>
			<div class="user-box">
				<h1>
					<strong>Cycle:</strong>
					<%=((inscriptionBeans) request.getAttribute("inscription")).getCycle()%></h1>
			</div>
		</div>
	</div>

</body>
</html>
