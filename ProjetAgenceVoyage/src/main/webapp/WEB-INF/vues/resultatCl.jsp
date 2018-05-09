<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/resources/CSS/bootstrap.css'/>"/>
<title>Recherche</title>
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

<h1 style="color:green;text-align: center">Client recherché</h1>

<div align="center">
<table class="table table-bordered">
	<tr>
		<th>ID</th>
		<th>Nom</th>
		<th>Prenom</th>
		<th>Civilité</th>
		<th>Tel</th>
		<th>Date de naissance</th>
		<th>Mail</th>
		<th>Numero compte bancaire</th>
		<th>Operations</th>
	</tr>
	
	
	<tr>
		<td>${clFind.id}</td>
		<td>${clFind.nom}</td>
		<td>${clFind.prenom}</td>
		<td>${clFind.civilite}</td>
		<td>${clFind.tel}</td>
		<td><fmt:formatDate pattern="dd/MM/yyyy" value="${clFind.dn}"/></td>
		<td>${clFind.mail}</td>
		<td>${clFind.numcb}</td>
		<td>${clFind.conseiller.id_co}</td>
		<td>${clFind.voyage.id_v}</td>
		<td><a href="${pageContext.request.contextPath}/clCTRL/deleteLink/${clFind.id}">Supprimer</a> |<a href="${pageContext.request.contextPath}/clCTRL/updateLink?pId=${clFind.id}">Modifier</a></td>
	</tr>
	

</table>

</div>

</body>
</html>