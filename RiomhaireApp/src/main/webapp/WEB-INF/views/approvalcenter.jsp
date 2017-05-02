<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap/3/css/bootstrap.css" />
 
  <script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
</head>
<body>
<div class="container">
                     	<div class="row">
	<div style="height:30px;background-color:steelblue;width:80%; margin-left:20px">
		<span style="color:white;font-size:15px">Approval Center</span>
	</div>
</div>
<br/>
<br/>
<div class="row">
<form:form action="approvalLeaves" method="POST" modelattribute  = "employeeLeavesList" commandName="employeeLeavesList"  >
<table border="1" style="width:80%;margin-left:20px;">
<tr>
<th>Employee Name</th>
<th>Comment</th>
<th>Start Date</th>
<th>End Date</th>
<th>Accept/Reject</th>

</tr>
<c:forEach items="${employeeLeavesList.employeeLeaves}" var = "employeeLeave" varStatus = "status">
<tr>
<form:hidden path="employeeLeaves[${status.index}].employeeLeaveId"/>
<td> <input type="text" name="employeeLeaves[${status.index}].employeeId" value="${employeeLeave.employeeId}"/></td>
<td> <input type="text" name="employeeLeaves[${status.index}].leaveComment" value="${employeeLeave.leaveComment}"/></td>
<td> <input type="text" name="employeeLeaves[${status.index}].startDate" value="${employeeLeave.startDate}"/></td>
<td> <input type="text" name="employeeLeaves[${status.index}].endDate" value="${employeeLeave.endDate}"/></td>
<td> <form:radiobuttons path="employeeLeaves[${status.index}].leaveStatus" items ="${employeeLeavesList.employeeLeaveStatus}" name="leavestatuses" element="li"/></td>
</tr>
</c:forEach>
</table>
<input type="submit"  name="btnSubmit" class="btn btn-info btn-block" value="Submit" style="width:500px;"/>
</form:form>
</div>
</div>
</body>
</html>