<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; UTF-8">
    <link rel="stylesheet" type="text/css" href="scripts/jchartfx/styles/chartfx.css" />
    <script type="text/javascript" src="scripts/jchartfx/js/jchartfx.system.js"></script>
    <script type="text/javascript" src="scripts/jchartfx/js/jchartfx.coreVector.js"></script>
    <script type="text/javascript" src="scripts/jchartfx/js/jchartfx.heatmap.js"></script>      
	<script type="text/javascript" src="scripts/jchartfx/js/jchartfx.advanced.js"></script> 
	<script type="text/javascript" src="scripts/jchartfx/js/jchartfx.data.js"></script> 
	<script type="text/javascript" src="https://jquery-json.googlecode.com/files/jquery.json-2.4.min.js	"></script> 
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="scripts/jchartfx/js/jchartfx.animation.js"></script> 

<script type="text/javascript">
function generatePage(){
	loadChart1();
	loadChart2();
	loadChart3();
	loadChart4();
	loadChart5();
}

function loadChart1()
{
	chart1 = new cfx.Chart();
	chart1.setGallery(cfx.Gallery.Bar);
	chart1.getAnimations().getLoad().setEnabled(true);

	var fields = chart1.getDataSourceSettings().getFields();
	var field1 = new cfx.FieldMap();
	var field2 = new cfx.FieldMap();
	
	field1.setName("recommendation");
	field1.setDisplayName("Recommendation");
	field1.setUsage(cfx.FieldUsage.Label);
	fields.add(field1);
	
	field2.setName("num_products");
	field2.setDisplayName("Total Products");
	field2.setUsage(cfx.FieldUsage.Value);
	fields.add(field2);

	var data = <% out.print(request.getAttribute("recommendations"));%>
	chart1.setDataSource(data);   
	var divHolder = document.getElementById('Counters');
	chart1.create(divHolder);
}

function loadChart2()
{
	chart1 = new cfx.Chart();
	chart1.setGallery(cfx.Gallery.Pie);
	chart1.getAnimations().getLoad().setEnabled(true);

	var fields = chart1.getDataSourceSettings().getFields();
	var field1 = new cfx.FieldMap();
	var field2 = new cfx.FieldMap();
	
	field1.setName("recommendation");
	field1.setDisplayName("Recommendation");
	field1.setUsage(cfx.FieldUsage.Label);
	fields.add(field1);
	
	field2.setName("num_products");
	field2.setDisplayName("Total Products");
	field2.setUsage(cfx.FieldUsage.Value);
	fields.add(field2);

	var data = <% out.print(request.getAttribute("recommendations_hive"));%>
	chart1.setDataSource(data);   
	var divHolder = document.getElementById('Hive');
	chart1.create(divHolder);
}

function loadChart3()
{
	chart1 = new cfx.Chart();
	
	var heatMap = new cfx.heatmap.HeatMap();
	chart1.setGalleryAttributes(heatMap);
	chart1.getAnimations().getLoad().setEnabled(true);
	
	var items = <% out.print(request.getAttribute("vendor_recommendations"));%>
	
	var fields = chart1.getDataSourceSettings().getFields();
	var field1 = new cfx.FieldMap();
	var field2 = new cfx.FieldMap();
	var fieldVal = new cfx.FieldMap();
	
	field1.setName("vendor");
	field1.setUsage(cfx.FieldUsage.RowHeading);
	fields.add(field1);

	field2.setName("recommendation");
	field2.setUsage(cfx.FieldUsage.ColumnHeading);
	fields.add(field2);
	
	fieldVal.setName("num_products");
	fieldVal.setUsage(cfx.FieldUsage.Value);
	fields.add(fieldVal);
	
	var crosstab = new cfx.data.CrosstabDataProvider();
	crosstab.setDataSource(items);
	
	chart1.setDataSource(crosstab);
	chart1.setAxesStyle(cfx.AxesStyle.None);
	
	var divHolder = document.getElementById('VendorHeatmap');
	chart1.create(divHolder);
}


function loadChart4()
{
	chart1 = new cfx.Chart();
	chart1.setGallery(cfx.Gallery.Bar);
	chart1.getAnimations().getLoad().setEnabled(true);

	var fields = chart1.getDataSourceSettings().getFields();
	var field1 = new cfx.FieldMap();
	var field2 = new cfx.FieldMap();
	
	field1.setName("product_name");
	field1.setDisplayName("Product");
	field1.setUsage(cfx.FieldUsage.Label);
	fields.add(field1);
	
	field2.setName("orders");
	field2.setDisplayName("Total Orders");
	field2.setUsage(cfx.FieldUsage.Value);
	fields.add(field2);

	var data = <% out.print(request.getAttribute("recommended_products"));%>
	chart1.setDataSource(data);   
	var divHolder = document.getElementById('RecommendedProducts');
	chart1.create(divHolder);
}

function loadChart5()
{
	chart1 = new cfx.Chart();
	chart1.setGallery(cfx.Gallery.Bar);
	chart1.getAnimations().getLoad().setEnabled(true);

	var fields = chart1.getDataSourceSettings().getFields();
	var field1 = new cfx.FieldMap();
	var field2 = new cfx.FieldMap();
	
	field1.setName("product_name");
	field1.setDisplayName("Product");
	field1.setUsage(cfx.FieldUsage.Label);
	fields.add(field1);
	
	field2.setName("orders");
	field2.setDisplayName("Total Orders");
	field2.setUsage(cfx.FieldUsage.Value);
	fields.add(field2);

	var data = <% out.print(request.getAttribute("vendor_recommended_products"));%>
	chart1.setDataSource(data);   
	var divHolder = document.getElementById('VendorRecommendedProducts');
	chart1.create(divHolder);
}

</script>    
    
<title>Recommendations</title>
</head>

<body onload="generatePage()">
<h1>Recommendation Summary</h1>
<table><tr>
<td>
<div id="Counters" style="width:400px;height:400px;display:inline-block"></div>
</td>
<td>
<div id="Hive" style="width:400px;height:400px;display:inline-block"></div>
</td>
</tr></table>
<h3>Vendor Recommendation Heatmap</h3>
<div id="VendorHeatmap" style="width:800px;height:400px;display:inline-block"></div>
<h3>Top 20 Recommended Products</h3>
<div id="RecommendedProducts" style="width:800px;height:400px;display:inline-block"></div>
<h3>Top 20 Recommended Products for <%out.print(request.getParameter("vendor")); %></h3>
<div id="VendorRecommendedProducts" style="width:800px;height:400px;display:inline-block"></div>
</body>
</html>


