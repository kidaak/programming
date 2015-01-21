<%-- 
    Document   : TestEL469
    Created on : Jan 14, 2015, 4:47:28 AM
    Author     : hoangnv
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>c:out with null value</title>
    </head>
    <body>
        <b>Hello <c:out default="guest" value="${user}"/></b>
    </body>
</html>
