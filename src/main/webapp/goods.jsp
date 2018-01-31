<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Goods</title>
</head>
<body>
<h2>Goods List</h2>
<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Stock</th>
    </tr>
    <c:forEach items="${goodsList}" var="goods">
        <jsp:useBean id="goods" scope="page" type="ru.fab.model.Goods"/>
        <tr>
            <td>${goods.name}</td>
            <td>${goods.description}</td>
            <td>${goods.price}</td>
            <td>${goods.stock}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
