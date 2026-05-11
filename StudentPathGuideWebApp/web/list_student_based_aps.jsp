<%-- 
    Document   : list_student_based_aps
    Created on : May 10, 2026, 4:01:51 PM
    Author     : JREscert
--%>

<%@page import="java.util.List"%>
<%@page import="com.apexcoders.entities.Student"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"
    href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon_names=arrow_back_ios_new,search" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"> 
    <link rel="stylesheet" href="style/style.css">
        <title>List All Students Based on APS Page</title>
    </head>
    <body>
        <h1 class="head section">List All Students Based on APS</h1>

        <form class ="course_search" action="ListStudentsBasedOnAPS.do" method="GET">

            <label for="">Enter APS Score to see Students</label>
                    <input  type="text" name="aps" required="">
                
                    <input type="submit" value="List Students">

        </form>


        <h1>Students Based On APS</h1>

        <%
            List<Student> students = (List<Student>) request.getAttribute("students");
        %>

        <%
            if (students != null && students.size() > 0) {
        %>

        <table >

            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Grade</th>
                <th>Field</th>
                <th>APS</th>
                <th>Subjects</th>
            </tr>

            <%
                for (int i = 0; i < students.size(); i++) {

                    Student stud = students.get(i);
            %>

            <tr>

                <td><%=stud.getId()%></td>
                <td><%=stud.getUsername()%></td>
                <td><%=stud.getGrade()%></td>
                <td><%=stud.getFieldOfInterest()%></td>
                <td><%=stud.getAps()%></td>


                <td>

                    <%
                        Map<String, Integer> marks = stud.getSubjectMarks();

                        for (String subject : marks.keySet()) {
                    %>

                    <%=subject%> :
                    <%=marks.get(subject)%> ,

                    <%
                        }
                    %>

                </td>

            </tr>

            <%
                }
            %>

        </table>

        <%
        } else {
        %>

        <p>No students found.</p>

        <%
            }
        %>

        <ul>
            <li><a href="admin_page.jsp">Back</a></li>
        </ul>
    </body>
</html>
