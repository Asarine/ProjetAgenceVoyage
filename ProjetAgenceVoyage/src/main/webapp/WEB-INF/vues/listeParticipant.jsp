<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Pouvoir utiliser forEach -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserer nom</title>

<script type="text/javascript" src="../../resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../../resources/js/bootstrap.js"></script>
<!-- spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>" />

</head>

<body>

<%@ include file="/resources/template/headerParticipantConseiller.html"%>

	
	<h1>Liste des participants</h1>

	<div align="center">
		<table class="table table-bordered">
			<tr>
				<th>ID</th>
				<th>Civilité</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Numéro de <br/> téléphone</th>
				<th>Date de<br/> naissance</th>
				<th>Mail</th>
				<th>Id du client </th>
				<th>Opérations</th>
			</tr>
			<c:forEach var="p" items="${listeParticipant}">
				<tr>
					<td>${p.id}</td>
					<td>${p.civilite}</td>
					<td>${p.nom}</td>
					<td>${p.prenom}</td>
					<td>${p.tel}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${p.dn}" /></td>
					<td>${p.mail}</td>
					<td>${p.client.id}</td>
					<td><a href="<c:url value = '/conseiller/pCTRL/deleteLink/${p.id}' />">Supprimer</a>
						| <a href="<c:url value = '/conseiller/pCTRL/updateLink?pId=${p.id}' />">Modifier</a></td>
				</tr>

			</c:forEach>
		</table>
	</div>

</body>
</html>