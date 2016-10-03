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
  <h3>Branch Provider List</h3>
  <form class="form-inline" role="form" action="add_branchProvider" method="post">
    <input type="submit" class="btn btn-default" value="Add new sale">
  </form>
  <table class="table table-striped">
    <thead>
    <tr>
      <td><b>Branch Address</b></td>
      <td><b>Provider Name</b></td>
      <td><b>Day of Bilievery</b></td>
    </tr>
    </thead>
    <c:forEach items="${bpds}" var="bps">
      <tr>
        <td>${bps.provider.providername}</td>
        <td>${bps.branch.address}</td>
        <td>${bps.dayOfBilevery}</td>
      </tr>
    </c:forEach>
  </table>
  <FORM><INPUT Type="button" VALUE="Back" onClick="history.go(-1);return true;"></FORM>


</div>
</body>
</html>