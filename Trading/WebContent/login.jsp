<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Log in</title>
</head>

<body style="background-color: rgb(5, 103, 208)">

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#"><font
			style="color: rgb(5, 103, 208)">Coinboss</font></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav"> 
				<a class="nav-item nav-link" href="help.jsp">Help</a> 
				<a class="nav-item nav-link" href="prices.jsp">Prices</a>
			</div>
		</div>

		<a class="btn btn-primary" href="register.jsp"
			style="margin-right: 40px;color:white;">Sign Up</a>
				
	</nav>
	
	
	
	<div class="row">
		<div class="col col-lg-12" style="height: 100px;"></div>
	</div>
	<div class="row">
		<!-- <div class="col col-lg-4" style="height: 100px;"></div> -->
		<div class="col col-lg-12" style="height: 100px;">
			<h3 style="text-align: center;">
				<font color="white">Sign in to Coinboss</font>
			</h3>
		</div>
		<!-- <div class="col col-lg-4" style="height: 100px;"></div> -->
	</div>
	<div class="row">
	
		<div class="col col-3"></div>


		<div class="col col-6">
			<div class="card bg-light text-white">			
				<div class="card-body ">
                    <form action="LoginServlet" method="GET">
                        <div class="form-group">
                            <label style="color:rgb(5, 103, 208)">User name</label> <input class="form-control" name="name"
                                placeholder="Enter username"> <small
                                class="form-text text-muted"></small>
                        </div>
                        <div class="form-group">
                            <label style="color:rgb(5, 103, 208)">Password</label> <input type="password"
                                class="form-control" name="password" placeholder="Password">
                        </div>
                        <div class="form-group form-check">
                            <input type="checkbox" class="form-check-input" name="rememberme">
                            <label class="form-check-label" style="color:rgb(5, 103, 208)">Remember me</label>
                        </div>
                        <button type="submit" class="btn btn-primary" style="">Sign
                            in</button>
                        <br> <br> <a href="/Trading/register.jsp" class="button"
                            style="color: rgb(5, 103, 208)">Sign up here</a>
                    </form>				
				</div>
			</div>
		</div>


		<div class="col col-3"></div>
		
	</div>
	
	<br>
	
	<div class="row">
	<div class="col col-4">
	   
	   </div>
	   <div class="col col-4">
       <a href="#" style="color:white; margin: 5px; text-align: center;">Forgot password?</a>
       <a href="#" style="color:white; margin: 5px; text-align: center;">Don't have an account?</a>
       <a href="#" style="color:white; margin: 5px; text-align: center;">Privacy Policy</a>
       </div>
       <div class="col col-4">
       
       </div>
	</div>
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>