
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
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
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



<body>
	<div class="row">
		<div class="col col-lg-12" style="height: 200px;"></div>
	</div>

	<div class="row">
		<div class="col col-lg-4" style="height: auto;"></div>
		<div class="col col-lg-4" style="height: 575px;">
            <!-- onSubmit="return checkPassword(this)" -->
			<!-- Sign up form -->
			<form action="RegisterServlet"  method="POST" onSubmit="return checkPassord(this)">
				<div class="form-group">
					<label>Your User name</label> <input class="form-control"
						name="username" placeholder="Choice your own user name"> <small
						id="usernamehelp" class="form-text text-muted">You may
						user your email as your user name</small>
				</div>
				<div class="form-group">
					<label>Password</label> <input type="password" class="form-control"
						name="password" placeholder="Password"> <small
						id="usernamehelp" class="form-text text-muted"> <span>Be
							a minimum of eight (8) characters in length;</span><br> <span>Contain
							at least one (1) character from three (3) of the following
							categories:</span><br> <span> * Upper case letter (A-Z);</span><br>
						<span> * Lower case letter (A-Z);</span><br> <span> *
							Special character (~`!@#$%^&*()+=_-{}[]\|:;”’?/<>,.) </span><br>
					</small>
				</div>
				<div class="form-group">
					<label>Please confirm your password</label> <input type="password"
						class="form-control" name="checkpassword"
						placeholder="Comfirm Password">
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
			<!-- sign up form end -->

		</div>

		<div class="col col-lg-4" style="height: auto;"></div>
	</div>

	<div class="row">
		<div class="col col-lg-12"
			style="height: 50px; background-color: black"></div>
	</div>



</body>
</html>