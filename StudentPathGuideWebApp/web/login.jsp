<%-- 
    Document   : login
    Created on : May 10, 2026, 3:56:44 PM
    Author     : JREscert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"
    href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon_names=arrow_back_ios_new,search" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"> 
    <link rel="stylesheet" href="style/style.css">
        <title>Login Page</title>
    </head>
    <body class="admin_body">
      <div class="admin_login_container card">
          <h1>Login</h1>
        <form class="admin_login_form" action="j_security_check" method="POST">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input class="input_field" type="text" name="j_username"/></td>
                </tr>
                 <tr>
                    <td>Password:</td>
                    <td><input class="input_field" type="text" name="j_password"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input class="button_primary" type="submit" value="login"/></td>
                </tr>
            </table>
        </form>
      </div>
    </body>
</html>
