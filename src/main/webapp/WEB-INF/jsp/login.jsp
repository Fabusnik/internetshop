<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<%--<form action="<c:url value="/j_spring_security_check" />" method="post">--%>
<form action="spring_security_check" method="post">
    <dl>
        <dt>Name:</dt>
        <dd><input type="text" placeholder="Name" name="username"></dd>
    </dl>
    <dl>
        <dt>Password:</dt>
        <dd><input type="password" placeholder="Password" name="password"></dd>
    </dl>
    <button type="submit">Ok</button>
    <button onclick="window.history.back()">Cancel</button>
</form>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
