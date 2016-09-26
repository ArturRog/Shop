<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <table class="table table-striped custab">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>E-mail</th>
            <th>Phone number</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td class="col-lg-1">${user.id}</td>
                <td class="col-lg-3">${user.firstName}</td>
                <td class="col-lg-3">${user.lastName}</td>
                <td class="col-lg-3">${user.email}</td>
                <td class="col-lg-2">${user.phoneNumber}</td>
            </tr>
        </c:forEach>
    </table>