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

<title>Accueil Dossier</title>
</head>
<body>

<h1 style="color:green;text-align: center">Liste des dossiers</h1>

<div align="center">
<table class="table table-bordered">
	<tr>
		<th>ID</th>
		<th>Client</th>
		<th>Voyage</th>
		<th>Statut Dossier</th>
		<th>Assurance</th>
		<th>Prix Total</th>
		<th>Operations</th>
	</tr>
	
	<c:forEach var="dos" items="${liste}">
	<tr>
		<td>${dos.id}</td>
		<td>${dos.voyageDos.destination.pays}</td>
		<td>${dos.statutdossier}</td>
		<td>${dos.assurance}</td>
		<td>${dos.prixTotal}</td>
		
		<td><a href="${pageContext.request.contextPath}/resCTRL/delete/${dos.id}">Annuler le voyage</a></td>
		</tr>
	
	</c:forEach>

</table>

</div>

</body>
</html>