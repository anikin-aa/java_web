<%@ page import="DAO.Dao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>DataBase</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
    <script src=/js_validators.js></script>
</head>
<body>
<%
    request.setAttribute("users", new Dao().getUsers());
%>

<div class="container">

    <h2 align="center">Table of users</h2>

    <div class="pure-control-group">
        <INPUT type="button" value="Add Row" id="addBtn" class="pure-button pure-button-primary"
               onclick="addRow('dataTable')"/>
        <INPUT type="button" value="Delete Row" class="pure-button pure-button-primary"
               onclick="deleteRow('dataTable')"/>
        <a id="test" href="">
            <button class="pure-button pure-button-primary"></button>
        </a>
    </div>
    <br>
    <table id="dataTable" class="pure-table pure-table-bordered">
        <thead>
        <tr>
            <th></th>
            <th>FirstName</th>
            <th>LastName</th>
            <th>Email</th>
            <th>Age</th>
            <th>Passport Series</th>
            <th>Passport Number</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="User">
            <tr>
                <td><INPUT type="checkbox" name="chk"/> <input type="hidden" name="id"
                                                               value="<c:out value="${User.id}"></c:out>"/></td>
                <td><c:out value="${User.name}"/></td>
                <td><c:out value="${User.surname}"/></td>
                <td><c:out value="${User.email}"/></td>
                <td><c:out value="${User.age}"/></td>
                <td><c:out value="${User.getpassSeries()}"/></td>
                <td><c:out value="${User.getpassNumb()}"/></td>
                <td><a href="/?action=view&id=<c:out value="${User.id}"></c:out>">
                    <button class="pure-button pure-button-primary">Edit</button>
                </a>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<SCRIPT>
    function addRow(tableID) {

        var table = document.getElementById(tableID);

        var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);
        var colCount = table.rows[0].cells.length;
        for (var i = 0; i < colCount; i++) {
            var cell = row.insertCell(i);
            switch (i) {
                case 0:
                    cell.innerHTML = '<input type = "checkbox" name = "checkbox">';
                    break;
                case 1:
                    cell.innerHTML = '<input type= "text" onchange="" name= "name">';
                    break;
                case 2:
                    cell.innerHTML = '<input type= "text" onchange="" name= "surname">';
                    break;
                case 3:
                    cell.innerHTML = '<input type= "text" onchange="" name= "email">';
                    break;
                case 4:
                    cell.innerHTML = '<input type= "text" maxlength="3" size="3" onchange="" name= "age">';
                    break;
                case 5:
                    cell.innerHTML = '<input type= "text" maxlength="4" size="4" onchange="" name= "series">';
                    break;
                case 6:
                    cell.innerHTML = '<input type= "text" maxlength="6" size="6" onchage="" name= "number">';
                    break;
                case 7:
                    cell.innerHTML = '<INPUT type="button" value="Save" id="saveBtn" disabled class="pure-button pure-button-primary" onclick="save()"/>';
                    break;
            }
        }
        document.getElementById("addBtn").disabled = true;

    }

    function deleteRow(tableID) {
        document.getElementById("test").href = "/view?id=6";
        var table = document.getElementById(tableID);
        var rowCount = table.rows.length;
        for (var i = 0; i < rowCount; i++) {
            var row = table.rows[i];
            var chkbox = row.cells[0].childNodes[0];
            if (null != chkbox && true == chkbox.checked) {
                if (rowCount <= 1) {
                    alert("Cannot delete all the rows.");
                    break;
                }
                if (i == (rowCount - 1)) {
                    document.getElementById("addBtn").disabled = false;
                }
                table.deleteRow(i);
            }
        }
    }

    function save() {
        document.getElementById("addBtn").disabled = false;
    }

</SCRIPT>
</body>
</html>
