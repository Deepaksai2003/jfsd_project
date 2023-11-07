<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<!-- Coding By CodingNepal - codingnepalweb.com -->
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login & Registration Form</title>
  <link rel="stylesheet" href="../css/jobseekerregister.css">
 <%@ include file="nav.jsp" %>
</head>
<body>
<center><font style="color:red;">${message}</font></center>
  <div class="container2">    
    <div class="registration form">
      <header>Recruiter</header>
      <form action="updaterecruiter" method="post">
      
      <label for="email">Email</label>
          <input id="email" name="email" value="${obj.email}"  readonly="readonly"/>
          
      
          <label for="full-name">Full Name</label>
          <input id="full-name" name="fullname" placeholder="Enter your full name"  />
          
           <label for="gender">Gender</label>
          <input id="gender" name="gender" value="${obj.gender}"  readonly="readonly"/>

          <label for="password">Password</label>
          <input type="password" name="password" placeholder="Enter your full password" id="password"/>
          
        <br/>
          <input type="submit" class="button" value="update">
      </form>
    </div>
  </div>
</body>
</html>
