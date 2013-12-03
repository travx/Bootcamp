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
function generatePage(){
	loadChart1();
	loadChart2();
}

function loadChart1()
{
	chart1 = new cfx.Chart();
	chart1.setGallery(cfx.Gallery.Gantt);

	var fields = chart1.getDataSourceSettings().getFields();
	var field1 = new cfx.FieldMap();
	var field2 = new cfx.FieldMap();
	
	field1.setName("order_id");
	field1.setDisplayName("Order");
	field1.setUsage(cfx.FieldUsage.Label);
	fields.add(field1);
	
	field2.setName("order_amt");
	field2.setDisplayName("Order Total");
	field2.setUsage(cfx.FieldUsage.Value);
	fields.add(field2);


	var data = <% out.print(request.getAttribute("vendor_orders"));%>
	chart1.setDataSource(data);   
	var divHolder = document.getElementById('Chart1Div');
	chart1.create(divHolder);
}


function loadChart2()
{
	chart1 = new cfx.Chart();
	chart1.setGallery(cfx.Gallery.Gantt);

	var fields = chart1.getDataSourceSettings().getFields();
	var field1 = new cfx.FieldMap();
	var field2 = new cfx.FieldMap();
	
	field1.setName("user_id");
	field1.setDisplayName("User");
	field1.setUsage(cfx.FieldUsage.Label);
	fields.add(field1);
	
	field2.setName("orders");
	field2.setDisplayName("# Orders");
	field2.setUsage(cfx.FieldUsage.Value);
	fields.add(field2);


	var data = <% out.print(request.getAttribute("vendor_users"));%>
	chart1.setDataSource(data);   
	var divHolder = document.getElementById('Chart2Div');
	chart1.create(divHolder);
}



</script>    
    
<title>Vendor</title>
</head>

<body onload="generatePage()">
<h1>All Orders for <%out.print(request.getParameter("vendor")); %></h1>
<div id="Chart1Div" style="width:800px;height:800px;display:inline-block"></div>

<h1>All Users for <%out.print(request.getParameter("vendor")); %></h1>
<div id="Chart2Div" style="width:800px;height:800px;display:inline-block"></div>

<h1>Query Statistics</h2>
<h3>select * from vendor_orders where vendor = '<%out.print(request.getParameter("vendor")); %>';</h3>
<pre>
 activity                                                                   | timestamp    | source         | source_elapsed
----------------------------------------------------------------------------+--------------+----------------+----------------
                                                         execute_cql3_query | 00:26:17,028 | 172.16.232.129 |              0
 Parsing select * from vendor_orders where vendor = 'Foodguys' LIMIT 10000; | 00:26:17,029 | 172.16.232.129 |             88
                                                         Peparing statement | 00:26:17,029 | 172.16.232.129 |            222
                          Executing single-partition query on vendor_orders | 00:26:17,029 | 172.16.232.129 |            613
                                               Acquiring sstable references | 00:26:17,029 | 172.16.232.129 |            625
                                                Merging memtable tombstones | 00:26:17,029 | 172.16.232.129 |            650
                                               Key cache hit for sstable 14 | 00:26:17,029 | 172.16.232.129 |            734
                                Seeking to partition beginning in data file | 00:26:17,029 | 172.16.232.129 |            746
                                               Key cache hit for sstable 10 | 00:26:17,031 | 172.16.232.129 |           2145
                                Seeking to partition beginning in data file | 00:26:17,031 | 172.16.232.129 |           2160
                                 Merging data from memtables and 2 sstables | 00:26:17,032 | 172.16.232.129 |           4007
                                      Read 1226 live and 0 tombstoned cells | 00:26:17,045 | 172.16.232.129 |          16372
                                                           Request complete | 00:26:17,084 | 172.16.232.129 |          56575
</pre>
<h3>select * from vendor_users where vendor = '<%out.print(request.getParameter("vendor")); %>';</h3>
<pre>
 activity                                                                  | timestamp    | source         | source_elapsed
---------------------------------------------------------------------------+--------------+----------------+----------------
                                                        execute_cql3_query | 00:27:08,387 | 172.16.232.129 |              0
 Parsing select * from vendor_users where vendor = 'Foodguys' LIMIT 10000; | 00:27:08,387 | 172.16.232.129 |             54
                                                        Peparing statement | 00:27:08,387 | 172.16.232.129 |            114
                          Executing single-partition query on vendor_users | 00:27:08,388 | 172.16.232.129 |            360
                                              Acquiring sstable references | 00:27:08,388 | 172.16.232.129 |            369
                                               Merging memtable tombstones | 00:27:08,388 | 172.16.232.129 |            389
                                              Key cache hit for sstable 14 | 00:27:08,388 | 172.16.232.129 |            422
                               Seeking to partition beginning in data file | 00:27:08,388 | 172.16.232.129 |            432
                                              Key cache hit for sstable 13 | 00:27:08,388 | 172.16.232.129 |            458
                               Seeking to partition beginning in data file | 00:27:08,388 | 172.16.232.129 |            464
                                Merging data from memtables and 2 sstables | 00:27:08,388 | 172.16.232.129 |            709
                                     Read 1088 live and 0 tombstoned cells | 00:27:08,392 | 172.16.232.129 |           4935
                                                          Request complete | 00:27:08,395 | 172.16.232.129 |           8182
</pre>

</body>
</html>


