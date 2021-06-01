<%@ page errorPage="errorPage.jsp" %>
<%@ page import="java.util.*"%>
<%! public int x = 55; %>
<HTML>
<BODY>
	<h1>Additional JSP stuff</h1>

	<%
	int a = 5;
	int b = 6;
	int c =  a + b;
	out.print(a+" + "+b + " = "+c);
	%>

	<h1>Your name is:</h1>
	<%
		String firstName = request.getParameter("first");
		String lastName = request.getParameter("last");
		out.print(firstName+" "+lastName);
	%>

	<h1>Another section</h1>
	<%
		out.print("X divided by "+a+" is " +(x/a));
	%>

	<h1>Date part</h1>
	<%
	out.println("Current time: "+(new Date()));
	%>

</BODY>
</HTML>
