<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Ajout client</title>

<script type="text/javascript" src="../../resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../../resources/js/bootstrap.js"></script>
<!-- spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>" />

</head>

<body>

<%@ include file="/resources/template/headerClientConseiller.html"%>


<h1 style="color:green;text-align: center">Ajout des clients</h1>


<form:form cssClass="form-horizontal" method="POST" action="soumettreAjout" modelAttribute="clAjout">
  <div class="form-group">
    <form:label class="col-sm-2 control-label" path="civilite">Civilite</form:label>
    <div class="col-sm-10">
      <form:input cssclass="form-control" placeholder="civilite" path="civilite"/>
    </div>
    </div>
  <div class="form-group">
    <form:label for="inputEmail3" class="col-sm-2 control-label" path="nom">Nom</form:label>
    <div class="col-sm-10">
      <form:input cssclass="form-control" placeholder="Nom" path="nom"/>
    </div>
  </div>
  <div class="form-group">
    <form:label class="col-sm-2 control-label" path="prenom">Prenom</form:label>
    <div class="col-sm-10">
      <form:input cssclass="form-control" placeholder="Prenom" path="prenom"/>
    </div>
  </div>
   <div class="form-group">
    <form:label class="col-sm-2 control-label" path="tel">Tel</form:label>
    <div class="col-sm-10">
      <form:input cssclass="form-control" placeholder="Tel" path="tel"/>
    </div>
  </div>
   <div class="form-group">
    <form:label class="col-sm-2 control-label" path="dn">Date de naissance</form:label>
    <div class="col-sm-10">
      <form:input type="date" cssclass="form-control" placeholder="date de naissance" path="dn"/>
    </div>
  </div>
   <div class="form-group">
    <form:label class="col-sm-2 control-label" path="mail">Mail</form:label>
    <div class="col-sm-10">
      <form:input cssclass="form-control" placeholder="Mail" path="mail"/>
    </div>
  </div>
   <div class="form-group">
    <form:label class="col-sm-2 control-label" path="numcb">Numero Carte Bancaire</form:label>
    <div class="col-sm-10">
      <form:input cssclass="form-control" placeholder="numero carte bancaire" path="numcb"/>
    </div>
  </div>
   <div class="form-group">
    <form:label class="col-sm-2 control-label" path="mdp">Mot de passe</form:label>
    <div class="col-sm-10">
      <form:input cssclass="form-control" placeholder="mot de passe" path="mdp"/>
    </div>
  </div>
  
  <div class="form-group">
    <form:label class="col-sm-2 control-label" path="conseiller.id_co">id conseiller</form:label>
    <div class="col-sm-10">
      <form:input cssclass="form-control" placeholder="IdConseiller" path="conseiller.id_co"/>
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