<%@ page isErrorPage="true"%>
<HTML>
<HEAD><TITLE>Error Page</TITLE></HEAD>
<style type="text/css">
	body{
		background-color: #9FC2B9;
	}
	.error{
		background-color: aliceblue;
		width: 90%;
    	height: 90%;
    	margin: auto;
    	margin-top: 40px;

	}
	.error-type{
		padding: 10%;	
		height: 25%;
	}
	h1{
		font-size: 108px;
    	text-align: center;
    	color: #336178;
	}
	span{
		font-size: 60%;
		color: #AE485E;
	}
	.error-message{
		
    size: 25%;
    width: 50%;
    margin: auto;
    margin-bottom: 25px;
    font-size: 20px;
	}
	
</style>
<BODY>
	<div class="error">
		<div class="error-type">
			<h1 id="500">500 <span>Server Error</span></h1>
		</div>
		<div class="error-message">	

		<p>Oops, something went wrong.<p>


		The problem: ${pageContext.exception}
		<p>Please enter valid numbers</p>

		</div>
	</div>
	

</BODY>
</HTML>
