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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Explore Varsity Outcome</title>
    </head>
    <body>
        <h2>Explore University Outcome</h2>

        <%
            University uni = (University) request.getAttribute("university");
            List<String> faculties = (List<String>) request.getAttribute("faculties");
            List<UniversityCourses> courses = (List<UniversityCourses>) request.getAttribute("courses");

        %>

        <h3>University: <%= uni.getUniversityName()%> , <%=uni.getUniversityAbbreviation()%></h3>
        <p>Province: <%= uni.getUniversityProvince()%></p>

        <hr><!---break to occur--->
        <%
            for (int x = 0; x < faculties.size(); x++) {

                String faculty = faculties.get(x);

        %>

        <h4><%= faculty%></h4>

        <%
            for (int z = 0; z < courses.size(); z++) {
                UniversityCourses uc = courses.get(z);

                if (uc.getFacultyName().equalsIgnoreCase(faculty)) {

        %>

        <p>
            <b>Course:</b> <%=uc.getCourse().getCourseName()%><br/>
            <b>Field</b> <%=uc.getCourse().getCourseField()%><br/>
            <b>APS:</b> <%=uc.getCourse().getCourseMinAps()%><br/>
            <b>Description:</b> <%=uc.getCourse().getCourseDescription()%><br/>
            <b>Required Subjects:</b> <%=uc.getCourse().getCourseRequiredSubjects()%><br/>

        </p>
        <hr>

        <%
                    }
                }
            }
        %>


        <p>Click <a href="dashboard.jsp">here</a> to go to the dashboard</p>


    </body>
</html>
