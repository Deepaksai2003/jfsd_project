<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Responses</title>
<%@include file="recruiternav.jsp" %>
</head>
<body>
<center>
  <c:forEach items="${list}" var="lst">
    <div class="card" style="width: 20rem;">   
  <div class="card-body">
    <img class="card-img-top" src="displayprodimage?email=${lst.email}" alt="Card image cap">
    <h5 class="card-title">${lst.applicantName}</h5>
    <p class="card-text">${lst.coverLetter}</p>
    <p class="card-text">${lst.email}</p>
    <a href="acceptjob?email=${lst.email}&job_id=${lst.job_id}"  class="btn btn-success" >Accept</a>
    <br/>
    <br/>
    <a href="downloadpdf?id=${lst.applicationId}">Download</a>
  </div>
</div>
  </c:forEach>
  </center>
</body>
</html>