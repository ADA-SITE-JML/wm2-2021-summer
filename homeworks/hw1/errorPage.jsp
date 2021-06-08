<%@ page isErrorPage="true"%>
<HTML>
<HEAD><TITLE>Error Page</TITLE></HEAD>
<BODY>
	<h1>Sorry, but something happened....</h1>

	The problem: ${pageContext.exception}

	<div id="game-rules">
		Enter <span>Rock/Paper/Scissors</span> as a request parameter and wait for the opponent's reponse
	</div>
</BODY>
</HTML>
