<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>
<head>
 <!-- <script type="text/javascript" src="/resources/LoginLogic.js"></script> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

body{
background-color: #2f6b6b;
}

.quote{

margin-left: 35%;
background-color: white;
height:400px;
width: 400px;
border-style: solid;
text-align: center;



}

 .info {
    box-flex: 1;
   
    width: 300px;
} 

.btn{

background-color: #0fba35;
border:2px solid white;
color: white;
padding: 15px 32px;
text-align: center;
font-size: 16px;
display: inline-block;
}

.h1{

text-decoration: underline ;

}

.b {
	position: absolute;
	left: 10px;
	background-color: #1394e6;
	color: white;
	padding: 7px 15px;
	text-align: left;
	font-size: 16px;
	cursor: pointer;
	margin-bottom: 30px;
}

</style>
</head>
<body>
<form:form> 
<button type="submit" class="b" value="GET WELCOME" formaction="${pageContext.request.contextPath}/main/getHomepage">
			<b>HOME</b>
		</button>
		
		</form:form>

<form:form action="${pageContext.request.contextPath}/main/getHome" modelAttribute="QuoteVO" method="POST">



<div class="quote">
<h1 ><b> Get Quote </b></h1>
<input type="text" class="info" name="user_name" placeholder="Name" required><br><br>
<input type="tel" class="info"  name="user_contact" placeholder="Phone Number" required><br><br>
<input type="email" class="info"  name="user_email" placeholder="* Valid email address required" required><br><br>
<p >How can we help you?</p><br>
<textarea id="enquiry" name="user_enquiry" class="info" rows="4" cols="50" required>Enter your enquiry details.</textarea><br><br>

<button input type="submit" class="btn"> SUBMIT </button>

</div>

</form:form>
</body>
</html>


