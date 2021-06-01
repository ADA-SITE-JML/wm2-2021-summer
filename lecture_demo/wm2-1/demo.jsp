<HTML>
<BODY>
	<h1>Hello, from HTML</h1>

	<%
		out.println("The current time is: "+new java.util.Date());
	%>

	<h1>Another demonstration of Java:</h1>
	<%
	for (int i=0;i<5;i++) {
		out.println("2 x "+i+" = "+2*i+"<br>");
	}
	%>
</BODY>
</HTML>
