<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
      "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
  <title></title>
  <meta name="keywords" content="">
  <meta name="description" content="">
  <link rel="stylesheet" type="text/css" href="default.css">
  
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="http://codeorigin.jquery.com/ui/1.10.3/jquery-ui.min.js"></script>
  
  <script>

  function loadpage(){
      var solr = jQuery.parseJSON('<% out.print(request.getAttribute("results"));%>');
      var docs = solr.response.docs;
      $('#contentarea').prepend('<p><b>Number of Results: ' + solr.response.numFound + '</b></p>');
      $.each(docs, function(i, item) {
          $('#contenttable').append('<tr><td><a href="http://localhost:8080/WebApp/OrderServlet?action=user_orders&user_id=' + item.user_id + '">' + item.user_id + '</a></td><td>' + item.first_name + ' ' + item.middle_name + ' ' + item.last_name + '</td></tr>');
      });
  }
  
  </script>
    
</head>

<body onload="loadpage()">

<div id="upbg">
</div>

<div id="outer">

<div id="header">

<div id="headercontent">
<h1>Bootcamp Project <sup></sup></h1>

<h2>By Travis Price</h2>
</div>
</div>

<form method="post" action="SolrServlet">

  <div id="search">
  <input type="text" class="text" maxlength="64" name="search"> 
  <input type="submit" value="Search" class="submit"> </div>
</form>

<div id="headerpic">
</div>

<div id="menu">
<!-- HINT: Set the class of any menu link below to "active" to make it appear active -->
<ul>
  <li><a href="index.html">Overview</a></li>
  <li><a href="http://172.16.232.129:8888/opscenter/index.html">OpsCenter</a></li>
  <li><a href="cassandra.html" >Cassandra</a></li>
  <li><a href="#hadoop">Hadoop</a></li>
  <li><a href="http://localhost:8080/WebApp/SolrServlet" class="active">Solr</a></li>
</ul>
</div>

<div id="menubottom">
</div>

<div id="content">
<!-- Normal content: Stuff that's not going to be put in the left or right column. -->

<div id="normalcontent">
<h3><strong>Search Results</strong></h3>

<div class="contentarea" id="contentarea">

<!-- Normal content area start -->

<table id="contenttable"></table>

<!-- Normal content area end -->

</div>
</div>
</div>

<div id="footer">

<div class="right">
Travis Price
</div>
</div>
</div>
</body>
</html>
