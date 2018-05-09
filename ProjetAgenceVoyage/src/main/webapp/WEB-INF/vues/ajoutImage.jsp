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
<title>Ajouter Voiture</title>
</head>
<body>
	<h1 style="color: crimson; text-align: center">Ajouter des images</h1>
	<br/>
		<form:form cssClass="form-horizontal" method="POST"
		action="ajoutImgBD" modelAttribute="groupeFichier">
		<div class="form-group">
			<form:label path="images">Images: </form:label> 
			<form:input type="file" multiple="multiple" path="images" />
		</div>

		<div class="col-sm-offset-2 col-sm-10">
			<input type="submit" class="btn btn-default" value="Ajouter">
		</div>
	</form:form>
</body>
</html>