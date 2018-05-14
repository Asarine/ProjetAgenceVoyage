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
<title>Prix à payer</title>
<link rel="stylesheet"
	href="<c:url value='/resources/css/monStyleCedric.css'/>" />
</head>
<body
	style="background-image: url('../resources/image/SkyView.jpg'); background-repeat: round; height: 3000px">
	<div style="background-color: #87CEFA">
		<br /> <br /> <br />
		<h1 style="text-align: center; font-size: 80px; color: slateBlue">
			<b>BoVoyage</b>
		</h1>
		<h2 style="text-align: center">
			<b>Globe-Trottez</b>
		</h2>
		<br /> <br /> <br />
<%@ include file="/resources/template/headerClient.html"%>
	<h1>Validation de la commande : </h1>
	<br/>
	<hr/>
	<br/>
	Prix à payer = ${dossier.prixTotal}

	<form:form cssClass="form-horizontal" action="finir"
		method="POST" modelAttribute="dossier">
		<form:hidden path="id" value="${dossier.id}"/>
		CB
		<input type="text" name="pCB" placeholder="Numero Carte Bleue"/>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Valider</button>
			</div>
		</div>
	</form:form>
	
	<form:form cssClass="form-horizontal" action="annuler"
		method="POST" modelAttribute="dossier">
		<form:hidden path="id" value="${dossier.id}"/>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Annuler</button>
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>