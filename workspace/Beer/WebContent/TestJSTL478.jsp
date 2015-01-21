<%-- 
    Document   : TestJSTL478
    Created on : Jan 15, 2015, 3:47:43 AM
    Author     : hoangnv
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>c:choose</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${userPref == 'performance'}">
                Now you can stop event if you <em>doc</em> drive insanely fast.
            </c:when>
            <c:when test="${userPref == 'safety'}">
                Our brakes will never lock up, no matter how bad a driver you are.
            </c:when>
            <c:when test="${userPref == 'maintenance'}">
                Lost your tech job? No problem -- you won't have to service these brakes for
                at least three years.
            </c:when>
            <c:otherwise>
                Our brakes are the best.
            </c:otherwise>
        </c:choose>
    </body>
</html>
