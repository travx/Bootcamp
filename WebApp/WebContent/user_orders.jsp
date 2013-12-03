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
function generatePage(){
	loadChart();
	displayTable();
}

function loadChart()
{
	chart1 = new cfx.Chart();
	chart1.setGallery(cfx.Gallery.Gantt);
	chart1.getAnimations().getLoad().setEnabled(true);

	var fields = chart1.getDataSourceSettings().getFields();
	var field1 = new cfx.FieldMap();
	var field2 = new cfx.FieldMap();
	var field3 = new cfx.FieldMap();
	var field4 = new cfx.FieldMap();
	
	field1.setName("order_id");
	field1.setDisplayName("Order");
	field1.setUsage(cfx.FieldUsage.Label);
	fields.add(field1);
	
	field2.setName("unit_price");
	field2.setDisplayName("Unit Price");
	field2.setUsage(cfx.FieldUsage.Value);
	fields.add(field2);

	field3.setName("quantity");
	field3.setDisplayName("Quantity");
	field3.setUsage(cfx.FieldUsage.Value);
	fields.add(field3);

	field4.setName("order_amt");
	field4.setDisplayName("Order Total");
	field4.setUsage(cfx.FieldUsage.Value);
	fields.add(field4);

	var data = <% out.print(request.getAttribute("user_orders"));%>
	chart1.setDataSource(data);   
	var divHolder = document.getElementById('ChartDiv');
	chart1.create(divHolder);
}

function displayTable(){
	//var obj = jQuery.parseJSON(<% out.print(request.getAttribute("user_orders"));%>)
	var arr = <% out.print(request.getAttribute("user_orders"));%>;
	var table = document.getElementById("TableDiv");
	var html = "<TABLE>"
    for(var i=0;i<arr.length;i++){
        html = html + "<TR><TD>" + arr[i]["product_name"] + "</TD><TD>" + arr[i]["product_attributes"] + "</TD></TR>";
    }
	html = html + "</TABLE>"
	table.innerHTML = html;
}

</script>    
    
<title>User Orders</title>
</head>

<body onload="generatePage()">
<h1>All Orders for <%out.print(request.getParameter("user_id")); %></h1>
<div id="ChartDiv" style="width:800px;height:400px;display:inline-block"></div>

<h2>Product Attributes</h2>
<div id="TableDiv"></div>

<h2>Query Statistics</h2>
<h3>select * from user_orders where user_id = '<%out.print(request.getParameter("user_id")); %>';</h3>
<pre>
 activity                                                               | timestamp    | source         | source_elapsed
------------------------------------------------------------------------+--------------+----------------+----------------
                                                     execute_cql3_query | 00:19:59,280 | 172.16.232.129 |              0
 Parsing select * from user_orders where user_id = 'U3585' LIMIT 10000; | 00:19:59,280 | 172.16.232.129 |            103
                                                     Peparing statement | 00:19:59,280 | 172.16.232.129 |            294
                        Executing single-partition query on user_orders | 00:19:59,281 | 172.16.232.129 |            671
                                           Acquiring sstable references | 00:19:59,281 | 172.16.232.129 |            696
                                            Merging memtable tombstones | 00:19:59,281 | 172.16.232.129 |            873
                                           Key cache hit for sstable 12 | 00:19:59,281 | 172.16.232.129 |           1028
                            Seeking to partition beginning in data file | 00:19:59,281 | 172.16.232.129 |           1044
                             Merging data from memtables and 1 sstables | 00:19:59,281 | 172.16.232.129 |           1087
                                    Read 28 live and 0 tombstoned cells | 00:19:59,281 | 172.16.232.129 |           1525
                                                       Request complete | 00:19:59,282 | 172.16.232.129 |           2191

</pre>
</body>
</html>


