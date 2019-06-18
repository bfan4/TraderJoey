
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
<!DOCTYPE html>
<!-- FIXME fan ready for debug
    本页面的需求:
    1.要有确认密码的功能,两次输入密码不一致要提示
    2.参数post给RegisterServlet-->
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Sign up</title>
<script>
	// Function to check Whether both passwords 
	// is same or not. 
	function checkPassword(form) {
		password1 = form.password.value;
		password2 = form.checkpassword.value;

		// If password not entered 
		if (password1 == '')
			alert("Please enter Password");

		// If confirm password not entered 
		else if (password2 == '')
			alert("Please enter confirm password");

		// If Not same return False.     
		else if (password1 != password2) {
			alert("\nPassword did not match: Please try again...")
			return false;
		}

		// If same return True. 
		else {
			alert("Sign up successful! Welcome Trader Joey")
			return true;
		}
	}
</script>

</head>



<body style="background-color: rgba(21, 82, 240)">

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
				<a class="nav-item nav-link" href="help.jsp">Help</a> <a
					class="nav-item nav-link" href="prices.jsp">Prices</a>
			</div>
		</div>

		<a href="login.jsp" class="btn btn-primary"
			style="margin-right: 40px; color: white;">Sign In</a>

	</nav>




	<div class="row" style="width:100%;">
		<div class="col col-lg-12" style="height: 80px;"></div>
	</div>

	<div class="row" style="width:100%;">
		<div class="col col-lg-12"
			style="height: 100px; color: white; text-align: center;">
			<h3>Create your account</h3>
		</div>
	</div>

	<div class="row" style="width:100%;">
		<div class="col col-lg-3" style="height: auto;"></div>
		<div class="col col-lg-6" style="height: 500px;">
			<!-- onSubmit="return checkPassword(this)" -->
			<!-- Sign up form -->
			<div class="card bg-light text-white">
				<div class="card-body ">
					<form action="RegisterServlet" method="POST"
						onSubmit="return checkPassord(this)">
						<div class="form-group">
							<label style="color: black">Your User name</label> <input
								class="form-control" name="username"
								placeholder="Choice your own user name"> <small
								id="usernamehelp" class="form-text text-muted">You may
								user your email as your user name</small>
						</div>
						<div class="form-group">
							<label style="color: black">Password</label> <input
								type="password" class="form-control" name="password"
								placeholder="Password"> <small id="usernamehelp"
								class="form-text text-muted"> <span>Be a minimum
									of eight (8) characters in length;</span>
							</small>
						</div>
						<div class="form-group">
							<label style="color: black">Please confirm your password</label>
							<input type="password" class="form-control" name="checkpassword"
								placeholder="Comfirm Password">
						</div>
						<div class="form-group">
							<input type="checkbox" value="confirm-policy"> 
							<label style="color: black;margin-left:10px;">I certify that I agree to the User Agreement and Privacy Policy. </label>
						</div>
						<button type="submit" class="btn btn-block btn-primary">Create
							account</button>
					</form>
				</div>
			</div>
			<!-- sign up form end -->

		</div>

		<div class="col col-lg-3" style="height: auto;"></div>
	</div>
	<div class="row" style="width:100%;">
	
	<div class="col col-lg-4" style="height: auto;"></div>
	
	<div class="col col-lg-4" style="height: auto; text-align:center;">
	<font color="white">Already have a Coinboss account?</font>
	<a href="login.jsp" style="color:white;">Log in</a>
	</div>
	
	<div class="col col-lg-4" style="height: auto;"></div>
	
	</div>




</body>
</html>