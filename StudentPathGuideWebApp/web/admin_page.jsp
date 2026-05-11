<%-- 
    Document   : admin_page
    Created on : May 10, 2026, 3:45:42 PM
    Author     : JREscert
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
        <title>Admin Page</title>
    </head>
    <body>
        <h1 class="section head">Admin</h1>
        <div style="text-align: center;font-size: 1.75rem;">
            <h3>Welcome admin</h3>
        <p>Please select an option below</p>
        </div>
        
        <ol class="admin_options">

            <li><a href="list_all.jsp">List All students in the database</a></li>
            <li><a href="list_student_based_aps.jsp">List All based on APS scores</a></li>
            <li><a href="list_students_based_on_min_max_aps.jsp">List All students based on min APS and max APS</a></li>
            <li><a href="list_students_based_on_grade.jsp">List All students based on a specific grade</a></li>
            <li><a href="list_students_based_on_field.jsp">List All students based on field of interest</a></li>
            
        </ol>
    </body>
</html>
