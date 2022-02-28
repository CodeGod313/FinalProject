<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ales
  Date: 17.02.2022
  Time: 03:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization/locale"/>
<html>
<head>
    <title>CleverEx</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
            integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <script type="text/javascript">
        function disableBack() {
            window.history.forward();
        }

        setTimeout("disableBack()", 0);
        window.onunload = function () {
            null
        };
    </script>
</head>

<%@include file="header/guestHeader.jspf" %>

<body>
<div class="container mt-4">
    <c:if test="${requestScope.alert == true}">
        <div class="alert alert-danger mt-4" role="alert">
            <fmt:message key="logIn.alert"/>
        </div>
    </c:if>
    <form action="/controller" method="post" autocomplete="on" accept-charset="UTF-8">
        <input type="hidden" name="command" value="log_in">
        <div class="form-group">
            <label for="exampleInputEmail1"><fmt:message key="logIn.emailField"/> </label>
            <input required type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                   placeholder="Enter email" name="email" pattern="[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-z]{2,3}">
            <small id="emailHelp" class="form-text text-muted"><fmt:message key="logIn.emailHelp"/> </small>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1"><fmt:message key="logIn.passwordField"/> </label>
            <input required type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"
                   name="password" aria-describedby="passwordHelp">
            <small id="passwordHelp" class="form-text text-muted"><fmt:message key="logIn.passwordHelp"/> </small>
        </div>
        <button type="submit" class="btn btn-primary mt-4"><fmt:message key="logIn.submit"/></button>
    </form>
</div>

</body>
<%@include file="footer/footer.jspf" %>
</html>

</html>
