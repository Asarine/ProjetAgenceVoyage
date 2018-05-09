<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Accueil</title>
<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet"
	href="<c:url value='/resources/CSS/bootstrap.css'/>" />
</head>
<body>
	<nav class="navbar navbar-inverse">
		<ul class="nav nav-pills">
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/hbgController/listeHbg">Accueil hebergement</a></li>
			<li role="presentation"><a
				href="<c:url value='/hbgCTRL/Ajouthbg'/>">Ajouter</a></li>
			<li role="presentation"><a
				href="<c:url value='/hbgController/modifHbg'/>">Modifier</a></li>
			<li role="presentation"><a
				href="<c:url value='/hbgController/suppHbg'/>">Supprimer</a></li>
			<li role="presentation"><a
				href="<c:url value='/hbgController/rechhbg'/>">Rechercher</a></li>
			<li role="presentation"><a
				href="<c:url value='/j_spring_security_logout'/>">Se déconnecter</a></li>
		</ul>
	</nav>
	<hr />
	<h1 style="color: coral; text-align: center">Liste des hebergements</h1>
	<div align="center">
		<table class="table table-bordered">
			<tr>
				<th>ID</th>
				<th>Petit dej</th>
				<th>dej</th>
				<th>diner</th>
				<th>Operation</th>
			</tr>

			<c:forEach var="h" items="${listeHbg}">
				<tr>
					<td>${h.id_h}</td>
				

					<td><a
						href="${pageContext.request.contextPath}/hbgController/deleteLink/${h.id_h}">Supprimer</a>|<a
						href="${pageContext.request.contextPath}/hbgController/updateLink?pId=${h.id_h}">Modifier</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>