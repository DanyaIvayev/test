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
  <title>Add new employer</title>
</head>
<body>
<form role="form" enctype="multipart/form-data" class="form-horizontal" action="employer_save" method="post">
  <p><b>Имя работника:</b>
    <input type="text" name="firstName" size="70" placeholder="Введите имя работника">
  </p>
  <p><b>Фамилия:</b>
    <input type="text" name="secondName" size="70" placeholder="Введите фамилию">
  </p>
  <p><b>Отчество:</b>
    <input type="text" name="patronymic" size="70" placeholder="Введите отчество">
  </p>
  <p><b>ИНН:</b>
    <input type="text" name="inn" size="70" placeholder="Введите ИНН">
  </p>
  <p><b>Серия паспорта:</b>
    <input type="text" name="serialOfPassport" size="70" placeholder="Введите серию паспорта">
  </p>
  <p><b>Номер паспорта:</b>
    <input type="text" name="numberOfPassport" size="70" placeholder="Введите номер паспорта">
  </p>
  <p><b>Адрес филиала:</b>
    <select id="branchAddress" name="branchAddress">
      <c:forEach items="${brns}" var="brn">
        <option value="${brn.idBranch}">${brn.address}</option>
      </c:forEach>
    </select>
  </p>
  <p> <b>Должность:</b>
    <select id="positionName" name="positionName">
      <c:forEach items="${psns}" var="psn">
        <option value="${psn.idPosition}">${psn.positionname}</option>
      </c:forEach>
    </select>
  </p>
  <input type="submit" class="btn btn-primary" value="Add">
</form>
<FORM><INPUT Type="button" VALUE="Back" onClick="history.go(-1);return true;"></FORM>
</body>
</html>
