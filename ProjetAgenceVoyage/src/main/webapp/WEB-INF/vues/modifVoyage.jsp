<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet"
	href="<c:url value='/ressources/css/bootstrap.css'/>" />
</head>
<body>

<nav class="navbar navbar-default navbar-static-top">
 
<!-- navs -->
<ul class="nav nav-pills">
  <li role="presentation" ><a href="<c:url value='/vCTRL/listeVoyage'/>">Accueil </a></li>        <!-- il faut appeler dans href l'url des methodes des Controllers et non la page -->
  <li role="presentation"><a href="<c:url value='/vCTRL/afficheAjoutVoyage'/>">Ajouter </a></li>
  <li role="presentation"><a href="<c:url value='/vCTRL/afficheModifVoyage'/>">Modifier </a></li>
  <li role="presentation"><a href="<c:url value='/vCTRL/afficheRechVoyage'/>">Rechercher </a></li>
  <li role="presentation"><a href="<c:url value='/vCTRL/afficheSupprVoyage'/>">Supprimer </a></li>
    <li role="presentation"><a href="<c:url value='/fCTRL/listeFormule'/>">Liste des formules </a></li>
  
  <li  role="presentation"> <a href="">Se déconnecter</a></li>
</ul>
 
</nav>

<br/>

<hr/>
<h1 style="color: blue; text-align: center">Formulaire de modification</h1>



<form:form cssClass="form-horizontal" method="post" modelAttribute="vModif" action="soumettreModifVoyage" >    


<div class="form-group">
    <form:label cssClass="col-sm-2 control-label" path="id_v">Id</form:label>
    <div class="col-sm-6">
      <form:input cssClass="form-control" placeholder="Id" path="id_v"/>
    </div>
  </div>

 <div class="form-group">
    <form:label cssClass="col-sm-2 control-label" path="dateD">Date de depart</form:label>
    <div class="col-sm-6">
      <form:input type="date" cssClass="form-control" placeholder="date de depart" path="dateD"/>
    </div>
  </div>
  
   <div class="form-group">
    <form:label cssClass="col-sm-2 control-label" path="dateR">Date de retour</form:label>
    <div class="col-sm-6">
      <form:input type="date" cssClass="form-control" placeholder="date de retour" path="dateR"/>
    </div>
  </div>
  


  <div class="form-group">
    <form:label cssClass="col-sm-2 control-label" path="nbPlaces">Nombre de place</form:label>
    <div class="col-sm-6">
      <form:input cssClass="form-control" placeholder="NbPlaces" path="nbPlaces"/>
    </div>
  </div>
  
<div class="form-group">

    <form:label cssClass="col-sm-2 control-label" path="tarif">Tarif</form:label>
    <div class="col-sm-6">
      <form:input cssClass="form-control" placeholder="Tarif" path="tarif"/>
    </div>
  </div>
  
  <div class="form-group">

    <form:label cssClass="col-sm-2 control-label" path="disponibilite">Disponibilite</form:label>
    <div class="col-sm-6">
      <form:input cssClass="form-control" placeholder="Disponibilite" path="disponibilite"/>
    </div>
  </div>
  
  <div class="form-group">

    <form:label cssClass="col-sm-2 control-label" path="assurance">Assurance</form:label>
    <div class="col-sm-6">
      <form:input type="boolean" cssClass="form-control" placeholder="Assurance" path="assurance"/>
    </div>
  </div>
  
  <div class="form-group">

    <form:label cssClass="col-sm-2 control-label" path="hebergement.id_h">Id Hebergement</form:label>
    <div class="col-sm-6">
      <form:input cssClass="form-control" placeholder="Idhebergement" path="hebergement.id_h"/>
    </div>
  </div>
  
  
  
  <div class="form-group">

    <form:label cssClass="col-sm-2 control-label" path="destination.id">Id destination</form:label>
    <div class="col-sm-6">
      <form:input cssClass="form-control" placeholder="Iddestination" path="destination.id"/>
    </div>
  </div>
  

  
  <div class="form-group">

    <form:label cssClass="col-sm-2 control-label" path="formule.id_f">Id formule</form:label>
    <div class="col-sm-6">
      <form:input cssClass="form-control" placeholder="Idformule" path="formule.id_f"/>
    </div>
  </div>
  


    
  

  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Modifier</button>
    </div>
  </div>
</form:form>

</body>
</html>