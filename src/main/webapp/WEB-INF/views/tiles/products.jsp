<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.js"/>"></script>
<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"/>"></script>
<script src="<c:url value="/resources/js/controllers.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>

<div ng-app="cartApp">
    <c:forEach items="${products}" var="product">

        <div class="col-sm-6 col-md-3">
            <div class="thumbnail" style="height: 500px">
                <a href="<c:url value='/products/product?id=${product.id}' />">
                    <img src="/resources/img/product.jpg" alt="image" style="width:100%; height: 230px"/>
                </a>
                <div class="caption" style="overflow: hidden; height: 170px">
                    <a href="<c:url value='/products/product?id=${product.id}' />">
                        <h3><b>${product.productName}</b></h3>
                    </a>
                    <p>${product.productDescription}</p>
                </div>
                <div class="price and button" style="height: 80px">
                    <hr>
                    <b>$${product.productPrice}</b>
                    <div class="pull-right" ng-controller="cartCtrl">
                        <a href="#" class="btn btn-danger btn-sm" role="button" ng-click="addToCart('${product.id}')">Add
                            to cart</a>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>