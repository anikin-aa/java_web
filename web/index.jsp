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
        <INPUT type="button" value="Add Row" class="pure-button pure-button-primary"
               onclick="addRow('dataTable')"/>
        <INPUT type="button" value="Delete Row" class="pure-button pure-button-primary"
               onclick="deleteRow('dataTable')"/>
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
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="User">
            <tr>
                <td><INPUT type="checkbox" name="chk"/> <input type="hidden" name="id"
                                                               value="<c:out value="${User.id}"></c:out>"/></td>
                <td><a href="/view?id=<c:out value="${User.id}"></c:out>"><c:out value="${User.name}"/></a></td>
                <td><c:out value="${User.surname}"/></td>
                <td><c:out value="${User.email}"/></td>
                <td><c:out value="${User.age}"/></td>
                <td><c:out value="${User.getpassSeries()}"/></td>
                <td><c:out value="${User.getpassNumb()}"/></td>
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

            var newcell = row.insertCell(i);

            newcell.innerHTML = table.rows[0].cells[i].innerHTML;
            //alert(newcell.childNodes);
            switch (newcell.childNodes[0].type) {
                case "text":
                    newcell.childNodes[0].value = "";
                    break;
                case "checkbox":
                    newcell.childNodes[0].checked = false;
                    break;
                case "select-one":
                    newcell.childNodes[0].selectedIndex = 0;
                    break;
            }
        }
    }

    function deleteRow(tableID) {
        try {
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
                    table.deleteRow(i);
                    rowCount--;
                    i--;
                }


            }
        } catch (e) {
            alert(e);
        }
    }

</SCRIPT>
</body>
</html>
