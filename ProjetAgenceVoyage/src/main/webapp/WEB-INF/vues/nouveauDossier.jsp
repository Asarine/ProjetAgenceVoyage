<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="<c:url value='/resources/js/jquery-3.3.1.js'/>"></script>
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>" />

<script src="<c:url value='/resources/js/bootstrap.js'/>"
	type="text/javascript"></script>
<title>Reservation- Etape 1</title>
<link rel="stylesheet" href="<c:url value='/resources/css/monStyleCedric.css'/>"/>
</head>
<body style="background-image: url('../resources/image/SkyView.jpg'); background-repeat:round; height: 3000px">
<div style="background-color:#87CEFA">
<br/>
<br/>
<br/>
<h1 style="text-align:center;font-size: 80px; color:slateBlue"><b>BoVoyage</b></h1>
<h2 style="text-align:center"><b>Globe-Trottez</b></h2>
<br/>
<br/>
<br/>
<%@ include file="/resources/template/headerClient.html"%>
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

	<form:form cssClass="form-horizontal" method="POST"
		action="creerNouveauDossier" modelAttribute="dossier">
		<div class="form-group">
			<div class="col-sm-10">
				<form:checkbox path="assurance" />
				Assurance annulation
			</div>
		</div>
		<div class="form-group">
			<form:label path="clientDos.id" cssClass="col-sm-2 control-label">Numéro Client</form:label>
			<div class="col-sm-4">
				<form:input path="clientDos.id" cssClass="form-control"
					placeholder="Numéro Client" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-4">
				<form:hidden path="voyageDos.id_v" cssClass="form-control"
					value="${voyageSelect.id_v}" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Réserver</button>
			</div>
		</div>

	</form:form>
</div>
</body>
</html>