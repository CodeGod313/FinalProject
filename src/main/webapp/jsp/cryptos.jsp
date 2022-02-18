<%--
  Created by IntelliJ IDEA.
  User: Ales
  Date: 17.02.2022
  Time: 02:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>СleverEx</title>
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
                <a class="nav-item nav-link active" href="/jsp/cryptos.jsp">Список криптовалют</a>
            </div>
        </div>
        <form class="form-inline" action="/jsp/registration.jsp" method="post">
            <button class="btn btn-outline-success" type="submit">Зарегистрироваться</button>
        </form>
        <form class="form-inline" action="/jsp/logIn.jsp" method="post">
            <button class="btn btn-sm btn-outline-secondary" type="submit">Войти</button>
        </form>
    </nav>
</header>

<body>
<div class="container">
    <div class="row mt-4">
        <div class="col-md-auto">
            <div class="card" style="width: 18rem;">
                <img class="card-img-top" src="/images/google.jpg" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Название карточки</h5>
                    <p class="card-text">
                        Some quick example text to build on the card title and make up the bulk of the card's
                        content.
                    </p>
                    <a href="#" class="btn btn-primary">Переход куда-нибудь</a>
                </div>
            </div>
        </div>


        <div class="col-md-auto">
            <div class="card" style="width: 18rem;">
                <img class="card-img-top" src="/images/google.jpg" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Название карточки</h5>
                    <p class="card-text">
                        Some quick example text to build on the card title and make up the bulk of the card's
                        content.
                    </p>
                    <a href="#" class="btn btn-primary">Переход куда-нибудь</a>
                </div>
            </div>
        </div>
        <div class="col-md-auto">
            <div class="card" style="width: 18rem;">
                <img class="card-img-top" src="/images/google.jpg" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Название карточки</h5>
                    <p class="card-text">
                        Some quick example text to build on the card title and make up the bulk of the card's
                        content.
                    </p>
                    <a href="#" class="btn btn-primary">Переход куда-нибудь</a>
                </div>
            </div>
        </div>
        <div class="col-md-auto">
            <div class="card" style="width: 18rem;">
                <img class="card-img-top" src="/images/google.jpg" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Название карточки</h5>
                    <p class="card-text">
                        Some quick example text to build on the card title and make up the bulk of the card's
                        content.
                    </p>
                    <a href="#" class="btn btn-primary">Переход куда-нибудь</a>
                </div>
            </div>
        </div>
    </div>
    <div class="row mt-4">
        <div class="col-md-auto">
            <div class="card" style="width: 18rem;">
                <img class="card-img-top" src="/images/google.jpg" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Название карточки</h5>
                    <p class="card-text">
                        Some quick example text to build on the card title and make up the bulk of the card's
                        content.
                    </p>
                    <a href="#" class="btn btn-primary">Переход куда-нибудь</a>
                </div>
            </div>
        </div>


        <div class="col-md-auto">
            <div class="card" style="width: 18rem;">
                <img class="card-img-top" src="/images/google.jpg" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Название карточки</h5>
                    <p class="card-text">
                        Some quick example text to build on the card title and make up the bulk of the card's
                        content.
                    </p>
                    <a href="#" class="btn btn-primary">Переход куда-нибудь</a>
                </div>
            </div>
        </div>
        <div class="col-md-auto">
            <div class="card" style="width: 18rem;">
                <img class="card-img-top" src="/images/google.jpg" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Название карточки</h5>
                    <p class="card-text">
                        Some quick example text to build on the card title and make up the bulk of the card's
                        content.
                    </p>
                    <a href="#" class="btn btn-primary">Переход куда-нибудь</a>
                </div>
            </div>
        </div>
        <div class="col-md-auto">
            <div class="card" style="width: 18rem;">
                <img class="card-img-top" src="/images/google.jpg" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Название карточки</h5>
                    <p class="card-text">
                        Some quick example text to build on the card title and make up the bulk of the card's
                        content.
                    </p>
                    <a href="#" class="btn btn-primary">Переход куда-нибудь</a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container mt-4">
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>
    </nav>
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

</html>
