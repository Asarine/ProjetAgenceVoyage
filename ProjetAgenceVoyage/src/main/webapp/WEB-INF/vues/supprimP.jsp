<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supprimer</title>

<link rel="stylesheet"
	href="<c:url value = '/resources/CSS/bootstrap.css' />" />

</head>
<body>

<%@ include file="/resources/template/header.html" %>

	<hr />
	<br />
	<h1 style="color: red; text-align: center">Supprimer des participants</h1>

	<form:form cssClass="form-horizontal" action="soumettreDelete"
		method="POST" modelAttribute="pDelete">

		<div class="form-group">
			<form:label path="id" cssClass="col-sm-2 control-label">ID</form:label>
			<div class="col-sm-4">
				<form:input path="id" cssClass="form-control" placeholder="ID" />
			</div>
			<form:errors path="id" cssStyle="color:red" />
		</div>
		<br />

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Supprimer</button>
			</div>
		</div>
	</form:form>

</body>
</html>