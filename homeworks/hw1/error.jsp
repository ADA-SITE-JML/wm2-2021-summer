<%@ page isErrorPage="true" %>
<HTML>
    <HEAD>
        <TITLE>Error Message</TITLE>
        <link href="./loginstyle.css" rel="stylesheet" type="text/css">
    </HEAD>
    <BODY>
        <h1>Oops, something wasn"t right</h1>
        <h4>The problem: ${pageContext.exception}</h4>
    </BODY>
</HTML>
