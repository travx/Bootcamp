<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.0/themes/base/jquery-ui.css" />
    <script type="text/javascript" src="scripts/jchartfx/js/jchartfx.system.js"></script>
    <script type="text/javascript" src="scripts/jchartfx/js/jchartfx.coreVector.js"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="http://codeorigin.jquery.com/ui/1.10.3/jquery-ui.min.js"></script>
  
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
    
	<meta charset="UTF-8">
	<title>Order Manager</title>
</head>
<body>
<h1>DataStax Bootcamp Project</h1>

<h2>Cassandra Data Modeling Objectives</h2>

<p>
<form action="OrderServlet">
<input type="hidden" name="action" value="user_orders">
<b>1)</b> Find all product orders associated a user (the Shopping Cart).<br>  
Note: All descriptive attributes for each product will be included.<br>
User ID: <input name="user_id" type="text">
<input type="submit" value="Query" />
</form>
<hr>

<p>
<form action="OrderServlet">
<input type="hidden" name="action" value="vendor">
<b>2)</b> Find all product orders associated with a vendor. <br>  
<b>4)</b> Find all users who have ordered from a vendor. <br>  
Vendor Name: <input name="vendor" type="text">
<input type="submit" value="Query" />
</form>
<hr>

<p>
<form action="OrderServlet">
<input type="hidden" name="action" value="product_users">
<b>3)</b> Find all users who have placed an order for a product. <br>  
Product ID: <input name="product_id" type="text">
<input type="submit" value="Query" />
</form>
<hr>

<p>
<form action="OrderServlet">
<input type="hidden" name="action" value="time_orders">
<h3>Query orders within a time range</h3>
<b>5)</b> All product orders associated with a given day.<br>
<b>6)</b> All product orders within a given hourly range for a specified day. <br>
<b>7)</b> All product orders within a given minute range for a specified day. <br>
<b>8)</b> All product orders within a given second for a specified day. <br>  
Date: <input name="order_date" type="text" id="datepicker"><br>
Start Time (Hour Minute Second):<input name="shour" type="text"><input name="sminute" type="text"><input name="ssecond" type="text"><br>
End Time (Hour Minute Second):<input name="ehour" type="text"><input name="eminute" type="text"><input name="esecond" type="text"><br>
<input type="submit" value="Query" />
</form>
<hr>

<p>
<form action="OrderServlet">
<input type="hidden" name="action" value="user_time_orders">
<h3>Query orders for a user within a time range</h3>
<b>9)</b> All product orders for a user associated with a given day.<br>
<b>10)</b> All product orders for a user within a given hourly range for a specified day. <br>
<b>11)</b> All product orders for a user within a given minute range for a specified day. <br>
<b>12)</b> All product orders for a user within a given second for a specified day. <br>  
User ID: <input name="user_id" type="text"><br>
Date: <input name="order_date" type="text" id="datepicker"><br>
Start Time (Hour Minute Second):<input name="shour" type="text"><input name="sminute" type="text"><input name="ssecond" type="text"><br>
End Time (Hour Minute Second):<input name="ehour" type="text"><input name="eminute" type="text"><input name="esecond" type="text"><br>
<input type="submit" value="Query" />
</form>
<hr>

<h2>Hadoop Map-Reduce Objectives</h2>
<p>
<form action="OrderServlet">
<input type="hidden" name="action" value="recommendation">
<b>1)</b> Total number of products for each recommendation.<br>
<b>2)</b> The product(s) most highly recommended.<br>
<b>3)</b> The product(s) most highly recommended for each vendor.<br>
Vendor Name: <input name="vendor" type="text">
<input type="submit" value="Go!" />
</form>
<hr>

<h2>Hadoop Extra Credit</h2>
<p>
<form action="OrderServlet">
<input type="hidden" name="action" value="moving_average">
Develop a map-reduce job to compute the 10 period moving average of order prices in the order stream.<br>
<input type="submit" value="Go!" />
</form>
<hr>


<h2>Solr</h2>
<p>
Determine the number of occurrences of the letter 's' and the letter 'S' in all street addresses.<br>
The letter "s/S" is said to be the most commonly occurring letter in the English language. Validate or disprove this in street addresses.<br>
<a href="http://localhost:8080/WebApp/SolrServlet">Go!</a>
<hr>


</body>
</html>