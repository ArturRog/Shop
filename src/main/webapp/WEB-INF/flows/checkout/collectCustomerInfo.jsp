<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;" charset="utf-8"/>

    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Customer</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Customer</h1>
            <p>Customer details</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form modelAttribute="order.user" class="form-horizontal">
        <fieldset>
            <legend>Customer Details</legend>
            <form:errors path="*" cssClass="alert alert-danger" element="div"/>


            <div class="form-group">
                <label class="control-label col-lg-2" for="firstName">First Name</label>
                <div class="col-lg-10">
                    <form:input id="firstName" path="firstName" type="text" class="form:input-large"/>
                    <form:errors path="firstName" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="lastName">Last Name</label>
                <div class="col-lg-10">
                    <form:input id="lastName" path="lastName" type="text" class="form:input-large"/>
                    <form:errors path="lastName" cssClass="text-danger"/>

                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="email">E-mail</label>
                <div class="col-lg-10">
                    <form:input id="email" path="email" type="text" class="form:input-large"/>
                    <form:errors path="email" cssClass="text-danger"/>

                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="phoneNumber">Phone Number</label>
                <div class="col-lg-10">
                    <form:input id="phoneNumber" path="phoneNumber" type="text" class="form:input-large"/>
                    <form:errors path="phoneNumber" cssClass="text-danger"/>

                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="doorNo">Door No</label>
                <div class="col-lg-10">
                    <form:input id="doorNo" path="doorNo" type="text"
                                class="form:input-large"/>
                    <form:errors path="doorNo" cssClass="text-danger"/>

                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="streetName">Street Name</label>
                <div class="col-lg-10">
                    <form:input id="streetName" path="streetName" type="text"
                                class="form:input-large"/>
                    <form:errors path="streetName" cssClass="text-danger"/>

                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="areaName">Area Name</label>
                <div class="col-lg-10">
                    <form:input id="areaName" path="areaName" type="text"
                                class="form:input-large"/>
                    <form:errors path="areaName" cssClass="text-danger"/>

                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="state">State</label>
                <div class="col-lg-10">
                    <form:input id="state" path="stateName" type="text"
                                class="form:input-large"/>
                    <form:errors path="stateName" cssClass="text-danger"/>

                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="country">country</label>
                <div class="col-lg-10">
                    <form:input id="country" path="country" type="text"
                                class="form:input-large"/>
                    <form:errors path="country" cssClass="text-danger"/>

                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="zipCode">Zip Code</label>
                <div class="col-lg-10">
                    <form:input id="zipCode" path="zipCode" type="text"
                                class="form:input-large"/>
                    <form:errors path="zipCode" cssClass="text-danger"/>

                </div>
            </div>

            <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>

            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary"
                           value="Add" name="_eventId_customerInfoCollected"/>
                    <button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Cancel</button>
                </div>
            </div>

        </fieldset>
    </form:form>
</section>
</body>
</html>
