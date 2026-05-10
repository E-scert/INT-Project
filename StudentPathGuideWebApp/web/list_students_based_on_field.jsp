<%-- 
    Document   : list_students_based_on_field
    Created on : May 10, 2026, 4:03:50 PM
    Author     : JREscert
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.apexcoders.entities.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Field Of Interest Page</title>
    </head>
    <body>
        <h1>List Students Based On Field Of Interest</h1>


        <form action="ListStudentsBasedOnFieldServlet.do"  method="GET">
            <table>

                <tr>

                    <td>Enter Field Of Interest</td>

                    <td><input type="text" name="field" required=""></td>


                </tr>

                <tr>
                    <td></td>

                    <td>
                        <input type="submit" value="List Students">
                    </td>

                </tr>

            </table>




            <h1>Students Based On Field Of Interest</h1>

            <%
                List<Student> students = (List<Student>) session.getAttribute("students");
            %>

            <%
                if (students != null && students.size() > 0) {
            %>

            <table border="1">

                <tr>

                    <th>ID</th>
                    <th>Username</th>
                    <th>Grade</th>
                    <th>Field</th>
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
