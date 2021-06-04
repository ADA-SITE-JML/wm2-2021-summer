<%@ page errorPage="errorPage.jsp" %>
<%@ page import="ada.hw1.*, java.util.*"%>
<%! final static String filename="/Users/feqanrasulov/Desktop/WebMobile2/apache-tomcat-9.0.46/webapps/hw1/DB/courses.txt";%>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

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
        width: 350px;
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
        padding: 15px 10px;
        margin-bottom: 50px;
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
        font-weight: 600;
        font-size: 20px;
        margin-top: 10px;
        text-align: center;
    }
    .main{
        width: 60%;
        margin-left: 20%;
        margin-top: 100px;
    }
</style>

<body>

    <%
    Database db = new Database();
    ArrayList<Course> courses = db.getCourses(filename);

%>


<div class="main">
    <h2>Seach Course</h2>
    <form action="/hw1/index.jsp" method="GET">
        <input class="input-search" placeholder="Search by id, title, category, instrucor" autocomplete="off" type="search" name="q">
        <button class="btn-search">Search</button>
    </form>

    <div class="result-header">Search Result</div>
    <div class="search-res">
        <%
            String query = request.getParameter("q");
            int count = 0;
            if (query!=null){
                if(query.length() == 0){
                    throw new Exception("No query added for Search Course");
                }
        %>

                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <td style="font-weight:600">ID</td>
                            <td style="font-weight:600">Title</td>
                            <td style="font-weight:600">Category</td>
                            <td style="font-weight:600">Instructor</td>
                        </tr>
                    </thead>
                    <tbody>

                <% if (query.equalsIgnoreCase("all")){
                    for(Course course: courses){
                    count++;
                %>
                    <tr>
                            <td><%=course.getId()%></td>
                            <td><%=course.getTitle()%></td>
                            <td><%=course.getCategory()%></td>
                            <td><%=course.getInstructor()%></td>
                    </tr>
                <%
                }
                }else{
                %>


               <% for(Course course: courses){

                    if(course.compare(query)){
                        count++;
                %>
                        <tr>
                            <td><%=course.getId()%></td>
                            <td><%=course.getTitle()%></td>
                            <td><%=course.getCategory()%></td>
                            <td><%=course.getInstructor()%></td>
                        </tr>
                <%   
                    }
                }
                %>
                 
            <%
            }}
            %>
               </tbody>
                </table>
                <div class="count"><%=count%> courses found for '<%=query%>'</div>
    </div>
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