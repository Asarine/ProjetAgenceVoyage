<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="../../resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../../resources/js/bootstrap.js"></script>
<!-- spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>" />
<link rel="stylesheet" href="<c:url value='/resources/css/monStyleCedric.css'/>"/>


<title>Modifier Dossier</title>
</head>
<body>

<div style="background-color:#FFEBCD">


<nav class="navbar navbar-inverse">
 <ul class="nav nav-pills">
  <li role="presentation"><a href="${pageContext.request.contextPath}/conseiller/dosCTRL/listeDossier">Accueil</a></li>
  <li role="presentation"><a href="<c:url value='/conseiller/dosCTRL/formAjout'/>">Ajouter</a></li>
  <li role="presentation"><a href="<c:url value='/conseiller/dosCTRL/formModif'/>">Modifier</a></li>
  <li role="presentation"><a href="<c:url value='/conseiller/dosCTRL/formSupp'/>">Supprimer</a></li>
  <li role="presentation"><a href="${pageContext.request.contextPath}/conseiller/dosCTRL/formRech">Rechercher</a></li>
  </ul>
</nav>

<h1 style="color:green;text-align: center">Modification des clients</h1>

<form:form cssClass="form-horizontal" method="POST" action="soumettreModif" commandName="dosModif">
  <div class="form-group">
    <form:label for="inputEmail3" class="col-sm-2 control-label" path="id">ID</form:label>
    <div class="col-sm-10">
      <form:input cssclass="form-control" placeholder="id" path="id"/>
    </div>
  </div>
  
    <div class="form-group">
    <form:label class="col-sm-2 control-label" path="assurance">Assurance</form:label>
    <div class="col-sm-10">
      <form:input type="boolean" cssclass="form-control" placeholder="Assurance" path="assurance"/>
    </div>
    </div>
    
    <div class="form-group">
    <form:label class="col-sm-2 control-label" path="prixTotal">Prix total</form:label>
    <div class="col-sm-10">
      <form:input type="boolean" cssclass="form-control" placeholder="PrixTotal" path="prixTotal"/>
    </div>
    </div>
    
    <div class="form-group">
    <form:label class="col-sm-2 control-label" path="statutdossier">Statut dossier</form:label>
    <div class="col-sm-10">
      <form:input cssclass="form-control" placeholder="statut dossier" path="statutdossier"/>
    </div>
    </div>
 
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Modifier</button>
    </div>
  </div>
</form:form>

<br/>

<br/>
<br/>
<br/>
<br/>
<br/>
</div>

</body>
</html>