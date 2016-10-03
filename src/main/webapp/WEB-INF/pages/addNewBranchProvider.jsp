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
<form role="form" enctype="multipart/form-data" class="form-horizontal" action="branchProvider_save" method="post">

  <p><b>Адрес филиала:</b>
    <select id="branchAddress" name="branchAddress">
      <c:forEach items="${brns}" var="brn">
        <option value="${brn.idBranch}">${brn.address}</option>
      </c:forEach>
    </select>
  </p>
  <p> <b>Поставщик:</b>
    <select id="providerName" name="providerName">
      <c:forEach items="${prds}" var="pds">
        <option value="${pds.idProvider}">${pds.providername}</option>
      </c:forEach>
    </select>
  </p>
  <p> <b>День поставки:</b>
    <select id="dayOfBilievery" name="dayOfBilievery">
        <option value="Понедельник">Понедельник</option>
      <option value="Вторник">Вторник</option>
      <option value="Среда">Среда</option>
      <option value="Четверг">Четверг</option>
      <option value="Пятница">Пятница</option>
      <option value="Суббота">Суббота</option>
      <option value="Воскресение">Воскресение</option>
    </select>
  </p>

  <input type="submit" class="btn btn-primary" value="Add">
</form>
<FORM><INPUT Type="button" VALUE="Back" onClick="history.go(-1);return true;"></FORM>
</body>
</html>
