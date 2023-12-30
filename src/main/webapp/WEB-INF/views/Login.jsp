<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>
<head>
<style><%@include file="/resources/Login/LoginDesign.css"%></style>
<script><%@include file="/resources/Login/LoginLogic.js"%></script>
 <!-- <script type="text/javascript" src="/resources/LoginLogic.js"></script> -->
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Voter</title>


</head>
<body>


<div id="login-form-wrap">
  <h2>Login</h2>
  <form:form id="login-form" action="${pageContext.request.contextPath}/main/getData" modelAttribute="VO2" method="POST">  
 
    <p>
    <input type="text" id="username" name="username" placeholder="Username" required><i class="validation"><span></span><span></span></i>
    </p>
    <p>
    <input type="text" id="password" name="password" placeholder="password" required><i class="validation"><span></span><span></span></i>
    </p>
    <p>
    <input type="submit" id="login" value="Login" >
    </p>
    
 </form:form>
     
  
</body>
</html>