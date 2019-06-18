<%@page import="com.traderjoey.utils.LoadUtil"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Dashboard</title>
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
<%
    LoadUtil loadUtil = new LoadUtil();
%>
<%
    String btcjson = loadUtil.readJsonFromUrl(
					"https://api.nomics.com/v1/candles?key=41627720a6147a36a0bad2ab339d557b&currency=BTC&interval=1d&start=2018-05-10T06%3A00%3A00Z&end=2019-06-15T09%3A00%3A00Z");
			String ethjson = loadUtil.readJsonFromUrl(
					"https://api.nomics.com/v1/candles?key=41627720a6147a36a0bad2ab339d557b&currency=ETH&interval=1d&start=2019-05-10T06%3A00%3A00Z&end=2019-06-15T09%3A00%3A00Z");
%>

<body>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="index.jsp"><font style="color:rgb(5,103,208)">Coinboss</font></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-item nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                <a class="nav-item nav-link" href="buy.jsp">Buy/Sell</a> <a
                    class="nav-item nav-link active" href="#">Dashboard</a> <a
                    class="nav-item nav-link" href="prices.jsp">Prices</a>
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
	<!-- Styles -->
	<style>
#BTC {
	width: 100%;
	height: 500px;
}

#ETH {
	width: 100%;
	height: 500px;
}
</style>

	<!-- Resources -->
	<script src="https://www.amcharts.com/lib/4/core.js"></script>
	<script src="https://www.amcharts.com/lib/4/charts.js"></script>
	<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>

	<!-- BTC price -->
	<script>
		am4core
				.ready(function() {

					// Themes begin
					am4core.useTheme(am4themes_animated);
					// Themes end

					var chart = am4core.create("BTC", am4charts.XYChart);
					chart.paddingRight = 20;

					chart.dateFormatter.inputDateFormat = "yyyy-MM-dd";

					var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
					dateAxis.renderer.grid.template.location = 0;

					var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
					valueAxis.tooltip.disabled = true;

					var series = chart.series
							.push(new am4charts.CandlestickSeries());
					series.dataFields.dateX = "timestamp";
					series.dataFields.valueY = "close";
					series.dataFields.openValueY = "open";
					series.dataFields.lowValueY = "low";
					series.dataFields.highValueY = "high";
					series.tooltipText = "Open:{openValueY.value}\nLow:{lowValueY.value}\nHigh:{highValueY.value}\nClose:{valueY.value}";

					// important!
					// candlestick series colors are set in states. 
					// series.riseFromOpenState.properties.fill = am4core.color("#00ff00");
					// series.dropFromOpenState.properties.fill = am4core.color("#FF0000");
					// series.riseFromOpenState.properties.stroke = am4core.color("#00ff00");
					// series.dropFromOpenState.properties.stroke = am4core.color("#FF0000");

					series.riseFromPreviousState.properties.fillOpacity = 1;
					series.dropFromPreviousState.properties.fillOpacity = 0;

					chart.cursor = new am4charts.XYCursor();

					// a separate series for scrollbar
					var lineSeries = chart.series
							.push(new am4charts.LineSeries());
					lineSeries.dataFields.dateX = "timestamp";
					lineSeries.dataFields.valueY = "close";
					// need to set on default state, as initially series is "show"
					lineSeries.defaultState.properties.visible = false;

					// hide from legend too (in case there is one)
					lineSeries.hiddenInLegend = true;
					lineSeries.fillOpacity = 0.5;
					lineSeries.strokeOpacity = 0.5;

					var scrollbarX = new am4charts.XYChartScrollbar();
					scrollbarX.series.push(lineSeries);
					chart.scrollbarX = scrollbarX;

					chart.data =
	<%=btcjson%>
		;

				}); // end am4core.ready()
	</script>
	<!-- ETH price -->
	<script>
		am4core
				.ready(function() {

					// Themes begin
					am4core.useTheme(am4themes_animated);
					// Themes end

					var chart = am4core.create("ETH", am4charts.XYChart);
					chart.paddingRight = 20;

					chart.dateFormatter.inputDateFormat = "yyyy-MM-dd";

					var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
					dateAxis.renderer.grid.template.location = 0;

					var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
					valueAxis.tooltip.disabled = true;

					var series = chart.series
							.push(new am4charts.CandlestickSeries());
					series.dataFields.dateX = "timestamp";
					series.dataFields.valueY = "close";
					series.dataFields.openValueY = "open";
					series.dataFields.lowValueY = "low";
					series.dataFields.highValueY = "high";
					series.tooltipText = "Open:{openValueY.value}\nLow:{lowValueY.value}\nHigh:{highValueY.value}\nClose:{valueY.value}";

					// important!
					// candlestick series colors are set in states. 
					// series.riseFromOpenState.properties.fill = am4core.color("#00ff00");
					// series.dropFromOpenState.properties.fill = am4core.color("#FF0000");
					// series.riseFromOpenState.properties.stroke = am4core.color("#00ff00");
					// series.dropFromOpenState.properties.stroke = am4core.color("#FF0000");

					series.riseFromPreviousState.properties.fillOpacity = 1;
					series.dropFromPreviousState.properties.fillOpacity = 0;

					chart.cursor = new am4charts.XYCursor();

					// a separate series for scrollbar
					var lineSeries = chart.series
							.push(new am4charts.LineSeries());
					lineSeries.dataFields.dateX = "timestamp";
					lineSeries.dataFields.valueY = "close";
					// need to set on default state, as initially series is "show"
					lineSeries.defaultState.properties.visible = false;

					// hide from legend too (in case there is one)
					lineSeries.hiddenInLegend = true;
					lineSeries.fillOpacity = 0.5;
					lineSeries.strokeOpacity = 0.5;

					var scrollbarX = new am4charts.XYChartScrollbar();
					scrollbarX.series.push(lineSeries);
					chart.scrollbarX = scrollbarX;

					chart.data =
	<%=ethjson%>
		;

				}); // end am4core.ready()
	</script>


	<div>
		<h2>Bitcoin Price</h2>
		<div id="BTC"></div>
	</div>

	<div>
	    <h2>Ethe Price</h2>
		<div id="ETH"></div>
	</div>

</body>
</html>