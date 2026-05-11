<%-- 
    Document   : list_students_based_on_min_max_aps
    Created on : May 10, 2026, 4:02:29 PM
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
        <title>Students Based On Min And Max APS Page</title>
    </head>
    <body>

        <div class="section head">
            <ul>
            <li><a href="admin_page.jsp"><span class="material-symbols-outlined back">
            arrow_back_ios_new
            </span></a></li>
            </ul>
            <h1>List Students Based On Min And Max APS</h1>
        </div>

        <form action="ListStudentsBetweenMinAndMaxApsServlet.do" method="GET">

            <table class="card" style="margin: 20px 0;">

                <tr>
                    <td>Enter Minimum APS</td>

                    <td>
                        <input class="input_field" type="text" name="minAps" required="">
                    </td>
                </tr>

                <tr>
                    <td>Enter Maximum APS</td>

                    <td>
                        <input class="input_field" type="text" name="maxAps" required="">
                    </td>
                </tr>

                <tr>
                    <td></td>

                    <td>
                        <input class="button_primary" type="submit" value="List Students">
                    </td>
                </tr>

            </table>

        </form>




        <h1>Students Between Min And Max APS</h1>

        <%
            List<Student> students = (List<Student>) request.getAttribute("students");
        %>

        <%
            if (students != null && students.size() > 0) {
        %>

        <table class="dashboard_table">

            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Grade</th>
                <th>Field Of Interest</th>
                <th>APS</th>
                <th>Subject Marks</th>
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

       

    </body>
</html>
