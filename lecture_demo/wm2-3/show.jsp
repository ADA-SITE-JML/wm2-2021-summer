<%@ page import="java.util.*,ada.wm2.*"%>

<html>
<head>
	<title>Our students</title>
</head>

<body>
	<h1>Students (pure Java way):</h1>
	<%
	ArrayList<StudentBean> al = (ArrayList)session.getAttribute("students");
	for (StudentBean sb : al) {
		out.println(sb.getFirstName()+" "+ sb.getLastName() +" "+ sb.getMajor()+"<br>");
	}
	%>

	<h1>Students (HTML way):</h1>
	<table style="width:30%">
	  <tr>
    	<th>Firstname</th>
    	<th>Lastname</th> 
    	<th>Major</th>
  	  </tr>
	<% for (StudentBean sb : al) { %>
	  <tr>
	    <td><%=sb.getFirstName() %></td>
    	<td><%=sb.getLastName() %></td> 
    	<td><%=sb.getMajor() %></td>
  	  </tr>
	<% } %>
	</table>

</body>

</html>
