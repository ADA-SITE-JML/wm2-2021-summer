<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
	<title>Error Page</title>
</head>
<style type="text/css">
	
	.my-link{
		background: #fff;
		color:#a80000;
		border: 1px solid #a80000;
		font-weight: 650;
		font-size: 16px;
		padding: 10px 15px;
		text-decoration: none;
		border-radius: 5px;
		transition: all 0.3s;
	}
	.my-link:hover{
		border-color: transparent;
		color: #fff;
		background: #a80000;
	}

	.error{
		background: #a80000;
		color:#fff;
		font-weight: 600;
		font-size: 18px;
		border: 1px solid transparent;
		border-radius: 5px;
		padding: 10px;
	}
	.main{
		width: 40%;
		margin-left: 30%;
		margin-top: 100px;
	}
	.l-div{
		display: flex;
		justify-content: center;
		align-items: center;
	}

</style>
<body>
	<div class="main">
		<h1>Sorry, but something happened....</h1>

		<div class="error">
			The problem: ${pageContext.exception}
		</div>
		<br>
		<br>
		<div class="l-div">
			<a href="/hw1/index.jsp" class="my-link">< Back to Home Page</a>
		</div>
	</div>
</body>
</html>