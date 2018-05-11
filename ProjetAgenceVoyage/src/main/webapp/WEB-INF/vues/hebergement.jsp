<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Accueil</title>
<script type="text/javascript" src="../../resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../../resources/js/bootstrap.js"></script>
<!-- spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>" />
</head>
<body>
	
	<%@ include file="/resources/template/headerHebergementConseiller.html"%>
	
	
	
	<hr />
	<h1 style="color: coral; text-align: center">Liste des hebergements</h1>
	<div align="center">
		<table class="table table-bordered">
			<tr>
				<th>ID</th>
				<th>Selection du type d'hebergement</th>
				<th>Operation</th>
			</tr>

			<c:forEach var="h" items="${hbgliste}">
				<tr>
					<td>${h.id_h}</td>
				     <td>${h.selectionhbg}</td>
					<td><a
						href="${pageContext.request.contextPath}/conseiller/hbgCTRL/deleteLink/${h.id_h}">Supprimer</a>|<a
						href="${pageContext.request.contextPath}/conseiller/hbgCTRL/updateLink?pId=${h.id_h}">Modifier</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>