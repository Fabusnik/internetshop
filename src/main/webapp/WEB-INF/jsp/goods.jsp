<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<h2>Goods List</h2>

<a href="goods/create">Add goods</a>
<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Stock</th>
        <th/>
        <th/>
        <th/>
    </tr>
    <c:forEach items="${goodsList}" var="goods">
        <jsp:useBean id="goods" scope="page" type="ru.fab.model.Goods"/>
        <tr>
            <td>${goods.name}</td>
            <td>${goods.description}</td>
            <td>${goods.price}</td>
            <td>${goods.stock}</td>
            <td>
                <form action="goods/buy" method="post">
                    <input type="hidden" name="goodsId" value="${goods.id}">
                    <input type="number" style="width: 40px" name="amount"/>
                    <button type="submit">Buy</button>
                </form>
            </td>
            <td><a href="goods/update?id=${goods.id}">Edit</a></td>
            <td><a href="goods/delete?id=${goods.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
