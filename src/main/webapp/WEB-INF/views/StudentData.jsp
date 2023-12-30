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
	margin-left: 90px;
}

body {
	text-align: center;
	background-color: #2f6b6b;
}

.pl {
	margin-left: 90px;
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
	<form:form class="home"
		action="${pageContext.request.contextPath}/main/getHomepage">

		<button type="submit" class="b" value="GET WELCOME">
			<b>HOME</b>
		</button>
		<br>
		<br>
		<br>
		<button   type="submit" class="b" formaction="${pageContext.request.contextPath}/main/getDatabase">
			<b>VIEW STUDENT DATA</b>
		</button>
		<br>
		<br>
		<br>
		<button  type="submit" class="b" formaction="${pageContext.request.contextPath}/main/getQuoteDatabase">
			<b>VIEW STUDENT ENQUIRY</b>
		</button>
		<br>
		<br>
		<br>
		<br>
	</form:form>

	
</body>
</html>