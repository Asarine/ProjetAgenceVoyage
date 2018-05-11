<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rechercher</title>

<script type="text/javascript" src="../../resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../../resources/js/bootstrap.js"></script>
<!-- spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>" />

</head>
<body>


<%@ include file="/resources/template/headerParticipantConseiller.html"%>


	<br />
	<h1 style="color: red; text-align: center">Rechercher des participants</h1>

	<form:form cssClass="form-horizontal" action="soumettreSearch"
		method="POST" modelAttribute="pSearch">

		<div class="form-group">
			<form:label path="id" cssClass="col-sm-2 control-label">ID</form:label>
			<div class="col-sm-4">
				<form:input path="id" cssClass="form-control" placeholder="ID" />
			</div>
			<form:errors path="id" cssStyle="color:red" />
		</div>
		<br />

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Rechercher
					participant par id</button>
			</div>
		</div>
	</form:form>

	<br />
	<div align="center">
		<table class="table table-bordered">

			<tr>
				<th>ID</th>
				<th>Civilité</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Date de<br /> naissance
				</th>
				<th>Numéro de <br /> téléphone
				</th>
				<th>Mail</th>
				<th>Id client</th>
				<th>Opérations</th>
			</tr>
			<tr>
				<td>${pOut.id}</td>
				<td>${pOut.civilite}</td>
				<td>${pOut.nom}</td>
				<td>${pOut.prenom}</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${pOut.dn}" /></td>
				<td>${p.tel}</td>
				<td>${pOut.mail}</td>
				<td>${pOut.client.id}</td>
				<td></td>
				<!-- Supprimer | Modifier -->
			</tr>
		</table>

	</div>

	<h1 style="color: red; text-align: center">${msg}</h1>


</body>
</html>