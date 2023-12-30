<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Upload Form</title>
</head>
<body>
<h1>File Upload Example - JavaTpoint</h1>

<h3 style="color:red">${filesuccess}</h3>
<form modelAttribute=”candidatedetails” role="form" action="/pro/main/savefile" method = "post" enctype="multipart/form-data">
<%-- <form method="post" action="/pro/main/savefile" enctype="multipart/form-data"> --%>
<p><label for="image">Choose Image</label></p>
<p><input name="file" id="fileToUpload" type="file" /></p>
<p><input type="submit" value="Upload"></p>
</form>

<!-- <img alt="image" src="RANU SIGN_1.jpg" width="500" height="600">-->
<img alt="" width="30px" height="30px" src="<c:url value="/resources/images/RANU PHOTO 2.jpg"></c:url>">

</body>
</html>