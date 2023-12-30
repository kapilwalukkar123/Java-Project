<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Database</title>
<script type="text/javascript">
	
</script>

<style type="text/css">
h1 {
	background-color: white;
	margin-left:0px;
}

body {
	text-align: center;
	background-color: #2f6b6b;
}

.pl {
	margin-left: 0px;
	margin-right: 90px;
	width: 1800px;
}

.hpl {
	text-align: center;
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

<br>
	<form:form class="home"
		action="${pageContext.request.contextPath}/main/getHomepage">

		 <button type="submit" class="b" value="GET WELCOME">
			<b>HOME</b>
		</button>
		<br>
		<br>
		<br>
		
		<button onclick="studentdata()" type="submit" class="b" formaction="${pageContext.request.contextPath}/main/getDatabase">
			<b>VIEW STUDENT DETAILS</b>
		</button>
		<br>
		<br>
		<br>
	
		<button onclick="enquirydata()" type="submit" class="b" formaction="${pageContext.request.contextPath}/main/getQuoteDatabase">
			<b>VIEW STUDENT ENQUIRY</b>
		</button>
		<br>
		<br>
		<br>
		<br> 
	</form:form>

	<form id="id_student">
		<div class="hpl">
			<h1 style="width: 1250px;">STUDENT DETAILS</h1>
		</div>
		<div class="pl">
			<table border="2" width="70%" cellpadding="2">
				<tr>
					<th>Sr.No</th>
					<th>admission_date</th>
					<th>UserName</th>
					<th>LastName</th>
					<th>CourseName</th>
					<th>CourseFees</th>
					<th>FeesPaid</th>
					<th>FeesRemaining</th>
					<th>User Email</th>
					<th>Contact No</th>
					<th>Address</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
				</div>
				<c:forEach items="${dataList}" var="data">
					<tr>
						<td>${data.id}</td>
						<td>${data.admission_date}</td>
						<td>${data.username}</td>
						<td>${data.lastname}</td>
						<td>${data.coursename_1}</td>
						<td>${data.total_fees}</td>
						<td>${data.fees_paid}</td>
						<td>${data.fees_remaining}</td>
						<td>${data.email}</td>
						<td>${data.contact_no}</td>
						<td>${data.address}</td>

						<td><a href="updatepat/${data.id}">Update</a></td>
						<td><a href="deletepat/${data.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
			<br />
	</form>

	<form id="id_enquiry">
		<div class="hpl">

			<h1 style="width: 1250px; margin-left: 3px;">STUDENT ENQUIRY DETAILS</h1>
		</div>
		<div class="pl" style="margin-left: 3px;">
			<table border="2" width="70%" cellpadding="2" id="enq_tbl">
				<tr>
					<th>Sr.No</th>
					<th>Name</th>
					<th>Contact</th>
					<th>Email</th>
					<th>Enquiry</th>
				</tr>
				</div>
				<c:forEach items="${quoteList}" var="data">
					<tr>
						<td>${data.id}</td>
						<td>${data.user_name}</td>
						<td>${data.user_contact}</td>
						<td>${data.user_email}</td>
						<td>${data.user_enquiry}</td>

					</tr>
				</c:forEach>
			</table>
			<br />
	</form>


</body>
</html>