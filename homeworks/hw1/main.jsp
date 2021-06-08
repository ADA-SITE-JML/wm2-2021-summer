<%@ page errorPage="errorPage.jsp" %>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="main.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,100;0,300;0,400;0,700;0,900;1,100;1,300;1,400;1,700;1,900&display=swap" rel="stylesheet">
	<title>HW #1 </title>
</head>
<body>
<section id="main">
	<h1>Rock Paper Scissors Game</h1>
	<h5>Khanim Huseynzada | WM 2 | HW #1 </h5>
	
	<%   
	String [] images = {"./images/rock.png", "./images/paper.png", "./images/scissors.png"};
	Random r=new Random();        
	int randomNumber=r.nextInt(images.length);
	for(int i =0; i<images.length; i++){
		if(i==randomNumber){	%>
		<div id="image-container">
			<img src="<%=images[i]%>">
		</div>

	
	<%}}%>
	
		<h1>Your Choice was:

		<%
			String myChoice = request.getParameter("choice");
			out.print(myChoice);
		%>
	</h1>
</section>
</body>
</html>

