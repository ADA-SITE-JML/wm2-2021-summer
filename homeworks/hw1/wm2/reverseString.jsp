<%@ page errorPage="errorpage.jsp"%>
<%@ page import="java.util.*"%>
<link rel="stylesheet" type="text/css" href="styles/style.css"/> 

<HTML>

<BODY>
	

<h1>Reverse String</h1>

<%
String inputStr = request.getParameter("string");
String outputStr= "";


for(int i=inputStr.length()-1;i>=0;i--){
	outputStr = outputStr+inputStr.charAt(i);
}


if(inputStr == null || "".equals(inputStr) ){
		throw new ServletException("the mandatory parameter is missing");
	}

out.println(inputStr + " in reverse order is: " + outputStr);

%>


<h2>User Environment</h2>


   <em> User's platform and browser:</em>
    <%= request.getHeader("user-agent") %>
	<br>
   <em>Request method: </em> 
    <%= request.getMethod() %>
    <br>
	<em>Remote Address:</em> 
    <%= request.getRemoteAddr() %>
    <br>
    <em>Remote Host: </em>
    <%= request.getRemoteHost() %>
     <br>
   <em> Request URI: </em>
    <%= request.getRequestURI() %>
    <br>
    <em>Request protocol: </em>
    <%= request.getProtocol() %>
     <br>
   <em> HttpSession: </em>
    <%= request.getSession() %>
    <br>
    <em>Cookies:</em>
    <%= request.getCookies() %>





    


</BODY>
</HTML>