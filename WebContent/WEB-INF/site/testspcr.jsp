<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" >
</head>
<body>
	<form action="Index" method="get">
		<input type="hidden" name="action" value="formulairetest"/>
		<div class="mb-3">
		<input class="btn btn-primary mb-3" type="submit"
			value="Ajouter Test PCR">
		</div>
	</form>
	<table class="table table-striped">
		<tr><th>Id</th><th>Jour</th><th>Mois</th><th>Annee</th><th>Resultat</th><th>Id(cas)</th>
		</tr>
		<c:forEach var="test" items="${gestion.getTestList()}">
			<tr>
			<td>${test.getId_testpcr()}</td>
			<td>${test.getJour()}</td>
			<td>${test.getMois()}</td>
			<td>${test.getAnnee()}</td>
			<td>${test.getResultat()}</td>
			<td>${test.getId_teste()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>