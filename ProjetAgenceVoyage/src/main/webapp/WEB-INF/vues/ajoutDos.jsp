<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/resources/CSS/bootstrap.css'/>"/>

<title>Ajout Dossier</title>
</head>
<body>

<nav class="navbar navbar-inverse">
 <ul class="nav nav-pills">
  <li role="presentation"><a href="${pageContext.request.contextPath}/conseiller/dosCTRL/listeDossier">Accueil</a></li>
  <li role="presentation"><a href="<c:url value='/conseiller/dosCTRL/formAjout'/>">Ajouter</a></li>
  <li role="presentation"><a href="<c:url value='/conseiller/dosCTRL/formModif'/>">Modifier</a></li>
  <li role="presentation"><a href="<c:url value='/conseiller/dosCTRL/formSupp'/>">Supprimer</a></li>
  <li role="presentation"><a href="${pageContext.request.contextPath}/conseiller/dosCTRL/formRech">Rechercher</a></li>
  </ul>
</nav>

<h1 style="color:green;text-align: center">Ajout des dossiers</h1>


<form:form cssClass="form-horizontal" method="POST" action="soumettreAjout" modelAttribute="dosAjout">
    <div class="form-group">
  		<form:label for="idStatutdossier" class="col-sm-2 control-label" path="statutdossier">Statut Dossier</form:label>
  			<div class="col-sm-10">
  				<form:select class="form-control" id="idStatutdossier" path="statutdossier">
  					<option value="NONE" label="Choisir un statut dossier"/>
  						<option>Accepté</option>
    					<option>Rejeté</option>
    					<option>En attente</option> 
  				</form:select>
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