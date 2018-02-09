<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<section>
    <h2><a href="/shop">Home</a></h2>
    <h3>${register ? "Register" : "Edit user"}</h3>
    <hr>
    <jsp:useBean id="user" scope="request" type="ru.fab.model.User"/>
    <form method="post" action="register">
        <input type="hidden" name="id" value="${user.id}">
        <input type="hidden" name="role" value="${user.roles}">
        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value="${user.name}" name="name"></dd>
        </dl>
        <dl>
            <dt>Password:</dt>
            <dd><input type="password" value="${user.password}" name="password"></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
