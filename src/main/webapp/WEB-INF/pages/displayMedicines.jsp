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
  <form class="form-inline" role="form" action="add_medicine" method="post">
    <input type="submit" class="btn btn-default" value="Add new medicine">
  </form>
  <table class="table table-striped">
    <thead>
    <tr>
      <td><b>idMedicine</b></td>
      <td><b>Medicine Name</b></td>
      <td><b>Price</b></td>
      <td><b>Country</b></td>
      <td><b>Type</b></td>
    </tr>
    </thead>
    <c:forEach items="${mdns}" var="mdn">
      <tr>
        <td>${mdn.idMedicine}</td>
        <td>${mdn.medicinename}</td>
        <td>${mdn.price}</td>
        <td>${mdn.country}</td>
        <td>${mdn.type.typename}</td>
      </tr>
    </c:forEach>
  </table>
  <FORM><INPUT Type="button" VALUE="Back" onClick="history.go(-1);return true;"></FORM>


</div>
</body>
</html>