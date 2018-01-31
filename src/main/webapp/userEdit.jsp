<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h2><a href="/shop">Home</a></h2>
    <h3>Edit user</h3>
    <hr>
    <jsp:useBean id="user" scope="request" type="ru.fab.model.User"/>
    <form method="post" action="users">
        <input type="hidden" name="id" value="${user.id}">
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
</body>
</html>
