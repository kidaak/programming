<%-- 
    Document   : TestJSTL497
    Created on : Jan 16, 2015, 10:06:43 PM
    Author     : hoangnv
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>c:catch</title>
    </head>
    <body>
        About to do a risky thing: <br>
        <c:catch var="myException">
            Inside the catch...
            <% int x = 10 / 0;%>
        </c:catch>
        <c:if test="${myException != null}">
            There was an exception: ${myException.message}
        </c:if>
        We survived.
    </body>
</html>
