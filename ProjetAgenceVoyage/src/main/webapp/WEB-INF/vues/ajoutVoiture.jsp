<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="../../resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../../resources/js/bootstrap.js"></script>
<!-- spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>" />
<link rel="stylesheet" href="<c:url value='/resources/css/monStyleCedric.css'/>"/>

<title>Ajouter Voiture</title>
</head>
<body>
<div style="background-color:#FFEBCD">

<%@ include file="/resources/template/headerVoitureConseiller.html"%>
<br/>



	<h1 style=" text-align: center">Ajouter une nouvelle voiture</h1>
	<br/>
	<form:form cssClass="form-horizontal" method="POST"
		action="ajoutVoiture" modelAttribute="voitureAjoutee">
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
			<input type="submit" class="btn btn-default" value="Ajouter">
		</div>
	</form:form>
	
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