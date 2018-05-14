<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../../resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../../resources/js/bootstrap.js"></script>
<!-- spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>" />
	<link rel="stylesheet" href="<c:url value='/resources/css/monStyleCedric.css'/>"/>
	
</head>
<body style="background-image: url('../../resources/image/ChuteNiagara.JPG'); background-repeat:round; height: 3000px">
	<div style="background-color:#FFEBCD">


	<%@ include file="/resources/template/headerDestinationConseiller.html"%>


	<br>

	<h1 style="color: red; text-align: center">Formulaire d'ajout</h1>

	<form:form cssClass="form-horizontal" method="post"
		action="soumettreAjoutds" modelAttribute="dsAjout"
		enctype="multipart/form-data">

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="continent">Continent</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Continent"
					path="continent" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="pays">Pays</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" placeholder="pays"
					path="pays" />
			</div>
		</div>


		<div class="form-group">
			<label class="col-sm-2 control-label">Images</label>
			<div class="col-sm-10">
				<input name="files" id="fileToUpload" type="file" multiple/>

			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Ajouter
					Destination</button>
			</div>
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