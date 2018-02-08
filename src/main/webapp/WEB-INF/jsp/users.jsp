<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<h2>User List</h2>
<h2>
<a href="users/create">Add User</a>
</h2>
<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>Name</th>
        <th>Roles</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${userList}" var="user">
        <jsp:useBean id="user" scope="page" type="ru.fab.model.User"/>
        <tr>
            <td>${user.name}</td>
            <td>${user.roles}</td>
            <td><a href="users/update?id=${user.id}">Edit</a></td>
            <td><a href="users/delete?id=${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
