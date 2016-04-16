<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
            <h2>Login to Your Account</h2>
        </div>


        <div class="panel ">
            <form action="/" method='POST'>
                <div class="form-group">
                    <label class="col-sm-4 control-label" for="emailInput">Email</label>

                    <div class="col-sm-7">
                        <input type="email" name="email" id="emailInput"
                               class="form-control" value='' required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-4 control-label"
                           for="passwordInput">Password</label>

                    <div class="col-sm-7">
                        <input type="password" name="password" id="passwordInput"
                               class="form-control"
                               value='' required>
                    </div>
                </div>
                <div>
                    <label class="error">${error}</label>
                </div>
                <label>Don't have an account ?  <a href="/signup" class="reference">Sign up</a></label> <br>
                <button type="submit" name="submit" value="Submit" class="btn btn-submit">Log in</button>


            </form>
        </div>


    </div>
</div>
</body>
</html>
