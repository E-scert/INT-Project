<%-- 
    Document   : list_all
    Created on : May 10, 2026, 3:59:47 PM
    Author     : JREscert
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.apexcoders.entities.Student"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List All Students Page</title>
    </head>
    <body>
        <h1>List All Students</h1>

        <form action="ListAllStudentsServlet.do" method="GET">

            <table>
                <tr>
                    <td></td>
                    <td>Click to View all Students</td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="List Students"></td>
                </tr>
            </table>


        </form>
              

        <h1>List All Students</h1>

        <%
            List<Student> students = (List<Student>) request.getAttribute("students");
        %>

        <%
            if (students != null && students.size() > 0) {
        %>

        <table>
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

                    Student s = students.get(i);
            %>

            <tr>
                <td><%=s.getId()%></td>
                <td><%=s.getUsername()%></td>
                <td><%=s.getGrade()%></td>
                <td><%=s.getFieldOfInterest()%></td>
                <td><%=s.getAps()%></td>
                

                <td>

                    <%
                        Map<String, Integer> marks = s.getSubjectMarks();

                        for (String subject : marks.keySet()) {
                    %>

                   
                        <%=subject%> :
                        <%=marks.get(subject)%> ;
                    

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
