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
<title>Ajout commentaire</title>
</head>
<body>
	<h1 style="color: crimson; text-align: center">Supprimer un commentaire</h1>
	<div align="center">
		<form:form cssClass="form-horizontal" method="POST"
			action="suppCommentaire">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="contenu">Contenu</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" placeholder="ID" name="pIdCom"
						id="contenu" />
				</div>
			</div>
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-default" value="Supprimer">
			</div>
		</form:form>
	</div>

</body>
</html>