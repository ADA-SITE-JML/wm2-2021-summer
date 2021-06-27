<%-- 
    Document   : new
    Created on : Jun 25, 2021, 01:35:59 AM
    Author     : emil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html SYSTEM "https://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-4.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org">
    <head>
        <meta charset="utf-8" />
        <title>Create New Book</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cosmo/bootstrap.min.css" />
        <script src= "https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" ></script>
    </head>
    <body>
        <div align="center">
            <h1>Add New Book</h1>
            <br />
            <div class="col-sm-4">
            <form action="#" th:action="@{/save}" th:object="${book}" method="post">
                <div align="left">
                    <tr>
                        <label class="form-label" >Book Name</label>
                        <td>
                            <input type="hidden" th:field="*{id}" />
                            <input type="text" th:field="*{name}" class="form-control" placeholder="Book Name" />
                        </td>
                    </tr>
                </div>   

                <div align="left">
                    <tr>
                        <label class="form-label" >Author</label>
                        <td>
                            <input type="text" th:field="*{Author}" class="form-control" placeholder="Author" />
                        </td>
                    </tr>
                </div> 
                <div align="left">
                    <tr>
                        <label class="form-label" >Stock</label>
                        <td>
                            <input type="text" th:field="*{stock}" class="form-control" placeholder="Stock" />
                        </td>
                    </tr>
                </div> 
                <div align="left">
                    <tr>
                        <label class="form-label" >Price</label>
                        <td>
                            <input type="text" th:field="*{price}" class="form-control" placeholder="Price" />
                        </td>
                    </tr>
                </div> 
                <br>
                    <tr>
                        <td colspan="2"><button type="submit" class="btn btn-warning">Save</button> </td>
                    </tr>  
            </form>
        </div>
    </body>
</html>