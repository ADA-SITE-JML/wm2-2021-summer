<%@ page errorPage="errorPage.jsp" %>
<%@ page import="java.util.*"%>
<%@ page import= "java.text.DecimalFormat" %>
<%! public int x = 55; %>
<!-- <%! public int squareRoot; %>
<%! public int logarithm; %> -->

<!DOCTYPE html>
<html>
<head>
	<title>
		
	</title>
</head>
<style type="text/css">

	html{
		position: relative;
	}
	
	.log, .sqrt{
		    float: left;
		    text-align: center;
		    border: 5px solid #AE485E;
		    border-radius: 12px;
		    background-color: lightblue;
		    text-align: center;
		    margin-top: 25%;
		    margin-left: 15%;


	}
	.log{
		margin-left: 25%;
	}
	.esas{
		width: 100%;
		height: 80%;



	}
	.hello{
		background-color: blueviolet;
	}
	h2{
		font-weight: normal;
	}
	.system-info{
		    float: left;
		    text-align: center;
		    border: 5px solid #AE485E;
		    border-radius: 12px;
		    background-color: lightblue;
		    text-align: center;
		    position: absolute;
		    left: 10%;

	}
	


</style>
<body>

		<div class="system-info">
			<h1>Environment Information: Browser and OS </h1>
			<h2>
				<% 
			String userAgent = request.getHeader("User-Agent");
			 out.println(userAgent);

		%>
		</h2>
		</div>
	
		
		<div class="sqrt">
				<h1>Square Root</h1>
					<h2>Entered Number:
						<%
							int firstNum = Integer.parseInt(request.getParameter("sqrt"));
							out.println(firstNum);
						%></h2>
					<h2>Square Root of a Number:
						<%
							double squareRoot = Math.sqrt(firstNum);
							DecimalFormat df1 = new DecimalFormat("#.####");
							out.println(df1.format(squareRoot));

						%></h2>
		</div>	
		<div class="log">
				<h1>Logarithm</h1>
					<h2>Entered Number:
						<%
							int secondNum = Integer.parseInt(request.getParameter("log"));
							out.println(secondNum);
						%></h2>
					<h2>Logarithm of a Number:
						<%
							double logarithm = Math.log(secondNum);
							DecimalFormat df2 = new DecimalFormat("#.####");
							out.println(df2.format(logarithm));

						%></h2>
		</div>
	
	



		
		<%


		if (Double.isNaN(squareRoot) || Double.isNaN(logarithm))


  			throw new Exception("Cannot find a square root or logarithm of negative number");
   
	%>

</body>
</html>