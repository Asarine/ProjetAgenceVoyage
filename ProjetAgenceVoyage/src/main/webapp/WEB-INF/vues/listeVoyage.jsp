<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../../resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../../resources/js/bootstrap.js"></script>
<!-- spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>" />
<link rel="stylesheet" href="<c:url value='/resources/css/monStyleCedric.css'/>"/>

</head>
<body  style="background-image: url('../../resources/image/MurailleChine.jpg'); background-repeat:round; height: 8000px">

<div style="background-color:#FFEBCD">


<br/>

<%@ include file="/resources/template/headerVoyageConseiller.html"%>


 



<br/>
<hr />

	<h1 style=" text-align: center">Liste des voyages disponibles</h1>


<div align="center">

		<table class="table table-bordered">
			<tr>
				<th>id</th>
				<th>Date depart</th>
				<th>Date retour</th>
				<th>Nombre de place</th>
				<th>Tarif</th>
				<th>Disponibilite</th>
				<th>Id de la destination</th>
				<th>Pays de la destination</th>				
				<th>Id de l'hebergement</th>
				<th>Id de la formule</th>
				<th>Operation</th>
			</tr>


			<c:forEach var="v" items="${listeVoy}">

				<tr>
					<td>${v.id_v}</td>
				    <td> <fmt:formatDate pattern="dd/MM/yyyy" value="${v.dateD}"/></td>
					<td> <fmt:formatDate pattern="dd/MM/yyyy" value="${v.dateR}"/></td>				
					<td>${v.nbPlaces}</td>
					<td>${v.tarif }</td>
					<td>${v.disponibilite}</td>
					<td>${v.destination.id }</td>
					<td>${v.destination.pays }</td>					
					<td>${v.hebergement.id_h }</td>
					<td>${v.formule.id_f }</td>
					<td><a href="${pageContext.request.contextPath}/conseiller/vCTRL/deleteLinkVoyage/${v.id_v}">Supprimer</a> | <a href="${pageContext.request.contextPath}/conseiller/vCTRL/updateLinkVoyage?pIdV=${v.id_v}">Modifier</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	
			<br/>
<br/>

<br/>
<br/>
<br/>
<br/>
<br/>
</div>

</body>
</html>
