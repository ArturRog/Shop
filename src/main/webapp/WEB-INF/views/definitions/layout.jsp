<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
</head>
<body>



<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <tiles:insertAttribute name="header" />
        </div>
    </div>
    <div class="row">
        <div class="col-md-2">
            <tiles:insertAttribute name="menu" />
        </div>
        <div class="col-md-10">
            <tiles:insertAttribute name="body" />
        </div>
    </div>
    <div class="row">
        <div class="col-md-12" style="text-align: right">
            <tiles:insertAttribute name="footer" />
        </div>
    </div>
</div>



<%--<table>--%>
    <%--<tr>--%>
        <%--<td>--%>
            <%--<tiles:insertAttribute name="header" />--%>
        <%--</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td>--%>
            <%--<tiles:insertAttribute name="menu" />--%>
        <%--</td>--%>
        <%--<td>--%>
            <%--<tiles:insertAttribute name="body" />--%>
        <%--</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td>--%>
            <%--<tiles:insertAttribute name="footer" />--%>
        <%--</td>--%>
    <%--</tr>--%>
<%--</table>--%>
</body>
</html>