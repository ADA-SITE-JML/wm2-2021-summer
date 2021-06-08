<%@ page isErrorPage="true"%>
<HTML>
<HEAD><TITLE>Error Page</TITLE></HEAD>
<link rel="stylesheet" href="main.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,100;0,300;0,400;0,700;0,900;1,100;1,300;1,400;1,700;1,900&display=swap" rel="stylesheet">
<BODY>
	<section>
	<h1>Sorry, but something happened....</h1>

	<div id="error">
	The problem: ${pageContext.exception}
</div>
	<div id="game-rules">
		Enter <span>Rock/Paper/Scissors</span> as a request parameter and wait for the opponent's reponse
	</div>
</section>
</BODY>
</HTML>
