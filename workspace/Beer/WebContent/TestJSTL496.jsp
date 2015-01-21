<%-- 
    Document   : TestJSTL496
    Created on : Jan 15, 2015, 8:40:30 PM
    Author     : hoangnv
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>c:catch</title>
    </head>
    <body>
        About to do a risky thing: <br>
        <c:catch>
            <% int x = 10 / 0;%>
        </c:catch>
        If you see this, we survived.
    </body>
</html>
