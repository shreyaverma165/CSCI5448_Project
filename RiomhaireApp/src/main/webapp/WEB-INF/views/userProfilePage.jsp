<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  		<li><a href="#"><span style="color:white;">My Account</span></a></li>
        <li><a href="logout"><span style="color:white;">Sign Out</span></a></li> 
  	</ul>
  	</div>
	</div>
</nav>
<style>
 body {
    overflow-x: hidden;
    background:powderblue;
 }

/* Toggle Styles */

#wrapper {
    padding-left: 0;
    -webkit-transition: all 0.6s ease;
    -moz-transition: all 0.6s ease;
    -o-transition: all 0.6s ease;
    transition: all 0.6s ease;
    
}

#wrapper.toggled {
    padding-left: 200px;
}

#sidebar-wrapper {
    z-index: 1000;
    position: fixed;
    left: 250px;
    
    width: 0;
    height: 100%;
    margin-left: -250px;
    overflow-y: auto;
    background-color:grey !Important;
    foreground-color:white;
   
    -webkit-transition: all 0.5s ease;
    -moz-transition: all 0.5s ease;
    -o-transition: all 0.5s ease;
    transition: all 0.5s ease;
}

#wrapper.toggled #sidebar-wrapper {
    width: 0;
}

#page-content-wrapper {
    width: 100%;
    position: absolute;
    padding: 10px;
}

#wrapper.toggled #page-content-wrapper {
    position: absolute;
    margin-left:-250px;
}

/* Sidebar Styles */

.sidebar-nav {
    position: absolute;
    top: 0;
    right:15px;
    width: 200px;
    margin: 0;
    padding: 0;
    list-style: none;
    color:black;
}

.sidebar-nav li {
    text-indent: 20px;
    line-height: 40px;
}

.sidebar-nav li a {
    display: block;
    text-decoration: none;
    color: #999999;
}

.sidebar-nav li a:hover {
    text-decoration: none;
    color: #0000;
    background: #312A25;
}

.sidebar-nav li a:active,
.sidebar-nav li a:focus {
    text-decoration: none;
}

.sidebar-nav > .sidebar-brand {
    height: 65px;
    font-size: 18px;
    line-height: 60px;
}

.sidebar-nav > .sidebar-brand a {
    color: white;
}

.sidebar-nav > .sidebar-brand a:hover {
    color: #fff;
    background: none;
}

@media(min-width:768px) {
    #wrapper {
        padding-left: 220px;
    }

    #wrapper.toggled {
        padding-left: 0;
    }

    #sidebar-wrapper {
        width: 200px;
    }

    #wrapper.toggled #sidebar-wrapper {
        width: 40px;
        
        
    }

#wrapper.toggled span {
        visibility:hidden;
        
    }
  #wrapper.toggled   i {
 float:right;
 } 

    #page-content-wrapper {
        padding: 20px;
        position: relative;
    }

    #wrapper.toggled #page-content-wrapper {
        position: relative;
        margin-right: 0;
    }
}


@media(max-width:414px) {

#wrapper.toggled #page-content-wrapper {
    position: absolute;
    margin-right:60px;
}

#wrapper.toggled {
    padding-right: 60px;
}

 #wrapper {
        padding-left: 20px;
    }

    #wrapper.toggled {
        padding-left: 0;
    }

    #sidebar-wrapper {
        width: 50px;
    }

    #wrapper.toggled #sidebar-wrapper {
        width: 140px;
        
        
    }
    
    #wrapper.toggled span {
        visibility:visible;
        position:relative;
        left:70px;
        bottom:13px;
        
    }

#wrapper span {
        visibility:hidden;
        
    }
  #wrapper.toggled   i {
 float:right;
 } 
 
  #wrapper   i {
 float:right;
 } 

    #page-content-wrapper {
        padding: 5px;
        position: relative;
    }

    #wrapper.toggled #page-content-wrapper {
        position: relative;
        margin-right: 0;
    }
</style>
</head>
<body>
<div class="container">
	<div class="row">
		 <div id="wrapper">
        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav" style="margin-left:0;">
              <li class ="active">
              	<a href="#dashboard"><span style="margin-left:10px;color:white;">Dashboard</span></a>
              </li>
              <c:if test = "${employee.designation == 'FactoryEmployee' }">
              <li>
              	<a href="#dashboard_pp"><span style="margin-left:10px;color:white;">My Line</span></a>
              </li>
              </c:if>
              <c:if test = "${employee.designation == 'FactoryManager' }">
              <li>
              	<a href="#dashboard"><span style="margin-left:10px;color:white;">My Line</span></a>
              </li>
              </c:if>
              <c:if test = "${employee.designation == 'HRManager' }">
              <li>
              	<a href="#dashboard_pp"><span style="margin-left:10px;color:white;">Approval Central</span></a>
              </li>
              </c:if>
              <c:if test = "${employee.designation == 'HRManager' }">
              <li>
              	<a href="#dashboard"><span style="margin-left:10px;color:white;">Employee Creation</span></a>
              </li>
              </c:if>
              <li>
              	<a href="#"><span style="margin-left:10px;color:white;">Employee Search</span></a>
              </li>
              <li>
              	<a href="#"><span style="margin-left:10px;color:white;">My Leaves & Claims</span></a>
              </li>
            </ul>
            
        </div>
        <!-- Page Content -->
        <div id="page-content-wrapper">
       		<div class="page-content" id="dashboard">
       			crazy
      		</div>
       		<div class="page-content" id="dashboard_pp">
       			crazy
      		</div>
       	</div>
    
	</div>
</div>
</body>
</html>