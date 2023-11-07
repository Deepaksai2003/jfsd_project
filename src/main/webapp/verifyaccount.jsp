<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/verifyaccount.css">
<title>verify account</title>
</head>
<body>
<%@ include file="nav.jsp" %>
<center>
<div class="container4">
<form action="emailverify" method="post">
<input type="text" value="${email}" name="email" hidden="true"><br/>
<button type="submit">Verify</button>
</form>
</div>
</center>
</body>
</html>
