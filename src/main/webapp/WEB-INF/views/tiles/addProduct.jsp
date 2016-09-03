<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Products</title>
</head>

<%--<section class="container">--%>
    <form:form method="post" modelAttribute="newProduct" class="form-horizontal"
               action="${pageContext.request.contextPath}/products/add">
        <fieldset>
            <legend>Add new product</legend>


            <div class="form-group">
                <label class="control-label col-lg-2" for="productName"></label>
                <div class="col-lg-10">
                    <form:input id="productName" path="productName" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="productPrice"></label>
                <div class="col-lg-10">
                    <div class="form:input-prepend">
                        <form:input id="productPrice" path="productPrice" type="text" class="form:input-large"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="category">Categories</label>
                <form:select path="category." items="${categories}" multiple="false" itemValue="id"
                             itemLabel="categoryName"
                             class="form-control input-sm"/>
                <%--<form:select path="category" id="category">--%>
                    <%--<form:option value="1" label="--CATEGORY--"/>--%>
                    <%--<form:options items="${categories}"/>--%>
                <%--</form:select>--%>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="productDescription"></label>
                <div class="col-lg-10">
                    <form:textarea id="productDescription" path="productDescription" rows="2"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value="Add"/>
                </div>
            </div>

        </fieldset>
    </form:form>
<%--</section>--%>
</body>
</html>
