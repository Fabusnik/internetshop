<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<section>
    <h2><a href="/shop">Home</a></h2>
    <h3>Edit user</h3>
    <hr>


    <form:form method="post" action="goods" modelAttribute="goods">
        <form:input path="id" type="hidden"/>
        <dl>
            <dt>Name:</dt>
            <dd><form:input path="name" type="text" value="${goods.name}" name="name"/></dd>
            <dd><form:errors path="name" cssClass="error"/></dd>
        </dl>
        <dl>
            <dt>Description:</dt>
            <dd><form:input path="description" type="text" value="${goods.description}" name="description"/></dd>
            <dd><form:errors path="description" cssClass="error"/></dd>
        </dl>
        <dl>
            <dt>Price:</dt>
            <dd><form:input path="price" type="number" value="${goods.price}" name="price"/></dd>
            <dd><form:errors path="price" cssClass="error"/></dd>
        </dl>
        <dl>
            <dt>Stock:</dt>
            <dd><form:input path="stock" type="number" value="${goods.stock}" name="stock"/></dd>
            <dd><form:errors path="stock" cssClass="error"/></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
        </table>
    </form:form>
</section>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
