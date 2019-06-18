<%@page import="com.traderjoey.utils.LoadUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- FIXME fan 
	本页面用且仅用于登录,不登录不能使用任何业务,所以它应至少实现3个功能:
	1.用户名为空时要弹框提示,或者在旁边红字提示
	2.密码为空时也要提示,密码规则:必须有数字和特殊符号,且不能包含用户名
	3.用post方法传参数给LoginServlet-->
<html>
<head>
<meta charset="ISO-8859-1">

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

<!-- amchart import -->
<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/kelly.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
<script src="https://www.amcharts.com/lib/4/maps.js"></script>
<script src="https://www.amcharts.com/lib/4/geodata/worldLow.js"></script>
<script src="https://www.amcharts.com/lib/4/geodata/continentsLow.js"></script>

<!-- own import -->
<script src="js/map.js"></script>


<title>Coinboss</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#"><font style="color:rgb(5,103,208)">Coinboss</font></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<a class="nav-item nav-link active" href="#">Home <span
					class="sr-only">(current)</span></a> <a class="nav-item nav-link"
					href="buy.jsp">Buy/Sell</a> <a class="nav-item nav-link" href="dashboard.jsp">Dashboard</a>
				<a class="nav-item nav-link" href="prices.jsp">Prices</a>
			</div>
		</div>
		
        <button type="button" class="btn btn-success" style="margin-right:40px;">Invite friends, earn $10</button>
		<div class="dropdown pull-right" style="margin-right: 40px;">
		    
			<a class="btn btn-primary dropdown-toggle " href="#" role="button"
				id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-user"></i></a>
			<div class="dropdown-menu dropdown-menu-right shadow-lg bg-white rounded" aria-labelledby="dropdownMenuButton" style="margin-top:20px;">
				<a class="dropdown-item" href="#">Settings</a> 
				<a class="dropdown-item" href="#">Help</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="#"><font color="red">Sign
						out</font></a>
			</div>

		</div>
	</nav>
	<div id="headbreaker" class="row">
		<br> <br>
	</div>
	<div class="container">

		<div class="row">

			<div class="card w-100 shadow-sm bg-white rounded">
				<!-- <img src="..." class="card-img-top" alt="..."> -->
				<div class="card-body">
					<h5 class="card-title">Invest automatically with recurring
						buys</h5>
					<p class="card-text text-muted">Traditional investors have used
						dollar-cost averaging for years, and now you can, too, with
						recurring purchases for crypto.</p>
					<a href="buy.jsp" class="btn btn-primary">Get Started</a>
				</div>
			</div>

		</div>

		<div id="headbreaker" class="row">
			<br> <br>
		</div>

		<div class="card-group row">
			<!-- Following -->

			<div class="card w-100">
				<div class="card-header">
					<b>Following</b>
				</div>
			</div>


		</div>
		<!-- card-group -->
		<div class="card-group row ">

			<div class="card w-50">
				<div class="card-body"
					style="padding-left: 0; padding-right: 0; padding-bottom: 0; padding-top: 10px;">
					<div>
						<img src="image/btc.png" width="24" hight="24"
							style="margin-left: 20px;"> <label>BTC</label> <small
							class="text-muted" style="float: right; margin-right: 20px;">1
							month</small>
					</div>
					<div id="chart_btc" style="height: 280px;"></div>
				</div>
			</div>

			<div class="card w-50">
				<div class="card-body"
					style="padding-left: 0; padding-right: 0; padding-bottom: 0; padding-top: 10px;">
					<div>
						<img src="image/eth.png" width="24" hight="24"
							style="margin-left: 20px;"> <label>ETH</label> <small
							class="text-muted" style="float: right; margin-right: 20px;">1
							month</small>
					</div>
					<div id="chart_eth" style="height: 280px;"></div>
				</div>
			</div>

		</div>

		<div class="row">

			<div class="card w-100 shadow-sm bg-white rounded">
				<div class="card-body" style="text-align: center; padding: 1rem;">
					<a href="list.jsp">Discover more assets ></a>
				</div>

			</div>

		</div>


		<!--  -->
		<div id="headbreaker" class="row">
			<br> <br>
		</div>

		<div class="row">
			<div class="card w-100 shadow-sm bg-white rounded">
				<!-- <img src="..." class="card-img-top" alt="..."> -->
				<div class="card-body" style="padding: 0;">
					<div class="row">
						<div class="col-8"
							style="padding-top: 1.25rem; padding-left: 2rem;">
							<h5 class="card-title">Earn free crypto with Coinboss Earn</h5>
							<p class="card-text text-muted">Learn about different
								cryptocurrencies and earn them for free!</p>
							<a href="#" class="btn btn-primary">Earn crypto</a>
						</div>
						<div class="col">
							<img src="image/earn_dash_banner.png" width="300"
								style="float: right; position: relative">
						</div>
					</div>
				</div>
			</div>
		</div>


		<div id="headbreaker" class="row">
			<br> <br>
		</div>

		<div class="row ">
			<div class="card-deck " style="width: 1170px;">
				<div class="card w-50 shadow-sm bg-white rounded">
					<div class="card-header">
						<font><b>Exchange Market</b></font>
					</div>
					<div class="card-body" style="padding: 0;">
						<div id="map" style="height: 300px;"></div>
					</div>
					<div class="card-footer">
						<small class="text-muted"></small>
					</div>
				</div>
				<div class="card w-50 shadow-sm bg-white rounded">
					<div class="card-header">
						<font><b>Recent Activity</b></font>
					</div>
					<div class="card-body" style="padding: 0;">
						<ul class="list-group list-group-flush">
							<li class="list-group-item" style="text-align: center;"><font>Your
									don't have recent history</font></li>

						</ul>
					</div>
					<div class="card-footer" style="text-align: center;">
						<small class="text-muted"><a href="#"><font>View
									your accounts ></font></a></small>
					</div>
				</div>
			</div>
		</div>

		<div id="headbreaker" class="row">
			<br> <br> <br>
		</div>
	</div>

</body>


<%
    LoadUtil loadUtil = new LoadUtil();
%>
<%
    String btc_json = loadUtil.readJsonFromUrl(
					"https://api.nomics.com/v1/candles?key=41627720a6147a36a0bad2ab339d557b&currency=BTC&interval=1d&start=2019-05-16T00%3A00%3A00Z&end=2019-06-16T00%3A00%3A00Z");
			String eth_json = loadUtil.readJsonFromUrl(
					"https://api.nomics.com/v1/candles?key=41627720a6147a36a0bad2ab339d557b&currency=ETH&interval=1d&start=2019-05-16T00%3A00%3A00Z&end=2019-06-16T00%3A00%3A00Z");
%>
<!-- chart ETH -->
<script>
	am4core.ready(function() {

		// Themes begin

		//am4core.useTheme(am4themes_kelly);
		am4core.useTheme(am4themes_animated);
		// Themes end

		// Create chart instance
		var chart = am4core.create("chart_eth", am4charts.XYChart);

		// Add data
		chart.data =
<%=eth_json%>
	;

		// Create axes
		var dateAxis = chart.xAxes.push(new am4charts.DateAxis());

		var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

		// Create series
		var series = chart.series.push(new am4charts.LineSeries());
		series.dataFields.valueY = "open";
		series.dataFields.dateX = "timestamp";
		series.strokeWidth = 3;
		series.fillOpacity = 0.5;

		// Add cursor
		chart.cursor = new am4charts.XYCursor();
		chart.cursor.behavior = "zoomY";
		chart.cursor.lineX.disabled = true;

	});
</script>

<!-- chart BTC -->
<script>
	am4core.ready(function() {

		// Themes begin
		//am4core.useTheme(am4themes_animated);
		am4core.useTheme(am4themes_kelly);
		// Themes end

		// Create chart instance
		var chart = am4core.create("chart_btc", am4charts.XYChart);

		// Add data
		chart.data =
<%=btc_json%>
	;

		// Create axes
		var dateAxis = chart.xAxes.push(new am4charts.DateAxis());

		var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

		// Create series
		var series = chart.series.push(new am4charts.LineSeries());
		series.dataFields.valueY = "open";
		series.dataFields.dateX = "timestamp";
		series.strokeWidth = 3;
		series.fillOpacity = 0.5;

		// Add cursor
		chart.cursor = new am4charts.XYCursor();
		chart.cursor.behavior = "zoomY";
		chart.cursor.lineX.disabled = true;

	}); // end am4core.ready()
</script>
<footer>
	<div>
		<div
			style="background-color: cornflowerblue; height: 50px; text-align: center;">
			<div style="text-align: center">
				<font class="text-muted"> &copy 2019 Coinboss</font>
			</div>
		</div>
	</div>

</footer>
</html>