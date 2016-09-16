<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Details</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
    <script src=js_validators.js></script>
</head>
<body onload="check()">

<div class="container">
    <form action="" class="pure-form pure-form-aligned">
        <legend>Detailed info about user:</legend>
        <input type="hidden" name="id" id="id" value="<c:out value="${user.id}"></c:out>"/>
        <input type="hidden" name="action" id="action" value="save"/>
        <fieldset>
            <div class="pure-control-group">
                <label for="name">First Name</label>
                <input id="name" name="name" type="text" value="<c:out value="${user.name}"/>"
                       onchange="check()">
            </div>

            <div class="pure-control-group">
                <label for="surname">Last Name</label>
                <input id="surname" name="surname" type="text" value="<c:out value="${user.surname}"/>"
                       onchange="check()">
            </div>

            <div class="pure-control-group">
                <label for="email">Email Address</label>
                <input id="email" name="email" type="email" value="<c:out value="${user.email}"/>"
                       onchange="check()">
            </div>

            <div class="pure-control-group">
                <label for="age">Age of user</label>
                <input id="age" name="age" type="text" value="<c:out value="${user.age}"/>"
                       onchange="check()">
            </div>

            <div class="pure-control-group">
                <label for="position">Position</label>
                <input id="position" name="position" type="text" value="<c:out value="${user.position}"/>"
                       onchange="check()">
            </div>

            <div class="pure-control-group">
                <label for="salary">Salary</label>
                <input id="salary" name="salary" type="text" value="<c:out value="${user.getSalary()}"/>"
                       onchange="check()">
            </div>

            <div class="pure-controls">
                <button type="submit" id="submit" class="pure-button pure-button-primary">Submit
                </button>
            </div>

        </fieldset>
    </form>

</div>
<script>
    function check_string(element) {
        var regexp = /^[a-zA-Z]+$/;
        if (element.value != "" && element.value.match(regexp)) {
            element.style.borderColor = "";
            return true;
        } else {
            element.style.borderColor = "red";
            return false;
        }
    }

    function check_salary(element) {
        if ((element.value.length > 4 && element.value.length < 10 ) && isInt(element.value) && !(element.value == "")) {
            element.style.borderColor = "";
            return true;
        } else {
            element.style.borderColor = "red";
            return false;
        }
    }
    function check_age(element) {
        if (element.value.length > 1 && element.value.length < 3 && isInt(element.value) && !(element.value == "")) {
            element.style.borderColor = "";
            return true;
        } else {
            element.style.borderColor = "red";
            return false;

        }
    }
    function isInt(value) {
        var x;
        return isNaN(value) ? !1 : (x = parseFloat(value), (0 | x) === x);
    }
    function check_series(element) {
        if (element.value.length == 4 && isInt(element.value) && !(element.value == "")) {
            element.style.borderColor = "";
            return true;
        } else {
            element.style.borderColor = "red";
            return false;
        }
    }
    function check_email(element) {
        var emailvalid = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if (element.value.match(emailvalid) && !(element.value == "")) {
            element.style.borderColor = "";
            return true;
        } else {
            element.style.borderColor = "red";
            return false;
        }
    }
    function check_numb(element) {
        if (element.value.length == 6 && isInt(element.value) && !(element.value == "")) {
            element.style.borderColor = "";
            return true;
        } else {
            element.style.borderColor = "red";
            return false;
        }
    }
    function check() {
        if (check_string(document.getElementById("name"))
                && check_string(document.getElementById("surname"))
                && check_email(document.getElementById("email"))
                && check_age(document.getElementById("age"))
                && check_series(document.getElementById("series"))
                && check_salary(document.getElementById("salary"))) {
            document.getElementById("submit").disabled = false;
        } else {
            document.getElementById("submit").disabled = true;
        }
    }
</script>
</body>
</html>
