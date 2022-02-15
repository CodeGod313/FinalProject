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
    <title>Registration</title>
    <script type="text/javascript">
        function disableBack() { window.history.forward(); }
        setTimeout("disableBack()", 0);
        window.onunload = function () { null };
    </script>
</head>

<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">
            <img src="images/currency-exchange.png" width="30" height="30" class="d-inline-block align-top" alt="">
            CleverEx
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-item nav-link active" href="/controller?command=about_us">О нас</a>
                <a class="nav-item nav-link" href="/controller?command=companies">Список компаний</a>
                <a class="nav-item nav-link" href="/controller?command=cryptos">Список криптовалют</a>
            </div>
        </div>
        <form class="form-inline" action="/controller?command=log_in" method="post">
            <button class="btn btn-sm btn-outline-secondary" type="button">Войти</button>
        </form>
    </nav>
</header>

<body>

</body>
</html>
