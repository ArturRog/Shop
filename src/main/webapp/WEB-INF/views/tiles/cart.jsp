<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

    <script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="/resources/js/controllers.js"></script>

    <title>Cart</title>
</head>
<section class="container" ng-app="cartApp">
    <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')" class="col-md-5">

        <div>
            <a class="btn btn-danger pull-left"
               ng-click="clearCart()"> <span
                    class="glyphicon glyphicon-remove-sign"></span> Erase Cart
            </a> <a href="<spring:url value="/checkout?cartId=${cartId}"/>" class="btn btn-success pull-right"> <span
                class="glyphicon-shopping-cart glyphicon"></span> Confirm
        </a>
        </div>
        <table class="table table-hover">
            <tr>
                <th>Product</th>
                <th>Unit price</th>
                <th>Quantity</th>
                <%--<th>Total price</th>--%>
                <th>Action</th>
            </tr>
            <tr ng-repeat="item in cart.products">
                <td>{{item.product.id}}-{{item.product.productName}}</td>
                <td>{{item.product.productPrice}}</td>
                <td>{{item.quantity}}</td>
                <%--<td>{{item.totalPrice}}</td>--%>
                <td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.id)"> <span
                        class="glyphicon glyphicon-remove" /></span> Delete
                </a></td>
            </tr>
            <tr>
                <th></th>
                <th></th>
                <th>Total</th>
                <th>{{cart.totalValue}} PLN</th>
                <th></th>
            </tr>
        </table>

        <a href="<spring:url value="/products" />" class="btn btn-default">
            <span class="glyphicon-hand-left glyphicon"></span> Continue shopping
        </a>
    </div>
</section>
</html>


<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: artur--%>
  <%--Date: 31.08.2016--%>
  <%--Time: 22:22--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Cart</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--<div class="container">--%>
    <%--<div class="row">--%>
        <%--<div class="col-xs-8">--%>
            <%--<div class="panel panel-info">--%>
                <%--<div class="panel-heading">--%>
                    <%--<div class="panel-title">--%>
                        <%--<div class="row">--%>
                            <%--<div class="col-xs-6">--%>
                                <%--<h5><span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart</h5>--%>
                            <%--</div>--%>
                            <%--<div class="col-xs-6">--%>
                                <%--<button type="button" class="btn btn-primary btn-sm btn-block">--%>
                                    <%--<span class="glyphicon glyphicon-share-alt"></span> Continue shopping--%>
                                <%--</button>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="panel-body">--%>
                    <%--<div class="row">--%>
                        <%--<div class="col-xs-2"><img class="img-responsive" src="http://placehold.it/100x70">--%>
                        <%--</div>--%>
                        <%--<div class="col-xs-4">--%>
                            <%--<h4 class="product-name"><strong>Product name</strong></h4><h4><small>Product description</small></h4>--%>
                        <%--</div>--%>
                        <%--<div class="col-xs-6">--%>
                            <%--<div class="col-xs-6 text-right">--%>
                                <%--<h6><strong>25.00 <span class="text-muted">x</span></strong></h6>--%>
                            <%--</div>--%>
                            <%--<div class="col-xs-4">--%>
                                <%--<input type="text" class="form-control input-sm" value="1">--%>
                            <%--</div>--%>
                            <%--<div class="col-xs-2">--%>
                                <%--<button type="button" class="btn btn-link btn-xs">--%>
                                    <%--<span class="glyphicon glyphicon-trash"> </span>--%>
                                <%--</button>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<hr>--%>
                    <%--<div class="row">--%>
                        <%--<div class="col-xs-2"><img class="img-responsive" src="http://placehold.it/100x70">--%>
                        <%--</div>--%>
                        <%--<div class="col-xs-4">--%>
                            <%--<h4 class="product-name"><strong>Product name</strong></h4><h4><small>Product description</small></h4>--%>
                        <%--</div>--%>
                        <%--<div class="col-xs-6">--%>
                            <%--<div class="col-xs-6 text-right">--%>
                                <%--<h6><strong>25.00 <span class="text-muted">x</span></strong></h6>--%>
                            <%--</div>--%>
                            <%--<div class="col-xs-4">--%>
                                <%--<input type="text" class="form-control input-sm" value="1">--%>
                            <%--</div>--%>
                            <%--<div class="col-xs-2">--%>
                                <%--<button type="button" class="btn btn-link btn-xs">--%>
                                    <%--<span class="glyphicon glyphicon-trash"> </span>--%>
                                <%--</button>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<hr>--%>
                    <%--<div class="row">--%>
                        <%--<div class="text-center">--%>
                            <%--<div class="col-xs-9">--%>
                                <%--<h6 class="text-right">Added items?</h6>--%>
                            <%--</div>--%>
                            <%--<div class="col-xs-3">--%>
                                <%--<button type="button" class="btn btn-default btn-sm btn-block">--%>
                                    <%--Update cart--%>
                                <%--</button>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="panel-footer">--%>
                    <%--<div class="row text-center">--%>
                        <%--<div class="col-xs-9">--%>
                            <%--<h4 class="text-right">Total <strong>$50.00</strong></h4>--%>
                        <%--</div>--%>
                        <%--<div class="col-xs-3">--%>
                            <%--<button type="button" class="btn btn-success btn-block">--%>
                                <%--Checkout--%>
                            <%--</button>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>


<%--</body>--%>
<%--</html>--%>
