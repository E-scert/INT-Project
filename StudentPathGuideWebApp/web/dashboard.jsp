<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dashboard Page</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" />
    <link rel="stylesheet" href="style/style.css">
</head>
<body class="dashboard_container">
    
        
        
    
   
    <!--displays name and grade and aps score-->
<div id="name_container" class="student_details_container">
  
            <div class="dashboard_nav section">

                <div class="logo">Student Path Guide</div>

                <div id="button_holder"class="nav">

                <a class="button_primary" href="#">
                    <span id="dashboard_nav" class="material-symbols-outlined">edit_note</span>
                </a>
                <a class="button_primary" href="explore_page.jsp">
                    <span id="dashboard_nav" class="material-symbols-outlined">explore</span>
                </a>
                <a class="button_primary" href="chat.jsp"> 
                    <span id="dashboard_nav" class="material-symbols-outlined">android</span>
                </a>
    
</div>
                 <div class="student_name">
                    ${name} 
                 (Grade ${grade}) 
                 <span>
                    <a style="color:rgb(133, 133, 133);font-size:1.125rem" href="LogoutServlet.do">Logout</a>
                 </span>
                 </div>
            </div>

            <div class="student_details">
                
                <span>APS SCORE: ${aps}</span> 
                <span>Field Of Interest:  ${field} </span>
            </div>
        
</div>
        

<h3 class="section text_center">Courses you qualify for:</h3>
<!--       holds the links to -->


        
<!--dashboard data display--> 
<div id="dashboard_analysis">
    <div id="data_description" >
        <table class="dashboard_table center ${courseNotFound}">
            
            <tr>
                
                <th>Faculty</th>
                <th>Course</th>
                <th>Course Description</th>
                <th>Course Field</th>
                <th>Course required Subjects</th>
                <th>APS</th>
                <th>University</th>
                
            </tr>


           <c:if test="${empty course}">
            <div>You do not qualify for any course. try upgrading your APS</div>
           </c:if>

           
            <c:if test="${not empty course}">
                
                <c:forEach var="f" items="${course}">
                
                <tr>
                    <td>${f.facultyName}</td>
                    <td>${f.course.courseName}</td>
                    <td>${f.course.courseDescription}</td>
                    <td>${f.course.courseField}</td>
                    <td>${f.course.courseRequiredSubjects}</td>
                    <td>${f.course.courseMinAps}</td>
                    <td>${f.university.universityName}</td>
                   
                </tr>
            </c:forEach>
                
            </c:if>
            
        </table>
    </div>
</div>

</body>
</html>