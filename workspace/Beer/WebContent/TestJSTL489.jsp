<%-- 
    Document   : TestJSTL489
    Created on : Jan 15, 2015, 4:53:53 AM
    Author     : hoangnv
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>URL rewriting</title>
    </head>
    <body>
        This is a hyperlink with URL rewriting enabled.
        <a href="<c:url value="/inputComments.jsp"></c:url>">Click here.</a>
    </body>
</html>
