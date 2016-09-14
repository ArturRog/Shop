<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<form:form method="post" modelAttribute="newProduct" class="form-horizontal"
           action="${pageContext.request.contextPath}/products/edit/${newProduct.id}">
    <form:errors path="*" cssClass="alert alert-danger" element="div"/>

    <fieldset>
        <legend>Edit product</legend>


        <div class="form-group col-md-12">
            <label class="control-label col-md-3" for="productName">
                <spring:message code="addProduct.form.productName.label"/>
            </label>
            <div class="col-md-7">
                <form:input id="productName" path="productName" type="text" class="form:input-large"/>
                <form:errors path="productName" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group col-md-12">
            <label class="control-label col-md-3" for="productPrice">
                <spring:message code="addProduct.form.productPrice.label"/>
            </label>
            <div class="col-md-7">
                <div class="form:input-prepend">
                    <form:input id="productPrice" path="productPrice" type="text" class="form:input-large"/>
                    <form:errors path="productPrice" cssClass="text-danger"/>
                </div>
            </div>
        </div>
        <div class="form-group col-md-12">
            <label class="col-md-3 control-label" for="category">
                <spring:message code="addProduct.form.productCategory.label"/>
            </label>
            <div class="col-md-7">
                <form:select path="category." items="${categories}" multiple="false" itemValue="id"
                             itemLabel="categoryName"
                             class="form-control input-sm"/>
                <form:errors path="category" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group col-md-12">
            <label class="control-label col-md-3" for="productDescription">
                <spring:message code="addProduct.form.productDescription.label"/>
            </label>
            <div class="col-md-7">
                <form:textarea id="productDescription" path="productDescription" rows="2"/>
                <form:errors path="productDescription" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group col-md-12">
            <div class="col-lg-offset-3 col-lg-10">
                <input type="submit" id="btnAdd" class="btn btn-primary" value="Edit Product"/>
            </div>
        </div>
        <div class="form-group col-md-12">
            <div class="col-lg-offset-3 col-lg-10">
                <a href="<c:url value='/products/remove/${newProduct.id}' />" class="btn btn-danger pull-left"> <span
                        class="glyphicon glyphicon-remove-sign"></span> Delete Product
                </a>
            </div>
        </div>
    </fieldset>
</form:form>
