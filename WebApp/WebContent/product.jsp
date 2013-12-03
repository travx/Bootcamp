<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; UTF-8">
    <link rel="stylesheet" type="text/css" href="scripts/jchartfx/styles/chartfx.css" />
    <script type="text/javascript" src="scripts/jchartfx/js/jchartfx.system.js"></script>
    <script type="text/javascript" src="scripts/jchartfx/js/jchartfx.coreVector.js"></script>
    <script type="text/javascript" src="scripts/jchartfx/js/jchartfx.treemap.js"></script>
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
	
	field1.setName("user_id");
	field1.setDisplayName("Users");
	field1.setUsage(cfx.FieldUsage.Label);
	fields.add(field1);
	
	field2.setName("quantity");
	field2.setDisplayName("Total Quantity");
	field2.setUsage(cfx.FieldUsage.Value);
	fields.add(field2);


	var data = <% out.print(request.getAttribute("product_users"));%>
	chart1.setDataSource(data);   
	var divHolder = document.getElementById('Chart1Div');
	chart1.create(divHolder);
}


function loadChart2()
{
	chart1 = new cfx.Chart();
	var treeMap = new cfx.treemap.TreeMap();
	chart1.setGalleryAttributes(treeMap);

	var fields = chart1.getDataSourceSettings().getFields();
	var field1 = new cfx.FieldMap();
	var field2 = new cfx.FieldMap();
	
	field1.setName("state_name");
	field1.setDisplayName("State");
	field1.setUsage(cfx.FieldUsage.Label);
	fields.add(field1);
	
	field2.setName("quantity");
	field2.setDisplayName("Total Quantity");
	field2.setUsage(cfx.FieldUsage.Value);
	fields.add(field2);


	var data = <% out.print(request.getAttribute("product_states"));%>
	chart1.setDataSource(data);   
	var divHolder = document.getElementById('Chart2Div');
	chart1.create(divHolder);
}



</script>    
    
<title>Product</title>
</head>

<body onload="generatePage()">
<h1>Quantity by User for Product: <%out.print(request.getParameter("product_id")); %></h1>
<div id="Chart1Div" style="width:800px;height:800px;display:inline-block"></div>

<h1>Quantity by State for Product: <%out.print(request.getParameter("product_id")); %></h1>
<div id="Chart2Div" style="width:800px;height:800px;display:inline-block"></div>

<h1>Query Statistics</h2>
<h3>select * from product_users where product_id = '<%out.print(request.getParameter("product_id")); %>';</h3>
<pre>
 activity                                                                   | timestamp    | source         | source_elapsed
----------------------------------------------------------------------------+--------------+----------------+----------------
                                                         execute_cql3_query | 00:36:54,877 | 172.16.232.129 |              0
 Parsing select * from product_users where product_id = 'P842' LIMIT 10000; | 00:36:54,877 | 172.16.232.129 |             73
                                                         Peparing statement | 00:36:54,877 | 172.16.232.129 |            146
                          Executing single-partition query on product_users | 00:36:54,877 | 172.16.232.129 |            435
                                               Acquiring sstable references | 00:36:54,877 | 172.16.232.129 |            477
                                                Merging memtable tombstones | 00:36:54,877 | 172.16.232.129 |            507
                                    Bloom filter allows skipping sstable 14 | 00:36:54,877 | 172.16.232.129 |            531
                                               Key cache hit for sstable 13 | 00:36:54,877 | 172.16.232.129 |            557
                                Seeking to partition beginning in data file | 00:36:54,877 | 172.16.232.129 |            578
                                 Merging data from memtables and 1 sstables | 00:36:54,877 | 172.16.232.129 |            610
                                        Read 18 live and 0 tombstoned cells | 00:36:54,877 | 172.16.232.129 |            695
                                                           Request complete | 00:36:54,879 | 172.16.232.129 |           2091
</pre>

<h3>select * from product_state where product_id = '<%out.print(request.getParameter("product_id")); %>';</h3>
<pre>
 activity                                                                   | timestamp    | source         | source_elapsed
----------------------------------------------------------------------------+--------------+----------------+----------------
                                                         execute_cql3_query | 00:37:40,556 | 172.16.232.129 |              0
 Parsing select * from product_state where product_id = 'P842' LIMIT 10000; | 00:37:40,556 | 172.16.232.129 |             80
                                                         Peparing statement | 00:37:40,556 | 172.16.232.129 |            154
                          Executing single-partition query on product_state | 00:37:40,556 | 172.16.232.129 |            452
                                               Acquiring sstable references | 00:37:40,556 | 172.16.232.129 |            464
                                                Merging memtable tombstones | 00:37:40,556 | 172.16.232.129 |            484
                                    Bloom filter allows skipping sstable 12 | 00:37:40,556 | 172.16.232.129 |            548
                                                Key cache hit for sstable 8 | 00:37:40,556 | 172.16.232.129 |            572
                                Seeking to partition beginning in data file | 00:37:40,556 | 172.16.232.129 |            578
                                     Bloom filter allows skipping sstable 6 | 00:37:40,556 | 172.16.232.129 |            596
                                                Key cache hit for sstable 7 | 00:37:40,556 | 172.16.232.129 |            620
                                Seeking to partition beginning in data file | 00:37:40,556 | 172.16.232.129 |            627
                                 Merging data from memtables and 2 sstables | 00:37:40,556 | 172.16.232.129 |            638
                                        Read 13 live and 0 tombstoned cells | 00:37:40,557 | 172.16.232.129 |            909
                                                           Request complete | 00:37:40,557 | 172.16.232.129 |           1355
</pre>

</body>
</html>


