<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="/resources/css/main.css" var="minCss"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap/3/css/bootstrap.css" />
<script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="container">
<div class= "row">
<div style="height:30px;background-color:steelblue;width:80%; margin-left:20px">
		<span style="color:white;font-size:15px">My Account</span>
	</div>
</div>
<br/>
<br/>
<div class="row">

<form class="form-horizontal" data-toggle="validator"  action="savePassword" method="POST">
<fieldset>

<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>  
  <div class="col-md-4">
  <input  name="password" type="password" id="inputpassword" placeholder="Password" class="form-control input-md" required=""/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="confirmpassword">Confirm Password</label>  
  <div class="col-md-4">
  <input name="confirmpassword" type="password" placeholder="Confirm Password"
   class="form-control input-md" data-match ="#inputpassword" data-match-error="Whoops, these don't match" required=""/>
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-4">
    <button id="submit" name="submit" class="btn btn-primary">Update Password</button>
  </div>
</div>
</fieldset>
</form>
</div>
<br/>
<br/>

<div class= "row">
<div style="height:30px;background-color:steelblue;width:80%; margin-left:20px">
		<span style="color:white;font-size:15px">Details</span>
	</div>
	<br/>
	<br/>
<form class="form-horizontal" action="saveDetails" method="POST">

<div class="form-group">
  <label class="col-md-4 control-label" for="address">Address</label>  
  <div class="col-md-4">
  <input name="address" type="text" class="form-control input-md" required="" style="height:100px;" />
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-4">
    <button id="submit" name="submit" class="btn btn-primary">SUBMIT</button>
  </div>
</div>

</form>
</div>
</div>
</body>
</html>