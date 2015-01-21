<%-- 
    Document   : inputComments
    Created on : Jan 14, 2015, 9:54:30 PM
    Author     : hoangnv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comment page</title>
    </head>
    <body>
        <form action="commentProcess.jsp" method="POST">
            Add your comment: <br>
            <textarea name="input" cols="40" rows="40"></textarea><br>
            <input name="commentSubmit" type="button" value="Add comment">
        </form>
    </body>
</html>
