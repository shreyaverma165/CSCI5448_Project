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
  <nav class="navbar navbar-inverse navbar-static-top navigationbar" style="background-color:steelblue">
    	<div class="container">
    <div class="navbar-header">
    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar6">
    <span class="sr-only"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
     <span class="icon-bar"></span>
    </button> 
    <a class="navbar-brand text-hide" href="http://disputebills.com" style="background: url(https://canvas.facebook.com/images/canvas/logo-mrporter-2x.png) center / contain no-repeat; width:200px;">Text</a>
  	</div>
  	<div id="nav6" class="navbar-collapse-collapse">
  	<ul class="nav navbar-nav navbar-right">
  		<li><a href="userHome"><span style="color:white;">Back</span></a></li> 
  	</ul>
  	</div>
	</div>
</nav>
<style>
@media (min-width: 7px) {

    .brand-pills > li > a {
        border-top-right-radius: 0px;
    	border-bottom-right-radius: 0px;
    	background-color: grey;
    	foreground-color: white;
    }
    
    li.brand-nav.active a:after{
    	content: " ";
    	display: block;
    	width: 0;
    	height: 0;
    	border-top: 20px solid transparent;
    	border-bottom: 20px solid transparent;
    	border-left: 9px solid #428bca;
    	position: absolute;
    	top: 50%;
    	margin-top: -20px;
    	left: 100%;
    	z-index: 2;
    }
}

</style>
</head>
<body style="background-color:powderblue;">
<div class="container">
<div class="row">
	   <div style="height:30px;background-color:steelblue;width:90%; margin-left:20px">
	                    		<span style="color:white;font-size:15px">Search Results</span>
	   </div>

</div>
<br/>
<br/>

<div class="row">
<table border="1" style="width:90%;margin-left:20px;" >
<tr>
<th> Name </th>
<th> Department</th>
<th> Mail Address</th>
<c:if test="${not empty isManager}">
<th> Contact Number</th>
<th> Date Of Joining</th>
<th> Designation </th>
<th> Employee Id</th>
</c:if>
</tr>
<c:forEach items="${searchResults}" var="searchResult">
<tr>
<td><c:out value ="${searchResult.name}"/></td>
<td><c:out value ="${searchResult.department}"/></td>
<td><c:out value ="${searchResult.mailAddress}"/></td>
<c:if test="${not empty isManager}">
<td><c:out value = "${searchResult.contactNumber}"/></td>
<td><c:out value = "${searchResult.dateOfJoining}"/></td>
<td><c:out value = "${searchResult.designation}"/></td>
<td><c:out value = "${searchResult.employeeId}"/></td>
</c:if>
</tr>
</c:forEach>
</table>
</div>
</div>
	<c:if test="${not empty alertMessage}">
		<script>
		window.alert("${alertMessage}");
		</script>
	</c:if>
</body>
</html>