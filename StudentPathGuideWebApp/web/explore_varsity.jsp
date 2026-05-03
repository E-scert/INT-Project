<%-- 
    Document   : explore_varsity
    Created on : May 2, 2026, 9:58:15 AM
    Author     : Rebaona
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Explore Varsity Page</title>
</head>
<body>
    <h2>Explore Varsity</h2>
    
   <form action="ExploreVarsityServlet.do" method="post">
       
        <table border="1" cellpadding="10">
            <tr>
                <td>Enter Varsity Name:</td>
                <td><input type="text" name="varsityName" required=""></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Explore Varsity"></td>
            </tr>
        </table>
    </form>
    
    <ul>
        <li><a href="explore_page.jsp">Back</a></li>
    </ul>
</body>
</html>
