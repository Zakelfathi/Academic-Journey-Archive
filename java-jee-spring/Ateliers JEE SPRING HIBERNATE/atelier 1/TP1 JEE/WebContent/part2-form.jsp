<!doctype html>
<html lang="en">
<head>
<title>Inscription etudiant</title>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="login-box">
		<h2>Inscription:</h2>
		<form method="post" action="part2Servlet">
			<div class="input-group">
				<div class="user-box">
					<input type="text" class="form-control" id="firstName"
						name="firstName" placeholder="votre prenom">
				</div>
				<div class="user-box">
					<input type="text" class="form-control" id="lastName"
						name="lastName" placeholder="votre prenom">
				</div>
				<div class="user-box">
					<input type="email" class="form-control" id="email" name="email"
						placeholder="votre email">
				</div>
				<div class="user-box">
					<input type="text" class="form-control" id="cne" name="cne"
						placeholder="votre CNE">
				</div>
				<label class="user-box">Date de naissance:</label>
				<div class="user-box">
					<input type="date" id="dNaiss" name="dNaiss">
				</div>
				<label class="user-box">Date d'inscription:</label>
				<div class="user-box">
					<input type="date" class="form-control" id="dInscription"
						name="dInscription" placeholder="votre date inscription">
				</div>
				<div class="user-box">
					<input type="tele" class="form-control" id="tele" name="tele"
						placeholder="votre numero de telephone">
				</div>
				<div class="user-box">
					<input type="number" class="form-control" id="nbrAnneeInscription"
						name="nbrAnneeInscription"
						placeholder="Nombre d'ans d'inscription">
				</div>
				<div class="user-box">
					<input type="text" class="form-control" id="groupe" name="groupe"
						placeholder="votre groupe">
				</div>
				<div class="user-box">
					<select name="niveau" class="custom-select" id="niveau">
						<option value=" ">Select niveau..</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
					</select>
				</div>
				<div class="user-box">
					<select name=cycle class="custom-select" id="cycle">
						<option value=" ">Select cycle..</option>
						<option value="preparatoire">preparatoire</option>
						<option value="d'ingenieur">d'ingenieur</option>
					</select>
				</div>
				<div class="user-box">
					<select name="filiere" class="custom-select" id="filiere">
						<option value=" ">Select filiere..</option>
						<option value="cp">CP</option>
						<option value="iric">IRIC</option>
						<option value="iid">IID</option>
						<option value="gi">GI</option>
						<option value="ge">GE</option>
						<option value="gpee">GPEE</option>
					</select>
				</div>

				<input type="submit" value="Envoyer!">

			</div>
		</form>
	</div>
</body>
</html>

