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
<body>
	<div class="row">
        <div class="col col-lg-12" style="height: 200px;"></div>
    </div>
	<div class="row">
		<div class="col col-3"></div>
		<div class="col col-6">
			<form action="LoginServlet" method="GET">
				<div class="form-group">
					<label>User name</label> 
					<input
						class="form-control" name="username"
						placeholder="Enter username"> 
						<small class="form-text text-muted">We'll never
						share your user name with anyone else.</small>
				</div>
				<div class="form-group">
					<label>Password</label>
					 <input
						type="password" class="form-control" name="password"
						placeholder="Password">
				</div>
				<div class="form-group form-check">
					<input type="checkbox" class="form-check-input" name="rememberme">
					<label class="form-check-label">Remember me</label>
				</div>
				<button type="submit" class="btn btn-primary"  style="padding=30px;">Sign in</button>
				
				<a href="/Trading/register.jsp" class="button" style="margin-left:450px;">Sign up here</a>
			</form>

		</div>
		<div class="col col-3"></div>
	</div>


	
</body>
</html>