<%-- 
    Document   : index
    Created on : Jun 8, 2021, 11:26:34 AM
    Author     : emil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subtract</title>
    </head>
    <body>
        <% String browserType = request.getHeader("User-Agent");%>
        <% Integer num1 = Integer.parseInt(request.getParameter("n1"));
           Integer num2 = Integer.parseInt(request.getParameter("n2"));
           Integer ans = 0;
           if(num1 == (int)num1 && num2 == (int)num2){
               ans = num1-num2;
           }else {
               ans = 0;
           }
        %>
        <%= "<h1>Sum answer is : " + ans +"</h1> " 
                + "<h2>Environment : </h2>" + browserType%>
    </body>
</html>
