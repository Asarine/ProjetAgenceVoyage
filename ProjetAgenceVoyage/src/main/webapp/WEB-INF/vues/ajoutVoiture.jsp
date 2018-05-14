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
	<link rel="stylesheet" href="<c:url value='/resources/css/monStyleCedric.css'/>"/>
	
<title>Ajouter Voiture</title>
</head>
<body>
<div style="background-color:#FFEBCD">


	<h1 style="color: crimson; text-align: center">Ajouter une nouvelle voiture</h1>
	<br/>
	<form:form cssClass="form-horizontal" method="post"
		action="ajoutVoiture" modelAttribute="voitureAjoutee" enctype="multipart/form-data">
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
		
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Images</label>
			<div class="col-sm-10">
				<input name="files" id="fileToUpload" type="file" multiple/>

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
</div>
	
</body>
</html>