<%-- 
    Document   : errorPage
    Created on : Jan 15, 2015, 5:13:14 AM
    Author     : hoangnv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error page</title>
    </head>
    <body>
        You caused a ${pageContext.exception} on the server. <br>
        <img src="images/error.png">
    </body>
</html>
