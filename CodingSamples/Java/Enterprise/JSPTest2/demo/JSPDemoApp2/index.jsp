<%@taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:useBean id="customer" class="model.CustomerBean" scope="session"/>
<jsp:setProperty name="customer" property="*"/>
<c:if test="${param.signout}">
    <c:set target="${customer}" property="id"/>
    <c:set target="${customer}" property="password"/>
    <c:redirect url="index.jsp"/>
</c:if>
<html>
    <head>
        <title>DemoApp</title>
    </head>
    <body>
        <h1>Welcome Customer</h1>
        <h3>Please Sign In</h3>
        <form method="post">
            <p>
                <b>Customer ID</b><br/>
                <input type="text" name="id"/>
            </p>
            <p>
                <b>Password</b><br/>
                <input type="password" name="password"/>
            </p>     
            <p>
                <input type="submit" name="submit" value="Login"/>
            </p>       
        </form>
        <c:if test="${param.submit == 'Login'}">
            <c:choose>
                <c:when test="${customer.authenticate()}">
                    <c:redirect url="detail.jsp"/>
                </c:when>
                <c:otherwise>
                    <p>
                        <i>Invalid Customer ID or Password</i>
                    </p>
                </c:otherwise>
            </c:choose>
        </c:if>
    </body>
</html>
