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
	chart1.setGallery(cfx.Gallery.Bar);
	chart2 = new cfx.Chart();
	chart2.setGallery(cfx.Gallery.Bar);
	
	var data = <% out.print(request.getAttribute("tokens"));%>
	var data1 = data.facet_counts.facet_fields.full_address;
	var jsondata = '[{';
	var jsondata2 = '[';
	
	for (var i=1; i<data1.length; i=i+2){
		jsondata = jsondata + '"' + data1[i-1] + '":' + data1[i] + ',';
		jsondata2 = jsondata2 + '{"Letter":"' + data1[i-1] + '","Count":' + data1[i] + '},';		
	}
	
	jsondata = jsondata.substring(0, jsondata.length-1);
	jsondata = jsondata + "}]";
	jsondata2 = jsondata2.substring(0, jsondata2.length-1);
	jsondata2 = jsondata2 + "]";
	
	chart1.setDataSource(jQuery.parseJSON(jsondata));   
	var divHolder = document.getElementById('Chart1');
	chart1.create(divHolder);
	
	chart2.setDataSource(jQuery.parseJSON(jsondata2));   
	var divHolder = document.getElementById('Chart2');
	chart2.create(divHolder);	
}

</script>    
    
<title>Solr Address</title>
</head>

<body onload="loadChart()">
<h1>Frequently Occurring Letters in Address</h1>
<div id="Chart2" style="width:1000px;height:400px;display:inline-block"></div>
<div id="Chart1" style="width:1000px;height:400px;display:inline-block"></div>
</body>
</html>


