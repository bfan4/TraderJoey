<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top 50 cryptocurrency prices</title>
<!-- Bootstrap import -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<!-- fontawesome import -->
<script src="https://kit.fontawesome.com/9ad0806a99.js"></script>
</head>
<body>

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
				<a class="nav-item nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
				<a class="nav-item nav-link" href="buy.jsp">Buy/Sell</a> <a
					class="nav-item nav-link" href="dashboard.jsp">Dashboard</a> <a
					class="nav-item nav-link active" href="#">Prices</a>
			</div>
		</div>

		<button type="button" class="btn btn-success"
			style="margin-right: 40px;">Invite friends, earn $10</button>
		<div class="dropdown pull-right" style="margin-right: 40px;">

			<a class="btn btn-primary dropdown-toggle " href="#" role="button"
				id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-user"></i></a>
			<div
				class="dropdown-menu dropdown-menu-right shadow-lg bg-white rounded"
				aria-labelledby="dropdownMenuButton" style="margin-top: 20px;">
				<a class="dropdown-item" href="#">Settings</a> <a
					class="dropdown-item" href="#">Help</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="#"><font color="red">Sign
						out</font></a>
			</div>

		</div>
	</nav>


	<div class="container">
	
		<div>
			<br> <br>
		</div>
		
		
		<div class="row">
			<div class="col col-12">
				<form class="form-inline">

					<div class="form-group mx-sm-3 mb-2">
						<label for="inputPassword2" class="sr-only">Serach</label> <input
							type="password" class="form-control" id="inputPassword2"
							placeholder=...>
					</div>
					<button type="submit" class="btn btn-primary mb-2">search</button>
				</form>

			</div>
		</div>
		
		<div class="row">
               		
		
		</div>


	</div>

























</body>
</html>