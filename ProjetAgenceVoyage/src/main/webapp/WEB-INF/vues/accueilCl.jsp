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
<link rel="stylesheet" href="<c:url value='/resources/css/monStyleCedric.css'/>"/>

<title>Accueil Client</title>
</head>
<body style="background-image: url('../../resources/image/Londres.jpg'); background-repeat:round; height: 3000px">

<div style="background-color:#FFEBCD">


<%@ include file="/resources/template/headerClientConseiller.html"%>


<h1 style="text-align: center">Liste des clients</h1>

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
		
		<td><a href="${pageContext.request.contextPath}/client/clCTRL/deleteLink/${cl.id}">Supprimer</a> |<a href="${pageContext.request.contextPath}/client/clCTRL/updateLink?pId=${cl.id}">Modifier</a></td>
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
<br/>
</div>

</body>
</html>