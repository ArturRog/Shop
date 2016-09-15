<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 15.09.2016
  Time: 02:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:forEach items="${orders}" var="order">
    <table class="table table-hover">
        <tr>
            <th>Product</th>
            <th>Product id</th>
            <th>Category</th>
            <th>Unit price</th>
        </tr>
        <c:forEach items="${order.productList}" var="product">
            <tr>
                <td class="col-lg-3">${product.productName}</td>
                <td class="col-lg-3">${product.id}</td>
                <td class="col-lg-3">${product.category.categoryName}</td>
                <td class="col-lg-3">${product.productPrice}</td>
            </tr>
        </c:forEach>
    </table>
</c:forEach>
