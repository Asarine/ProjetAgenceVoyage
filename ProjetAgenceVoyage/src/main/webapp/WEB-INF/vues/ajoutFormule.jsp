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
    

    <li role="presentation"><a href="<c:url value='/fCTRL/listeFormule'/>">Liste des formules </a></li>
    <li role="presentation"><a href="<c:url value='/fCTRL/afficheAjoutFormule'/>">Ajouter </a></li>
  <li role="presentation"><a href="<c:url value='/fCTRL/afficheModifFormule'/>">Modifier </a></li>
  <li role="presentation"><a href="<c:url value='/fCTRL/afficheRechFormule'/>">Rechercher </a></li>
  <li role="presentation"><a href="<c:url value='/fCTRL/afficheSupprFormule'/>">Supprimer </a></li>
  <li  role="presentation"> <a href="">Se déconnecter</a></li>
</ul>
 
</nav>

<br/>
<hr/>


<br/>

<hr/>
<h1 style="color: blue; text-align: center">Formulaire d'ajout</h1>



<form:form cssClass="form-horizontal" method="post" modelAttribute="fAjout" action="soumettreAjoutFormule" >    


  <div class="form-group">
    <form:label cssClass="col-sm-2 control-label" path="avion">Avion</form:label>
    <div class="col-sm-6">
      <form:input type="boolean" cssClass="form-control" placeholder="Avion" path="avion"/>
    </div>
  </div>
  
<div class="form-group">

    <form:label cssClass="col-sm-2 control-label" path="hotel">Hotel</form:label>
    <div class="col-sm-6">
      <form:input type="boolean" cssClass="form-control" placeholder="Hotel" path="hotel"/>
    </div>
  </div>
  
  <div class="form-group">

    <form:label cssClass="col-sm-2 control-label" path="voiture">Voiture</form:label>
    <div class="col-sm-6">
      <form:input type="boolean" cssClass="form-control" placeholder="Voiture" path="voiture"/>
    </div>
  </div>
  
  <div class="form-group">

    <form:label cssClass="col-sm-2 control-label" path="voitureLouer.id">Id voiture louee</form:label>
    <div class="col-sm-6">
      <form:input cssClass="form-control" placeholder="IdVoitureLouee" path="voitureLouer.id"/>
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