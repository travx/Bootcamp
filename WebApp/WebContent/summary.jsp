<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; UTF-8">
    <link rel="stylesheet" type="text/css" href="scripts/jchartfx/styles/chartfx.css" />
    <script type="text/javascript" src="scripts/jchartfx/js/jchartfx.system.js"></script>
    <script type="text/javascript" src="scripts/jchartfx/js/jchartfx.coreVector.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

	
<script type="text/javascript">
function loadChart()
{
	chart1 = new cfx.Chart();
	chart1.setGallery(cfx.Gallery.Lines);

	var fields = chart1.getDataSourceSettings().getFields();
	var field1 = new cfx.FieldMap();
	var field2 = new cfx.FieldMap();
	var field3 = new cfx.FieldMap();
	
	field1.setName("order_date_hours");
	field1.setDisplayName("Hour");
	field1.setUsage(cfx.FieldUsage.Label);
	fields.add(field1);
	
	field2.setName("hourly_total");
	field2.setDisplayName("Total");
	field2.setUsage(cfx.FieldUsage.Value);
	fields.add(field2);

	field3.setName("moving_average");
	field3.setDisplayName("Moving Average");
	field3.setUsage(cfx.FieldUsage.Value);
	fields.add(field3);
	
	var data = <% out.print(request.getAttribute("moving_average"));%>
	chart1.setDataSource(data);   
	var divHolder = document.getElementById('ChartDiv');
	chart1.create(divHolder);
}
</script>    
    
<title>Summary</title>
</head>

<body onload="loadChart()">
<h1>Summary of All Orders</h1>
<div id="ChartDiv" style="width:800px;height:400px;display:inline-block"></div>
</body>
</html>


