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
<div class="row">
                  <div class="row">
                     <div style="height:30px;background-color:steelblue;width:80%; margin-left:20px">
                        <span style="color:white;font-size:15px">Claims</span>
                     </div>
                  </div>
                  <br/>
                     
                        <table border="1" style="width:80%;margin-left:20px;">
                           <tr>
                              <th>Employee ID</th>
                              <th>Comment</th>
                              <th>Purchase Date</th>
                              <th>Amount</th>
                              <th>Accept/Reject</th>
                           </tr>
                           <c:forEach items="${appliedEmployeeClaimsList}" var = "employeeClaim" varStatus = "status">
                            <form action="deleteClaim?employeeClaimId=${employeeClaim.employeeClaimId}" method="POST" >
                              <tr>
                                
                                 <td> <c:out value= "${employeeClaim.employeeId}" /></td>
                                 <td> <c:out value= "${employeeClaim.claimComment}" /></td>
                                 <td> <c:out value= "${employeeClaim.purchaseDate}"/></td>
                                 <td> <c:out value= "${employeeClaim.amount}"/></td>
                                 <td>
                                   <input type="submit"  name="btnSubmit" class="btn btn-info btn-block" value="Delete" style="width:100px;margin-left:20px;"/>
                                 </td>
                                
                              </tr>
                               </form>
                           </c:forEach>
                        </table>
                        <br/>
                        <br/>
                        
                     
                  </div>
                  
                  <br/>
                  <br/>
                  <br/>
                  <div class="row">
                     <div style="height:30px;background-color:steelblue;width:80%; margin-left:20px">
                        <span style="color:white;font-size:15px">Leaves</span>
                     </div>
                  </div>
                  <br/>
                  <br/>
                  <div class="row">
                   
                        <table border="1" style="width:80%;margin-left:20px;">
                           <tr>
                              <th>Employee ID</th>
                              <th>Comment</th>
                              <th>Start Date</th>
                              <th>End Date</th>
                              <th>Accept/Reject</th>
                           </tr>
                           <c:forEach items="${appliedEmployeeLeavesList}" var = "employeeLeave" varStatus = "status">
                             <form action="deleteLeave?employeeLeaveId=${employeeLeave.employeeLeaveId}" method="POST">
                              <tr>
                                 
                                 <td> <c:out value="${employeeLeave.employeeId}"/></td>
                                 <td> <c:out value="${employeeLeave.leaveComment}"/></td>
                                 <td> <c:out value="${employeeLeave.startDate}" /></td>
                                 <td> <c:out value="${employeeLeave.endDate}"/></td>
                                 <td>
                                    <input type="submit"  name="btnSubmit" class="btn btn-info btn-block" value="Delete" style="width:100px;margin-left:20px;"/>
                                 </td>
                              </tr>
                              </form>
                           </c:forEach>
                        </table>
                        <br/>
                        <br/>
                        
                   
                     </div>
         
</body>
</html>