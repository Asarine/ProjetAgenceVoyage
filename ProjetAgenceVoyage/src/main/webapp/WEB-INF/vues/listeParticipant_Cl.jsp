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

<script type="text/javascript" src="/resources/js/jquery-3.3.1.js"></script>
<!-- spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>" />
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>

</head>

<body>

<%@ include file="/resources/template/headerClient.html"%>

	
	<h1>Liste des participants</h1>

	<div align="center">
		<table class="table table-bordered">
			<tr>
				<th>Personne</th>
				<th>Numéro de téléphone</th>
				<th>Date de naissance</th>
				<th>Mail</th>
				<th>Opérations</th>
			</tr>
			<c:forEach var="p" items="${listeParticipant_Cl}">
				<tr>
					<td>${p.civilite} ${p.nom} ${p.prenom}</td>
					<td>${p.tel}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${p.dn}" /></td>
					<td>${p.mail}</td>
					<td><a href="<c:url value = '/client/pCTRL/deleteLink_Cl/${p.id}' />">Supprimer</a>
						| <a href="<c:url value = '/client/pCTRL/updateLink_Cl?pId=${p.id}' />">Modifier</a></td>
				</tr>

			</c:forEach>
		</table>
	</div>

</body>
</html>