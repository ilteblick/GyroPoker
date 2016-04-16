<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Poker </title>
    <link type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet"/>
    <link type="text/css" href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet"/>
    <link type="text/css" href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="modal-dialog">
        <div class="label-login" align="center">
            <h2>Create New Account</h2>
        </div>
        <div class="panel ">
            <form action="/signup" method='POST'>
                <div class="form-group">
                    <label class="col-sm-4 control-label" for="nameInput">Name</label>

                    <div class="col-sm-7">
                        <input type="text" name="aName" id="nameInput"
                               class="form-control" value='' required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label" for="surnameInput">Surname</label>

                    <div class="col-sm-7">
                        <input type="text" name="aSurename" id="surnameInput"
                               class="form-control" value='' required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label" for="addressInput">Address</label>

                    <div class="col-sm-7">
                        <input type="text" name="aAddress" id="addressInput"
                               class="form-control" value='' required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label" for="phone">Phone</label>

                    <div class="col-sm-7">
                        <input name="aPhone" id="phone" type="tel" class="form-control"
                               pattern="[+][0-9]{5} [0-9]{3}-[0-9]{2}-[0-9]{2}"
                               placeholder="+37529 123-45-67" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label" for="countrySelect">Country</label>

                    <div class="col-sm-7">
                        <select name="countryId" id="countrySelect">
                            <c:forEach var="country" items="${countries}">
                                <option value="${country.idCountry}">${country.cCountryName}</option>
                            </c:forEach>
                        </select>
                    </div>

                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label" for="emailInput">Email</label>

                    <div class="col-sm-7">
                        <input type="email" name="aEmail" id="emailInput"
                               class="form-control" value='' required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-4 control-label"
                           for="passwordInput">Password</label>

                    <div class="col-sm-7">
                        <input type="password" name="aPassword" id="passwordInput"
                               class="form-control"
                               value='' required>
                    </div>
                </div>
                <div>
                    <label class="error"></label>
                </div>
                <button type="submit" name="submit" value="Submit" class="btn btn-submit">Submit</button>
                <br>
                <a class="reference" href="/">Back</a>
            </form>
        </div>
    </div>
</div>
</body>
</html>
