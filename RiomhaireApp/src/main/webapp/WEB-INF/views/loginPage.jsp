
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="/resources/css/main.css" var="minCss"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body style="background-color:powderblue;">
  <nav class="navbar navbar-inverse navbar-static-top navigationbar" style="background-color:steelblue">
    <div class="container">
    <div class="navbar-header">
    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar6">
    <span class="sr-only"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
     <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand text-hide" style="background: url(https://image.ibb.co/hjw3J5/Transparent4.png) center / contain no-repeat; width:200px;">Text</a>
  	</div>
</div>
</nav>
<!-- <div class="jumbotron text-center" style="background-color:steelblue"> 
<h1 style="color:white;font-family:lora" align="left">Riomhaire</h1>
</div> -->
<div class="container" style="width:570px">
<form action="processCredentials" method="post">
	<div align="left">
	<div class="input-group">
    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
    <input name="userName" type="text" placeholder="UserName" class="form-control" Style="width:500px;" name="email"/>
  </div>
  <div class="input-group">
    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
    <input name="password" type="password"  style="width:500px;" placeholder="Password" class="form-control" name="password"></div>			
	</div>
	<div>
	<input type="submit" class="btn btn-info btn-block" style="width:540px;" />
	<a href="ForgotPassword"><p align="right"><U>Forgot password?</U></p></a>
	<br/>
	<p style="color:red;font-size:22px"><U>${message}</U></p>
	</div>
	</form>
</div>
</body>
</html>