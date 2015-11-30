<%@ page import="DAO.Dao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>DataBase web app</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<%
    try {
        request.setAttribute("users", new Dao().getUsers());
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
%>

<div class="container">
    <h2 align="center">Table of users</h2>
    <table class="table  table-striped table-bordered">
        <thead>
        <tr>
            <th>FirstName</th>
            <th>LastName</th>
            <th>Email</th>
            <th>Age</th>
            <th>Passport Series</th>
            <th>Passport Number</th>
            <th>Link to view</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="User">
            <tr>
                <td><c:out value="${User.name}"/></td>
                <td><c:out value="${User.surname}"/></td>
                <td><c:out value="${User.email}"/></td>
                <td><c:out value="${User.age}"/></td>
                <td><c:out value="${User.getpassSeries()}"/></td>
                <td><c:out value="${User.getpassNumb()}"/></td>
                <td>link</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>
</body>
</html>
