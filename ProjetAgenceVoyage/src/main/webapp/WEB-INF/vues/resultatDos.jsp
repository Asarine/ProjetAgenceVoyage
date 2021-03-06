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
<title>Dossier recherch�</title>
</head>
<body>

<nav class="navbar navbar-inverse">
 <ul class="nav nav-pills">
  <li role="presentation"><a href="${pageContext.request.contextPath}/conseiller/dosCTRL/listeDossier">Accueil</a></li>
  <li role="presentation"><a href="<c:url value='/conseiller/dosCTRL/formAjout'/>">Ajouter</a></li>
  <li role="presentation"><a href="<c:url value='/conseiller/dosCTRL/formModif'/>">Modifier</a></li>
  <li role="presentation"><a href="<c:url value='/conseiller/dosCTRL/formSupp'/>">Supprimer</a></li>
  <li role="presentation"><a href="${pageContext.request.contextPath}/conseiller/dosCTRL/formRech">Rechercher</a></li>
  </ul>
</nav>

<h1 style="color:green;text-align: center">Dossier recherch�</h1>

<div align="center">
<table class="table table-bordered">
	<tr>
		<th>ID</th>
		<th>Statut Dossier</th>
		<th>Operations</th>
	</tr>
	
	
	<tr>
		<td>${dosFind.id}</td>
		<td>${dosFind.statutdossier}</td>
		<td><a href="${pageContext.request.contextPath}/dosCTRL/deleteLink/${dosFind.id}">Supprimer</a> |<a href="${pageContext.request.contextPath}/dosCTRL/updateLink?pId=${dosFind.id}">Modifier</a></td>
	</tr>
	

</table>

</div>

</body>
</html>