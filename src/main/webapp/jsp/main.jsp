<%--
  Created by IntelliJ IDEA.
  User: Ales
  Date: 15.02.2022
  Time: 05:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>

<%@include file="header/adminHeader.jspf" %>

<body>
<h1 class="text-center">CleverEx</h1>
<h3 class="text-center">
    Небольшая биржа, где вы можете покупать и продавать криптовалюту, а также акции разных компаний.
</h3>
<div class="container">
    <p class="text-justify">
        <fmt:message key="main.article1"/>
    </p>
    <p class="text-justify">
        <fmt:message key="main.article2"/>
    </p>
    <p class="text-justify">
        <fmt:message key="main.article3"/>
    </p>
    <p class="text-justify">
        <fmt:message key="main.article4"/>
    </p>
</div>

</body>
<%@include file="footer/footer.jspf" %>
</html>
