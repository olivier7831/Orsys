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
<form action="Index?action=login" method="post">
	<div class="mb-3"><label class="form-label">Login: </label><input class="form-control" type="text" name="login" pattern="[a-zA-Z0-9]{5,9}" required/></div>
	<div class="mb-3"><label class="form-label">Password: </label><input class="form-control" type="text" name="password" pattern="[a-zA-Z0-9]{5,9}" required/></div>
	<div><input class="btn btn-primary" type="submit" value="Valider..."/></div>
</form>
</div>
</body>
</html>