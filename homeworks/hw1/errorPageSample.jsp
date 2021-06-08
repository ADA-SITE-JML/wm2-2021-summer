
<%@ page isErrorPage="true"%>
<HTML>
<HEAD>
  <TITLE>Error Page</TITLE>
</HEAD>

<style>
  #button{
    background-color: #a1261d;
      border: none;
      border-radius: 3px;
      color: white;
      padding: 20px;
      font-size: 15px;
      margin: 4px 2px;
      text-align: center;
      margin-left: 43%;
      text-decoration: none;
      display: inline-block;
  }

  h1, p{
    text-align: center;
  }

</style>

<BODY>

  <h1 style="margin-top: 13%;">Sorry, but something happened...</h1>

  <p>The problem: ${pageContext.exception}</p>

  <br>
  <br>
  <br>

  <a id = "button" href="/hw1/sample.jsp?a=15&b=3&s1=al&s2=alma">GO TO HOMEPAGE</a>

</BODY>
</HTML>