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
	<div class="container">
		<div class="mb-3">
			<form action="Index" method="get">
				<input type="hidden" name="action" value="udpatetest"/>
				<div class="mb-3">
					<label class="form-label">Jour: </label><input
						class="form-control" type="text" name="jour"/>
				</div>
				<div class="mb-3">
					<label class="form-label">Mois: </label><input class="form-control"
						type="text" name="mois"/>
				</div>
				<div class="mb-3">
					<label class="form-label">Ann�e: </label><input
						class="form-control" type="text" name="annee"/>
				</div>
				<div class="mb-3">
					<label class="form-label">Id du cas: </label> <input
						class="form-control" type="number" name="cas"/>
				</div>
				<div class="mb-3">
				<label class="form-label">Etat: </label> <input
						class="form-control" type="number" name="etat"/>
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