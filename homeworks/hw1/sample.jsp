<%@ page errorPage="errorPageSample.jsp"%>
<%@ page import="java.util.*"%>

<HTML>

<style type="text/css">
	 h1{
	 	color: #a1261d;
	}
</style>
<HEAD>
	<TITLE>Homework 1</TITLE>
</HEAD>

<BODY style= "text-align: center; ">

	 <p style="font-size: 60px; "> Homework 1 </p>

	<h1 style="margin-top: -3%;">Example 1: </h1>
	<h2>Division: </h2>
	<h4>Enter two Integers for Division: </h4>

	<%

	int FirstNum = Integer.valueOf(request.getParameter("a"));
	int SecondNum = Integer.valueOf(request.getParameter("b"));

	out.print("<b>First  Integer: </b>" + FirstNum + "<br>");
	out.print("<b>Second  Integer: </b>" + SecondNum+ "<br><br>");

	out.print("<b>Result: </b>" + FirstNum + " / " + SecondNum+ " " + "= " +FirstNum / SecondNum);
	%>

	<br>
	<br>

	<h1>Example 2: </h1>
	<h2>Contains: </h2>
	<h4>Enter two Strings for Comparion: </h4>

	<%
	String FirstString = request.getParameter("s1");
	out.print("<b>First String: </b>" + FirstString + "<br>");

	String SecondString = request.getParameter("s2");
	out.print("<b>Second String: </b>" + SecondString + "<br>");


	if(SecondString.contains(FirstString)){
	out.print("<br>" + "<b> Result: </b>An Input String  \"" + FirstString + "\" Contains a Specified Substring  \"" + SecondString + "\"");
	}
	else{
	out.print("<br>" + "<b> Result: </b>An Input String \" " + SecondString + " \" Does not Contain a Specified Substring \"" + FirstString + "\"");
	}
	%>

	<br><br>
	<br><br>

	<h1>Additional Info: </h1>
	<h3>The Information about the User Environment: </h3>

	<%
	out.println(request.getHeader("user-agent"));
	%>

</BODY>
</HTML>