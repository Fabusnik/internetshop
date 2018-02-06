<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>


<section>
    <form method="post" action="users">
        <select name="userId">
        <option value="1" selected>Admin</option>
        <option value="2">User</option>
    </select>
        <button type="submit">Select</button>
    </form>
    <ul>
        <li><a href="goods">Goods</a></li>
        <li><a href="purchases">Purchases</a></li>
        <li><a href="users">Users</a> </li>
    </ul>
</section>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
