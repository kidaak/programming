<%-- 
    Document   : TestJSTL487
    Created on : Jan 15, 2015, 4:39:42 AM
    Author     : hoangnv
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customize c:import</title>
    </head>
    <body>
        <c:import url="Header.jsp">
            <c:param name="subTitle" value="We take the sting out of SOAP."/>
        </c:import>
        <br>
        <em>Welcome to our Web Services Support Group.</em><br><br>
        Contact us at: ${initParam.mainEmail}
    </body>
</html>
