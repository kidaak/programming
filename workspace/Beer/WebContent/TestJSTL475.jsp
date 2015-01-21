<%-- 
    Document   : TestJSTL475
    Created on : Jan 14, 2015, 9:53:13 PM
    Author     : hoangnv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>c:if</title>
    </head>
    <body>
        <strong>Member Comments</strong><br>
        <hr>${commentList}<hr>
        <c:if test="${userType eq 'member'}">
            <jsp:include page="inputComments.jsp"></jsp:include>
        </c:if>
    </body>
</html>
