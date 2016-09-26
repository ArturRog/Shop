<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>

<nav class="navbar navbar-inverse ">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/home">NutritionShop</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="!isAuthenticated()">
                    <li class="active"><a href="<c:url value='/login'/>">Log in</a></li>
                    <li class="active"><a href="<c:url value='/newUser'/>">Register</a></li>

                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li class="active"><a href="<c:url value='/cart'/>">Cart <span
                            class="glyphicon glyphicon-shopping-cart"></span></a></li>
                    <sec:authorize access="not hasRole('ADMIN')">
                        <li class="active"><a href="<c:url value='/myOrders'/>">My Orders <span class="sr-only">(current)</span></a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN')">
                        <li class="active"><a href="<c:url value='/admin'/>">Admin Page</a></li>
                    </sec:authorize>

                    <li class="active"><a class="login" href="<c:url value='/logout'/>">Log out</a></li>
                </sec:authorize>


            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
