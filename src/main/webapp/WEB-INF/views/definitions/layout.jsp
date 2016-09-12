<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"/>
    <link rel="stylesheet"
          href="<c:url value="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>">

    <link rel="stylesheet" type="text/css"
          href="<c:url value='//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css' />"/>

</head>
<body>


<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <tiles:insertAttribute name="header"/>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2">
            <tiles:insertAttribute name="menu"/>
        </div>
        <div class="col-md-10">
            <tiles:insertAttribute name="body"/>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12" style="text-align: right">
            <tiles:insertAttribute name="footer"/>
        </div>
    </div>
</div>
</body>
</html>