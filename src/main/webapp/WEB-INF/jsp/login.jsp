<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<h2>
    <a href="register">Registered</a>
</h2>
<form action="spring_security_check" method="post">
    <c:if test="${param.error == true}">
        <div class="error">
            <h3>Bad credential</h3>
        </div>
    </c:if>
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
