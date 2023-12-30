<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html>


<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] ,input[type=file]{
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}
#cars{

width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;

}

/* Set a style for the submit button */
.registerbtn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>

<%@include file="./ElectionAuthority.jsp" %>


<script type="text/javascript">  
 
	 $(document).ready(function(){
		 document.getElementById("addCandidate").className="nav-link active"
			 document.getElementById("home").className="nav-link"
		});
  
 </script>
 
  <script type="text/javascript"> 
var loadFile = function(event) {
	
	debugger;
	var image = document.getElementById('output');
	image.src = URL.createObjectURL(event.target.files[0]);
	
	document.getElementById('path').value=event.target.files[0].name;
	
	//alert(event.target.files[0].name);
};
</script>
 
</head>
<body>

 <%-- <img alt="" width="100%" height="200px" src="<c:url value="/resources/images/election.jpg"></c:url>"> --%>

<!-- <form modelAttribute=”candidatedetails” role="form" action="/pro/main/saveCandidate" enctype="multipart/form-data"> -->
<form modelAttribute=”candidatedetails” role="form" method="post" action="/pro/main/savefile" enctype="multipart/form-data">
  <div class="container" style="width: 50%;">
    <h1>ADD CANDIDATE</h1>
   
    <hr>
<label style="color: black;font-weight: bold;" for="cars">Select Election<b></label><br>
  <select name="election_name" id="election_name" style="width: 250px;">
  <option value="">Select Election</option>
    <c:forEach items="${election_list}" var="elct">
    <option value="${elct}">${elct}</option>
  </c:forEach>   
  </select>
  <br><br>
  
    <label for="email"><b>Candidate Name</b></label>
    <input type="text" placeholder="Candidate Name" name="candidate_name" id="candidate_name" pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" title="Please Enter only alphabets in text" required>
  
    <label for="email"><b>Party Name</b></label>
    <input type="text" placeholder="Party Name" name="party_name" id="party_name" pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" title="Please Enter only alphabets in text" required>

    <label for="psw"><b>Address</b></label>
    <input type="text" placeholder="Enter Address" name="address" id="address" required>

    <label for="psw-repeat"><b>Phone Number</b></label><br>
     <input type="text" id="contact" placeholder="Phone number" class="form-control" name="contact" style="width: 650px;height: 50px;" required><br><br>
    
    <!-- <input type="number" placeholder="Phone Number" name="contact" id="contact" style="width: 650px;height: 50px;" required><br><br> -->
    
    <label for="image"><b>Upload Party Image</b></label><br>
    	<!-- Photo: <input type="file" name="photo"> -->
    
    <!--   <p><input type="file"  accept="image/*" name="image" id="file"  onchange="loadFile(event)" style="display: none;"></p> -->
	
	<p><input name="file" id="fileToUpload" type="file"  value="hello" onchange="loadFile(event)"/></p>
	<!-- <p><label for="file" style="cursor: pointer;">Upload Party Symbol</label></p> -->
	<p><img id="output" width="200" name="image" value="hello"/></p>
	<p><input id="path" width="200" name="image" hidden/></p>
   <!--   <input type="file" id="myFile" name="filename">
     <a href="/pro/main/uploadform">Upload Image</a>      
    -->  

     
     
    <hr>
 
    <button type="submit" class="registerbtn">SUBMIT</button>
    
  </div>
 
  <div class="container signin">
   
  </div>
</form>

</body>
</html>