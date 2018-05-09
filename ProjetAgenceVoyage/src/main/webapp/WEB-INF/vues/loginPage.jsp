<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<form action="connexion" method="post" class="form-horizontal">
		<div class="form-group">
			<label for="inputEmail" class="col-sm-2 control-label">Email
				: </label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputEmail"
					placeholder="Email" name="j_username">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword" class="col-sm-2 control-label">Mot
				de passe : </label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="inputPassword"
					placeholder="Password" name="j_password">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-default" value="Connexion" />
			</div>
		</div>
	</form>

	<c:if test="${not empty erreur}">
		<h2 style="color: crimson">Identifiant ou mot de passe erroné</h2>
	</c:if>

	<c:if test="${not empty nonDroit}">
		<h2 style="color: crimson">Vous n'êtes pas enregistré en tant que conseiller...</h2>
	</c:if>
</body>
</html>