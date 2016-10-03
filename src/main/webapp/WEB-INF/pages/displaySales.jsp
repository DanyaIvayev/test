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
  <h3>Sales List</h3>
  <form class="form-inline" role="form" action="add_sale" method="post">
    <input type="submit" class="btn btn-default" value="Add new sale">
  </form>
  <table class="table table-striped">
    <thead>
    <tr>
      <td><b>Branch Address</b></td>
      <td><b>Medicine Name</b></td>
      <td><b>In stock</b></td>
      <td><b>Sold</b></td>
    </tr>
    </thead>
    <c:forEach items="${sales}" var="sls">
      <tr>
        <td>${sls.medicine.medicinename}</td>
        <td>${sls.branch.address}</td>
        <td>${sls.instock}</td>
        <td>${sls.sold}</td>
      </tr>
    </c:forEach>
  </table>
  <FORM><INPUT Type="button" VALUE="Back" onClick="history.go(-1);return true;"></FORM>


</div>
</body>
</html>