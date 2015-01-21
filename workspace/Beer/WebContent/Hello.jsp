<%-- 
    Document   : jspforward
    Created on : Jan 11, 2015, 10:30:34 PM
    Author     : hoangnv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>jsp:forward standard action</title>
    </head>
    <body>
        Welcome to our page!
        <% if (request.getParameter("userName") == null) { %>
        <jsp:forward page="HandleIt.jsp"/>
        <% }%>
        Hello ${param.userName}
    </body>
</html>
