<%-- 
    Document   : TestEL473
    Created on : Jan 14, 2015, 5:09:34 AM
    Author     : hoangnv
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach var="listElement" items="${movies}">
            <c:forEach var="movie" items="${listElement}">
            <tr>
                <td>${movie}</td>
            </tr>
        </c:forEach>
    </c:forEach>
</body>
</html>
