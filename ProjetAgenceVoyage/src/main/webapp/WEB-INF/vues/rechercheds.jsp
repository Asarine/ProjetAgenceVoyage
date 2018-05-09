<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<li role="presentation"><a href="accueil.jsp"">accueil</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/dsCTRL/listeDest">Destinations</a></li>
			<li role="presentation"><a href="${pageContext.request.contextPath}/dsCTRL/afficheAjoutds">Ajouter Destination</a></li>
			<li role="presentation"><a href="${pageContext.request.contextPath}/dsCTRL/afficheSupprds">Supprimer Destination</a></li>
			<li role="presentation"><a href="${pageContext.request.contextPath}/dsCTRL/affichRechds">Rechercher Destination</a></li>
			<li role="presentation"><a href="${pageContext.request.contextPath}/dsCTRL/affichModifds">Modifier Destination</a></li>
		</ul>
	</nav>
	<h1 style="color: red; text-align: center">
		<i>Liste de Marchandise</i>
	</h1>
	<form:form class="form-horizontal" method="post" action="soumRech" >
		<div class="form-group">
			<label class="col-sm-2 control-label">Id</label>
			<div class="col-sm-10">
				<input class="form-control" placeholder="id" name="pId" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Rechercher</button>
			</div>
		</div>
	</form:form>
	<table class="table table-bordered">
		<tr>
			<th>id</th>
			<th>Pays</th>
			<th>Continent</th>
			
			
			
		</tr>
	
		<tr>
			<td>${dsFind.id}</td>
			<td>${dsFind.pays}</td>
			<td>${dsFind.continent}</td>
			
		</tr>
	
	</table>
</body>
</html>