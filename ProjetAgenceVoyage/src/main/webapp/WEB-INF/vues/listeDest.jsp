<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<c:url value='/resources/CSS/bootstrap.css'/>" />
</head>
<body>
		<nav class="navbar navbar-inverse">
		<ul class="nav nav-pills">
			<li role="presentation"><a href="accueil.jsp">accueil</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/dsCTRL/listeDest">Destinations</a></li>
			<li role="presentation"><a href="${pageContext.request.contextPath}/dsCTRL/afficheAjoutds">Ajouter Destination</a></li>
			<li role="presentation"><a href="${pageContext.request.contextPath}/dsCTRL/afficheSupprds">Supprimer Destination</a></li>
			<li role="presentation"><a href="${pageContext.request.contextPath}/dsCTRL/affichRechds">Rechercher Destination</a></li>
		<li role="presentation"><a href="${pageContext.request.contextPath}/dsCTRL/affichModifds">Modifier Destination</a></li>
		</ul>
	</nav>
	<h1 style="color: red; text-align: center">
		<i>Liste des destination</i>
	</h1>

	<table class="table table-bordered">
		<tr>
			<th>id</th>
			<th>Continent</th>
			<th>Pays</th>
		</tr>
		<c:forEach var="ds" items="${listeDestinations}">
			<tr>
			<td>${ds.id}</td>
			<td>${ds.continent}</td>
			<td>${ds.pays}</td>
			
		</tr>
		</c:forEach>
	</table>


</body>
</html>