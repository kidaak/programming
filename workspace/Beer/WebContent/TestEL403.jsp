<%-- 
    Document   : TestEL
    Created on : Jan 10, 2015, 3:48:22 AM
    Author     : hoangnv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL Expression</title>
    </head>
    <body>
        Music is ${musicList[numbers[0]]}<br>
        ${musicList[numbers[0]+1]}<br>
        ${musicList[numbers["2"]]}<br>
        ${musicList[numbers[numbers[1]]]}<br>
    </body>
</html>
