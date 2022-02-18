<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                <c:if test="${sessionScope.currentPage == '/jsp/main.jsp'}">
                    <a class="nav-item nav-link active" href="/jsp/main.jsp"><fmt:message key="header.aboutUs"/> </a>
                    <a class="nav-item nav-link" href="/jsp/companies.jsp"><fmt:message key="header.companies"/> </a>
                    <a class="nav-item nav-link" href="/jsp/cryptos.jsp"><fmt:message key="header.cryptos"/> </a>
                    <c:if test="${sessionScope.role == 'admin'}">
                        <a class="nav-item nav-link" href="/jsp/clientList.jsp"><fmt:message key="header.clients"/> </a>
                        <a class="nav-item nav-link" href="/jsp/companyCreation.jsp.jsp"><fmt:message key="header.companyCreation"/> </a>
                    </c:if>
                </c:if>
                <c:if test="${sessionScope.currentPage == '/jsp/companies.jsp'}">
                    <a class="nav-item nav-link" href="/jsp/main.jsp"><fmt:message key="header.aboutUs"/> </a>
                    <a class="nav-item nav-link active" href="/jsp/companies.jsp"><fmt:message
                            key="header.companies"/> </a>
                    <a class="nav-item nav-link" href="/jsp/cryptos.jsp"><fmt:message key="header.cryptos"/> </a>
                </c:if>
                <c:if test="${sessionScope.currentPage == '/jsp/logIn.jsp'}">
                    <a class="nav-item nav-link" href="/jsp/main.jsp"><fmt:message key="header.aboutUs"/> </a>
                    <a class="nav-item nav-link" href="/jsp/companies.jsp"><fmt:message key="header.companies"/> </a>
                    <a class="nav-item nav-link" href="/jsp/cryptos.jsp"><fmt:message key="header.cryptos"/> </a>
                </c:if>
                <c:if test="${sessionScope.currentPage == '/jsp/clientLis.jsp'}">
                    <a class="nav-item nav-link" href="/jsp/main.jsp"><fmt:message key="header.aboutUs"/> </a>
                    <a class="nav-item nav-link" href="/jsp/companies.jsp"><fmt:message key="header.companies"/> </a>
                    <a class="nav-item nav-link" href="/jsp/cryptos.jsp"><fmt:message key="header.cryptos"/> </a>
                    <a class="nav-item nav-link active" href="/jsp/clientList.jsp"><fmt:message key="header.clients"/> </a>
                    <a class="nav-item nav-link" href="/jsp/companyCreation.jsp.jsp"><fmt:message key="header.companyCreation"/> </a>
                </c:if>
                <c:if test="${sessionScope.currentPage == '/jsp/companyCreation.jsp'}">
                    <a class="nav-item nav-link" href="/jsp/main.jsp"><fmt:message key="header.aboutUs"/> </a>
                    <a class="nav-item nav-link" href="/jsp/companies.jsp"><fmt:message key="header.companies"/> </a>
                    <a class="nav-item nav-link" href="/jsp/cryptos.jsp"><fmt:message key="header.cryptos"/> </a>
                    <a class="nav-item nav-link" href="/jsp/clientList.jsp"><fmt:message key="header.clients"/> </a>
                    <a class="nav-item nav-link active" href="/jsp/companyCreation.jsp.jsp"><fmt:message key="header.companyCreation"/> </a>
                </c:if>
            </div>
        </div>
        <form class="form-inline" action="/jsp/registration.jsp" method="post">
            <button class="btn btn-outline-success" type="submit"><fmt:message key="header.registration"/></button>
        </form>
        <c:if test="${sessionScope.currentPage != '/jsp/logIn.jsp'}">
            <form class="form-inline" action="/jsp/logIn.jsp" method="post">
                <button class="btn btn-sm btn-outline-secondary" type="submit"><fmt:message
                        key="header.logIn"/></button>
            </form>
        </c:if>
    </nav>
</header>