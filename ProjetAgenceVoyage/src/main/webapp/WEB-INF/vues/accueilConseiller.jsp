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

	<a href="<c:url value='/j_spring_security_logout'/>">Se déconnecter</a>
	<a href="<c:url value='/voiture/listeVoitures'/>">Afficher les voitures</a>
	
	<iframe src="https://docs.google.com/forms/d/e/1FAIpQLSdEQcHTtm1MqausneGtJeL-gICH7dnELrhnrRoxYWyZZXK_ug/viewform?embedded=true" width="700" height="520" frameborder="0" marginheight="0" marginwidth="0">Chargement en cours...</iframe>
</body>
</html>