<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 24.08.2016
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MENU</title>
</head>
<body>


        <div class="list-group">
            <a href="/products" class="list-group-item ">
                Menu
            </a>
            <a href="<c:url value='/products?category=proteins'/>" class="list-group-item">Proteins</a>
            <a href="<c:url value='/products?category=proteins'/>" class="list-group-item">Creatine</a>
            <a href="<c:url value='/products?category=proteins'/>" class="list-group-item">Amino Acids</a>
            <a href="<c:url value='/products?category=proteins'/>" class="list-group-item">Accessories</a>
        </div>


</body>
</html>
