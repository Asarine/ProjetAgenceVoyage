<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter</title>

<link rel="stylesheet"
	href="<c:url value = '/resources/CSS/bootstrap.css' />" />

</head>
<body>
	<%@ include file="/resources/template/header.html"%>


	<hr />
	<br />
	<h1 style="color: red; text-align: center">Ajouter des
		participants</h1>

	<form:form cssClass="form-horizontal" action="soumettreAjout"
		method="POST" modelAttribute="pAjout">

		<div class="form-group">
			<form:label path="civilite" cssClass="col-sm-2 control-label">Civilité</form:label>
			<div class="col-sm-4">
				<form:select class="form-control" path="civilite">
					<option value="M.">M.</option>
					<option value="Mme">Mme</option>
				</form:select>
			</div>
			<form:errors path="civilite" cssStyle="color:red" />
		</div>
		<br />

		<div class="form-group">
			<form:label path="nom" cssClass="col-sm-2 control-label">Nom</form:label>
			<div class="col-sm-4">
				<form:input path="nom" cssClass="form-control" placeholder="Nom" />
			</div>
			<form:errors path="nom" cssStyle="color:red" />
		</div>
		<br />

		<div class="form-group">
			<form:label path="prenom" cssClass="col-sm-2 control-label">Prénom</form:label>
			<div class="col-sm-4">
				<form:input path="prenom" cssClass="form-control"
					placeholder="Prénom" />
			</div>
			<form:errors path="nom" cssStyle="color:red" />
		</div>
		<br />

		<div class="form-group">
			<form:label path="dn" cssClass="col-sm-2 control-label">Date de naissance</form:label>

			<div class="col-sm-4">

				<form:input path="dn" cssClass="form-control" type="date" />
			</div>
			<form:errors path="dn" cssStyle="color:red" />
		</div>
		<br />

		<div class="form-group">
			<form:label path="tel" cssClass="col-sm-2 control-label">Numéro de téléphone</form:label>
			<div class="col-sm-4">
				<form:input path="tel" cssClass="form-control"
					placeholder="Numéro de téléphone" />
			</div>
			<form:errors path="tel" cssStyle="color:red" />
		</div>
		<br />

		<div class="form-group">
			<form:label path="mail" cssClass="col-sm-2 control-label">Mail</form:label>
			<div class="col-sm-4">
				<form:input path="mail" cssClass="form-control" placeholder="Mail" />
			</div>
			<form:errors path="mail" cssStyle="color:red" />
		</div>
		<br />


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Ajouter</button>
			</div>
		</div>
	</form:form>

</body>
</html>