<%@ page import="ru.fab.model.Purchase" %>
<%@ page import="ru.fab.util.PurchaseUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<h2>Purchase List</h2>
<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>Date</th>
        <th>Buyer</th>
        <th>Name</th>
        <th>Cost</th>
        <th>Amount</th>
    </tr>
    <c:forEach items="${purchaseList}" var="purchases">
        <jsp:useBean id="purchases" scope="page" type="ru.fab.model.Purchase"/>
        <tr>
            <td>
                <fmt:parseDate value="${purchases.datePurchase}" pattern="y-M-dd'T'H:m" var="parsedDate"/>
                <fmt:formatDate value="${parsedDate}" pattern="yyyy.MM.dd HH:mm"/>
                <%--<%=PurchaseUtil.toString(purchases.getDatePurchase())%>--%>
            </td>
            <td>${purchases.user.name}</td>
            <td>${purchases.goods.name}</td>
            <td>${purchases.cost}</td>
            <td>${purchases.amount}</td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
