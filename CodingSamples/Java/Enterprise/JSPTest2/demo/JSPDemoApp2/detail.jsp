<%@taglib prefix="c" uri="jakarta.tags.core" %>
<% response.setHeader("Cache-Control", "no-store"); %>
<jsp:useBean id="customer" class="model.CustomerBean" scope="session"/>
<c:if test="${empty customer.id}">
    <c:redirect url="index.jsp"/>
</c:if>
<html>
    <head>
        <title>Demo App</title>
    </head>
    <body>
        <h1>Welcome Customer ${customer.id}</h1>
        <h3>Your Orders</h3>
        <table border="1">
            <tr>
                <th>Product No</th>
                <th>Quantity</th>
                <th>Order Date</th>
            </tr>
            <c:forEach var="entry" items="${customer.orders}">
                <tr>
                    <td>${entry.productNo}</td>
                    <td>${entry.quantity}</td>
                    <td>${entry.orderDate}</td>
                </tr>
            </c:forEach>
        </table>
        <p>
            <a href="index.jsp?signout=true">Logout</a>
        </p>
    </body>
</html>
