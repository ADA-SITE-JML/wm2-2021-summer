<%@ page import="java.util.*,ada.wm2.*"%>

<html>

<head>
<title>Our games</title>
</head>

<body>
<h1>Students (pure Java way):</h1>
<%
ArrayList<GamerBean> al = (ArrayList)session.getAttribute("gamers");
for (GamerBean sb : al) {
    out.println(sb.Name()+" "+ sb.getid() +" "+"<br>");
}
%>

<h1>Games (HTML way):</h1>
<table style="width:30%">
<tr>
<th>Name</th>
<th>Id</th>
</tr>
<% for (GamerBean sb : al) { %>
<tr>
    <td><%=sb.getName() %> </td>
    <td><%=sb.getid() %></td>
</tr>
<% } %>
</table>

</body>

</html>