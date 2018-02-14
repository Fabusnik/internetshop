<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<h1>Страница ошибки </h1>
<a href="goods">Home</a>


<p>This is message from ExceptionHandler:</p>
<b>${exceptionMsg}</b>


<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
