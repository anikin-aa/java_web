<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 01.12.2015
  Time: 8:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<head>
    <title>Details</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
    <script src=js_validators.js></script>
</head>
<body>
<form class="pure-form pure-form-aligned" action="/view" method="get">
    <legend>Detailed info about user:</legend>
    <input type="hidden" name="id" value="<c:out value="${user.id}"></c:out>"/>
    <fieldset>
        <div class="pure-control-group">
            <label for="name">First Name</label>
            <input id="name" name="name" type="text" value="<c:out value="${user.name}"/>"
                   onchange="check_string(this)">
        </div>

        <div class="pure-control-group">
            <label for="surname">Last Name</label>
            <input id="surname" name="surname" type="text" value="<c:out value="${user.surname}"/>"
                   onchange="check_string(this)">
        </div>

        <div class="pure-control-group">
            <label for="email">Email Address</label>
            <input id="email" name="email" type="email" value="<c:out value="${user.email}"/>"
                   onchange="check_email(this)">
        </div>

        <div class="pure-control-group">
            <label for="age">Age of user</label>
            <input id="age" name="age" type="text" value="<c:out value="${user.age}"/>"
                   onchange="check_age(this)">
        </div>

        <div class="pure-control-group">
            <label for="series">Passport Series</label>
            <input id="series" name="series" type="text" value="<c:out value="${user.getpassSeries()}"/>"
                   onchange="check_series(this)">
        </div>

        <div >
            <label for="number">Passport Number</label>
            <input id="number" name="number" type="text" value="<c:out value="${user.getpassNumb()}"/>"
                   onchange="check_numb(this)">
        </div>

        <div class="pure-controls">
            <button type="submit" id="submit" name="submit" class="pure-button pure-button-primary">Submit</button>
        </div>

    </fieldset>

</form>
<a href="/">
    <button class="pure-button">Back to main table</button>
</a>
<script>
    function myFunction() {
        var str = "Back to main table";
        var result = str.link("/");
        document.getElementById("demo").innerHTML = result;
    }
    function check_string(element) {
        var regexp = /^[a-zA-Z]+$/;
        if (element.value == "" || !element.value.match(regexp)) {
            document.getElementById("submit").disabled = true;
            element.style.borderColor = "E05858";
        } else {
            document.getElementById("submit").disabled = false;
            element.style.borderColor = "";
        }
    }
    function check_age(element) {
        if (element.value.length > 2 || !isInt(element.value) && (element.value == "")) {
            document.getElementById("submit").disabled = true;
            element.style.borderColor = "E05858";
        } else {
            document.getElementById("submit").disabled = false;
            element.style.borderColor = "";
        }
    }
    function isInt(value) {
        var x;
        return isNaN(value) ? !1 : (x = parseFloat(value), (0 | x) === x);
    }
    function check_series(element) {
        if (element.value.length == 4 && isInt(element.value) && !(element.value == "")) {
            document.getElementById("submit").disabled = false;
            element.style.borderColor = "";
        } else {
            document.getElementById("submit").disabled = true;
            element.style.borderColor = "E05858";
        }
    }
    function check_email(element) {
        var emailvalid = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if (element.value.match(emailvalid) && !(element.value == "")) {
            document.getElementById("submit").disabled = false;
            element.style.borderColor = "";
        } else {
            document.getElementById("submit").disabled = true;
            element.style.borderColor = "E05858";
        }
    }
    function check_numb(element) {
        if (element.value.length == 6 && isInt(element.value) && !(element.value == "")) {
            document.getElementById("submit").disabled = false;
            element.style.borderColor = "";
        } else {
            document.getElementById("submit").disabled = true;
            element.style.borderColor = "E05858";
        }
    }

</script>
</body>
</html>
