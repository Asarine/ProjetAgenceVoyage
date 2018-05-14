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
<title>Accueil</title>
</head>
<body>

	<div class="panel panel-default">
		<c:forEach var="v" items="${listeVoyages}">

			<div class="panel-heading ">
				<h3 class="panel-title" align="center">
					<b>R�f�rence du voyage</b> : ${v.id_v}
				</h3>
			</div>
			<div class="panel-body " align="center">
				<b>Date de depart </b>: ${v.dateD} - <b>Date de retour</b> :
				${v.dateR} <br /> <b>Nombre de places </b>: ${v.nbPlaces} - <b>
					Disponibilite</b> : ${v.disponibilite} <br />
				<b>Tarif</b> : ${v.tarif} <br /> <b>Destination</b> :
				${v.destination.pays} <br />
			</div>
			<a href="<c:url value='/resCTRL/afficheCreationDossier?pId=${v.id_v}'/>">R�server</a>
		</c:forEach>
	</div>
	
		<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active" style="font-size: 20px">
				<b>Vos commentaires</b>
			</div>
			<c:forEach var="com" items="${listeComs}">

				<div class="item" style="font-size: 20px">
					${com.note}/5 <br /> ${com.contenu} <br /> <a
						style="font-size: 10px"
						href="<c:url value='/comCTRL/ajoutSignal?pId=${com.idCom}'/>">Signaler
						un commentaire inappropri�</a>
				</div>
			</c:forEach>
		</div>

	</div>
	
<h2>${msg}</h2>
</body>
</html>