<%@ page import="Data.User" %>
<%@ page import="DAO.Dao" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <title>Show Single Person</title>
</head>

<script src=/script/js_validators.js></script>
<form id='person_form' action="/person" method="get">
  <input type="submit" value="create" id="create">
  <input type="hidden" name="action" value="create">
  <body>

  <table border=1>
    <caption>Person</caption>
    <tbody>
    <tr>
      <td>passport_data</td><td><input type="text" onchange="validate_name(this, this.form)" name="passport_data"></td>
      <th>&nbsp;</th>
      <td>birthday</td><td><input type="text" onchange="validate_name(this, this.form)"name="birthday"></td>
    </tr>
    <tr>
      <td>name</td><td><input type="text" onchange="validate_name(this, this.form)" name="name"></td>
      <th>&nbsp;</th>
      <td>surname</td><td><input type="text" onchange="validate_name(this, this.form)" name="surname" ></td>
    </tr>

    </tbody>
  </table>
  </body>
</form>
</html>