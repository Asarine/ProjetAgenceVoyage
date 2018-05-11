<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un hebergement</title>

<script type="text/javascript" src="../../resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../../resources/js/bootstrap.js"></script>
<!-- spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>" />
</head>
<body>

	<%@ include file="/resources/template/headerHebergementConseiller.html"%>


	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreForm" modelAttribute="hbgAjout">
	
	<div class="form-group">

    <form:label cssClass="col-sm-2 control-label" path="selectionhbg">Selectionner un type d'hebergement</form:label>
    <div class="col-sm-6">
      <form:input type="text" cssClass="form-control" placeholder="SelectionnHbg" path="selectionhbg"/>
    </div>
  </div>
	
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Ajouter</button>
			</div>
		</div>
	</form:form>
</body>
</html>