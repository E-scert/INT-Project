<%-- 
    Document   : explore_varsity_outcome
    Created on : 02 May 2026, 23:35:43
    Author     : Esther
--%>

<%@page import="com.apexcoders.entities.UniversityCourses"%>
<%@page import="java.util.List"%>
<%@page import="com.apexcoders.entities.University"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"
    href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon_names=arrow_back_ios_new,search" />
        <link rel="stylesheet" href="style/style.css">
        <title>Explore Varsity Outcome</title>
    </head>
    <body>
        <div class="head section">
        <h2>List of Course Offered by this University</h2>
        </div>

        <ul>
            <li><a href="explore_varsity_outcome.jsp">
                <span class="material-symbols-outlined">
arrow_back_ios_new
</span>
            </a></li>
        </ul>
        <div class="card" style="margin: 15px;">
        <%
            University uni = (University) session.getAttribute("university");
            List<String> faculties = (List<String>) session.getAttribute("faculties");
            List<UniversityCourses> courses = (List<UniversityCourses>) session.getAttribute("courses");

        %>
        

        <h3>University: <%= uni.getUniversityName()%> , <%=uni.getUniversityAbbreviation()%></h3>
        <p>Province: <%= uni.getUniversityProvince()%></p>
        </div>
        
        <%
            for (int x = 0; x < faculties.size(); x++) {

                String faculty = faculties.get(x);

        %>

        <h4 class="course_faculty"><%= faculty%></h4>

        <div class="course_card_container">
        <%
            for (int z = 0; z < courses.size(); z++) {
                UniversityCourses uc = courses.get(z);

                if (uc.getFacultyName().equalsIgnoreCase(faculty)) {

        %>
        
        <p class="card ">
            <b>Course:</b> <%=uc.getCourse().getCourseName()%><br/>
            <b>Field</b> <%=uc.getCourse().getCourseField()%><br/>
            <b>APS:</b> <%=uc.getCourse().getCourseMinAps()%><br/>
            <b>Description:</b> <%=uc.getCourse().getCourseDescription()%><br/>
            <b>Required Subjects:</b> <%=uc.getCourse().getCourseRequiredSubjects()%><br/>

        </p>
        
        

        <%
                    }
                }
                %>
        </div>
        <%    }
        %>

            
         
    


    </body>
</html>
