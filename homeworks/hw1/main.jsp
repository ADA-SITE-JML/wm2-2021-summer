<%@ page errorPage="errorPage.jsp" %>
<%@ page import="java.util.*"%>
<%! public int x = 55; %>
<HTML>
<BODY>
	<h1>Rock Paper Scissors Game</h1>
<h5>Khanim Huseynzada | WM 2 | HW #1 </h5>

	<%
String options[]={"Rock", "Paper", "Scissors"};
Random r=new Random();        
int randomNumber=r.nextInt(options.length);
	out.print(options[randomNumber]);
	%>

	<h1>Your Choice was:</h1>
	<%
		String myChoice = request.getParameter("choice");
		out.print(myChoice);
	%>


</BODY>
</HTML>
