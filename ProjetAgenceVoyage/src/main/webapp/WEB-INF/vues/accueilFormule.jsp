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
<body style="background-image: url('../../resources/image/Canyon.jpg'); background-repeat:round; height: 3000px">

<div style="background-color:#FFEBCD">


<%@ include file="/resources/template/headerFormuleConseiller.html"%>





<br/>
<hr/>

<h1 style=" text-align: center">Liste des voyages formules</h1>


<div align="center">

		<table class="table table-bordered">
			<tr>
				<th>id</th>
				<th>avion</th>
				<th>hotel</th>
				<th>voiture</th>
				<th>Id de la voiture louée</th>
				<th>Categorie de la voiture louée</th>
			   <th>Loueur de la voiture louée</th>				
				<th>Operation</th>
			</tr>


			<c:forEach var="f" items="${listeForm}">

				<tr>
					<td>${f.id_f}</td>			
					<td>${f.avion}</td>
					<td>${f.hotel}</td>
					<td>${f.voiture}</td>
					<td>${f.voitureLouer.id }</td>
					<td>${f.voitureLouer.categorie }</td>
					<td>${f.voitureLouer.loueur }</td>					
					<td><a href="${pageContext.request.contextPath}/conseiller/fCTRL/deleteLinkFormule/${f.id_f}">Supprimer</a> | <a href="${pageContext.request.contextPath}/conseiller/fCTRL/updateLinkFormule?pIdF=${f.id_f}">Modifier</a></td>
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

