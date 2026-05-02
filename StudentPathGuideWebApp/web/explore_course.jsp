<%-- 
    Document   : explore_course
    Created on : May 2, 2026, 9:52:15 AM
    Author     : Rebaona
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
       <title>Explore Course Page</title>
</head>
<body>
    <h2>Explore Course</h2>
    
    <form action="ExploreCourseServlet.do" method="post">
        
        <table border="1" cellpadding="10">
            <tr>
                <td>Enter Course Name:</td>
                <td><input type="text" name="courseName" required=""></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Explore Course"></td>
            </tr>
        </table>
    </form>
    
    <ul>
        <li><a href="explore_page.jsp">Back</a></li>
    </ul>
</body>
</html>
