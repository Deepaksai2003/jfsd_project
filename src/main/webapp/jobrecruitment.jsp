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
  <link rel="stylesheet" href="css/job.css">
 <%@ include file="recruiternav.jsp" %>

</head>
<body>
  
  <center><font style="color:red;">${msg}</font></center>

  <div class="container2">      
    <div class="registration form">
      <header>Add Jobs</header>
      <form:form action="insertjob" modelAttribute="Job" method="post" enctype="multipart/form-data">
          <label for="jobtitle">Job Title</label>
          <form:input id="full-name" path="title" placeholder="Enter Job Title" />

          <label for="job-description">Job Description</label>
          <form:input id="email" path="description" placeholder="Enter your Job Decription" />

          <label for="salary">Salary</label>
          <form:input type="number" step="0.01" path="salary" id="password"  placeholder="Enter the salary" />
                   
          <label for="company">Company Name</label>
          <form:input id="full-name" path="company" placeholder="Enter Company Name" />
         
          <form:input id="email" path="rec_email" value="${email}"  type="hidden" required="required"/>
         
          
          <label for="location">Company Location</label>
          <form:input id="full-name" path="location" placeholder="Enter Company Location" />
        <br/>
        <br/>
        <form:form action="insertjob" modelAttribute="Job" method="post" >
               <label for="image">Image (JPEG only)</label>
               <input type="file" id="image" name="image" accept=".jpg, .jpeg" />
               <input type="submit" class="button" value="AddJob">
         </form:form>
          
      </form:form>
    </div>
  </div>
</body>
</html>
