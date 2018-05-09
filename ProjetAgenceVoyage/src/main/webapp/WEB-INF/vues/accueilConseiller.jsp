<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
</head>
<body>
	<h1>${message}</h1>

	<a href="<c:url value='/j_spring_security_logout'/>">Se d�connecter</a>
	<a href="<c:url value='/voiture/listeVoitures'/>">Afficher les voitures</a>
</body>
</html>