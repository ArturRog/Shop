<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<sec:authorize access="hasRole('ADMIN')">

    <div class="list-group">
        <a href="/admin" class="list-group-item "><i class="glyphicon glyphicon-th-list"></i> Menu</a>
        <br>
        <a href="<c:url value='/newUser'/>" class="list-group-item"><i class="glyphicon glyphicon-plus"></i> Add user</a>
        <a href="<c:url value='/products/add'/>" class="list-group-item"><i class="glyphicon glyphicon-plus"></i> Add product</a>
        <a href="<c:url value='/admin/users'/>" class="list-group-item"><i class="glyphicon glyphicon-user"></i>  Users list</a>
        <a href="<c:url value='/myOrders'/>" class="list-group-item"><i class="glyphicon glyphicon-barcode"></i>  Orders list</a>
    </div>


</sec:authorize>
<br>
<div class="list-group">
    <a href="/products" class="list-group-item "><i class="glyphicon glyphicon-th-list"></i> Menu</a>
    <br>
    <a href="<c:url value='/products?category=proteins'/>" class="list-group-item">Proteins</a>
    <a href="<c:url value='/products?category=creatine'/>" class="list-group-item">Creatine</a>
    <a href="<c:url value='/products?category=amino_acids'/>" class="list-group-item">Amino Acids</a>
    <a href="<c:url value='/products?category=accessories'/>" class="list-group-item">Accessories</a>
</div>

