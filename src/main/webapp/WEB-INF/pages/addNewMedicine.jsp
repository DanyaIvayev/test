<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <title>Add new medicine</title>
</head>
<body>
<form role="form" enctype="multipart/form-data" class="form-horizontal" action="medicine_save" method="post">
  <p><b>Название лекарства:</b>
    <input type="text" name="medicineName" size="70" placeholder="Введите название лекарства">
  </p>
  <p><b>Цена:</b>
    <input type="text" name="price" size="70" placeholder="Введите цену">
  </p>
  <p><b>Страна производства:</b>
    <input type="text" name="country" size="70" placeholder="Введите страну производства">
  </p>

  <p><b>Тип:</b>
    <select id="type" name="type">
      <c:forEach items="${types}" var="type">
        <option value="${type.idType}">${type.typename}</option>
      </c:forEach>
    </select>
  </p>
  <input type="submit" class="btn btn-primary" value="Add">
</form>
<FORM><INPUT Type="button" VALUE="Back" onClick="history.go(-1);return true;"></FORM>
</body>
</html>
