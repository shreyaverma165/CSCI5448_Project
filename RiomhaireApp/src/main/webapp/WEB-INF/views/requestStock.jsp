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
      <div class ="container">
         <div style="height:30px;background-color:steelblue;width:80%; margin-left:20px">
            <span style="color:white;font-size:15px">Request Stock</span>
         </div>
         <br/>
         <br/>	   
         <form class="form-horizontal" action="requestStock" method="POST">
         <fieldset>
         <!-- Text input-->
         <div class="form-group">
            <label class="col-md-4 control-label" for="fn">Electronics</label>  
            <div class="col-md-4">
               <input  name="electronicsStock" type="number" pattern="[0-9]" placeholder="Electronics" class="form-control input-md"/>
            </div>
         </div>
         <!-- Text input-->
         <div class="form-group">
            <label class="col-md-4 control-label" for="ln">Screen</label>  
            <div class="col-md-4">
               <input name="screenStock" type="number" pattern="[0-9]" placeholder="Screen" class="form-control input-md"/>
            </div>
         </div>
         <!-- Text input-->
         <div class="form-group">
            <label class="col-md-4 control-label" for="cmpny">Casing</label>  
            <div class="col-md-4">
               <input name="casingStock" type="number" pattern="[0-9]" placeholder="Casing Stock" class="form-control input-md" />
            </div>
         </div>
         <!-- Text input-->
         <div class="form-group">
            <label class="col-md-4 control-label" for="email">Battery</label>  
            <div class="col-md-4">
               <input  name="batteryStock" type="number" pattern="[0-9]" placeholder="Battery Stock" class="form-control input-md" required=""/>
            </div>
         </div>
         <div class="form-group">
            <label class="col-md-4 control-label" for="submit"></label>
            <div class="col-md-4">
               <input id="submit" type="submit" class="btn btn-primary" value="submit"/>
            </div>
         </div>
         </fieldset>
         </form>
      </div>
   </body>
</html>