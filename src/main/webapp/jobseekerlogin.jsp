<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>

<link rel='stylesheet' type='text/css' media='screen' href='../css/login.css'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  <title>Login & Registration Form</title>
  <link rel="stylesheet" href="../css/home.css">
</head>
<body>
<%@ include file="nav.jsp" %>
<br/>
<center><font style="color:red;">${msg}</font></center>
  <div class="container1">
    <div class="login form">
      <header>Login</header>
     <form:form action="checkjobseekerlogin" modelAttribute="JobSeeker">
        <form:input path="email" placeholder="email"></form:input>
        <form:password path="password" placeholder="password"></form:password>
        <input type="submit" class="button" value="Login">
      </form:form>
    </div>
  </div>
</body>
</html>