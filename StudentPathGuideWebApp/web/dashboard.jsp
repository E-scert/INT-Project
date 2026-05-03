<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dashboard Page</title>
    <link rel="stylesheet" href="style/style.css">
</head>
<body class="dashboard_container">
    
        
        
    
   
    <!--displays name and grade and aps score-->
<div id="name_container" class="student_details_container">
    <table >
        <tr>
            <td>Username: <b> ${name} </b> </td>
            <td>GRADE: <b> ${grade} </b></td>
            <td>APS SCORE: <b> ${aps} </b></td>
            <td>Field Of Interest: <b> ${field} </b></td>
            
        </tr>
    </table>
</div>
        

<!--       holds the links to -->
<div id="button_holder"class="nav">
    <table >
        <tr>
            <td><a href="/">UPDATE DATA</a></td>
            <td><a href="explore_page.jsp">EXPLORE</a></td>
            <td><a href="chat.jsp">JARVIS</a></td>
            
        </tr>
        
    </table>
    
</div>

<h3>Courses that you qualify for:</h3>
        
<!--dashboard data display--> 
<div id="dashboard_analysis">
    <div id="data_description" style="max-height:500px; overflow-y:auto;">
        <table class="info_table">
            
            <tr>
                
                <th>Faculty</th>
                <th>Course</th>
                <th>Course Description</th>
                <th>Course required Subjects</th>
                <th>APS</th>
                <th>University</th>
                
            </tr>

            <c:forEach var="f" items="${course}">
                <tr>
                    <td>${f.facultyName}</td>
                    <td>${f.course.courseName}</td>
                    <td>${f.course.courseDescription}</td>
                    <td>${f.course.courseRequiredSubjects}</td>
                    <td>${f.course.courseMinAps}</td>
                    <td>${f.university.universityName}</td>
                   
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>