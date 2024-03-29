<%--
  Created by IntelliJ IDEA.
  User: Ales
  Date: 17.02.2022
  Time: 02:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization/locale"/>
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

<%@include file="header/adminHeader.jspf" %>

<body>
<div class="container">
    <div class="row mt-4">
        <c:forEach var="crypto" items="${requestScope.pageItems}">
            <div class="col-md-auto">
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="/images/CleverExImages/${crypto.imagePath}" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">${crypto.name}</h5>
                        <p class="card-text">
                            ${crypto.description}
                        </p>
                        <a href="#" class="btn btn-primary">Переход куда-нибудь</a>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>
</div>

<div class="container mt-4">
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <c:forEach var="pageNumber" items="${requestScope.pages}">
                <c:choose>
                    <c:when test="${requestScope.page == pageNumber}">
                        <li class="page-item active"><a class="page-link" href="/controller?command=display_cryptos&page=${pageNumber}">${pageNumber}</a></li>
                    </c:when>
                    <c:when test="${requestScope.page != pageNumber}">
                        <li class="page-item"><a class="page-link" href="/controller?command=display_cryptos&page=${pageNumber}">${pageNumber}</a></li>
                    </c:when>
                </c:choose>
            </c:forEach>
        </ul>
    </nav>
</div>

</body>
<%@include file="footer/footer.jspf" %>
</html>

</html>
