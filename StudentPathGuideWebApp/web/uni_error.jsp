<%-- 
    Document   : uni_error
    Created on : 02 May 2026, 23:56:50
    Author     : Esther
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h2 style="color: red">Error!</h2>
        
        <%
            String error = (String)request.getAttribute("error");
        %>
        
        <h4><%= error %></h4>
        
        <p>Click <a href="explore_varsity.jsp">here</a> to go back.</p>
    </body>
</html>
