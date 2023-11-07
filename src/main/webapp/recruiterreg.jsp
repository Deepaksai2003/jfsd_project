<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login & Registration Form</title>
  <link rel="stylesheet" href="css/jobseekerregister.css">
 <%@ include file="nav.jsp" %>
</head>
<body>
<center><font style="color:red;">${msg}</font></center>
  <div class="container2">    
    <div class="registration form">
      <header>Recruiter</header>
      <form:form action="recruiterinsert" modelAttribute="Recruiter" method="post" enctype="multipart/form-data">
          <label for="full-name">Full Name</label>
          <form:input id="full-name" path="fullname" placeholder="Enter your full name" required="required"/>

          <label for="email">Email</label>
          <form:input id="email" path="email" placeholder="Enter your email" required="required"/>

          <label for="password">Password</label>
          <form:password path="password" placeholder="Enter your full password" id="password" required="required"/>
          
          <label for="gender">Gender:</label>
          <form:select id="gender" path="gender" required="required">
              <form:option value="male">Male</form:option>
              <form:option value="female">Female</form:option>
              <form:option value="other">Others</form:option>
          </form:select>
        <br/>
        <br/>
        <form:form action="recruiterinsert" modelAttribute="Recruiter" method="post" required="required">
               <label for="image">Image (JPEG only)</label>
               <input type="file" id="image" name="image" accept=".jpg, .jpeg" required/>
               <input type="submit" class="button" value="Signup">
         </form:form>
      </form:form>
    </div>
  </div>
</body>
</html>
