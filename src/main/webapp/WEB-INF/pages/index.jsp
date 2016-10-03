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
    <%--<h3>Branches List</h3>--%>

    <%--<table class="table table-striped">--%>
        <%--<thead>--%>
        <%--<tr>--%>
            <%--<td><b>idBranch</b></td>--%>
            <%--<td><b>Address</b></td>--%>
            <%--<td><b>Phone</b></td>--%>
        <%--</tr>--%>
        <%--</thead>--%>
        <%--<c:forEach items="${advs}" var="adv">--%>
            <%--<tr>--%>
                <%--<td>${adv.idBranch}</td>--%>
                <%--<td>${adv.address}</td>--%>
                <%--<td>${adv.phone}</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
    <%--</table>--%>
        <form class="form-inline" role="form" action="displayBranches" method="get">
            <input type="submit" class="btn btn-default" value="Display branches">
        </form>
        <form class="form-inline" role="form" action="displayProviders" method="get">
            <input type="submit" class="btn btn-default" value="Display providers">
        </form>
        <form class="form-inline" role="form" action="displayPositions" method="get">
            <input type="submit" class="btn btn-default" value="Display positions">
        </form>
        <form class="form-inline" role="form" action="displayEmployers" method="get">
            <input type="submit" class="btn btn-default" value="Display employers">
        </form>
        <form class="form-inline" role="form" action="displayMedicines" method="get">
            <input type="submit" class="btn btn-default" value="Display medicines">
        </form>
        <form class="form-inline" role="form" action="displaySales" method="get">
            <input type="submit" class="btn btn-default" value="Display sales">
        </form>
        <form class="form-inline" role="form" action="displayBranchProviders" method="get">
            <input type="submit" class="btn btn-default" value="Display branch-providers">
        </form>
        <form class="form-inline" role="form" action="displayTypes" method="get">
            <input type="submit" class="btn btn-default" value="Display types">
        </form>
</div>
</body>
</html>