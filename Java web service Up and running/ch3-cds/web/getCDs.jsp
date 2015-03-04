<%-- 
    Document   : getCDs
    Created on : Feb 1, 2015, 10:03:03 AM
    Author     : hoangnv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="fetcher" class="cds.FetchXML" type="cds.FetchXML">
</jsp:useBean>
<jsp:getProperty name="fetcher" property="json"></jsp:getProperty>
