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
		<span style="color:white;font-size:15px">Employee Creation</span>
	</div>
</div>
<br/>
<br/>
<form class="form-horizontal" action="createEmployee" method="POST">
<fieldset>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="fn">First name</label>  
  <div class="col-md-4">
  <input  name="firstName" type="text" placeholder="First Name" class="form-control input-md" required=""/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="ln">Last name</label>  
  <div class="col-md-4">
  <input name="lastName" type="text" placeholder="Last Name" class="form-control input-md" required=""/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="cmpny">Middle Name</label>  
  <div class="col-md-4">
  <input id="cmpny" name="middleName" type="text" placeholder="Middle Initial" class="form-control input-md" />
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">Contact Number</label>  
  <div class="col-md-4">
  <input  name="contactNumber" type="number" pattern="[0-9]" placeholder="Contact Number" class="form-control input-md" required=""/>
    
  </div>
</div>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="add1"> Date of Birth</label>  
    <div class="col-md-4">
<input type="text" name="dateofBirth" class="form-control input-md"/>
 
		<script type="text/javascript">
			$(function() {
	    		$('input[name="dateofBirth"]').daterangepicker({
	        		singleDatePicker: true,
	        		showDropdowns: true
	    }, 
		    function(start, end, label) {
		        var years = moment().diff(start, 'years');
		        
		    });
		});
		</script>
    </div>
  </div>

<div class="form-group">
  <label class="col-md-4 control-label" for="address">Address</label>  
  <div class="col-md-4">
  <input name="address" type="text" placeholder="Address" class="form-control input-md" required="" style="height:100px;" required="" />
  </div>
</div>



<div class="form-group">
  <label class="col-md-4 control-label" for="designation">Designation</label>
  <div class="col-md-4">
    <select id="designation" name="designation" class="form-control input-md">
      <option>FactoryEmployee</option>
      <option>FactoryManager</option>
      <option>HRManager</option>
    </select>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="department">Department</label>
  <div class="col-md-4">
    <select id="department" name="department" class="form-control input-md">
      <option>Manufacturing</option>
      <option>Sales</option>
      <option>HR</option>
    </select>
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-4">
    <button id="submit" name="submit" class="btn btn-primary">SUBMIT</button>
  </div>
</div>

</fieldset>
</form>
</body>
</html>