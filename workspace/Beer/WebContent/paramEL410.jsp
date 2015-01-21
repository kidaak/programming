<%-- 
    Document   : paramEL410
    Created on : Jan 10, 2015, 5:07:45 AM
    Author     : hoangnv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>param and paramValue in EL expression</title>
    </head>
    <body>
        Request param name is: ${param.name} <br>
        Request param empID is: ${param.empID} <br>
        Request param food is: ${param.food} <br>
        First food request param: ${paramValues.food[0]} <br>
        Second food request param: ${paramValues.food[1]} <br>
        Request param name: ${paramValues.name[0]}
        <%--TEST ${param.food[0]} exception --%>
    </body>
</html>
