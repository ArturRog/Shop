<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome page</title>
    <script src="/resources/js/bootstrap.js"></script>
    <link href="../../../resources/css/bootstrap.css"/>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="carousel slide" id="carousel-269337">
                <ol class="carousel-indicators">
                    <li class="active" data-slide-to="0" data-target="#carousel-269337">
                    </li>
                    <li data-slide-to="1" data-target="#carousel-269337">
                    </li>
                    <li data-slide-to="2" data-target="#carousel-269337">
                    </li>
                    <li data-slide-to="3" data-target="#carousel-269337">
                    </li>
                </ol>
                <div class="carousel-inner">
                    <div class="item active">
                        <img alt="Carousel Bootstrap First"
                             src="/resources/img/3.jpg"/>
                        <div class="carousel-caption">
                            <h4>
                                First Thumbnail label
                            </h4>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta
                                gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                        </div>
                    </div>
                    <div class="item">
                        <img alt="Carousel Bootstrap Second"
                             src="/resources/img/4.jpg"/>
                        <div class="carousel-caption">
                            <h4>
                                Second Thumbnail label
                            </h4>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta
                                gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                        </div>
                    </div>
                    <div class="item">
                        <img alt="Carousel Bootstrap Third"
                             src="/resources/img/3.jpg"/>
                        <div class="carousel-caption">
                            <h4>
                                Third Thumbnail label
                            </h4>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta
                                gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                        </div>
                    </div>
                    <div class="item">
                        <img alt="Carousel Bootstrap Fourth"
                             src="/resources/img/4.jpg"/>
                        <div class="carousel-caption">
                            <h4>
                                Fourth Thumbnail label
                            </h4>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta
                                gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                        </div>
                    </div>

                </div>
                <a class="left carousel-control" href="#carousel-269337" data-slide="prev"><span
                        class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control"
                                                                                href="#carousel-269337"
                                                                                data-slide="next"><span
                    class="glyphicon glyphicon-chevron-right"></span></a>
            </div>
        </div>
    </div>
</div>
<%--<div class="jumbotron">--%>
<%--<h1>		Greeting : ${greeting}--%>
<%--This is a welcome page.</h1>--%>
<%--<p>...</p>--%>
<%--</div>--%>

</body>
</html>