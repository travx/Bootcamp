<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; UTF-8">
    <link rel="stylesheet" type="text/css" href="scripts/jchartfx/styles/chartfx.css" />
    <script type="text/javascript" src="scripts/jchartfx/js/jchartfx.system.js"></script>
    <script type="text/javascript" src="scripts/jchartfx/js/jchartfx.coreVector.js"></script>
     <script type="text/javascript" src="scripts/jchartfx/js/jchartfx.animation.js"></script>  
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

	
<script type="text/javascript">

var chart_tppool;
var chart_tpmessage;
var chart_iostatcpu;
var chart_iostatdevice;

function loadPage(){
	loadTPPool();
	loadTPMessage();
	loadIOStatCPU();
	loadIOStatDevice();
	new_data();
}

function loadTPPool(){	
	chart_tppool = new cfx.Chart();
	chart_tppool.getAnimations().getLoad().setEnabled(true);
	chart_tppool.setGallery(cfx.Gallery.Gantt);  
	var divHolder = document.getElementById('TPPool');
	chart_tppool.create(divHolder);
}

function loadTPMessage(){	
	chart_tpmessage = new cfx.Chart();
	chart_tpmessage.getAnimations().getLoad().setEnabled(true);
	chart_tpmessage.setGallery(cfx.Gallery.Bar);  
	var divHolder = document.getElementById('TPMessage');
	chart_tpmessage.create(divHolder);
}

function loadIOStatCPU(){	
	chart_iostatcpu = new cfx.Chart();
	chart_iostatcpu.getAnimations().getLoad().setEnabled(true);
	chart_iostatcpu.setGallery(cfx.Gallery.Bar);  
	var divHolder = document.getElementById('IOstatCPU');
	chart_iostatcpu.create(divHolder);
}

function loadIOStatDevice(){	
	chart_iostatdevice = new cfx.Chart();
	chart_iostatdevice.getAnimations().getLoad().setEnabled(true);
	chart_iostatdevice.setGallery(cfx.Gallery.Bar);  
	var divHolder = document.getElementById('IOstatDevice');
	chart_iostatdevice.create(divHolder);
}

function new_data(){
    $.getJSON('NodetoolServlet?stat=tppool', function(data) {
    	chart_tppool.setDataSource(data);
        });
    $.getJSON('NodetoolServlet?stat=tpmessage', function(data) {
    	chart_tpmessage.setDataSource(data);
        });
    $.getJSON('NodetoolServlet?stat=iostatcpu', function(data) {
    	chart_iostatcpu.setDataSource(data);
        });
    $.getJSON('NodetoolServlet?stat=iostatdevice', function(data) {
    	chart_iostatdevice.setDataSource(data);
        });
}


setInterval(function(){new_data()}, 5000);


</script>    
    
<title>Performance Data</title>
</head>

<body onload="loadPage()">
<h1>nodetool tpstats</h1>
<table><tr><td>
<div id="TPPool" style="width:700px;height:600px;display:inline-block"></div>
</td><td>
<div id="TPMessage" style="width:500px;height:200px;display:inline-block"></div><br>
<div id="IOstatCPU" style="width:500px;height:200px;display:inline-block"></div><br>
<div id="IOstatDevice" style="width:500px;height:200px;display:inline-block"></div>

</td></tr></table>
</body>
</html>


