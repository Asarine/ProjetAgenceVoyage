<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rechercher hbg</title>
<script type="text/javascript" src="../../resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../../resources/js/bootstrap.js"></script>
<!-- spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>" />
<link rel="stylesheet" href="<c:url value='/resources/css/monStyleCedric.css'/>"/>

</head>
<body style="background-image: url('../../resources/image/Sydney.jpg'); background-repeat:round; height: 3000px">

		<div style="background-color:#FFEBCD">


	<%@ include file="/resources/template/headerHebergementConseiller.html"%>



<br/>
<hr/>



<hr/>
<h1 style=" text-align: center">Formulaire de recherche</h1>

<form:form cssClass="form-horizontal" method="post" modelAttribute="hbgRech" action="soumettreRech" >    
	<div class="form-group">
    <form:label cssClass="col-sm-2 control-label" path="id_h">Id de l'hebergement</form:label>
    <div class="col-sm-6">
      <form:input type="text" cssClass="form-control" placeholder="IdHebergement" path="id_h"/>
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
				<th>ID</th>
				<th>Selection du type d'hebergement</th>
				
			</tr>

				<tr>
					<td>${hbgFind.id_h}</td>
				     <td>${hbgFind.selectionhbg}</td>
				</tr>

		</table>
	</div>>
		
				<h1 style=" text-align: center">${msg}</h1>
		
		
	</div>


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