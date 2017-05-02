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
               <a class="navbar-brand text-hide" href="userHome" style="background: url(https://image.ibb.co/hjw3J5/Transparent4.png) center / contain no-repeat; width:200px;">Text</a>
            </div>
            <div id="nav6" class="navbar-collapse-collapse">
               <ul class="nav navbar-nav navbar-right">
                  <li><a href="logout"><span style="color:white;">Sign Out</span></a></li>
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
   <body style="background-color:powderblue">
      <div class="tabpanel" style="height:100%">
         <div class="col-sm-3"  style = "background-color:grey;height:100%">
            <ul class="nav nav-pills brand-pills nav-stacked" role="tablist">
               <li role="presentation" class="brand-nav active">
                  <a href="#dashboard" aria-controls="dashboard" role="tab" data-toggle="tab">
                  <span style="color:white">Dashboard</span></a>
               </li>
               <c:if test = "${employee.designation == 'FactoryEmployee' }">
                  <li role="presentation" class="brand-nav">
                     <a aria-controls="#myLine" role="tab" data-toggle="tab" href="#myline"><span style="color:white;">My Line</span></a>
                  </li>
               </c:if>
               <c:if test = "${employee.designation == 'HRManager' }">
                  <li role="presentation" class="brand-nav">
                     <a aria-controls="#myLine" role="tab" data-toggle="tab" href="#approvalcenter">
                     <span style="color:white;">Approval Central</span></a>
                  </li>
               </c:if>
               <c:if test = "${employee.designation == 'HRManager' }">
                  <li role="presentation" class="brand-nav">
                     <a aria-controls="#myLine" role="tab" data-toggle="tab" href="#employeeCreation">
                     <span style="color:white;">Employee Creation</span></a>
                  </li>
               </c:if>
               <li role ="presentation" class="brand-nav">
                  <a href="#myaccountjsp" role="tab" data-toggle="tab" aria-controls="myaccountjsp">
                  <span style="color:white;">My Account</span>
                  </a>
               </li>
               <li role="presentation" class="brand-nav"><a href="#tab2" aria-controls="tab2" role="tab" data-toggle="tab">
                  <span style="color:white">Leaves and Claims</span>
                  </a>   
               </li>
               <li role="presentation" class="brand-nav"><a href="#appliedLeavesAndClaims" aria-controls="tab2" role="tab" data-toggle="tab">
                  <span style="color:white">Applied Leaves and Claims</span>
                  </a>   
               </li>
               <li role="presentation" class="brand-nav"><a href="#tab3" aria-controls="tab3" role="tab" data-toggle="tab">
                  <span style="color:white">Employee Search</span></a>
               </li>
               <c:if test = "${employee.designation =='Admin'}">
                  <li role="presentation" class="brand-nav"><a href="#deactivateEmployee" aria-controls="deactivateEmployee" role="tab" data-toggle="tab">
                     <span style="color:white">Employee Management</span></a>
                  </li>
               </c:if>
               <c:if test = "${employee.designation =='FactoryManager'}">
                  <li role="presentation" class="brand-nav"><a href="#requestStock" aria-controls="requestStock" role="tab" data-toggle="tab">
                     <span style="color:white">Request Stock</span></a>
                  </li>
               </c:if>
            </ul>
         </div>
         <div class="col-sm-9">
            <div class="tab-content">
               <div role="tabpanel" class="tab-pane" id="deactivateEmployee">
                  <%@ include file="deactivateEmployee.jsp" %>
               </div>
               <div role="tabpanel" class="tab-pane" id="myaccountjsp">
                  <c:set var= "contactNumber" value ="${employee.workContact}"/>
                  <c:set var= "address" value ="${user.address}"/>
                  <%@ include file="myaccount.jsp" %>
               </div>
               <div role="tabpanel"class="tab-pane" id = "myline">
                  <%@ include file = "machineLineStatus.jsp" %>
               </div>
               <div role="tabpanel" class="tab-pane" id="tab2">
                  <%@ include file="include.jsp" %>
               </div>
                <div role ="tabpanel" class="tab-pane" id="tab3">
                  <%@ include file="searchPage.jsp" %>
               </div>
               <div role="tabpanel" class="tab-pane" id="requestStock">
                  <%@ include file="requestStock.jsp" %>
               </div>
               <div role ="tabpanel" class="tab-pane" id="appliedLeavesAndClaims">
                  <%@ include file="appliedLeavesAndClaims.jsp" %>
               </div>
               <div role="tabpanel" class="tab-pane active" id="dashboard">
                  <div class="row">
                     <div style="height:30px;background-color:steelblue;width:90%; margin-left:20px">
                        <span style="color:white;font-size:15px">Notification Center</span>
                     </div>
                  </div>
                  <br/>
                  <div class="row">
                     <c:if test="${empty notifications}">
                        <textarea style="width:90%;margin-left:20px;height:500px;" readonly=true>
                        You have no new notifications</textarea>
                     </c:if>
                     <c:if test= "${not empty notifications}">
                        <textarea style="width:90%;margin-left:20px;height:500px;" readonly=true>
		                	<c:forEach items="${notifications}" var = "notification">
		                		<c:out value="${notification.message}"/>
		                    </c:forEach>
		                </textarea>
                     </c:if>
                  </div>
               </div>
               <div role="tabpanel" class="tab-pane" id="approvalcenter">
                  <div class="row">
                     <div style="height:30px;background-color:steelblue;width:80%; margin-left:20px">
                        <span style="color:white;font-size:15px">Claims</span>
                     </div>
                  </div>
                  <br/>
                  <br/>
                  <div class="row">
                     <form:form action="approvalClaims" method="POST" modelattribute  = "employeeClaimsList" commandName="employeeClaimsList"  >
                        <table border="1" style="width:80%;margin-left:20px;">
                           <tr>
                              <th>Employee ID</th>
                              <th>Comment</th>
                              <th>Purchase Date</th>
                              <th>Amount</th>
                              <th>Accept/Reject</th>
                           </tr>
                           <c:forEach items="${employeeClaimsList.employeeClaims}" var = "employeeClaim" varStatus = "status">
                              <tr>
                                 <form:hidden path="employeeClaims[${status.index}].employeeClaimId" />
                                 <form:hidden path="employeeClaims[${status.index}].appliedDate"/>
                                 <td> <input type="text" name="employeeClaims[${status.index}].employeeId" value="${employeeClaim.employeeId}" readonly=true/></td>
                                 <td> <input type="text" name="employeeClaims[${status.index}].claimComment" value="${employeeClaim.claimComment}" readonly = true /></td>
                                 <td> <input type="text" name="employeeClaims[${status.index}].purchaseDate" value="${employeeClaim.purchaseDate}" readonly=true/></td>
                                 <td> <input type="text" name="employeeClaims[${status.index}].Amount" value="${employeeClaim.amount}" readonly=true/></td>
                                 <td>
                                    <form:radiobuttons path="employeeClaims[${status.index}].claimStatus" items ="${employeeClaimsList.employeeclaimStatus}" name="claimtatuses" element="li"/>
                                 </td>
                              </tr>
                           </c:forEach>
                        </table>
                        <br/>
                        <br/>
                        <input type="submit"  name="btnSubmit" class="btn btn-info btn-block" value="Submit" style="width:500px;margin-left:20px;"/>
                     </form:form>
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
                     <form:form action="approvalLeaves" method="POST" modelattribute  = "employeeLeavesList" commandName="employeeLeavesList"  >
                        <table border="1" style="width:80%;margin-left:20px;">
                           <tr>
                              <th>Employee ID</th>
                              <th>Comment</th>
                              <th>Start Date</th>
                              <th>End Date</th>
                              <th>Accept/Reject</th>
                           </tr>
                           <c:forEach items="${employeeLeavesList.employeeLeaves}" var = "employeeLeave" varStatus = "status">
                              <tr>
                                 <form:hidden path="employeeLeaves[${status.index}].employeeLeaveId"/>
                                 <form:hidden path="employeeLeaves[${status.index}].appliedDate"/>
                                 <td> <input type="text" name="employeeLeaves[${status.index}].employeeId" value="${employeeLeave.employeeId}" readonly=true/></td>
                                 <td> <input type="text" name="employeeLeaves[${status.index}].leaveComment" value="${employeeLeave.leaveComment}" readonly=true/></td>
                                 <td> <input type="text" name="employeeLeaves[${status.index}].startDate" value="${employeeLeave.startDate}" readonly=true/></td>
                                 <td> <input type="text" name="employeeLeaves[${status.index}].endDate" value="${employeeLeave.endDate}" readonly=true/></td>
                                 <td>
                                    <form:radiobuttons path="employeeLeaves[${status.index}].leaveStatus" items ="${employeeLeavesList.employeeLeaveStatus}" name="leavestatuses" element="li"/>
                                 </td>
                              </tr>
                           </c:forEach>
                        </table>
                        <br/>
                        <br/>
                        <input type="submit"  name="btnSubmit" class="btn btn-info btn-block" value="Submit" style="width:500px;margin-left:20px;"/>
                     </form:form>
                  </div>
               </div>
               <div role="tabpanel" class="tab-pane" id ="employeeCreation">
                  <%@ include file="employeeCreation.jsp" %>
               </div>
            </div>
         </div>
      </div>
      <c:if test="${not empty alertMessage}">
         <script>
            window.alert("${alertMessage}");
         </script>
      </c:if>
   </body>
</html>