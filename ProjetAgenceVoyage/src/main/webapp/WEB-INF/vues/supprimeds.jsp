<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<c:url value='/resources/CSS/bootstrap.css'/>" />
</head>
<body>
	<nav class="navbar navbar-inverse">
		<ul class="nav nav-pills">
			<li role="presentation"><a href="accueil.jsp"">accueil</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/dsCTRL/listeDest">Destinations</a></li>
			<li role="presentation"><a href="${pageContext.request.contextPath}/dsCTRL/afficheAjoutds">Ajouter Destination</a></li>
			<li role="presentation"><a href="${pageContext.request.contextPath}/dsCTRL/afficheSupprds">Supprimer Destination</a></li>
			<li role="presentation"><a href="${pageContext.request.contextPath}/dsCTRL/affichRechds">Rechercher Destination</a></li>
			<li role="presentation"><a href="${pageContext.request.contextPath}/dsCTRL/affichModifds">Modifier Destination</a></li>
		</ul>
	</nav>
	<h1 style="color: red; text-align: center">
		<i>Supprimer Destination</i>
	</h1>
	<form:form cssClass="form-horizontal" method="post" action="soumSupprds" modelAttribute="dsSuppr">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id">id</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="id" path="id" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Supprimer Destination</button>
			</div>
		</div>
	</form:form>

</body>
</html>