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
				<input type="hidden" name="action" value="udpatetest"/>
				<div class="mb-3">
					<label class="form-label">Jour: </label><input
						class="form-control" type="text" name="jour" pattern="[0-9]{1,2}" required/>
				</div>
				<div class="mb-3">
					<label class="form-label">Mois: </label><input class="form-control"
						type="text" name="mois" pattern="[0-9]{1,2}" required/>
				</div>
				<div class="mb-3">
					<label class="form-label">Ann�e: </label><input
						class="form-control" type="text" name="annee" pattern="[0-9]{1,2}" required/>
				</div>
				<div class="mb-3">
				<label class="form-label">Etat: </label> <input
						class="form-control" type="number" name="etat" pattern="-*1{1}" required/>
				</div>
				<div>
				<label class="form-label">Test: </label>
				<select class="form-select form-select-lg mb-3" name="casteste">
					<option value="">--Select--</option>
					<c:forEach var="c" items="${gestion.getCasList()}">
						<option value="${c.getId_cas()}" selected>${c.getNom_complet()}</option>
					</c:forEach>
				</select>
				</div>
				<div class="mb-3">
					<input class="btn btn-primary mb-3" type="submit" value="Ajouter"/>
				</div>
			</form>
		</div>
	</div>
</body>
</html>