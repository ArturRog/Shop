<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="alert alert-success" role="alert">
    <a href="#" class="alert-link">
        Confirmation message : ${success}
        <br>
        Would you like to <a href="<c:url value='/newUser' />">Add More Users</a>?
        <br/>
        Go to <a href="<c:url value='/admin' />">Admin Page</a> OR <a href="<c:url value="/logout" />">Logout</a>
    </a>
</div>