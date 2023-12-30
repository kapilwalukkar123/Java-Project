<!DOCTYPE html>
<html>
 
<head>
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
    
    <%@include file="./ElectionAuthority.jsp" %>
    <script type="text/javascript">  
 
	 $(document).ready(function(){
		 document.getElementById("viewResult").className="nav-link active"
			 document.getElementById("home").className="nav-link"
		});
  
	 
	 
 </script>
 
 
 
 <script type="text/javascript">
 
 
 function candidateList(election,date){
		
		debugger;
		
		var url =  "/pro/main/viewResults?Election=" + election+"&date="+date;
		window.open(url,"_self");
				
	}
 
 </script>
 
 <style>
body {
  background-image: url('vote');
}
</style>
    
</head>
 
<body>
   
    
    <table style="width:100%;margin-top: -35px;">
      <tr>
       
  <td>
   <label style="color: white;font-weight: bold;margin-left: 35%;" for="cars">Select Election<b></label>
   <select name="election_name" id="election_name" style="width: 250px;" value="" onchange="candidateList(this.value,'${election_list[0].election_date}')">
  
  <c:if test="${Election ne '' || Election ne 'null'}">
  <option value="">${Election}</option>
  </c:if>
  
  
   <c:if test="${Election eq '' || Election eq 'null'}">
  <option value="">Select Election</option>
  </c:if>
 
    <c:forEach items="${election_list}" var="elct">
    <option value="${elct.election_name}">${elct.election_name}</option>
  </c:forEach>   
  </select></td>
        </tr></table>
    <table style="width:100%">
        
      
        <tr>
        	<th>Sr.No</th>
            <th>Party Symbol</th>
            <th>Candidate Name</th>
            <th>Party Name</th>
            <th>Total Votes</th>
        </tr>
        
        <c:set var="srno" value="1" />
        <c:forEach items="${candidateList}" var="candidate">
        <tr>
            <td>${srno}</td>       
           <td>  <img alt="" width="80px" height="50px" src="<c:url value="/resources/images/${candidate.image}"></c:url>"></td>
             <td>${candidate.candidate_name}</td>
            <td>${candidate.party_name}</td> 
            <td>${candidate.vote}</td>           
            
                    </tr>
        	<c:set var="srno" value="${srno+1}"></c:set>
        </c:forEach>
       
    </table>
</body>
 
</html>