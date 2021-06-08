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
	String techInfo=	request.getHeader("User-Agent");
	%>


		<div id="image-container">
			<img src="<%=images[randomNumber]%>">
		</div>

	


	
		<h1>Your Choice was: 

		<%
			String myChoice = request.getParameter("choice");
			out.print(myChoice);
			%>
		</h1>
		<div>	
			<%
			switch(myChoice) {
			case "rock":
				switch(randomNumber){
					case 0:
					out.println("TIE");
					break;
					case 1:
					out.println("You Lose!");
					break;
					case 2:
					out.println("You Win!");
					break;
				}
				break;
				case "paper":
				switch(randomNumber){
					case 0:
					out.println("You Win!");
					break;
					case 1:
					out.println("TIE");
					break;
					case 2:
					out.println("You Lose!");
					break;
				}
				break;
				case "scissors":
				switch(randomNumber){
					case 0:
					out.println("You Lose!");
					break;
					case 1:
					out.println("You Win!");
					break;
					case 2:
					out.println("TIE");
					break;
				}
					break;
			default: throw new ServletException("Incorrect Input as a Choice");
					// code block
	}
	%></div>
		

	
	<div id="user-tech-info">
		
		<% 
out.print(techInfo);
		%>
	</div>

</section>
</body>
</html>

