<%@ page import="Data.User" %>
<%@ page import="DAO.Dao" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <title>Show All Persons</title>
</head>
<form id='main_form' action="/person" method="get">

  <body>
  <script src=/script/js_validators.js></script>
  <%@include file="toolbar.jsp" %>
  <table border=1>
    <thead>
    <tr>
      <th><input href="#" class="checkbox" type="checkbox" onclick="selectAllChecks(document.getElementById('main_form'), this)"></th>
      <th>First Name</th>
      <th>Functions</th>
      <th>Last Name</th>
    </tr>
    </thead>
    <tbody>
    <%
      for(User p: Dao.getUsers()) {
        out.println("<tr><td><input type=\"checkbox\" class=\"checkbox\" onclick=\"selectRow(this, event);\" name=\"checkbox\" value=\"" + p.getId() + "\">");
        out.println("<td>" + p.getName());
        out.println("<td>" + "<a href=/person?action=edit&personId=" + p.getId() + " />Edit</a>&nbsp;");
        out.println("<a href=/person?action=delete&personId=" + p.getId() + " />Del</a></td>");
        out.println("<td>" + p.getSurname());
        out.print("</tr>");
      }
    %>
    </tbody>
  </table>
  </body>
</form>
</html>
