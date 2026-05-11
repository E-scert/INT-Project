<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon_names=arrow_back_ios_new" />
    <link rel="stylesheet" href="style/style.css">
    <title>Update Data Page</title>
</head>
<body>
    <div class="section head">
        <ul>
            <li><a href="dashboard.jsp"><span class="material-symbols-outlined back">
            arrow_back_ios_new
            </span></a></li>
        </ul>
        <h1>UPDATE DATA</h1>
    </div>
    <div class="update_user_details">
    <form class="card" action="UpdateDataServlet.do" method="POST">
        <table>
            <tr>
                <td>Username:</td>
                <td><input class="input_field" type="text" name="username" value="${name}" required /></td>
            </tr>
            <tr>
                <td>Grade:</td>
                <td><input class="input_field" type="text" name="grade" value="${grade}" required /></td>
            </tr>
            <tr>
                <th>Subject</th>
                <th>Percentage (%)</th>
            </tr>
           
            <tr>
                <td><input class="input_field" type="text" name="subj1" value="${subj1}" /></td>
                <td><input class="input_field" type="number" name="perc1" value="${perc1}" min="0" max="100" /></td>
            </tr>
            <tr>
                <td><input class="input_field" type="text" name="subj2" value="${subj2}" /></td>
                <td><input class="input_field" type="number" name="perc2" value="${perc2}" min="0" max="100" /></td>
            </tr>
            <tr>
                <td><input class="input_field" type="text" name="subj3" value="${subj3}" /></td>
                <td><input class="input_field" type="number" name="perc3" value="${perc3}" min="0" max="100" /></td>
            </tr>
            <tr>
                <td><input class="input_field" type="text" name="subj4" value="${subj4}" /></td>
                <td><input class="input_field" type="number" name="perc4" value="${perc4}" min="0" max="100" /></td>
            </tr>
            <tr>
                <td><input class="input_field" type="text" name="subj5" value="${subj5}" /></td>
                <td><input class="input_field" type="number" name="perc5" value="${perc5}" min="0" max="100" /></td>
            </tr>
            <tr>
                <td><input class="input_field" type="text" name="subj6" value="${subj6}" /></td>
                <td><input class="input_field" type="number" name="perc6" value="${perc6}" min="0" max="100" /></td>
            </tr>
            <tr>
                <td>Field of Interest</td>
                <td><input class="input_field" type="text" name="fieldOfInterest" value="${field}" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input class="button_primary" type="submit" value="UPDATE" /></td>
            </tr>
        </table>
    </form>
    </div>

    
</body>
</html>
