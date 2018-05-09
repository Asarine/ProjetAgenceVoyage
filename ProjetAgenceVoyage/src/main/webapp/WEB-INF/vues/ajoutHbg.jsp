<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un hebergement</title>

<link rel="stylesheet"
	href="<c:url value='/resources/CSS/bootstrap.css'/>" />
</head>
<body>
	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreForm" modelAttribute="hbgAjout">
		<div class="form-group">
			<label for="sel1">Prestation d'hebergement:</label> 
			<form:select path="selectionhbg" class="form-control" id="sel1">
				<option value="Herbergement">Herbergement</option>
				<option value="Petit Dejeuner">Petit Dejeuner</option>
				<option value="Demi-pension">Demi-pension</option>
				<option value="Demi-pension et pension complete">Demi-pension et pension complete</option>
			</form:select>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Ajouter</button>
			</div>
		</div>
	</form:form>
</body>
</html>