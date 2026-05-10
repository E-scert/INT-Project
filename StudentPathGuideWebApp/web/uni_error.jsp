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
        <link rel="stylesheet"
    href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon_names=arrow_back_ios_new,search" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"> 
    <link rel="stylesheet" href="style/style.css">
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
