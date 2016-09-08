<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div class="alert alert-danger" role="alert">
    <a href="#" class="alert-link">Dear <strong>${user}</strong>, You are not authorized to access this page.
        <br/>
        <br/>
        <br/>
        <a href="<c:url value="/home" />" class="btn btn-danger" role="button">Go home</a>
        <sec:authorize access="hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')">
            <a href="<c:url value="/logout" />" class="btn btn-danger" role="button">Logout</a>
        </sec:authorize>
    </a>
</div>
