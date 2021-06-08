<%@ page isErrorPage = "true"%>
<link rel="stylesheet" type="text/css" href="styles/style.css"/> 
<HTML>
<HEAD><TITLE>Error Page</TITLE></HEAD>
<BODY>
	<h1>Whoops!</h1>
	<img id="error" src="styles/error1.gif">
	<h2>Sorry, something went wrong..</h2>
	
	<p>The problem is: ${pageContext.exception} </p>



</BODY>
</HTML>