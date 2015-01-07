<%-- 
    Document   : Testbean
    Created on : Jan 8, 2015, 4:20:32 AM
    Author     : hoangnv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="person" type="com.example.model.Person" class="com.example.model.Employee">
            <jsp:setProperty name="person" property="*"/>
        </jsp:useBean>
        Name is: <jsp:getProperty name="person" property="name"/>
        ID: <jsp:getProperty name="person" property="empID"/>
    </body>
</html>
