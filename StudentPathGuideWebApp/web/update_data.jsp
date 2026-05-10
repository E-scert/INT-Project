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
        <title>Update Data Page</title>
    </head>
    <body>
        <h1>UPDATE DATA</h1>

        <form action="UpdateDataServlet.do" method="POST">
            <table>
                <!--upgrade username-->
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="username" required=""/></td>
                </tr>
                 <!--upgrade grade-->
                <tr>
                    <td>Grade:</td>
                    <td><input type="text" name="grade" required=""/></td>
                </tr>
                <!--upgrade marks-->
                 <tr>
                    <td>Marks:</td>
                    <td><input type="text" name="marks" min="0" max="100" required=""/></td>
                </tr>
                <!--upgrade subjects-->
                <tr>
                    <td>Subjects</td>
                    <td><input type="text" name="subject"/></td>
                </tr>
                <!--upgrade field of interest-->
                 <tr>
                     <td>Field of Interest</td>
                     <td><input type="text" name="fieldOfInterest"/></td>
                </tr>
                
                 <tr>
                     <td></td>
                     <td><input type="submit" value="SUBMIT"/></td>
                </tr>
                
            </table>
        </form>

        
    </body>
</html>
