<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
 
<html> 
<head> 
 
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  <%@include file="adminnav.jsp" %>
</head> 
<body> 
<br> 
 
<h3 align="center"><u>View All Recruiters</u></h3> 
 
<table align=center  border=2 class="table table-striped">  
<tr bgcolor="black" style="color:white"> 
<td scope="col">NAME</td> 
<td scope="col">EMAIL ID</td> 
<td scope="col">STATUS</td>
<td scope="col">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ACTION</td>

</tr> 
 
<c:forEach items="${recdata}"  var="rec"> 
<tr> 
<td scope="row"><c:out value="${rec.fullname}" /></td> 
<td scope="row"><c:out value="${rec.email}" /></td> 



<c:if test="${rec.isactive==true}">
<td bgcolor="green">ACTIVE</td>
</c:if>
<c:if test="${rec.isactive==false}">
<td bgcolor="red">INACTIVE</td>
</c:if>

<td>
<a href="recruiteractionactive?email=${rec.email}" class="btn btn-success">ACTIVE</a>
<a href="recruiteractioninactive?email=${rec.email}" class="btn btn-danger">INACTIVE</a>
</td>
</tr> 
</c:forEach> 
 
</table> 
 
</body> 
</html>