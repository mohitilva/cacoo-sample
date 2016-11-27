<%-- 
    Document   : error
    Created on : Nov 23, 2016, 3:01:47 PM
    Author     : mtilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cacoo - Error</title>
    </head>
    <body>
        <h2>An error occurred. <%= request.getParameter("msg")%> </h2>
        <br>
        <a href="<%=request.getContextPath()%>/welcome.jsp"> Go back </a>
        
    </body>
</html>
