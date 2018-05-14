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
<script type="text/javascript" src="../../resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../../resources/js/bootstrap.js"></script>
<!-- spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>" />
<link rel="stylesheet" href="<c:url value='/resources/css/monStyleCedric.css'/>"/>

</head>
<body style="background-image: url('../../resources/image/MurailleChine.jpg'); background-repeat:round; height: 8000px">

<div style="background-color:#FFEBCD">

<%@ include file="/resources/template/headerVoyageConseiller.html"%>


<br/>

<hr/>
<h1 style=" text-align: center">Formulaire d'ajout</h1>



<form:form cssClass="form-horizontal" method="post" modelAttribute="vAjout" action="soumettreAjoutVoyage" >    

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