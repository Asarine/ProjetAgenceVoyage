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
<!-- spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>" />
<link rel="stylesheet" href="<c:url value='/resources/css/monStyleCedric.css'/>"/>


<title>Accueil Dossier</title>
</head>
<body>

<div style="background-color:#FFEBCD">


<nav class="navbar navbar-inverse">
 <ul class="nav nav-pills">
  <li role="presentation"><a href="${pageContext.request.contextPath}/conseiller/dosCTRL/listeDossier">Accueil</a></li>
  <li role="presentation"><a href="<c:url value='/conseiller/dosCTRL/formAjout'/>">Ajouter</a></li>
  <li role="presentation"><a href="<c:url value='/conseiller/dosCTRL/formModif'/>">Modifier</a></li>
  <li role="presentation"><a href="<c:url value='/conseiller/dosCTRL/formSupp'/>">Supprimer</a></li>
  <li role="presentation"><a href="${pageContext.request.contextPath}/conseiller/dosCTRL/formRech">Rechercher</a></li>
  </ul>
</nav>

<h1 style="color:green;text-align: center">Liste des dossiers</h1>

<div align="center">
<table class="table table-bordered">
	<tr>
		<th>ID</th>
		<th>Id du client</th>
		<th>Nom du client</th>
		<th>Prenom du client</th>
		<th>Id du voyage</th>
		<th>Nombre de place</th>
		<th>Disponibilite </th>
	   <th>Lieu de la destination</th>		
		<th>Statut Dossier</th>
		<th>Assurance</th>
		<th>Prix Total</th>
		<th>Operations</th>
	</tr>
	
	<c:forEach var="dos" items="${listeDossier}">
	<tr>
		<td>${dos.id}</td>
		<td>${dos.clientDos.id}</td>
		<td>${dos.clientDos.nom}</td>
		<td>${dos.clientDos.prenom}</td>		
		<td>${dos.voyageDos.id_v}</td>
		<td>${dos.voyageDos.nbPlaces}</td>
		<td>${dos.voyageDos.disponibilite}</td>
		<td>${dos.voyageDos.destination.pays}</td>						
		<td>${dos.statutdossier}</td>
		<td>${dos.assurance}</td>
		<td>${dos.prixTotal}</td>
		
		<td><a href="${pageContext.request.contextPath}/conseiller/dosCTRL/updateLinkDossier?pIdD=${dos.id}">Modifier</a></td>
	</tr>
	
	</c:forEach>

</table>

</div>


<br/>

<br/>
<br/>
<br/>
<br/>
<br/>
</div>
</body>
</html>