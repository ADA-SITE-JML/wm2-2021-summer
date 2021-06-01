<%@ page errorPage="errorPage.jsp" %>
<%!
    String [] courses = {"Programming 1", "Programming 2", "Big data", "Web and Mobile 1", "Web and Mobile 2", "Intro to Networking", "Fundamentals of Database", "Calculus", "Linear Algebra", "Discrete", "Math","Machine Learning", "Cyber Security"};

%>

<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
</head>

<style type="text/css">
    .result-header{
        font-size: 18px;
        font-weight: 650;
        margin: 10px 0;
        margin-top: 50px;
    }
    .input-search{
        font-size: 16px;
        padding: 7px 10px;
        border: 1px solid #a80000;
        width: 250px;
    }
    .input-search:focus{
        box-shadow: none;
        outline: none;
        border-color: #a80000;
    }
    .btn-search{
        padding: 7px 15px;
        font-size: 16px;
        margin:0;
        border: 1px solid transparent;
        background: #a80000;
        color: #fff;
        font-weight: 600;
    }
    .search-res{
        border:1px solid #a80000;
        background: #f1f1f1;
        width: 100%;
        padding: 10px;
    }
    .res-ul{
        margin: 5px 0 5px 17px;
        padding:0;
        font-size: 18px;
        font-weight: 550;
    }
    .res-ul li + li{
        margin-top: 6px;
    }
    .count{
        font-weight: 650;
        font-size: 20px;
        margin-top: 10px;
    }
    .main{
        width: 28%;
        margin-left: 36%;
        margin-top: 100px;
    }
</style>
<body>


<div class="main">
    <h2>Seach Course</h2>
    <form action="/fagan-hw1/index.jsp" method="GET">
        <input class="input-search" autocomplete="off" type="search" name="q">
        <button class="btn-search">Search</button>
    </form>

    <div class="result-header">Search Result</div>
    <div class="search-res">
        <%

            int count = 0;
            String query = request.getParameter("q");
            if (query != null){
                out.println("<ul type='1' class='res-ul'>");
                if(query.length() == 0){
                    throw new Exception("No query added for Search Course");
                }

                for(String c: courses){
                    if (c.toLowerCase().contains(query.toLowerCase())){
                        count++;
                        out.println("<li>"+c+"</li>");
                    }
                }
                out.println("</ul>");
                out.println("<div class='count'>"+count+" courses found for '"+query+"'</div>");

            }



        %>
    </div>
<%@ page import = "java.io.*,java.util.*" %>
    <div class="result-header">Request Information</div>
    <div class="search-res">
        <ul class="res-ul">
            <li>Request Method: <%out.println(request.getMethod());%></li>
            <li>Request Client: <%out.println(request.getHeader("user-agent"));%></li>
            <li>Request Host: <%out.println(request.getHeader("host"));%></li>
        </ul>


    </div>
</div>
</body>
</html>