<%--
  Created by IntelliJ IDEA.
  User: Дамир
  Date: 20.09.2016
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new branch</title>
</head>
<body>
<form role="form" enctype="multipart/form-data" class="form-horizontal" action="add_save" method="post">
  <p><b>Адрес филиала:</b>
    <input type="text" name="branchName" size="70" placeholder="Введите адрес филиала">
  </p>
  <p><b>Телефон</b>
    <input type="text" name="phone" size="70" placeholder="Введите номер телефона">
  </p>
  <input type="submit" class="btn btn-primary" value="Add">
</form>
<FORM><INPUT Type="button" VALUE="Back" onClick="history.go(-1);return true;"></FORM>
</body>
</html>
