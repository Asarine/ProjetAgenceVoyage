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

<h1 style="color: blue; text-align: center">Liste des voyages formules</h1>


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
				<th>Operation</th>
			</tr>


			<c:forEach var="f" items="${listeForm}">

				<tr>
					<td>${f.id_f}</td>			
					<td>${f.avion}</td>
					<td>${f.hotel}</td>
					<td>${f.voiture}</td>
					<td>${f.voitureLouer.id }</td>
					<td>${f.voitureLouer.catégorie }</td>
					<td>${f.voitureLouer.loueur }</td>					
					<td><a href="${pageContext.request.contextPath}/fCTRL/deleteLinkFormule/${f.id_f}">Supprimer</a> | <a href="${pageContext.request.contextPath}/fCTRL/updateLinkFormule?pIdF=${f.id_f}">Modifier</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>