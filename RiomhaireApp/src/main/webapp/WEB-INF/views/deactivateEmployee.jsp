<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ page isELIgnored="false"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="Riomhaire/src/main/resources/css/mainmenu.css.css" var="mainCss"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
@media(min-width: 992px){
.col5{
width: 20%;
float: left;
position: relative;
min-height: 1px;
padding-right: 15px;
padding-left: 15px;
}
}
</style>
</head>
<body>
<div class="container">
<div class="row">
	<div style="height:30px;background-color:steelblue;width:80%; margin-left:20px">
		<span style="color:white;font-size:15px">Remove Employee</span>
	</div>
</div>
<br/>
<br/>
<div style="margin-left:20px">
<form action="deactiveProfile" method="post">
	
	<div class="input-group">
    <input name="employeeId" type="text" placeholder="Employee ID" class="form-control" Style="width:500px;" required= ""/>
  	
	<input type="submit" class="btn btn-info btn-block" style="width:300px;" value = "Deactivate Employee" />
	</div>
	</form>
</div>
<br/>
<br/>
<br/>
<div class="row">
	<div style="height:30px;background-color:steelblue;width:80%; margin-left:20px">
		<span style="color:white;font-size:15px">Change User Role</span>
	</div>
</div>
<br/>
<br/>
<div style="margin-left:20px">
<form action="changeUserRole" method="post">
	
	<div class="input-group">
    <input name="employeeId" type="text" placeholder="Employee ID" class="form-control" Style="width:500px;" required= ""/>
    <select id="userRoleStatus" name="userRoleStatus" class="form-control input-md">
    <option value="FactoryEmployee">FactoryManager</option>
    <option value="FactoryManager">FactoryManager</option>
    <option value="HRManager">HRManager</option>
	</select> 
   </div>
	<input type="submit" class="btn btn-info btn-block" style="width:300px;" value = "Deactivate Employee" />
	</div>
	</form>
</div>
</body>
</html>