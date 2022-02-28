<%--
  Created by IntelliJ IDEA.
  User: Ales
  Date: 17.02.2022
  Time: 22:23
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
<div class="container mt-4">
    <c:if test="${requestScope.wrongCompanyName == true}">
        <div class="alert alert-warning" role="alert">
            Компания с таким именем уже существует
        </div>
    </c:if>
    <c:if test="${requestScope.wrongParameters == true}">
        <div class="alert alert-danger" role="alert">
            Проверьте введённые данные
        </div>
    </c:if>
    <form action="/controller" method="post" enctype="multipart/form-data">
        <input type="hidden" name="command" value="company_creation">
        <div class="form-group">
            <label for="inputCompanyName">Название компании</label>
            <input type="text" class="form-control" id="inputCompanyName" aria-describedby="companyNameHelp"
                   placeholder="Название компании" pattern="[A-Z]+[a-z0-9]*" required name="companyName">
            <small id="companyNameHelp" class="form-text text-muted">Введите название компании c большой буквы</small>
        </div>
        <div class="form-group">
            <label for="inputShortCompanyName">Короткое название компании</label>
            <input type="text" class="form-control" id="inputShortCompanyName" aria-describedby="shortCompanyNameHelp"
                   placeholder="Короткое название компании" pattern="[A-Z]{3,5}" required name="companyShortName">
            <small id="shortCompanyNameHelp" class="form-text text-muted">От 3 до 5 больших английских букв</small>
        </div>
        <div class="form-group">
            <label for="inputSharePrice">Стоимость акций</label>
            <input type="text" class="form-control" id="inputSharePrice" aria-describedby="sharePriceHelp"
                   placeholder="Стоимость акций" pattern="\d+" required name="sharePrice">
            <small id="sharePriceHelp" class="form-text text-muted">Введите стоимость акции компании</small>
        </div>
        <div class="form-group">
            <label for="companyDescription">Описание компании</label>
            <textarea class="form-control" id="companyDescription" rows="4" required
                      name="companyDescription"></textarea>
        </div>
        <div class="form-group">
            <label for="exampleFormControlFile1">Лого компании</label>
            <input type="file" accept="image/*" class="form-control-file" id="exampleFormControlFile1" required
                   name="companyImage">
        </div>
        <button type="submit" class="btn btn-primary mt-4">Создать</button>
    </form>
</div>
</body>
<%@include file="footer/footer.jspf" %>
</html>
