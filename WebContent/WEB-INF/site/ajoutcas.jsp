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
	<div class="container">
		<div class="mb-3">
			<form action="Index" method="post">
				<input type="hidden" name="action" value="updatecas"/>
				<div class="mb-3">
					<label class="form-label">Nom complet: </label><input
						class="form-control" type="text" name="nom_complet" pattern="[a-zA-Z0-9- ]{1,100}" required/>
				</div>
				<div class="mb-3">
					<label class="form-label">Telephone: </label><input class="form-control"
						type="text" name="telephone" pattern="[0-9+]{8,15}" required/>
				</div>
				<div class="mb-3">
					<label class="form-label">Adresse: </label><input
						class="form-control" type="text" name="adresse" pattern="[a-zA-Z0-9- ]{1,300}" required/>
				</div>
				<div class="mb-3">
					<label class="form-label">Code Postal: </label> <input
						class="form-control" type="text" name="code_postal" pattern="[0-9]{5}" required/>
				</div>
				<div class="mb-3">
					<label class="form-label">Etat: </label> <input
						class="form-control" type="number" name="etat" pattern="-*1{1}" required/>
				</div>
				<div class="mb-3">
					<input class="btn btn-primary mb-3" type="submit"
							value="Ajouter">
				</div>
			</form>
		</div>
	</div>
</body>
</html>