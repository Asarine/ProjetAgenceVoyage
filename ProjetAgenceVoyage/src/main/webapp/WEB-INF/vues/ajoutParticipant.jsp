<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="<c:url value='/resources/js/jquery-3.3.1.js'/>"></script>
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>" />

<script src="<c:url value='/resources/js/bootstrap.js'/>"
	type="text/javascript"></script>
<title>Accueil</title>
</head>
<body>

	<div class="panel panel-default">
		<div class="panel-heading ">
			<h3 class="panel-title" align="center">
				<b>Référence du voyage</b> : ${voyageSelect.id_v}
			</h3>
		</div>
		<div class="panel-body " align="center">
			<b>Date de depart </b>: ${voyageSelect.dateD} - <b>Date de retour</b>
			: ${voyageSelect.dateR} <br /> <b>Nombre de places </b>:
			${voyageSelect.nbPlaces} - <b>Tarif</b> : ${voyageSelect.tarif} <br />
			<b>Destination</b> : ${voyageSelect.destination.pays} <br />
		</div>
	</div>

	<h1>Ajout des participants</h1>

	<div align="center">
		<table class="table table-bordered">
			<tr>
				<th>ID</th>
				<th>Civilité</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Numéro de <br /> téléphone
				</th>
				<th>Date de<br /> naissance
				</th>
				<th>Mail</th>
				<th>Id du client</th>
				<th>Opérations</th>
			</tr>
			<c:forEach var="p" items="${listeP}">
				<tr>
					<td>${p.id}</td>
					<td>${p.civilite}</td>
					<td>${p.nom}</td>
					<td>${p.prenom}</td>
					<td>${p.tel}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${p.dn}" /></td>
					<td>${p.mail}</td>
					<td>${p.client.id}</td>
					<td><a
						href="<c:url value = '/resCTRL/deleteLink?pId=${p.id}&pIdDossier=${dossier.id}' />">Supprimer</a>
				</tr>

			</c:forEach>
		</table>
	</div>
	<form:form cssClass="form-horizontal" action="ajouterParticipant"
		method="POST" modelAttribute="participant">

		<div class="form-group">
			<form:label path="civilite" cssClass="col-sm-2 control-label">Civilité</form:label>
			<div class="col-sm-4">
				<form:select class="form-control" path="civilite" name="pCivilite">
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

		<div class="form-group">
			<div class="col-sm-4">
				<form:hidden path="client.id" cssClass="form-control"
					value="${dossier.clientDos.id}" />
			</div>
			<form:errors path="client.id" cssStyle="color:red" />
		</div>

		<br />
		<input type="hidden" name="idDossier" value="${dossier.id}">
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Ajouter un
					participant</button>
			</div>
		</div>
	</form:form>

	<form:form cssClass="form-horizontal" action="continuerReservation"
		method="POST" modelAttribute="dossierRecup">
		<form:hidden path="id" cssClass="form-control" value="${dossier.id}" />

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Continuer la réservation</button>
			</div>
		</div>
	</form:form>
</body>

</html>