<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="../../resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../../resources/js/bootstrap.js"></script>
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>"/>
<title>Recherche</title>
</head>
<body>

<div class="btn-group" role="group" aria-label="...">
  <button type="button" class="btn btn-default"><a href="/conseiller/clCTRL/listeClient">Liste des clients enregistrés </a></button>

  <button type="button" class="btn btn-default"><a href="<c:url value = '/conseiller/clCTRL/formAjout' />">ajouter un nouveau client a la liste</a></button>
  <button type="button" class="btn btn-default"><a href="<c:url value = '/conseiller/clCTRL/formModif' />">modifier les modalites d'un client </a></button>
  <button type="button" class="btn btn-default"><a href="<c:url value = '/conseiller/clCTRL/formRech' />">rechercher un client a la base de donnee</a></button>
    <button type="button" class="btn btn-default"><a href="<c:url value = '/conseiller/clCTRL/formSupp' />">supprimer un client de la base de donnee</a></button>
    
  
</div>

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