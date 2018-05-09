<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/dsCTRL/afficheAjoutds">Ajouter
					Destination</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/dsCTRL/afficheSupprds">Supprimer
					Destination</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/dsCTRL/affichRechds">Rechercher
					Destination</a></li>
					<li role="presentation"><a href="${pageContext.request.contextPath}/dsCTRL/affichModifds">Modifier Destination</a></li>
		</ul>
	</nav>
	<h1 style="color: pink; text-align: center">Modifier Destination</h1>
	<form:form cssClass="form-horizontal" method="post" action="soumettreModifds" modelAttribute="dsModif">
		<div class="form-group">
			<label for="id" class="col-sm-2 control-label">Id</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="id"
					placeholder="Id" name="id">
			</div>
		</div>
		<div class="form-group">
			<label for="idcontinent" class="col-sm-2 control-label">Continent</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="idContinent"
					placeholder="continent" name="pContinent">
			</div>
		</div>
		<div class="form-group">
			<label for="idPays" class="col-sm-2 control-label">Pays</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="idPays"
					placeholder="Pays" name="pPays">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Modifier</button>
			</div>
		</div>
	</form:form>
</body>
</html>