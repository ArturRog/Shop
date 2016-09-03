<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Products</title>
    <link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"/>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script href="resources/js/bootstrap.js"></script>
</head>
<body>


<c:forEach items="${products}" var="product">

    <div class="col-sm-6 col-md-3">

        <div class="thumbnail" style="height: 500px">
            <a href="<c:url value='/products/product?id=${product.id}' />">
                <img src="/resources/img/product.jpg" alt="image" style="width:100%"/>
            </a>
            <div class="caption">
                <a href="<c:url value='/products/product?id=${product.id}' />">
                    <h3><b>${product.productName}</b></h3>
                </a>
                <p>${product.productDescription}</p>
                <hr>
                <b>$${product.productPrice}</b><div class="pull-right"><a href="#" class="btn btn-danger btn-sm" role="button">Add to cart</a></div>


            </div>
        </div>
    </div>
</c:forEach>


</body>
</html>