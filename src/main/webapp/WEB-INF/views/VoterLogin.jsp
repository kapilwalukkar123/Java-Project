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
<title>Login </title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
 <%@include file="../views/Header.jsp" %>
 <style type="text/css">
 body { 
  background: url(http://lorempixel.com/1920/1920/city/9/) no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  background-image: url('/resources/images/election.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
   background-image: url('/images/img_girl.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}



.panel-default {
opacity: 0.9;
margin-top:30px;
}
.form-group.last { margin-bottom:0px; }
</style>



<script type="text/javascript">
var CONTEXT_ROOT= '<%= request.getContextPath() %>';
</script>

<script type="text/javascript">

function Voter_Registration(){
	
	
	
	this.window.open(CONTEXT_ROOT+"/voter/VoterReg","_self");
}



</script>

<script type="text/javascript">

$(document).ready(function(){
	
	debugger;
	
	
	if('${count_user}'==1 || '${count_user}'==0){
		
		alert('${message}');
	}
	
if('${count_user}'==3){
		
		document.getElementById("footer").style.display="none";
	}
	
if('${count_user}'==4){
	
	document.getElementById("footer").style.display="none";
	alert("Please enter correct username or passward!");
}
	
	
	if('${auth}'=="authority"){
		
		document.getElementById("footer").style.display="none";
		document.getElementById("autho").className="nav-link active"
	    document.getElementById("Voter").className="nav-link"
	    document.getElementById("Home").className="nav-link"
	}
	
	else{
	
		
		document.getElementById("Voter").className="nav-link active"
			 document.getElementById("Home").className="nav-link"
	}
	 
	});

</script>



</head>
<body >



<form modelAttribute=”logindetails” role="form" action="${action}">
  <div class="container">
  <img alt="" width="100%" height="450px" src="<c:url value="/resources/images/election.jpg"></c:url>">
    <div class="row">
       <div class="col-md-4 col-md-offset-7" style="margin-left: 350px;">
            <div class="panel panel-default">
                <div class="panel-heading" style="margin-top: -300px;">
                    <span class="glyphicon glyphicon-lock"></span> Login</div>
                <div class="panel-body" style="border-style: solid;border-color: #0000006b;">
                    <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-3 control-label" style="margin-top: 8px;">
                            Username</label>
                        <div class="col-sm-9">
                            <input type="email" class="form-control" id="inputEmail3" placeholder="Email" name="email" required>
                        </div>
                    </div>
                    <div class="form-group">
                         <label for="inputPassword3" class="col-sm-3 control-label" style="margin-top: 18px;">
                            Password</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password" style="margin-top: 10px;" required>
                        </div>
                    </div>
                    
                    <div class="form-group last">
                        <div class="col-sm-offset-3 col-sm-9">
                           <button type="submit" class="btn btn-success btn-sm" style="margin-top: 15px;">
                                Sign in</button>
                                 
                        </div>
                    </div>
                    </form>
                </div>
                <div class="panel-footer" id="footer">
                    Not Registred? <a href="#" onclick="Voter_Registration()" style="font-size: initial;">Register here</a></div>
            </div>
        </div>
    </div>
</div>
</form>
</body>
</html>