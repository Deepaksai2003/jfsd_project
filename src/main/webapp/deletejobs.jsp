<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete</title>
<%@include file="recruiternav.jsp"%>
</head>
<body>
<table align=center  border=2 class="table table-striped">  
<tr bgcolor="black" style="color:white"> 
<td scope="col">Title</td> 
<td scope="col">description</td> 
<td scope="col">salary</td>
<td scope="col">location</td>
<td scope="col">company</td>
<td scope="col">delete</td>

</tr>
 <c:forEach items="${jsdata}"  var="rec">
 <td scope="row">${rec.title}</td> 
<td scope="row">${rec.description}</td> 
<td scope="row">${rec.salary}</td> 
<td scope="row">${rec.location}</td> 
<td scope="row">${rec.company}</td> 

<td scope="row">
<a href='<c:url value="deletejob?id=${rec.id}"></c:url>' class="btn btn-primary">Delete</a>
</td>

 </c:forEach>
 </table>
</body>
</html>