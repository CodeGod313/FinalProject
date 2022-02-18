<%--
  Created by IntelliJ IDEA.
  User: Ales
  Date: 17.02.2022
  Time: 06:14
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
                <a class="nav-item nav-link" href="/jsp/cryptos.jsp">Список криптовалют</a>
                <a class="nav-item nav-link active" href="/jsp/clientList.jsp">Список пользователей</a>
                <a class="nav-item nav-link" href="/jsp/companyCreation.jsp">Создать компанию</a>
                <a class="nav-item nav-link" href="/jsp/cryptoCreation.jsp">Создать криптовалюту</a>
            </div>
        </div>
        <form class="form-inline" action="/controller?command=log_out" method="post">
            <button class="btn btn-sm btn-outline-secondary" type="submit">Выйти</button>
        </form>
    </nav>
</header>
<body>

<div class="container">
    <div class="row mt-4">
        <div class="col-md-auto">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Название карточки</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's
                        content.</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Cras justo odio</li>
                    <li class="list-group-item">Dapibus ac facilisis in</li>
                    <li class="list-group-item">Vestibulum at eros</li>
                </ul>
                <div class="card-body">
                    <a href="#" class="card-link">Ссылка карты</a>
                    <a href="#" class="card-link">Другая ссылка</a>
                </div>
            </div>
        </div>
        <div class="col-md-auto">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Название карточки</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's
                        content.</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Cras justo odio</li>
                    <li class="list-group-item">Dapibus ac facilisis in</li>
                    <li class="list-group-item">Vestibulum at eros</li>
                </ul>
                <div class="card-body">
                    <a href="#" class="card-link">Ссылка карты</a>
                    <a href="#" class="card-link">Другая ссылка</a>
                </div>
            </div>
        </div>
        <div class="col-md-auto">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Название карточки</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's
                        content.</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Cras justo odio</li>
                    <li class="list-group-item">Dapibus ac facilisis in</li>
                    <li class="list-group-item">Vestibulum at eros</li>
                </ul>
                <div class="card-body">
                    <a href="#" class="card-link">Ссылка карты</a>
                    <a href="#" class="card-link">Другая ссылка</a>
                </div>
            </div>
        </div>
        <div class="col-md-auto">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Название карточки</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's
                        content.</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Cras justo odio</li>
                    <li class="list-group-item">Dapibus ac facilisis in</li>
                    <li class="list-group-item">Vestibulum at eros</li>
                </ul>
                <div class="card-body">
                    <a href="#" class="card-link">Ссылка карты</a>
                    <a href="#" class="card-link">Другая ссылка</a>
                </div>
            </div>
        </div>
    </div>
    <div class="row mt-4">
        <div class="col-md-auto">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Название карточки</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's
                        content.</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Cras justo odio</li>
                    <li class="list-group-item">Dapibus ac facilisis in</li>
                    <li class="list-group-item">Vestibulum at eros</li>
                </ul>
                <div class="card-body">
                    <a href="#" class="card-link">Ссылка карты</a>
                    <a href="#" class="card-link">Другая ссылка</a>
                </div>
            </div>
        </div>
        <div class="col-md-auto">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Название карточки</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's
                        content.</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Cras justo odio</li>
                    <li class="list-group-item">Dapibus ac facilisis in</li>
                    <li class="list-group-item">Vestibulum at eros</li>
                </ul>
                <div class="card-body">
                    <a href="#" class="card-link">Ссылка карты</a>
                    <a href="#" class="card-link">Другая ссылка</a>
                </div>
            </div>
        </div>
        <div class="col-md-auto">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Название карточки</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's
                        content.</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Cras justo odio</li>
                    <li class="list-group-item">Dapibus ac facilisis in</li>
                    <li class="list-group-item">Vestibulum at eros</li>
                </ul>
                <div class="card-body">
                    <a href="#" class="card-link">Ссылка карты</a>
                    <a href="#" class="card-link">Другая ссылка</a>
                </div>
            </div>
        </div>
        <div class="col-md-auto">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Название карточки</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's
                        content.</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Cras justo odio</li>
                    <li class="list-group-item">Dapibus ac facilisis in</li>
                    <li class="list-group-item">Vestibulum at eros</li>
                </ul>
                <div class="card-body">
                    <a href="#" class="card-link">Ссылка карты</a>
                    <a href="#" class="card-link">Другая ссылка</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
