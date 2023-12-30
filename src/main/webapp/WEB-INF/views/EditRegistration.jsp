<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>
<head>

<style><%@include file="/resources/RegisterDesign.css"%></style>
<script><%@include file="/resources/RegisterLogic.js"%></script>
 <!-- <script type="text/javascript" src="/resources/LoginLogic.js"></script> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">



function resetf() {
	 
	
	document.getElementById("total_fees").value = "";
	document.getElementById("fees_paid").value = "";
	document.getElementById("user_rfees").value = "";
	}
function cal() {
	  
	
	document.getElementById("total_fees").value = "3000";
	}
function cal1() {
	 
	
	document.getElementById("total_fees").value = "3000";
	}
function cal2() {
	  
		
	document.getElementById("total_fees").value = "4500";
	}
function cal3() {
	 
	
	document.getElementById("total_fees").value = "30000";
	}
function cal4() {
	
	
	document.getElementById("total_fees").value = "5000";
	}
	
function fees() {

	document.getElementById("user_rfees").value = (document.getElementById("total_fees").value-document.getElementById("fees_paid").value);
	}
	
function update(){
	
	alert("Updated Successfully");
}
	
</script>
</head>
<body>

<form:form action="${pageContext.request.contextPath}/main/Update" modelAttribute="VO" method="POST">  
  <div class="container">
    <h1>Register</h1>
    <p>Please fill  this form for Admission Process.</p>
    <hr>
  
    
         
     <label for="id"><b>ID</b></label>	
	<input type="text"  path="id" name="id" id="id"    value="${user_id}" required>	<br>	<br>
	

    <label for="admission_date"><b>Admission Date</b></label>	
	<input type="date" name="admission_date" placeholder="DD-MM-YYYY" id="user_date" value="${date }" required>	<br>	<br>
	
	
	<label for="username"><b>UserName</b></label>
	<input type="text"  name="username" id="user_name"  value="${user_name}" required>
	
	<label for="lastname"><b>LastName</b></label>
	<input type="text"  name="lastname" id="user_last" value="${last_name}" required>
	
	
	<label for="coursename_1"><b>Course Name And Duration</b></label>
	<input type="text"  name="coursename_1" id="user_course" value="${course}" required>
	
	
	
      <label for="total_fees"><b>CourseFees</b></label>
	<input type="text"  name="total_fees" id="total_fees" value="${totfees}">
	
      <label for="fees_paid"><b>Paid Fees:-</b></label>
	<input type="text"  name="fees_paid" id="fees_paid" onclick="fees();" value="${feesp}" >
	
	<label for="fees_remaining"><b>Remaining Fees:-</b></label>
	<input type="text"  name="fees_remaining" id="user_rfees" value="${feesr}">
	
	<p ><b>  Contact Number:-</b></p> 	
	<input type="tel" name="contact_no" placeholder="+91-" id="user_no" pattern="[789][0-9]{9}" title="Mobile No Should be a valid 10-digit no" value="${no}" required> <br><br>

	
    <label for="email"><b>Email:-</b></label>
    <input type="text"  name="email" id="user_email" value="${mail}" pattern="[a-z0-9]+@[a-z]+\.[a-z]{2,3}" title="Enter Email Id , Ex: abc@gmail.com" required>

  <p ><b>  Address:-</b></p>   
   <textarea rows="4" cols="50" name="address" id="user_address" >${addr} </textarea>
	    
    <hr>

    <p>By creating an account you agree to our <a  style="cursor: pointer;" >Terms and Privacy</a>.</p>
    
     <button type="submit" class="registerbtn" onclick="update();">Update</button>
     <input type="reset" value="Clear" >
  </div>
  
  
</form:form>
</body>
</html>