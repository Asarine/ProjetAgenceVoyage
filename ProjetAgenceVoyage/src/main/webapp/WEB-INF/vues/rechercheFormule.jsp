<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet"
	href="<c:url value='/resources/CSS/bootstrap.css'/>" />
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



<hr/>
<h1 style="color: blue; text-align: center">Formulaire de recherche</h1>

<form:form cssClass="form-horizontal" method="post" modelAttribute="fRech" action="soumettreRechFormule" >    
<div class="form-group">
    <form:label cssClass="col-sm-2 control-label" path="id_f">Id</form:label>
    <div class="col-sm-10">
      <form:input cssClass="form-control" placeholder="Id_f" path="id_f"/>
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
				<th>avion</th>
				<th>hotel</th>
				<th>voiture</th>
				<th>Id de la voiture louée</th>
				<th>Categorie de la voiture louée</th>
			   <th>Loueur de la voiture louée</th>				
			</tr>


			

				<tr>
					<td>${fFind.id_f}</td>			
					<td>${fFind.avion}</td>
					<td>${fFind.hotel}</td>
					<td>${fFind.voiture}</td>
					<td>${fFind.voitureLouer.id }</td>
					<td>${fFind.voitureLouer.categorie }</td>
					<td>${fFind.voitureLouer.loueur }</td>					
				</tr>
			
		</table>
		
				<h1 style="color: blue; text-align: center">${msg}</h1>
		
		
	</div>

</body>
</html>