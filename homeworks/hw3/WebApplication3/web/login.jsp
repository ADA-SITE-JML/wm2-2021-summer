<%-- 
    Document   : login
    Created on : Jun 30, 2021, 5:30:40 PM
    Author     : emil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>LOGIN</h1>
        <form method="post" action="Login">
            <input type="email" placeholder="Enter your e-mail" name="email" required>
            <input type="password" placeholder="Enter your password" name="password" required>
            <input type="submit" value="Login">
            <a href="register.jsp">Dont you have an account sign up</a>
        </form>
    </body>
</html>

