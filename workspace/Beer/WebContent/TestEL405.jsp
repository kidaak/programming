<%-- 
    Document   : TestEL405
    Created on : Jan 10, 2015, 4:34:33 AM
    Author     : hoangnv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL Expression Page 405</title>
    </head>
    <body>
        ${person.name}'s dog ${person.dog.name}'s toys are: ${person.dog.toys[0].name}, 
        ${person.dog.toys[1].name}, and a ${person.dog.toys[2].name}
    </body>
</html>
