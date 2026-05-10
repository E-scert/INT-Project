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
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Admin</h1>
        <h3>Welcome admin</h3>
        <p>Please select an option below</p>
        <ol>
            <li><a href="list_all.jsp">List All students in the database</a></li>
            <li><a href="list_student_based_aps.jsp">List All based on APS scores</a></li>
            <li><a href="list_students_based_on_min_max_aps.jsp">List All students based on min APS and max APS</a></li>
            <li><a href="list_students_based_on_grade.jsp">List All students based on a specific grade</a></li>
            <li><a href="">List All students based on field of interest</a></li>
            
        </ol>
    </body>
</html>
