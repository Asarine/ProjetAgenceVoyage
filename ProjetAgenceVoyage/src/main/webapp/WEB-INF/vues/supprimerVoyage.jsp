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
<h1 style=" text-align: center">Formulaire de suppression</h1>

<form:form cssClass="form-horizontal" method="post" modelAttribute="vSupprim" action="soumettreSupprimVoyage" >    
<div class="form-group">
    <form:label cssClass="col-sm-2 control-label" path="id_v">Id</form:label>
    <div class="col-sm-10">
      <form:input cssClass="form-control" placeholder="Id_v" path="id_v"/>
    </div>
  </div>
  
  
   <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Supprimer</button>
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
