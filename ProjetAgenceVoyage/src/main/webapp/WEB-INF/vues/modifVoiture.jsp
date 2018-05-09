<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="<c:url value='/resources/js/jquery-3.3.1.js'/>"></script>
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>" />
<script src="<c:url value='/resources/js/bootstrap.js'/>"
	type="text/javascript"></script>
<title>Modifier Voiture</title>
</head>
<body>
	<h1 style="color: crimson; text-align: center">Modifier une voiture</h1>
	<br/>
	<form:form cssClass="form-horizontal" method="POST"
		action="http://localhost:8080/ProjetAgenceVoyage/voiture/modifVoiture" modelAttribute="voitureModifiee">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id">ID</form:label>
			<div class="col-sm-6">
				<form:input cssClass="form-control" placeholder="ID"
					path="id" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="categorie">Catégorie</form:label>
			<div class="col-sm-6">
				<form:input cssClass="form-control" placeholder="Catégorie"
					path="categorie" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="loueur">Entreprise loueuse</form:label>
			<div class="col-sm-6">
				<form:input cssClass="form-control" placeholder="Nom Entreprise"
					path="loueur" />
			</div>
		</div>
		<div class="col-sm-offset-2 col-sm-10">
			<input type="submit" class="btn btn-default" value="Modifier">
		</div>
	</form:form>
</body>
</html>