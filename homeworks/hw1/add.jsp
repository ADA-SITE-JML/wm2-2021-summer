<%@ page errorPage="error.jsp" %>
<%@ page import="java.util.*" %>
<html>
    <head>
        <title>Enter 2 numbers</title>
        <link href="./loginstyle.css" rel="stylesheet" type="text/css">
    </head>
    <body>
    <%="<h1> Answer: " + (Integer.parseInt(request.getParameter("n1")) + Integer.parseInt(request.getParameter("n2"))) + "</h1>" %>
    <%="<h1> Method: " +request.getMethod() + "</h1>" %>
    <%="<h1> URI: " +request.getRequestURI() + "</h1>" %>
    <%="<h1> Browser: " +request.getHeaders("User-Agent").nextElement() + "</h1>" %>
    </body>
</html>