<%-- 
    Document   : TestEL421
    Created on : Jan 11, 2015, 6:15:56 PM
    Author     : hoangnv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test EL operators page 421</title>
    </head>
    <body>
        ${num > 3}
        ${integer le 12}
        ${requestScope["integer"] ne 4 and 6 le num || false}
        ${list[0] || list["1"] and true}
        ${num > integer}
        ${num == integer - 1}
        <jsp:useBean class="com.example.model.Dog" id="myDog">
            <jsp:setProperty name="myDog" property="name" value="${list[1]}"/>
        </jsp:useBean>
        ${myDog.name and true}
        ${42 div 0}
    </body>
</html>
