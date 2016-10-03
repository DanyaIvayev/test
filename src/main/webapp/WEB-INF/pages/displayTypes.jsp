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
  <form class="form-inline" role="form" action="add_type" method="post">
    <input type="submit" class="btn btn-default" value="Add new type">
  </form>
  <table class="table table-striped">
    <thead>
    <tr>
      <td><b>idType</b></td>
      <td><b>Type Name</b></td>
    </tr>
    </thead>
    <c:forEach items="${types}" var="type">
      <tr>
        <td>${type.idType}</td>
        <td>${type.typename}</td>
      </tr>
    </c:forEach>
  </table>
  <FORM><INPUT Type="button" VALUE="Back" onClick="history.go(-1);return true;"></FORM>


</div>
</body>
</html>