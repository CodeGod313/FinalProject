<%--
  Created by IntelliJ IDEA.
  User: Ales
  Date: 15.02.2022
  Time: 06:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">
            <img src="/images/currency-exchange.png" width="30" height="30" class="d-inline-block align-top" alt="">
            CleverEx
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-item nav-link" href="/jsp/main.jsp">О нас</a>
                <a class="nav-item nav-link" href="/jsp/companies.jsp">Список компаний</a>
                <a class="nav-item nav-link" href="/jsp/cryptos.jsp">Список криптовалют</a>
            </div>
        </div>
        <form class="form-inline" action="/jsp/logIn.jsp" method="post">
            <button class="btn btn-sm btn-outline-secondary" type="submit">Войти</button>
        </form>
    </nav>
</header>

<body>
<div class="container">
    <form action="/controller" method="get" autocomplete="on" accept-charset="UTF-8">
        <input type="hidden" name="command" value="registration">
        <div class="form-group">
            <label for="firstName">First name</label>
            <input type="text" class="form-control" id="firstName" aria-describedby="firstNameHelp"
                   placeholder="First name" name="firstName">
            <small id="firstNameHelp" class="form-text text-muted">Enter your first name.</small>
        </div>
        <div class="form-group">
            <label for="lastName">Last name</label>
            <input type="text" class="form-control" id="lastName" aria-describedby="lastNameHelp"
                   placeholder="Last name" name="lastName">
            <small id="lastNameHelp" class="form-text text-muted">Enter your last name.</small>
        </div>
        <div class="form-group">
            <label for="passportSeries">Passport series</label>
            <input type="text" class="form-control" id="passportSeries" aria-describedby="passportSeriesHelp"
                   placeholder="Passport series" name="passportSeries">
            <small id="passportSeriesHelp" class="form-text text-muted">Enter your passport series.</small>
        </div>
        <div class="form-group">
            <label for="passportNumber">Passport number</label>
            <input type="text" class="form-control" id="passportNumber" aria-describedby="passportNumberHelp"
                   placeholder="Passport number" name="passportNumber">
            <small id="passportNumberHelp" class="form-text text-muted">Enter your passport number.</small>
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                   placeholder="Enter email" name="email">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password" aria-describedby="passwordHelp">
            <small id="passwordHelp" class="form-text text-muted">Enter your password.</small>
        </div>
        <button type="submit" class="btn btn-primary mt-4">Register</button>
    </form>
</div>

</body>
<!-- Footer -->
<footer class="bg-dark text-center text-white">
    <!-- Grid container -->
    <div class="container p-4">
        <!-- Section: Text -->
        <section class="mb-4">
            <p>
                Лучшая платформа для покупки и продажи акций
            </p>
        </section>
        <!-- Section: Text -->
    </div>
    <!-- Grid container -->

    <!-- Copyright -->
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
        © 2021 Copyright:
        <a class="text-white" href="/jsp/main.jsp">CleverEx LTD</a>
    </div>
    <!-- Copyright -->
</footer>
<!-- Footer -->
</html>
