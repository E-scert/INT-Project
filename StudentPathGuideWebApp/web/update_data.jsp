<%-- 
    Document   : update_data
    Created on : May 8, 2026, 12:52:27 PM
    Author     : JREscert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon_names=arrow_back_ios_new" />
        <link rel="stylesheet" href="style/style.css">
        <title>Update Data Page</title>
    </head>
    <body>
        <h1>UPDATE DATA</h1>

        <form action="UpdateDataServlet.do" method="GET">
            <table>
                <!--update username-->
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="username" required="" value="${name}"/></td>
                </tr>
                
                 <!--update grade-->
                <tr>
                    <td>Grade:</td>
                    <td><input type="text" name="grade" required="" value="${grade}"/></td>
                </tr>
                 
                <!-- UPDATE MARKS SECTION -->
                <tr>
                  <th>Subject</th>
                 <th>Percentage (%)</th>
                </tr>

                <!-- SUBJECT 1 -->
                <tr>
                   <td><input type="text" name="subject1" required /></td>
                   <td><input type="number" name="percentage1" min="0" max="100" required /></td>
                </tr>

                <!-- SUBJECT 2 -->
                <tr>
                   <td><input type="text" name="subject2" required /></td>
                    <td><input type="number" name="percentage2" min="0" max="100" required /></td>
                </tr>

                <!-- SUBJECT 3 -->
                <tr>
                   <td><input type="text" name="subject3" required /></td>
                   <td><input type="number" name="percentage3" min="0" max="100" required /></td>
                </tr>

                <!-- SUBJECT 4 -->
                <tr>
                   <td><input type="text" name="subject4" required /></td>
                   <td><input type="number" name="percentage4" min="0" max="100" required /></td>
                </tr>

                <!-- SUBJECT 5 -->
                <tr>
                     <td><input type="text" name="subject5" required /></td>
                   <td><input type="number" name="percentage5" min="0" max="100" required /></td>
                </tr>

                <!-- SUBJECT 6 -->
                <tr>
                   <td><input type="text" name="subject6" required /></td>
                   <td><input type="number" name="percentage6" min="0" max="100" required /></td>
                </tr>                
                <tr>
                     <td>Field of Interest</td>
                     <td><input type="text" name="fieldOfInterest" value="${field}"/></td>
                </tr>
                
                 <tr>
                     <td></td>
                     <td><input type="submit" value="SUBMIT"/></td>
                </tr>
                
            </table>
        </form>
        <ul>
            <li><a href="dashboard.jsp">Back</a></li>
        </ul>

        
    </body>
</html>
