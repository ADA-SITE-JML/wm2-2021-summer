<%@ page errorPage="errorPage.jsp"%>
<%@ page import="java.util.*"%>
<html>
    <head>
        <title>CSGO Major winners</title>
    </head>
<style>
body {
    background-color: #e1e5ea;
}
h1 {
    text-align: center;
    color: #da7f8f;
}

span {
    display: flex;
    text-align: left;
    justify-content: center;
}

.user-info {
    display: flex;
    justify-content: center;
    flex-direction: column;
    text-align: left;
}
</style>
    <body>
        <%
         Map<Integer, String> winners = new HashMap<Integer, String>(){{
            put(2013, "Fnatic");
            put(2014, "VirtusPro, Ninjas in Pyjamas, LDLC");
            put(2015, "Fnatic, Fnatic, Envy");
            put(2016, "Luminosity Gaming, SK");
            put(2017, "Astralis, Gambit");
            put(2018, "Cloud9, Astralis");
            put(2019, "Astralis, Astralis");
         }};
        %>
        <h1>CSGO Major winner(s) in <%=request.getParameter("year")%> </h1>
        <span class="teams">
        <%
            String year = request.getParameter("year");
            String[] teams = winners.get(Integer.valueOf(year)).split(",");

            for (String team : teams) {
            out.println(team+"<br>");
            }
        %>
        </span>
        <br>
        <h1> User information: </h1>
        <div class="user-info">
            <span>User Agent: <%=request.getHeader("user-agent")%></span>
        <span>IP address: <%=request.getRemoteAddr()%></span>
        </div>
    </body>
</html>
