<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter</title>

<script type="text/javascript" src="../../resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../../resources/js/bootstrap.js"></script>
<!-- sp�cifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>" />
<link rel="stylesheet" href="<c:url value='/resources/css/monStyleCedric.css'/>"/>

</head>
<body style="background-image: url('../../resources/image/Rio.jpeg'); background-repeat:round; height: 3000px">

<div style="background-color:#FFEBCD">

<%@ include file="/resources/template/headerParticipantConseiller.html"%>


	<br />
	<h1 style=" text-align: center">Ajouter des
		participants</h1>

	<form:form cssClass="form-horizontal" action="soumettreAjout"
		method="POST" modelAttribute="pAjout">

		<div class="form-group">
			<form:label path="civilite" cssClass="col-sm-2 control-label">Civilit�</form:label>
			<div class="col-sm-4">
				<form:select class="form-control" path="civilite" name="pCivilite">
					<option value="M.">M.</option>
					<option value="Mme">Mme</option>
				</form:select>
			</div>
			<form:errors path="civilite" cssStyle="color:red" />
		</div>
		<br />

		<div class="form-group">
			<form:label path="nom" cssClass="col-sm-2 control-label">Nom</form:label>
			<div class="col-sm-4">
				<form:input path="nom" cssClass="form-control" placeholder="Nom" />
			</div>
			<form:errors path="nom" cssStyle="color:red" />
		</div>
		<br />

		<div class="form-group">
			<form:label path="prenom" cssClass="col-sm-2 control-label">Pr�nom</form:label>
			<div class="col-sm-4">
				<form:input path="prenom" cssClass="form-control"
					placeholder="Pr�nom" />
			</div>
			<form:errors path="nom" cssStyle="color:red" />
		</div>
		<br />

		<div class="form-group">
			<form:label path="dn" cssClass="col-sm-2 control-label">Date de naissance</form:label>

			<div class="col-sm-4">

				<form:input path="dn" cssClass="form-control" type="date" />
			</div>
			<form:errors path="dn" cssStyle="color:red" />
		</div>
		<br />

		<div class="form-group">
			<form:label path="tel" cssClass="col-sm-2 control-label">Num�ro de t�l�phone</form:label>
			<div class="col-sm-4">
				<form:input path="tel" cssClass="form-control"
					placeholder="Num�ro de t�l�phone" />
			</div>
			<form:errors path="tel" cssStyle="color:red" />
		</div>
		<br />

		<div class="form-group">
			<form:label path="mail" cssClass="col-sm-2 control-label">Mail</form:label>
			<div class="col-sm-4">
				<form:input path="mail" cssClass="form-control" placeholder="Mail" />
			</div>
			<form:errors path="mail" cssStyle="color:red" />
		</div>
		
		<div class="form-group">
			<form:label path="mail" cssClass="col-sm-2 control-label">Id du client</form:label>
			<div class="col-sm-4">
				<form:input path="client.id" cssClass="form-control" placeholder="IdClient" />
			</div>
			<form:errors path="client.id" cssStyle="color:red" />
		</div>
		
		<br />

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Ajouter</button>
			</div>
		</div>
	</form:form>
	
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