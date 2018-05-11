<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../../resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../../resources/js/bootstrap.js"></script>
<!-- spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>" />
</head>
<body>


<%@ include file="/resources/template/headerDestinationConseiller.html"%>


		
	<h1 style="color: red; text-align: center">
		<i>Liste des destination</i>
	</h1>

	<table class="table table-bordered">
		<tr>
			<th>id</th>
			<th>Continent</th>
			<th>Pays</th>
			<th>Operation</th>
		</tr>
		<c:forEach var="ds" items="${listeDestinations}">
			<tr>
			<td>${ds.id}</td>
			<td>${ds.continent}</td>
			<td>${ds.pays}</td>
			<td><a href="${pageContext.request.contextPath}/conseiller/dsCTRL/deleteLink/${ds.id}">Supprimer</a> | <a href="${pageContext.request.contextPath}/conseiller/dsCTRL/updateLink?pId=${ds.id}">Modifier</a></td>
			
		</tr>
		</c:forEach>
	</table>


</body>
</html>
