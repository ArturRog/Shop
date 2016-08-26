<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>AccessDenied page</title>
	<link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<br/>
	<br/>
	<h1>Dear <strong>${user}</strong>, You are not authorized to access this page.</h1>
	<br/>
	<a href="<c:url value="/home" />">Go to home</a>  
	<sec:authorize access="hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')">
           OR  <a href="<c:url value="/logout" />">Logout</a>
    </sec:authorize>
	
</body>
</html>