<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<body style="background-image: url('../../resources/image/ChuteNiagara.JPG'); background-repeat:round; height: 3000px">
	
		<div style="background-color:#FFEBCD">
	
	
	<%@ include file="/resources/template/headerDestinationConseiller.html"%>
	

	<h1 style=" text-align: center">
		<i>Destination recherchée</i>
	</h1>
	<form:form class="form-horizontal" method="post" action="soumRech" >
		<div class="form-group">
			<label class="col-sm-2 control-label">Id</label>
			<div class="col-sm-10">
				<input class="form-control" placeholder="id" name="pId" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Rechercher</button>
			</div>
		</div>
	</form:form>
	<table class="table table-bordered">
		<tr>
			<th>id</th>
			<th>Pays</th>
			<th>Continent</th>
			
			
			
		</tr>
	
		<tr>
			<td>${dsFind.id}</td>
			<td>${dsFind.pays}</td>
			<td>${dsFind.continent}</td>
			
		</tr>
	
	</table>
	
	
	
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

