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
<h1 style="color: blue; text-align: center">Formulaire de recherche</h1>

<form:form cssClass="form-horizontal" method="post" modelAttribute="vRech" action="soumettreRechVoyage" >    
<div class="form-group">
    <form:label cssClass="col-sm-2 control-label" path="id_v">Id</form:label>
    <div class="col-sm-10">
      <form:input cssClass="form-control" placeholder="Id_v" path="id_v"/>
    </div>
  </div>
  
  
   <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Rechercher</button>
    </div>
  </div>
  </form:form>
  
  
  <div align="center">

		<table class="table table-bordered">
			<tr>
				<th>id</th>
				<th>Date depart</th>
				<th>Date retour</th>
				<th>Nombre de place</th>
				<th>Tarif</th>
				<th>Disponibilite</th>
				<th>Assurance</th>
				<th>Id de la destination</th>
				<th>Pays de la destination</th>				
				<th>Id de l'hebergement</th>
				<th>Id de la formule</th>
				
			</tr>


		

				<tr>
					<td>${vFind.id_v}</td>
				    <td> <fmt:formatDate pattern="dd/MM/yyyy" value="${vFind.dateD}"/></td>
					<td> <fmt:formatDate pattern="dd/MM/yyyy" value="${vFind.dateR}"/></td>				
					<td>${vFind.nbPlaces}</td>
					<td>${vFind.tarif }</td>
					<td>${vFind.disponibilite}</td>
					<td>${vFind.assurance }</td>
					<td>${vFind.destination.id }</td>
					<td>${vFind.destination.pays }</td>					
					<td>${vFind.hebergement.id_h }</td>
					<td>${vFind.formule.id_f }</td>
					
				</tr>
			
		</table>
		
		<h1 style="color: blue; text-align: center">${msg}</h1>
		
	</div>

</body>
</html>