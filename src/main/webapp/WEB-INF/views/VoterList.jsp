<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">
<title>VoterList</title>

    <%@include file="./ElectionAuthority.jsp" %>
    
     <style>
    table,
    th,
    td {
        border: 1px solid black;
        border-collapse: collapse;
    }
    th{
    background-color:powderblue;
    }
    </style>
    <script type="text/javascript">  
 
	 $(document).ready(function(){
		 document.getElementById("viewVoter").className="nav-link active"
			 document.getElementById("home").className="nav-link"
		});
  
	 

	 
	 </script>
	 
	  <script type="text/javascript">
	 /*  
	 function statusChange(name,email,status){
		 
		 debugger;
		 
		 var url =  "/pro/main/viewVoters1?name=" + name+"&email="+email"&status="+status;
			window.open(url,"_self");
		 
		// window.open("/pro/main/viewVoters1?name=" + name+"&email="+email,"&status="+status, "_self");
		 
	 } */
	 	 
	 function hello(name,email,status){
		 
		 debugger;
		 
		
		 
	 /*  var url =  "/pro/main/viewVoters1?name=" + name+"&email="+email"&status="+status; */
	  
	  var url = "/pro/main/viewVoters1?name="+name+"&email="+email+"&status="+status;
	  window.open(url,"_self");
	 
		/*	window.open(url,"_self"); */
		
	
		
	 }
	 
	 
 </script>
 
<!--  <script type="text/javascript">
 
 function newFunction(){
	 
	 alert("Hi");
	 
 }
 
 </script> -->
 
 
</head>
<body>

 <table style="width: 80%;margin-left: 10%;">
      <tr> <th colspan="9" text-align="center" style="text-align: center;">Voter List</th></tr>
        <tr>
            <th>Sr.No</th>
            <th>Voter Name</th>            
            <th>Dob</th>
            <th>Contact</th>
            <th>Email</th>
            <th>Adhar</th>
             <th>Voter id</th>
            <th>Status</th>
            <th>Action</th>            
        </tr>
        <c:set var="srno" value="1" />
        <c:forEach items="${voterList}" var="voter">
        <tr>
            <td>${srno}</td> 
            <td>${voter.fullname}</td>
            <td>${voter.dob}</td>
            <td>${voter.phone}</td>
            <td>${voter.email}</td>
            <td>${voter.adhar}</td>
            <td>${voter.voterid}</td>
            <c:if test="${voter.status eq 'null'}">
            <td>Pending</td>
            </c:if>
            <c:if test="${voter.status ne 'null'}">
         <td>${voter.status}</td>
            </c:if>
            
            
<%--             <td> <input type="button" placeholder="Approved"  value="Approved" onclick="statusChange('${voter.fullname}','${voter.email}','approved')"></td>
 --%>        

			<td> <input type="button" placeholder="Approved"  value="Approved" onclick="hello('${voter.fullname}','${voter.email}','approved')"></td> 

 			<!-- <td> <input type="button" placeholder="Approved"  value="Approved" onclick="newFunction();"></td> -->
 			</tr>
        	<c:set var="srno" value="${srno+1}"></c:set>
        </c:forEach>
    </table>


</body>
</html>