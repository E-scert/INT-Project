<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="style/style.css">
    <title>Update Data Page</title>
</head>
<body>
    <h1>UPDATE DATA</h1>

    <form action="UpdateDataServlet.do" method="POST">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username" value="${name}" required /></td>
            </tr>
            <tr>
                <td>Grade:</td>
                <td><input type="text" name="grade" value="${grade}" required /></td>
            </tr>
            <tr>
                <th>Subject</th>
                <th>Percentage (%)</th>
            </tr>
           
            <tr>
                <td><input type="text" name="subj1" value="${subj1}" /></td>
                <td><input type="number" name="perc1" value="${perc1}" min="0" max="100" /></td>
            </tr>
            <tr>
                <td><input type="text" name="subj2" value="${subj2}" /></td>
                <td><input type="number" name="perc2" value="${perc2}" min="0" max="100" /></td>
            </tr>
            <tr>
                <td><input type="text" name="subj3" value="${subj3}" /></td>
                <td><input type="number" name="perc3" value="${perc3}" min="0" max="100" /></td>
            </tr>
            <tr>
                <td><input type="text" name="subj4" value="${subj4}" /></td>
                <td><input type="number" name="perc4" value="${perc4}" min="0" max="100" /></td>
            </tr>
            <tr>
                <td><input type="text" name="subj5" value="${subj5}" /></td>
                <td><input type="number" name="perc5" value="${perc5}" min="0" max="100" /></td>
            </tr>
            <tr>
                <td><input type="text" name="subj6" value="${subj6}" /></td>
                <td><input type="number" name="perc6" value="${perc6}" min="0" max="100" /></td>
            </tr>
            <tr>
                <td>Field of Interest</td>
                <td><input type="text" name="fieldOfInterest" value="${field}" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="UPDATE" /></td>
            </tr>
        </table>
    </form>
         

    <ul>
        <li><a href="dashboard.jsp">Back</a></li>
    </ul>
</body>
</html>
