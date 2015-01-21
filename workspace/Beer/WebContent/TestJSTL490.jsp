<%-- 
    Document   : TestJSTL490
    Created on : Jan 15, 2015, 5:03:24 AM
    Author     : hoangnv
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>URL Encoding</title>
    </head>
    <body>
        <c:set var="last" value="Hidden Cursor"></c:set>
        <c:set var="first" value="Crouching Pixels"></c:set>
        <c:url value="/inputComments.jsp?first=${first}&last=${last}" var="inputURL"/>
        The URL using params is: ${inputURL} <br>

        <c:url value="/inputComments.jsp" var="inputURL">
            <c:param name="firstName" value="${first}"/>
            <c:param name="lastName" value="${last}"/>
        </c:url>
        The URL using params is: ${inputURL} <br>
    </body>
</html>
