<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Pharmacy</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h3>Branches List</h3>
  <form class="form-inline" role="form" action="add_employer" method="post">
    <input type="submit" class="btn btn-default" value="Add new employer">
  </form>
  <table class="table table-striped">
    <thead>
    <tr>
      <td><b>idEmployer</b></td>
      <td><b>First Name</b></td>
      <td><b>Second Name</b></td>
      <td><b>Patronymic</b></td>
      <td><b>Inn</b></td>
      <td><b>Passport</b></td>
      <td><b>Branch Address</b></td>
      <td><b>Position</b></td>
    </tr>
    </thead>
    <c:forEach items="${emps}" var="emp">
      <tr>
        <td>${emp.idEmployer}</td>
        <td>${emp.firstname}</td>
        <td>${emp.secondname}</td>
        <td>${emp.patronymic}</td>
        <td>${emp.inn}</td>
        <td>Serial: ${emp.serialofpassport} Number: ${emp.numberofpassport}</td>
        <td>${emp.branch.address}</td>
        <td>${emp.position.positionname}</td>
      </tr>
    </c:forEach>
  </table>
  <FORM><INPUT Type="button" VALUE="Back" onClick="history.go(-1);return true;"></FORM>


</div>
</body>
</html>