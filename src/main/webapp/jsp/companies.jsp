<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Ales
  Date: 17.02.2022
  Time: 01:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization/locale"/>

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

<%--${applicationScope.imagesFolder} --%>
<body>
<div class="container">
    <div class="row">
        <c:forEach var="company" items="${requestScope.pageItems}">
            <div class="col-md-auto mt-4">
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="/images/CleverExImages/${company.imagePath}"
                         alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">${company.name}</h5>
                        <p class="card-text">
                                ${company.description}
                        </p>
                        <a href="/controller?command=about_company&companyId=${company.id}" class="btn btn-primary">Подробнее</a>
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
                        <li class="page-item active"><a class="page-link" href="/controller?command=display_companies&page=${pageNumber}">${pageNumber}</a></li>
                    </c:when>
                    <c:when test="${requestScope.page != pageNumber}">
                        <li class="page-item"><a class="page-link" href="/controller?command=display_companies&page=${pageNumber}">${pageNumber}</a></li>
                    </c:when>
                </c:choose>
            </c:forEach>
        </ul>
    </nav>
</div>

</body>
<%@include file="footer/footer.jspf" %>
</html>
