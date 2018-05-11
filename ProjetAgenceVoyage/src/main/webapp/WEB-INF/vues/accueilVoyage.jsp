<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet"
	href="<c:url value='/resources/CSS/bootstrap.css'/>" />
<script type="text/javascript" src="/resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</head>
<body>

	<div class="btn-group" role="group" aria-label="...">
		<button type="button" class="btn btn-default">
			<a href="<c:url value='/conseiller/vCTRL/listeVoyageApres'/>">Acceder
				au menu de la gestion des voyages </a>
		</button>
		<button type="button" class="btn btn-default">
			<a href="<c:url value='/conseiller/pCTRL/liste'/>">Acceder a la
				gestion des participants </a>
		</button>
		<button type="button" class="btn btn-default">
			<a href="#">Acceder a la gestion des clients</a>
		</button>

	</div>

	<div class="btn-group pull-right" role="group" aria-label="..."
		style="text-align: right">

		<a href="<c:url value='/j_spring_security_logout'/>">Se
			déconnecter</a> <a href="<c:url value='/voiture/listeVoitures'/>">Afficher
			les voitures</a>
	</div>

	<br />
	<hr />

	<h1 style="color: blue; text-align: center">Liste des voyages
		disponibles</h1>

	
	<div align="center">

		<table class="table table-bordered">
			<tr>
				<th>id</th>
				<th>Date depart</th>
				<th>Date retour</th>
				<th>Nombre de place</th>
				<th>Tarif</th>
				<th>Disponibilite</th>
				<th>Assurance</th>
				<th>Id de la destination</th>
				<th>Pays de la destination</th>
				<th>Id de l'hebergement</th>
				<th>Id de la formule</th>
				<th>Operation</th>
			</tr>

			
				<c:forEach var="v" items="${listeVoy}" >
						
					<tr>
						<td>${v.id_v}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${v.dateD}" /></td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${v.dateR}" /></td>
						<td>${v.nbPlaces}</td>
						<td>${v.tarif }</td>
						<td>${v.disponibilite}</td>
						<td>${v.assurance }</td>
						<td>${v.destination.id }</td>
						
						<td>${v.destination.pays }</td>
						
						<td>${v.hebergement.id_h }</td>
						<td>${v.formule.id_f }</td>
						<td><a
							href="${pageContext.request.contextPath}/conseiller/vCTRL/deleteLinkVoyage/${v.id_v}">Supprimer</a>
							| <a
							href="${pageContext.request.contextPath}/conseiller/vCTRL/updateLinkVoyage?pIdV=${v.id_v}">Modifier</a></td>
					</tr>


				</c:forEach>
			
		</table>
	</div>




	<br />
	<br />
	<br />
	<br />

	<div class="typeform-widget"
		data-url="https://tudiantsddame.typeform.com/report/uOGCHO/N2RtFJ10mr5MwD86"
		style="width: 100%; height: 650px;"></div>
	<script>
		(function() {
			var qs, js, q, s, d = document, gi = d.getElementById, ce = d.createElement, gt = d.getElementsByTagName, id = "typef_orm", b = "https://embed.typeform.com/";
			if (!gi.call(d, id)) {
				js = ce.call(d, "script");
				js.id = id;
				js.src = b + "embed.js";
				q = gt.call(d, "script")[0];
				q.parentNode.insertBefore(js, q)
			}
		})()
	</script>
	<div
		style="font-family: Sans-Serif; font-size: 12px; color: #999; opacity: 0.5; padding-top: 5px;">
		powered by <a
			href="https://admin.typeform.com/signup?utm_campaign=uOGCHO&utm_source=typeform.com-5279313-Basic&utm_medium=typeform&utm_content=typeform-embedded-poweredbytypeform&utm_term=EN"
			style="color: #999" target="_blank">Typeform</a>
	</div>

</body>
</html>