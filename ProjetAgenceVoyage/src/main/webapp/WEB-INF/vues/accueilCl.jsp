<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>"/>
<title>Accueil Client</title>
</head>
<body>

<nav class="navbar navbar-inverse">
 <ul class="nav nav-pills">
  <li role="presentation"><a href="${pageContext.request.contextPath}/conseiller/clCTRL/listeClient">Accueil</a></li>
  <li role="presentation"><a href="<c:url value='/conseiller/clCTRL/formAjout'/>">Ajouter</a></li>
  <li role="presentation"><a href="<c:url value='/conseiller/clCTRL/formModif'/>">Modifier</a></li>
  <li role="presentation"><a href="<c:url value='/conseiller/clCTRL/formSupp'/>">Supprimer</a></li>
  <li role="presentation"><a href="${pageContext.request.contextPath}/conseiller/clCTRL/formRech">Rechercher</a></li>
  </ul>
</nav>

<h1 style="color:green;text-align: center">Liste des clients</h1>

<div align="center">
<table class="table table-bordered">
	<tr>
		<th>ID</th>
		<th>Civilité</th>
		<th>Nom</th>
		<th>Prenom</th>
		<th>Tel</th>
		<th>Date de naissance</th>
		<th>Mail</th>
		<th>Numero compte bancaire</th>
		<th>Id conseiller</th>
		<th>Id voyage</th>
		
		
		<th>Operations</th>
	</tr>
	
	<c:forEach var="cl" items="${listeClient}">
	<tr>
		<td>${cl.id}</td>
		<td>${cl.civilite}</td>
		<td>${cl.nom}</td>
		<td>${cl.prenom}</td>
		<td>${cl.tel}</td>
		<td>${cl.dn}</td>
		<td>${cl.mail}</td>
		<td>${cl.numcb}</td>
		<td>${cl.conseiller.id_co}</td>
		<td>${cl.voyage.id_v}</td>
		
		
		<td><a href="${pageContext.request.contextPath}/clCTRL/deleteLink/${cl.id}">Supprimer</a> |<a href="${pageContext.request.contextPath}/clCTRL/updateLink?pId=${cl.id}">Modifier</a></td>
	</tr>
	
	</c:forEach>

</table>

</div>

</body>
</html>