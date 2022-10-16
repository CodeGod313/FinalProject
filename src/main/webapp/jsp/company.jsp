<%--
  Created by IntelliJ IDEA.
  User: Ales
  Date: 17.02.2022
  Time: 06:07
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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/charts.css/dist/charts.min.css">
    <link rel="stylesheet" href="../css/chartSettings.css"/>
</head>
<%@include file="header/adminHeader.jspf" %>
<body>
<div class="container mt-4">
    <h3>
        Company Name
        <small class="text-muted">With faded secondary text</small>
    </h3>
</div>


<div class="container mt-5">
    <table class="charts-css line" id="my-chart">
        <tbody>
        <tr>
            <td style="--start: 0.0; --size: 0.4"><span class="data"> $ 40K </span></td>
        </tr>
        <tr>
            <td style="--start: 0.4; --size: 0.2"><span class="data"> $ 20K </span></td>
        </tr>
        <tr>
            <td style="--start: 0.2; --size: 0.6"><span class="data"> $ 60K </span></td>
        </tr>
        <tr>
            <td style="--start: 0.6; --size: 0.4"><span class="data"> $ 40K </span></td>
        </tr>
        <tr>
            <td style="--start: 0.4; --size: 0.8"><span class="data"> $ 80K </span></td>
        </tr>
        <tr>
            <td style="--start: 0.8; --size: 0.6"><span class="data"> $ 60K </span></td>
        </tr>
        <tr>
            <td style="--start: 0.6; --size: 1.0"><span class="data"> $ 100K </span></td>
        </tr>
        <tr>
            <td style="--start: 1.0; --size: 0.8"><span class="data"> $ 80K </span></td>
        </tr>
        <tr>
            <td style="--start: 0.8; --size: 0.3"><span class="data"> $ 30K </span></td>
        </tr>
        <tr>
            <td style="--start: 0.3; --size: 0.2"><span class="data"> $ 20K </span></td>
        </tr>
        </tbody>

    </table>
</div>




<div class="container" style="margin-top: 400px">
    <form>
        <div class="form-row">
            <div class="col-md-4 mb-3">
                <label for="validationServer01">First name</label>
                <input type="text" class="form-control is-valid" id="validationServer01" placeholder="First name"
                       value="Mark" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <label for="validationServer02">Last name</label>
                <input type="text" class="form-control is-valid" id="validationServer02" placeholder="Last name"
                       value="Otto" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <label for="validationServerUsername">Username</label>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroupPrepend3">@</span>
                    </div>
                    <input type="text" class="form-control is-invalid" id="validationServerUsername"
                           placeholder="Username" aria-describedby="inputGroupPrepend3" required>
                    <div class="invalid-feedback">
                        Please choose a username.
                    </div>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <label for="validationServer03">City</label>
                <input type="text" class="form-control is-invalid" id="validationServer03" placeholder="City" required>
                <div class="invalid-feedback">
                    Please provide a valid city.
                </div>
            </div>
            <div class="col-md-3 mb-3">
                <label for="validationServer04">State</label>
                <input type="text" class="form-control is-invalid" id="validationServer04" placeholder="State" required>
                <div class="invalid-feedback">
                    Please provide a valid state.
                </div>
            </div>
            <div class="col-md-3 mb-3">
                <label for="validationServer05">Zip</label>
                <input type="text" class="form-control is-invalid" id="validationServer05" placeholder="Zip" required>
                <div class="invalid-feedback">
                    Please provide a valid zip.
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="form-check">
                <input class="form-check-input is-invalid" type="checkbox" value="" id="invalidCheck3" required>
                <label class="form-check-label" for="invalidCheck3">
                    Agree to terms and conditions
                </label>
                <div class="invalid-feedback">
                    You must agree before submitting.
                </div>
            </div>
        </div>
        <button class="btn btn-primary" type="submit">Submit form</button>
    </form>
</div>

</body>
</html>
