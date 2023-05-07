<html lang="en">
<head>
<title>formulaire Etudiant</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<!-- Login box container -->
	<div class="login-box">
		<h2>Inscription:</h2>
		<!-- Form for student registration -->
		<form method="post" action="part1Servlet">
			<div class="input-group">
				<!-- First name input -->
				<div class="user-box">
					<input type="text" class="form-control" id="firstName"
						name="firstName" placeholder="votre prenom">
				</div>
				<!-- Last name input -->
				<div class="user-box">
					<input type="text" class="form-control" id="lastName"
						name="lastName" placeholder="votre nom">
				</div>
				<!-- Email input -->
				<div class="user-box">
					<input type="email" class="form-control" id="email" name="email"
						placeholder="votre email">
				</div>
				<!-- CNE input -->
				<div class="user-box">
					<input type="text" class="form-control" id="cne" name="cne"
						placeholder="votre CNE">
				</div>
				<!-- Date of birth input -->
				<label class="user-box">Date de naissance:</label>
				<div class="user-box">
					<input type="date" id="dNaiss" name="dNaiss">
				</div>
				<!-- Telephone input -->
				<div class="user-box">
					<input type="tele" class="form-control" id="tele" name="tele"
						placeholder="votre numero de telephone">
				</div>
				<!-- Submit button -->
				<input type="submit" value="Envoyer!">
			</div>
		</form>
	</div>
</body>
</html>