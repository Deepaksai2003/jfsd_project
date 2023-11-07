<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
 
<html> 
<head>
<%@ include file="adminnav.jsp" %> 
</head> 
<body> 
<br>  
<h3 align="center"><u>View All JobSeekers</u></h3> 
 
<table align=center  border=2 class="table table-striped">  
<tr bgcolor="black" style="color:white"> 
<td scope="col">NAME</td> 
<td scope="col">EMAIL ID</td> 
<td scope="col">GENDER</td>
<td scope="col">Delete</td>
<td scope="col">Update</td>

</tr> 
 
<c:forEach items="${jsdata}"  var="rec"> 
<tr> 
<td scope="row"><c:out value="${rec.fullname}" /></td> 
<td scope="row"><c:out value="${rec.email}" /></td> 
<td scope="row"><c:out value="${rec.gender}" /></td> 

<td scope="row">
<a href='<c:url value="deletejobseeker?email=${rec.email}"></c:url>' class="btn btn-primary">Delete</a>
</td>
<td scope="row" >
<a href='<c:url value="updatejobseekerpage?email=${rec.email}"></c:url>'class="btn btn-primary">Update</a>
</td>


</c:forEach> 
 
</table> 
 
</body> 
</html>