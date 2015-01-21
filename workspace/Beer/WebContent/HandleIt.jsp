<%-- 
    Document   : HandleIt
    Created on : Jan 11, 2015, 10:33:45 PM
    Author     : hoangnv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>jsp:forward</title>
    </head>
    <body>
        We're sorry... you need to log in again.
        <form action="Hello.jsp" method='GET'>
            Name: <input id="userName" type="text" name="userName">
            <input name="Submit" type="submit">
        </form>
    </body>
</html>
