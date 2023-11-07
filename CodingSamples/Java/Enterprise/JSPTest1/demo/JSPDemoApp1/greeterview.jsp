<jsp:useBean id="greeter" class="components.GreeterBean" scope="application"/>
<jsp:setProperty name="greeter" property="person" param="guest"/>
<jsp:setProperty name="greeter" property="period"/>
<html>
    <head>
        <title>DemoApp</title>
    </head>
    <body>
        <h1>${greeter.greetingMessage}</h1>
        <form method="post">
            <p>
                <b>Person:</b>
                <input type="text" name="guest"/>
            </p>
            <p>
                <b>Period</b>
                <select name="period">
                    <option>Night</option>
                    <option>Morning</option>
                    <option>Afternoon</option>
                    <option>Evening</option>
                </select>
            </p>
            <input type="submit" value="Greet"/>
            <p>
                <b>Number of Greetings: </b>${greeter.greetCount}
            </p>
        </form>
    </body>
</html>
