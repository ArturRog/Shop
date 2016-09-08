<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"/>"></script>
<script src="<c:url value="/resources/js/controllers.js"/>"></script>


<section class="container" ng-app="cartApp">
    <div class="row">
        <div class="col-md-5">
            <img src="<c:url value="/resources/img/product.jpg"/>" alt="image" style="width:100%"/>
        </div>

        <div class="col-md-5">
            <h3>${product.productName}</h3>
            <p>${product.productDescription}</p>
            <p>
                <strong>Product category: </strong><span
                    class="label label-warning">${product.category.categoryName}</span>
            </p>


            <h4>$${product.productPrice} USD</h4>
            <p ng-controller="cartCtrl">
                <a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.id}')">
                    <span class="glyphicon-shopping-cart glyphicon"></span> Order now
                </a>
                <a href="<spring:url value="/cart" />" class="btn btn-default">
                    <span class="glyphicon-hand-right glyphicon"></span> Cart
                </a>
                <sec:authorize access="hasRole('ADMIN')">
                    <a href="<spring:url value="edit/${product.id}" />" class="btn btn-default">
                        <span class="glyphicon-hand-right glyphicon"></span> Edit
                    </a>
                </sec:authorize>
                <a href="<spring:url value="/products" />" class="btn btn-default">
                    <span class="glyphicon-hand-left glyphicon"></span> Back
                </a>

            </p>

        </div>
    </div>
</section>
