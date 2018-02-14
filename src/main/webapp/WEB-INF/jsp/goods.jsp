<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<h2>Goods List</h2>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <h2><a href="goods/admin/create">Add goods</a></h2>
    <h2><a href="purchases">View purchases</a></h2>
</sec:authorize>


<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Stock</th>
        <sec:authorize access="hasRole('ROLE_USER')">
            <th/>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <th/>
            <th/>
        </sec:authorize>
    </tr>
    <c:forEach items="${goodsList}" var="goods">
        <jsp:useBean id="goods" scope="page" type="ru.fab.model.Goods"/>
        <tr>
            <td>${goods.name}</td>
            <td>${goods.description}</td>
            <td>${goods.price}</td>
            <td>${goods.stock}</td>
            <sec:authorize access="hasRole('ROLE_USER')">
                <td>
                    <form action="goods/buy" method="post">
                        <input type="hidden" name="goodsId" value="${goods.id}">
                        <input type="number" style="width: 40px" name="amount"/>
                        <button type="submit">Buy</button>
                    </form>
                </td>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <td>
                    <a href="goods/admin/update?id=${goods.id}">Edit</a>
                </td>
                <td><a href="goods/admin/delete?id=${goods.id}">Delete</a></td>
            </sec:authorize>
        </tr>
    </c:forEach>
</table>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
