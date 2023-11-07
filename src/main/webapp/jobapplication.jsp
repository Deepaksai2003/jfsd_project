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
  <link rel="stylesheet" href="css/jobapplication.css">
 <%@ include file="jobseekernav.jsp" %>

</head>
<body>
  
  <center><font style="color:red;">${msg}</font></center>

  <div class="container2">      
    <div class="registration form">
      <header>Apply Jobs</header>
      <form:form action="insertjobapplication" modelAttribute="JobApplication" method="post" enctype="multipart/form-data">
         
            <form:input  id="email" path="applicantName" type="hidden" value="${obj.fullname}"  required="required"/>
          
             <form:input id="email" path="email"  type="hidden"  value="${obj.email}" required="required"/>
             <label for="coverletter">CoverLetter</label>
             <form:input id="email" path="coverLetter"  placeholder="Enter your CoverLetter" required="required"/>
                       
             <form:input id="email" path="job_id" value="${job_id}"  type="hidden" required="required"/>
             
            <form:form action="insertjobapplication" modelAttribute="JobApplication" method="post" >
               <label for="image">Resume</label>
               <input type="file" id="image" name="file" required="required" />
               <input type="submit" class="button" value="Apply">
            </form:form>          
      </form:form>
    </div>
  </div>
</body>
</html>
