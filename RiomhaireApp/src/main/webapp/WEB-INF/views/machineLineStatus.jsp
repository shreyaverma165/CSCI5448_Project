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
<div class = "container">
<div class ="row">
	 <div style="height:30px;background-color:steelblue;width:80%; margin-left:20px">
	                    		<span style="color:white;font-size:15px">My Line Status</span>
	   </div>
</div>

<br/>
<br/>
<div class = "row" style="width:80%;">
    <div class="row">
           
              <div class="col-xs-2 col-xs-offset-1" id="p1" style="background-color: steelblue;">
              <br/>
              <br/>
              <br/>
              <br/>
              <br/>
              <br/>
             <span style="color: white"> Line Status </span>
             <br/>
             <br/>
             <br/>
             <br/>
             <span style="color: white"> Processing # </span>
             <br/>
              <br/>
              <br/>
              <br/>
             <span style="color: white"> Stock </span>
              </div>
              <div class="col-xs-2" id="p2">
             <img src="https://image.ibb.co/haSokk/Picture4.png" alt="Picture4" border="0" 
              width=100px height=100px
              />
               <br/>
               <br/>
               <textarea rows="1" id="electronicsStatustext" style="width: 100px;" readonly> ${electronicsStatus.status}</textarea>
               <br/>
               <br/>
               <br/>
               <textarea rows="1" id="electronicsStatusPosition" style="width: 100px;" readonly> ${electronicsStatus.startPosition}  -  ${electronicsStatus.startPosition} </textarea>
                <br/>
               <br/>
               <br/>
               <textarea rows="1" id="electronicsStock" style="width: 100px;" readonly> ${electronicsStatus.stock}</textarea>
              </div>
              <div class="col-xs-2" id="p3">
				<img src="https://image.ibb.co/iiMsBQ/Picture2.png" alt="Picture2" border="0" 
              width=100px height=100px
              />
				<br/>
               <br/>
               <textarea rows="1" id="screenStatus" style="width: 100px;" readonly> ${screenStatus.status}</textarea>
               <br/>
               <br/>
               <br/>
               <textarea rows="1" id="screenStatusPosition" style="width: 100px;" readonly> ${screenStatus.startPosition}  -  ${screenStatus.startPosition} </textarea>
               <br/>
               <br/>
               <br/>
               <textarea rows="1" id="screenStatusStock" style="width: 100px;" readonly> ${screenStatus.stock} </textarea>
               
			  </div>
              <div class="col-xs-2" id="p4">
             <img src="https://image.ibb.co/iiMsBQ/Picture3.png" alt="Picture3" border="0" 
              width=100px height=100px
              />
              <br/>
               <br/>
               <textarea rows="1" id="casingStatus" style="width: 100px;" readonly> ${casingStatus.status} </textarea>
               <br/>
               <br/>
               <br/>
               <textarea rows="1" id="casingStatusPosition" style="width: 100px;" readonly> ${casingStatus.startPosition}  -  ${casingStatus.startPosition} </textarea>
               <br/>
               <br/>
               <br/>
               <textarea rows="1" id="casingStatusStock" style="width: 100px;" readonly> ${casingStatus.stock}</textarea>
               
              </div>
              <div class="col-xs-2" id="p5">
              <img src="https://image.ibb.co/haSokk/Picture4.png" alt="Picture4" border="0" 
              width=100px height=100px
              />
              <br/>
               <br/>
               <textarea rows="1" id="batteryStatus" style="width: 100px;" readonly> ${batteryStatus.status}</textarea>
               <br/>
               <br/>
               <br/>
               <textarea rows="1" id="batteryStatusPosition" style="width: 100px;" readonly> ${batteryStatus.startPosition}  -  ${batteryStatus.startPosition} </textarea>
               <br/>
               <br/>
               <br/>
               <textarea rows="1" id="batteryStatusStock" style="width: 100px;" readonly> ${batteryStatus.stock}</textarea>
               
              </div>
            <!-- //col-lg-12 -->
          </div>
          <!-- //row -->
        </div>
   <br/>
   <br/>
   <br/>

</div>
<script type="text/javascript">
setInterval(function page_Reload()
{
	var x = document.getElementById("myline").getElementsByTagName("electronicsStatustext");
	alert("stock low");
	location.reload();
},1000*60*10);


</script>
</body>
</html>