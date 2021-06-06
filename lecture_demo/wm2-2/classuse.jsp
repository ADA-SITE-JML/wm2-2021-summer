<%@ page import="ada.wm2.*"%>

<HTML>
<BODY>
	<h1>We use our class to get the info:</h1>

	<%
		HelperClass hc = new HelperClass();
		out.println(hc.saySomething());
	%>

</BODY>
</HTML>
