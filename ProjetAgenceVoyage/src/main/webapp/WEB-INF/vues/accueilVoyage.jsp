<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../../resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../../resources/js/bootstrap.js"></script>
<!-- spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>" />

</head>
<body>




<%@ include file="/resources/template/headerAccueilConseiller.html"%>


<br/>
<br/>
<br/>
<br/>
<br/>
	
	
	<div class="panel panel-default">
				<c:forEach var="v" items="${listeVoy}">
	
  <div class="panel-heading "><h3 class="panel-title" align="center"><b>Référence du voyage</b> : ${v.id_v}</h3></div>
  <div class="panel-body " align="center" ><b>Date de depart </b>: ${v.dateD} -  <b>Date de retour</b> : ${v.dateR} 
  <br/> <b>Nombre de places </b>: ${v.nbPlaces} - <b> Disponibilite</b> : ${v.disponibilite}
       <br/><b>Tarif</b> : ${v.tarif}  <br/> <b>Numero de la destination</b> : ${v.destination.id} - <b>Lieu de la destination</b> : ${v.destination.pays}
       <br/><b> Nuemero du type d'hebergement </b> : ${v.hebergement.id_h } <br/> <b> Numero du type de formule</b> : ${v.formule.id_f}  </div>
  </c:forEach>
</div>
	
	
	
	<br/>
		<br/>
		<br/>
		<br/>
	


</body>
</html>