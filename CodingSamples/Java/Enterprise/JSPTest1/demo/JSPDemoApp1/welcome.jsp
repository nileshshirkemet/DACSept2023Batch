<jsp:useBean id="now" class="java.util.Date"/>
<html>
    <head>
        <title>DemoApp</title>
    </head>
    <body>
        <h1>Welcome Visitor ${param.user}</h1>
        <b>Current Time: </b>${now}
    </body>
</html>
