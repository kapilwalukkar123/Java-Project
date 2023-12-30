<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-2.1.3.min.js"></script>
 <%@include file="./Header.jsp" %>
<!--  <script type="text/javascript" src="../resources/js/Voter.js"></script>
 -->     
 <link rel="stylesheet" href="../resources/css/VoterForm.css"/>
 
 <script type="text/javascript">  
 
	 $(document).ready(function(){
		 document.getElementById("Voter").className="nav-link active"
			 document.getElementById("Home").className="nav-link"
		});
  
 </script>
 <script type="text/javascript"> 
 function check(confirm_pass){
	 
	 
	 debugger;
	 pass= document.getElementById("password").value
	 
	 if(confirm_pass!=pass){
		 
		 alert("Please fill  same password");
		 document.getElementById("con_password").value="";
	 }
	 
	 
 }
		 </script>
</head>
<body>


<div class="container">
            <form class="form-horizontal" modelAttribute=”voterdetails” role="form" action="/pro/voter/Login1">
			<h3 style="text-align: center;">Voter Registration</h3>
	                <div class="form-group">
                    <label for="firstName" class="col-sm-3 control-label">Full Name*</label>
                    <div class="col-sm-9">
                        <input type="text" id="firstName" placeholder="First Name" class="form-control" name="fullname" pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" title="Please Enter only alphabets in text" autofocus required>
                    </div>
                </div>
               <!--  <div class="form-group">
                    <label for="lastName" class="col-sm-3 control-label">Last Name</label>
                    <div class="col-sm-9">
                        <input type="text" id="lastName" placeholder="Last Name" class="form-control" autofocus>
                    </div>
                </div> -->
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Email* </label>
                    <div class="col-sm-9">
                        <input type="email" id="email" placeholder="Email" class="form-control" name= "email" pattern="[a-z0-9]+@[a-z]+\.[a-z]{2,3}" title="Enter Email Id , Ex: abc@gmail.com" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Password*</label>
                    <div class="col-sm-9">
                        <input type="password" id="password" placeholder="Password" class="form-control" name="password" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Confirm Password*</label>
                    <div class="col-sm-9">
                        <input type="password" id="con_password" placeholder="Password" class="form-control" name="con_password" onchange="check(this.value)" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="birthDate" class="col-sm-3 control-label">Date of Birth*</label>
                    <div class="col-sm-9">
                        <input type="date" id="birthDate" class="form-control" name="dob" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="phoneNumber" class="col-sm-3 control-label">Phone number* </label>
                    <div class="col-sm-9">
                        <input type="tel" id="phoneNumber" placeholder="Phone number" class="form-control" name="phone" pattern="[789][0-9]{9}" title="Mobile No Should be a valid 10-digit no" required> 
                        <span class="help-block">Your phone number won't be disclosed anywhere </span>
                    </div>
                </div>
                <div class="form-group">
                        <label for="Adhar" class="col-sm-3 control-label">Aadhar No.* </label>
                    <div class="col-sm-9">
                        <input type="text" id="adhar" placeholder="Please enter Adhar no" class="form-control" name="adhar" pattern=" /^([0-9]{4}[0-9]{4}[0-9]{4}$)|([0-9]{4}\s[0-9]{4}\s[0-9]{4}$)|([0-9]{4}-[0-9]{4}-[0-9]{4}$)/;"  title="Please enter correct 12 digit Adhar Id" required>
                    </div>
                </div>
                 <div class="form-group">
                        <label for="voter_id" class="col-sm-3 control-label">Voter Id* </label>
                    <div class="col-sm-9">
                        <input type="text" id="voter_id" placeholder="Please enter Voter id" class="form-control" pattern="^[A-Z]{3}[0-9]{7}$"  title="Please enter correct 10 digit Voter Id ex:- ABC1234567" name="voterid" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-3">Gender*</label>
                    <div class="col-sm-6">
                        <div class="row">
                            <div class="col-sm-4">
                                <label class="radio-inline">
                                    <input type="radio" id="femaleRadio" value="Female" name="gender" required>Female
                                </label>
                            </div>
                            <div class="col-sm-4">
                                <label class="radio-inline">
                                    <input type="radio" id="maleRadio" value="Male" name="gender" required>Male
                                </label>
                            </div>
                        </div>
                    </div>
                </div> <!-- /.form-group -->
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <span class="help-block">*Required fields</span>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Register</button>
            </form> <!-- /form -->
        </div> <!-- ./container -->
</body>
</html>