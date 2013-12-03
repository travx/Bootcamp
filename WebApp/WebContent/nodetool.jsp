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
	<script type="text/javascript" src="scripts/jchartfx/js/jchartfx.animation.js"></script> 
	
<script type="text/javascript">
function loadPage(){
	loadChart1();
	loadChart2();
}

function loadChart1()
{
	chart1 = new cfx.Chart();
	chart1.setGallery(cfx.Gallery.Gantt);
	chart1.getAnimations().getLoad().setEnabled(true);

	var fields = chart1.getDataSourceSettings().getFields();
	var field1 = new cfx.FieldMap();
	var field2 = new cfx.FieldMap();
	var field3 = new cfx.FieldMap();
	var field4 = new cfx.FieldMap();
	var field5 = new cfx.FieldMap();
	var field6 = new cfx.FieldMap();
	
	field1.setName("Offset");
	field1.setDisplayName("Offset");
	field1.setUsage(cfx.FieldUsage.Label);
	fields.add(field1);
	
	field2.setName("SSTables");
	field2.setDisplayName("SSTables");
	field2.setUsage(cfx.FieldUsage.Value);
	fields.add(field2);

	field3.setName("WriteLatency");
	field3.setDisplayName("Write Latency");
	field3.setUsage(cfx.FieldUsage.Value);
	fields.add(field3);

	field4.setName("ReadLatency");
	field4.setDisplayName("Read Latency");
	field4.setUsage(cfx.FieldUsage.Value);
	fields.add(field4);
	
	field5.setName("RowSize");
	field5.setDisplayName("Row Size");
	field5.setUsage(cfx.FieldUsage.Value);
	fields.add(field5);
	
	field6.setName("ColumnCount");
	field6.setDisplayName("Column Count");
	field6.setUsage(cfx.FieldUsage.Value);
	fields.add(field6);	
	
	
	var data = <% out.print(request.getAttribute("cfhistograms"));%>
	chart1.setDataSource(data);   
	var divHolder = document.getElementById('CFHistograms');
	chart1.create(divHolder);
}

function loadChart2()
{
	chart1 = new cfx.Chart();
	chart1.setGallery(cfx.Gallery.Gantt);
	chart1.getAnimations().getLoad().setEnabled(true);

	var data = <% out.print(request.getAttribute("tppool"));%>
	chart1.setDataSource(data);   
	var divHolder = document.getElementById('TPPool');
	chart1.create(divHolder);
}
</script>    
    
<title>Performance Data</title>
</head>

<body onload="loadPage()">
<h1>nodetool cfhistograms</h1>
<div id="CFHistograms" style="width:600px;height:800px;display:inline-block"></div>
<h1>nodetool tpstats</h1>
<div id="TPPool" style="width:600px;height:800px;display:inline-block"></div>
</body>
</html>


