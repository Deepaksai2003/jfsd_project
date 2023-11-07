<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Responses</title>
<%@ include file="jobseekernav.jsp" %>
</head>
<body>
<center>
<div class="card" style="width: 20rem;">   
  <div class="card-body">
    <img class="card-img-top" src="displayjobimage?id=${list.id}" alt="Card image cap">
    <h5 class="card-title">${list.title}</h5>
    <p class="card-text">${list.description}</p>
    <h5>Please Check Your MailBox For Communication</h5>
    </div>
    </div>
    </center>
</body>
</html>