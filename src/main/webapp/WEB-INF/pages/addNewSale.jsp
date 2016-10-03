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
  <title>Add new sale</title>
</head>
<body>
<form role="form" enctype="multipart/form-data" class="form-horizontal" action="sale_save" method="post">

  <p><b>Адрес филиала:</b>
    <select id="branchAddress" name="branchAddress">
      <c:forEach items="${brns}" var="brn">
        <option value="${brn.idBranch}">${brn.address}</option>
      </c:forEach>
    </select>
  </p>
  <p> <b>Лекарство:</b>
    <select id="medicineName" name="medicineName">
      <c:forEach items="${mdns}" var="mdn">
        <option value="${mdn.idMedicine}">${mdn.medicinename}</option>
      </c:forEach>
    </select>
  </p>
  <p><b>Количество лекарств на складе:</b>
    <input type="text" name="inStock" size="70" placeholder="Введите кол-во в наличии">
  </p>
  <p><b>Количество проданных:</b>
    <input type="text" name="sold" size="70" placeholder="Введите кол-во проданных">
  </p>

  <input type="submit" class="btn btn-primary" value="Add">
</form>
<FORM><INPUT Type="button" VALUE="Back" onClick="history.go(-1);return true;"></FORM>
</body>
</html>
