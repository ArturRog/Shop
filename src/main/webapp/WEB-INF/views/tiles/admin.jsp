<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin page</title>
	<link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"/>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script href="resources/js/bootstrap.js"></script>
</head>
<body>
<div class="jumbotron">
	Dear <strong>${user}</strong>, Welcome to Admin Page.
	<br/>
	Would you like to <a href="<c:url value='/newUser' />">Add Some Users</a> to keep yourself busy?
	Or maybe <a href="<c:url value='/products/add' />">Add new product</a>
	<br/>
	<button type="button" class="btn btn-info"><a href="<c:url value="/logout" />">Logout</a></button>
</div>
</body>
</html>