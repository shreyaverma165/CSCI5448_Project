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
               <a class="navbar-brand text-hide" href="http://disputebills.com" style="background: url(https://image.ibb.co/hjw3J5/Transparent4.png) center / contain no-repeat; width:200px;">Text</a>
            </div>
         </div>
      </nav>
      <style>
         @media (min-width: 7px) {
         .brand-pills` > li > a {
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

<div class="container" style="width:570px">
<form action="sendmail" method="post">
	<div align="left">
	<div class="input-group">
    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
    <input name="emailAddress" type="text" placeholder="EmailAddress" class="form-control" Style="width:500px;"/>
 	 </div>
 	<div>
	<input type="submit" class="btn btn-info btn-block" style="width:540px;" />
	</div>
	</form>
</div>



</body>
</html>