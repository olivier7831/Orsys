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
<jsp:directive.include file="../include/header.jsp" />
<body>
	<form action="Index" method="get">
		<input type="hidden" name="action" value="formulairecas"/>
		<div class="mb-3">
		<input class="btn btn-primary mb-3" type="submit"
			value="Ajouter cas">
		</div>
	</form>
	<table class="table table-striped">
		<tr><th>Id</th><th>Nom complet</th><th>Telephone</th><th>Adresse</th><th>Code postal</th><th>Etat</th><th></th>
		</tr>
		<c:forEach var="cas" items="${gestion.getCasList()}">
			<tr>
			<td>${cas.getId_cas()}</td>
			<td>${cas.getNom_complet()}</td>
			<td>${cas.getTelephone()}</td>
			<td>${cas.getAdresse()}</td>
			<td>${cas.getCode_postale()}</td>
			<td>${cas.getEtat()}</td>
			<td><a class="btn btn-outline-danger btn-sm" href="Index?action=filtre&id=${cas.getId_cas()}">tests</a></td>	
			</tr>
		</c:forEach>
	</table>
</body>
</html>