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
</head>
<body>


<%@ include file="/resources/template/headerFormuleConseiller.html"%>

<br/>
<hr/>


<form:form cssClass="form-horizontal" method="post" modelAttribute="fSupprim" action="soumettreSupprimFormule" >    
<div class="form-group">
    <form:label cssClass="col-sm-2 control-label" path="id_f">Id</form:label>
    <div class="col-sm-10">
      <form:input cssClass="form-control" placeholder="Id_f" path="id_f"/>
    </div>
  </div>
  
  
   <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Suprimer</button>
    </div>
  </div>
  </form:form>

</body>
</html>
