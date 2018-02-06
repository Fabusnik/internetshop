<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<section>
    <h2><a href="/shop">Home</a></h2>
    <h3>Edit user</h3>
    <hr>
    <jsp:useBean id="goods" scope="request" type="ru.fab.model.Goods"/>
    <form method="post" action="goods">
        <input type="hidden" name="id" value="${goods.id}">
        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value="${goods.name}" name="name"></dd>
        </dl>
        <dl>
            <dt>Description:</dt>
            <dd><input type="text" value="${goods.description}" name="description"></dd>
        </dl>
        <dl>
            <dt>Price:</dt>
            <dd><input type="number" value="${goods.price}" name="price"></dd>
        </dl>
        <dl>
            <dt>Stock:</dt>
            <dd><input type="number" value="${goods.stock}" name="stock"></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form>
</section>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
