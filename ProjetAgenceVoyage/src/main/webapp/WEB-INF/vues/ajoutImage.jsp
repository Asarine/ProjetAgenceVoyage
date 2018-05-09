<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="<c:url value='/resources/js/jquery-3.3.1.js'/>"></script>
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>" />
<script src="<c:url value='/resources/js/bootstrap.js'/>"
	type="text/javascript"></script>
<title>Ajouter Voiture</title>
</head>
<body>
	<h1>File Upload Example - JavaTpoint</h1>

	<h3 style="color: red">${filesuccess}</h3>
	<form:form method="post" action="savefile"
		enctype="multipart/form-data">
		<p>
			<label for="image">Choose Image</label>
		</p>
		<p>
			<input name="file" id="fileToUpload" type="file" />
		</p>
		<p>
			<input type="submit" value="Upload">
		</p>
	</form:form>



</body>
</html>