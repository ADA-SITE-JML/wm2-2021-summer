<%-- 
    Document   : home
    Created on : Jun 30, 2021, 5:31:04 PM
    Author     : emil
--%>

<%@page import="emil.UserData"%>
<%@page import="emil.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  User user = (User) session.getAttribute("loginStudent");
    if (user == null) {
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
    </head>
    <body>
        <h1>Welcome, <%= user.getName()%><%= user.getSurname()%></h1>
        <h3>Your Email: <%= user.getEmail()%> </h3>

        <button><a href="Logout">Log Out</a></button>
    </body>
</html>
