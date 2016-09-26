<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>




<div class="list-group">
    <a href="/products" class="list-group-item "><i class="glyphicon glyphicon-th-list"></i> Menu</a>
    <br>
    <a href="<c:url value='/products?category=proteins'/>" class="list-group-item">Proteins</a>
    <a href="<c:url value='/products?category=creatine'/>" class="list-group-item">Creatine</a>
    <a href="<c:url value='/products?category=amino_acids'/>" class="list-group-item">Amino Acids</a>
    <a href="<c:url value='/products?category=accessories'/>" class="list-group-item">Accessories</a>
</div>

