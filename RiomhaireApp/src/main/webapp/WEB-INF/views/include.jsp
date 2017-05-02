<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap/3/css/bootstrap.css" />
 
  <script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="container">
<div class="row">
	<div style="height:30px;background-color:steelblue;width:80%; margin-left:20px">
		 <span style="color:white;font-size:15px">Claims</span>
	</div>
	<br/>
	<div>
	<form action="SaveClaim" method="post">
	<table style="margin-left:20px">
		<tr>
			<td><input name="itemName" type="text" placeholder="Item Name" class="form-control" style="width:400px;"/></td>
			<td>
			<span style="{color:white;font-size:12px}">Purchase Date </span>
			<input type="text" name="purchaseDate" class="form-control" style="width:400px;"/>
 
		<script type="text/javascript">
			$(function() {
	    		$('input[name="purchaseDate"]').daterangepicker({
	        		singleDatePicker: true,
	        		showDropdowns: true
	    }, 
		    function(start, end, label) {
		        var years = moment().diff(start, 'years');
		        
		    });
		});
		</script>
		</td>
		</tr>
		<tr>
			<td> <input name = "amount" type="number" pattern="[0-9]" placeholder="Claim Amount" class="form-control" style="width:400px;"/></td>
			<td> <input name = "comment" type="text" placeholder="Comment" class="form-control" style="width:400px;"/></td>
		</tr>
		<tr>
		<td>
		<br/>
		<input type="submit" class="btn btn-info btn-block" style="width:540px;alignment:center;" />
		</td>
		</tr>
	</table>	
	</form>	
	</div>
	</div>
	<br/>
	<br/>
	<br/>
<div class="row">
<div style="height:30px;background-color:steelblue;width:80%; margin-left:20px">
		 <span style="color:white;font-size:15px">Leaves</span>
	</div>
	<br/>
	<div>
	<form action="SaveLeave" method="post">
	<table style="margin-left:20px">
		<tr>
			<td><span style="{color:white;font-size:12px}">Start Date </span>
			<input name="startDate" type="text" class="form-control" style="width:400px;"/>
			
			<script type="text/javascript">
			$(function() {
	    		$('input[name="startDate"]').daterangepicker({
	        		singleDatePicker: true,
	        		showDropdowns: true
	    }, 
		    function(start, end, label) {
		        var years = moment().diff(start, 'years');
		        
		    });
		});
		</script>
			
			
			</td>
			<td>
			<span>End Date</span>
			<input type="text" name="endDate" class="form-control" style="width:400px;"/>
 
		<script type="text/javascript">
			$(function() {
	    		$('input[name="endDate"]').daterangepicker({
	        		singleDatePicker: true,
	        		showDropdowns: true
	    }, 
		    function(start, end, label) {
		        var years = moment().diff(start, 'years');
		        
		    });
		});
		</script>
		</td>
		</tr>
		<tr>
			<td colspan="2"><input name = "leaveComment" type="text" placeholder="Comment" class="form-control" style="width:950px;"/></td>
		</tr>
		<tr>
		<td>
		<br/>
		<input type="submit" class="btn btn-info btn-block" style="width:540px;" />
		</td>
		</tr>
	</table>	
	</form>	
	</div>
</div>
</div>	
</body>
</html>