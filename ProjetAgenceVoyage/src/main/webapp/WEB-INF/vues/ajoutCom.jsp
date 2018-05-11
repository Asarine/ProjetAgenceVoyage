<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="<c:url value='/resources/js/jquery-3.3.1.js'/>"></script>
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>" />

<script src="<c:url value='/resources/js/bootstrap.js'/>"
	type="text/javascript"></script>
<title>Ajout commentaire</title>
<style>
.rating {
	float: left;
	width: 300px;
}

.rating span {
	float: right;
	position: relative;
}

.rating span input {
	position: absolute;
	top: 0px;
	left: 0px;
	opacity: 0;
}

.rating span label {
	display: inline-block;
	width: 30px;
	height: 30px;
	text-align: center;
	color: #FFF;
	background: #ccc;
	font-size: 30px;
	margin-right: 2px;
	line-height: 30px;
	border-radius: 50%;
	-webkit-border-radius: 50%;
}

.rating span:hover ~ span label, .rating span:hover label, .rating span.checked label,
	.rating span.checked ~ span label {
	background: #F90;
	color: #FFF;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		// Check Radio-box
		$(".rating input:radio").attr("checked", false);

		$('.rating input').click(function() {
			$(".rating span").removeClass('checked');
			$(this).parent().addClass('checked');
		});

		$('input:radio').change(function() {
			var userRating = this.value;
			alert(userRating);
		});
	});
</script>
</head>
<body>
	<h1 style="color: crimson; text-align: center">Ajouter un
		commentaire</h1>
	<div align="center">
		<form:form cssClass="form-horizontal" method="POST"
			action="ajoutCommentaire" modelAttribute="comAjout">
			<div class="form-group">
			<div class="rating" align="center">
				<span><input type="radio" name="rating" id="str5" value="5"><label
					for="str5" class="fa fa-star"></label></span> <span><input
					type="radio" name="rating" id="str4" value="4"><label
					for="str4" class="fa fa-star"></label></span> <span><input
					type="radio" name="rating" id="str3" value="3"><label
					for="str3" class="fa fa-star"></label></span> <span><input
					type="radio" name="rating" id="str2" value="2"><label
					for="str2" class="fa fa-star"></label></span> <span><input
					type="radio" name="rating" id="str1" value="1"><label
					for="str1" class="fa fa-star"></label></span>
			</div>
			<br/>
				<form:label cssClass="col-sm-2 control-label" path="contenu">Contenu</form:label>
				<div class="col-sm-6">
					<form:input cssClass="form-control"
						placeholder="Votre commentaire ici." path="contenu" />
				</div>
			</div>
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-default" value="Ajouter">
			</div>
		</form:form>
	</div>

</body>
</html>