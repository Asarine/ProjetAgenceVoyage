<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
</head>
<body>
	<h1>${message}</h1>

	<a href="<c:url value='/j_spring_security_logout'/>">Se déconnecter</a>
	<a href="<c:url value='/voiture/listeVoitures'/>">Afficher les
		voitures</a>

	<div class="typeform-widget"
		data-url="https://tudiantsddame.typeform.com/report/uOGCHO/N2RtFJ10mr5MwD86"
		style="width: 100%; height: 650px;"></div>
	<script>
		(function() {
			var qs, js, q, s, d = document, gi = d.getElementById, ce = d.createElement, gt = d.getElementsByTagName, id = "typef_orm", b = "https://embed.typeform.com/";
			if (!gi.call(d, id)) {
				js = ce.call(d, "script");
				js.id = id;
				js.src = b + "embed.js";
				q = gt.call(d, "script")[0];
				q.parentNode.insertBefore(js, q)
			}
		})()
	</script>
	<div
		style="font-family: Sans-Serif; font-size: 12px; color: #999; opacity: 0.5; padding-top: 5px;">
		powered by <a
			href="https://admin.typeform.com/signup?utm_campaign=uOGCHO&utm_source=typeform.com-5279313-Basic&utm_medium=typeform&utm_content=typeform-embedded-poweredbytypeform&utm_term=EN"
			style="color: #999" target="_blank">Typeform</a>
	</div>
</body>
</html>