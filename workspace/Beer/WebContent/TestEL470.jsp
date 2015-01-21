<%-- 
    Document   : TestEL470
    Created on : Jan 14, 2015, 4:53:10 AM
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
        <table>
            <c:forEach var="movie" items="${movieList}" varStatus="movieStatus">
                <tr>
                    <td>Count: ${movieStatus.count}</td>
                </tr>
                <tr>
                    <td>${movie}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
