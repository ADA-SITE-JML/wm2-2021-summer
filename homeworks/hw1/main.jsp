<html>
<head>
    <title>String Reverser</title>
    <style>
        html, body {
            width: 100%;
            height: 100%;
            background-color: #32a852;
        }

        .content {
            position: absolute;
            left: 50%;
            top: 50%;
            -webkit-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
            padding: 10px;

            text-align: center;
            font-family: Arial, serif;
            font-size: 2em;
            color: #F0F7F4;
            line-height: 180%;

            border: 3px solid;
            border-radius: 8px;
        }

        p {
            font-size: 20px;
        }
    </style>
</head>

<body>
<%@ page errorPage="errorPage.jsp" %>

<div class="content">
    <%
        String original = request.getParameter("str");
        if (original.isEmpty()) throw new Exception("The provided string is empty");
        StringBuilder stringBuilder = new StringBuilder(original);
        String reversed = stringBuilder.reverse().toString();

        out.print("<b> Original String: </b>" + original + "<br>");
        out.print("<b> Reversed String: </b>" + reversed + "<br>");

        String userAgent = request.getHeader("User-Agent");
        String userBrowser = null;
        String userOs = null;
        String[] browserCodes = {"Chrome", "Firefox", "Safari", "Opera", "MSIE"};
        String[] browserNames = {"Chrome", "Firefox", "Safari", "Opera", "Internet Explorer"};
        String[] osCodes = {"Win", "Mac", "X11", "Linux", "Android"};
        String[] osNames = {"Windows", "MacOS", "Linux", "Linux", "Android"};

        for (int i = 0; i < browserCodes.length; i++)
        {
            if (userAgent.contains(browserCodes[i]))
            {
                userBrowser = browserNames[i];
                break;
            }
        }

        for (int i = 0; i < osCodes.length; i++)
        {
            if (userAgent.contains(osCodes[i]))
            {
                userOs = osNames[i];
                break;
            }
        }

        out.print("<hr> <p>");
        out.print("<b> Browser: </b>" + userBrowser + "<br>");
        out.print("<b> OS: </b>" + userOs);
        out.print("<p>");
    %>
</div>
</body>
</html>