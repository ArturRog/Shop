<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>


<div class="jumbotron">
    Dear <strong>${user}</strong>, Welcome to Admin Page.
    <br/>
    Would you like to <a href="<c:url value='/newUser' />">Add Some Users</a> to keep yourself busy?
    Or maybe <a href="<c:url value='/products/add' />">Add new product</a>
    <br/>
</div>