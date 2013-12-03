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
	loadChart();
}

function loadChart()
{
	chart1 = new cfx.Chart();
	chart1.setGallery(cfx.Gallery.Lines);

	var fields = chart1.getDataSourceSettings().getFields();
	var field1 = new cfx.FieldMap();
	var field2 = new cfx.FieldMap();
	
	field1.setName("order_id");
	field1.setDisplayName("Order");
	field1.setUsage(cfx.FieldUsage.Label);
	fields.add(field1);
	
	field2.setName("order_amt");
	field2.setDisplayName("Order Amount");
	field2.setUsage(cfx.FieldUsage.Value);
	fields.add(field2);

	var data = <% out.print(request.getAttribute("time_orders"));%>
	chart1.setDataSource(data);   
	var divHolder = document.getElementById('ChartDiv');
	chart1.create(divHolder);
}


</script>    
    
<title>User Orders</title>
</head>

<body onload="generatePage()">
<h1>All Orders for selected time period (limited to 100)</h1>
<div id="ChartDiv" style="width:800px;height:400px;display:inline-block"></div>
<h1>Query Statistics</h1>
<h3>select * from time_orders where order_date = '<%out.print(request.getParameter("order_date")); %>' and order_seconds >= <% out.print(request.getAttribute("start"));%> and order_seconds <= <% out.print(request.getAttribute("end"));%>;</h3>
<pre>
 activity                                                                                                                       | timestamp    | source         | source_elapsed
--------------------------------------------------------------------------------------------------------------------------------+--------------+----------------+----------------
                                                                                                             execute_cql3_query | 00:43:49,124 | 172.16.232.129 |              0
 Parsing select * from time_orders where order_date = '2013-08-09' and order_seconds >= 0 and order_seconds <= 100 LIMIT 10000; | 00:43:49,124 | 172.16.232.129 |             75
                                                                                                             Peparing statement | 00:43:49,124 | 172.16.232.129 |            264
                                                                                Executing single-partition query on time_orders | 00:43:49,188 | 172.16.232.129 |          63961
                                                                                                   Acquiring sstable references | 00:43:49,188 | 172.16.232.129 |          63983
                                                                                                    Merging memtable tombstones | 00:43:49,188 | 172.16.232.129 |          64001
                                                                                                    Key cache hit for sstable 6 | 00:43:49,188 | 172.16.232.129 |          64054
                                                                              Seeking to partition indexed section in data file | 00:43:49,188 | 172.16.232.129 |          64062
                                                                                                    Key cache hit for sstable 5 | 00:43:49,188 | 172.16.232.129 |          64087
                                                                              Seeking to partition indexed section in data file | 00:43:49,188 | 172.16.232.129 |          64092
                                                                                     Merging data from memtables and 2 sstables | 00:43:49,188 | 172.16.232.129 |          64107
                                                                                           Read 135 live and 0 tombstoned cells | 00:43:49,188 | 172.16.232.129 |          64840
                                                                                                               Request complete | 00:43:49,189 | 172.16.232.129 |          65607
</pre>
<h3>select * from user_time_orders where user_id='<%out.print(request.getParameter("user_id")); %>' and order_date = '<%out.print(request.getParameter("order_date")); %>' and order_seconds >= <% out.print(request.getAttribute("start"));%> and order_seconds <= <% out.print(request.getAttribute("end"));%>;</h3>
<pre>
 activity                                                                                                                                                  | timestamp    | source         | source_elapsed
-----------------------------------------------------------------------------------------------------------------------------------------------------------+--------------+----------------+----------------
                                                                                                                                        execute_cql3_query | 01:00:30,872 | 172.16.232.129 |              0
 Parsing select * from user_time_orders where user_id='U3585' and order_date = '2013-08-09' and order_seconds >= 0 and order_seconds <= 86399 LIMIT 10000; | 01:00:30,872 | 172.16.232.129 |             55
                                                                                                                                        Peparing statement | 01:00:30,872 | 172.16.232.129 |            130
                                                                                                      Executing single-partition query on user_time_orders | 01:00:30,873 | 172.16.232.129 |           1135
                                                                                                                              Acquiring sstable references | 01:00:30,873 | 172.16.232.129 |           1144
                                                                                                                               Merging memtable tombstones | 01:00:30,873 | 172.16.232.129 |           1158
                                                                                                                              Key cache hit for sstable 14 | 01:00:30,873 | 172.16.232.129 |           1186
                                                                                                         Seeking to partition indexed section in data file | 01:00:30,873 | 172.16.232.129 |           1193
                                                                                                                Merging data from memtables and 1 sstables | 01:00:30,873 | 172.16.232.129 |           1253
                                                                                                                       Read 28 live and 0 tombstoned cells | 01:00:30,873 | 172.16.232.129 |           1384
                                                                                                                                          Request complete | 01:00:30,873 | 172.16.232.129 |           1557
</pre>

</body>
</html>


