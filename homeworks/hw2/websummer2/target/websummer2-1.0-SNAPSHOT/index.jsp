<%-- 
    Document   : index.jsp
    Created on : Jun 26, 2021, 12:25:47 AM
    Author     : baali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-4.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">

    <head>
        <title>Library</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cosmo/bootstrap.min.css" />
        <script src= "https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" ></script>
    </head>
    <body>
        <div> 
            <tr>
                <div align = "left" >		   
                    <h3><a href="new.jsp">Add new</a></h3>     
                </div>
            </tr>
            <tr>
                <div class="col-sm-5" align = "center">
                    <div class="panel-body" align = "center" >
                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th>Book ID</th>
                                    <th>Book Name</th>
                                    <th>Author</th>
                                    <th>Stock</th>
                                    <th>Price</th>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            
                            <tbody>
                                <tr  th:each="book : ${listbook }">
                                    <td th:text="${book.id}">Book ID</td>
                                    <td th:text="${book.name}">Book Name</td>
                                    <td th:text="${book.author}">Author</td>
                                    <td th:text="${book.stock}">Stock</td>                                    
                                    <td th:text="${book.price}">Price</td>				
                                    <td>
                                        <a th:href="@{'/edit/' + ${book.id}}">Edit</a>
                                    </td>							    
                                    <td>
                                        <a th:href="@{'/delete/' + ${book.id}}">Delete</a>
                                    </td>		    
                                </tr> 
                            </tbody>
                        </table>
                    </div>
                </div> 
            </tr>
        </div>
    </body>
</html>