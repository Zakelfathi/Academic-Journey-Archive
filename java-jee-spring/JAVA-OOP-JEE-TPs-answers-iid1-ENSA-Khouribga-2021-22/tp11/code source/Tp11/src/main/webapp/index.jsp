<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel ="stylesheet" type="text/css" href="bootstrap.css">

</head>
<body style="padding:20px">

<form action="connexion" style="width : 20%">
<h2><center>Connexion</center></h2>
<label for="nameuser"><strong>Nom d'utilisateur</strong></label>
<input type="text" name="nameuser" id="nameuser" class="form-control" placeholder="Entrer Nom d'utilisateur"><br>
<label for="password"><strong>Mot de passe</strong></label>
<input type="password" name="password" id="password" class="form-control" placeholder="Entrer Mot de passe "><br>
<input type="submit" name="login" value="login" class="btn btn-success form-control" >
</form>

</body>
</html>