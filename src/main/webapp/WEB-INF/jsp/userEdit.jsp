<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<section>
    <h2><a href="/shop">Home</a></h2>
    <h3>${register ? "Register" : "Edit user"}</h3>
    <hr>


    <form:form method="post" action="register" modelAttribute="user">

        <form:input path="id" type="hidden"/>
        <form:input path="roles" type="hidden"/>
        <dl>
            <dt>Name:</dt>
            <dd><form:input path="name" type="text"/></dd>
            <dd><form:errors path="name" cssClass="error"/></dd>
        </dl>
        <dl>
            <dt>Password:</dt>
            <dd><form:input path="password" type="password"/></dd>
            <dd><form:errors path="password" cssClass="error"/></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form:form>


</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
