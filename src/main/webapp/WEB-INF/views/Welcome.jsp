<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<html>
<head>
<style> <%@include file="/resources/Welcome/WelcomeDesign.css" %></style>
<script><%@include file="/resources/Welcome/Welcome.js"%></script>
 <!-- <script type="text/javascript" src="/resources/LoginLogic.js"></script> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>



<form:form class="homepage" action="${pageContext.request.contextPath}/main/getLog" > 

 <div  class="homebutton"> <br> <br>
 
<button type="submit" class="b1" formaction="${pageContext.request.contextPath}/main/getRegistration"> <b>REGISTRATION</b> </button><br><br><br>
<button type="submit" class="b2"  > <b>LOGIN</b> </button><br><br><br>
<button type="submit" class="b3" value="GET QUOTE" formaction="${pageContext.request.contextPath}/main/getWelcome2"> <b>GET QUOTE</b> </button>
       
 </div>    




 <div class="header">  

<h1><b> SHUBH DRAWING CLASSES  </b></h1>
<div class="img">
<img alt="" width="1000px" height="500px" src="<c:url value="/resources/images/Draw1.png"></c:url>">
</div> 
</div>





<div class="mbody"> 

<h2> <b> UPDATES </b></h2>
<img alt="" width="259.517px" height="259.517px" src="<c:url value="/resources/images/Draw2.png"></c:url>">
<img alt="" width="259.517px" height="259.517px" src="<c:url value="/resources/images/OImage.jpg"></c:url>">



</div> 


<div class="review"> 
<a class="dir" href="https://www.google.com/search?hl=en-IN&gl=in&q=Shreyas+Drawing+Classes,+33+Pawansut+Nagar,+Hudkeshwar+Rd,+near+Bharat+Petrol+Pump,+Nagpur,+Maharashtra+440034&ludocid=18220795398240763341&lsig=AB86z5Xd50mpG0RQvyxtZ63zul0R#lrd=0x3bd4b9c3ecbcb4b9:0xfcdd44e075367dcd,3"> <b> WRITE A REVIEW</b> </a>
<a class="dir" href="https://search.google.com/local/reviews?placeid=ChIJubS87MO51DsRzX02deBE3fw"> <b> READ MORE</b> </a>

</div>

<div class="gallery">  
<h2> <b> GALLERY </b> </h2>
<img alt="" width="259.517px" height="259.517px" src="<c:url value="/resources/images/1.jpg"></c:url>">
<img alt="" width="259.517px" height="259.517px" src="<c:url value="/resources/images/2.jpg"></c:url>">
<img alt="" width="259.517px" height="259.517px" src="<c:url value="/resources/images/3.jpg"></c:url>">
<img alt="" width="259.517px" height="259.517px" src="<c:url value="/resources/images/4.jpg"></c:url>">
<img alt="" width="259.517px" height="259.517px" src="<c:url value="/resources/images/5.jpg"></c:url>">
<img alt="" width="259.517px" height="259.517px" src="<c:url value="/resources/images/6.jpg"></c:url>">
<!-- insert here image -->
</div>


<h1>Contact Us</h1>
<hr>
<div class="bottom1"> 

<h2> <b> CONTACT </b></h2>

<P> Mb.No:- +91-7276371279 </P>

</div>

<div class="bottom2"> 

<h2> <b> ADDRESS </b></h2><br>

<a class="dir" href="https://www.google.com/maps/dir//Shreyas+Drawing+Classes/data=!4m8!4m7!1m0!1m5!1m1!1s0x3bd4b9c3ecbcb4b9:0xfcdd44e075367dcd!2m2!1d79.1239634!2d21.083931699999997"><b>GET DIRECTION</b> </a><br><br><br>

<P> 14, Pawansut Nagar,<br><br>
    Hudkeshwar Road,<br><br>
    Near Bharat Petrol Pump,<br><br>
    Nagpur, Maharashtra 440034,<br><br>
    India
</P>

</div>

<div class="bottom3">
<h2> <b> Business Hours </b></h2>
<p>
Mon: 9:00 AM - 6:00 PM<br><br>
Tue: 9:00 AM - 6:00 PM<br><br>
Wed: 9:00 AM - 6:00 PM<br><br>
Thu: 9:00 AM - 6:00 PM<br><br>
Fri: 9:00 AM - 6:00 PM<br><br>
Sat: Closed<br><br>
Sun: 9:00 AM - 6:00 PM<br><br>
</p>
</div>

</form:form>
</body>
</html>


