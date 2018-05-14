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

<link rel="stylesheet"
	href="<c:url value='/resources/css/monStyleCedric.css'/>" />
<title>Accueil</title>
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
		
		<form:form cssClass="form-horizontal" action="soumettreAjout"
		method="POST">

		<div class="form-group">
			<label  class="col-sm-2 control-label" for="numClient">Numéro Client</label>
			<div class="col-sm-4">
				<input type="text" id="numClient" name="pId">
			</div>
			
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Afficher</button>
			</div>
		</div>
	</form:form>

		<c:if test="${not empty liste}">
			<h1 style="color: green; text-align: center; font-size: 40px">Liste
				des dossiers</h1>

			<div align="center">
				<table class="table table-bordered">
					<tr>
						<th>ID</th>
						<th>Voyage</th>
						<th>Statut Dossier</th>
						<th>Assurance</th>
						<th>Prix Total</th>
						<th>Operations</th>
					</tr>

					<c:forEach var="dos" items="${liste}">
						<tr>
							<td>${dos.id}</td>
							<td>${dos.voyageDos.destination.pays}</td>
							<td>${dos.statutdossier}</td>
							<td>${dos.assurance}</td>
							<td>${dos.prixTotal}</td>

							<td><a
								href="${pageContext.request.contextPath}/resCTRL/delete/${dos.id}">Annuler
									le voyage</a></td>
						</tr>

					</c:forEach>

				</table>

			</div>
			
			</c:if>
	</div>
</body>
</html>