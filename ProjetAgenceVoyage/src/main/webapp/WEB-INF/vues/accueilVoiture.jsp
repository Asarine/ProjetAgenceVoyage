<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<!-- spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="../css/bootstrap.css" />
<link rel="stylesheet" href="<c:url value='/resources/css/monStyleCedric.css'/>"/>

<title>Accueil Voiture</title>
</head>
<body>

<div style="background-color:#FFEBCD">

	<h1 style="color: crimson; text-align: center">Liste des voitures</h1>
	<div align="center">
		<table class="table table-bordered">
			<tr>
				<th>Images</th>
				<th>ID</th>
				<th>Catégorie</th>
				<th>Entreprise de location</th>
				<th><th>
			</tr>

			<c:forEach var="v" items="${listeVoiture}">
				<tr>
					<td><c:forEach var="image" items="${v.photos}">
							<img src="${image}" width="30" height="30">
						</c:forEach></td>
					<td>${v.id}</td>
					<td>${v.categorie}</td>
					<td>${v.loueur}</td>
					<td><a href="<c:url value='conseiller/voiture/deleteVoit/${v.id}'/>">Supprimer</a>
						|| <a href="<c:url value='conseiller/voiture/updateVoit?pId=${v.id}'/>">Modifier</a></td>
				</tr>
			</c:forEach>

			<tr>
							<td></td>
			
				<td></td>
				<td></td>
				<td></td>
				<td><a href="<c:url value='/voiture/formAjoutVoit'/>">Ajouter
						une nouvelle voiture</a></td>
			</tr>
		</table>
	</div>
	<form:form cssClass="form-horizontal" method="POST"
		action="listeVoituresRech">
		<div class="form-group">
			<label class="col-sm-2 control-label">Rechercher</label>
			<div class="col-sm-10">
				<input class="form-control" placeholder="Mots clés" name="pMotCle" />
			</div>
		</div>
		<div class="col-sm-offset-2 col-sm-10">
			<input type="submit" class="btn btn-default" value="Trouver !">
		</div>
	</form:form>
	
	
	<br/>

<br/>
<br/>
<br/>
<br/>
<br/>
</div>
	
</body>
</html>