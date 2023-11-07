<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Job Seeker</title>
    <style>
        .nav-logo {
            position: absolute;
            left: 10px;
            top: 2px;
            border-radius: 50%;
            width: 4%;
            height: 8%;
            background: url('displayprodimage?email=${email}');
            background-size: cover;
        }
    </style>
</head>
<%@ include file="jobseekernav.jsp" %>
<body>
    <div class="nav-logo"></div>

<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Enter Job Title">
    <div class="container">
        <div class="row">
            <div class="col-6">
            </div>
            <div class="col-6 text-right">
                <a class="btn btn-primary mb-3 mr-1" href="#carouselExampleIndicators2" role="button" data-slide="prev">
                    <i class="fa fa-arrow-left"></i>
                </a>
                <a class="btn btn-primary mb-3 " href="#carouselExampleIndicators2" role="button" data-slide="next">
                    <i class="fa fa-arrow-right"></i>
                </a>
            </div>
        </div>

        <div class="col-12">
            <div id="carouselExampleIndicators2" class="carousel slide" data-ride="carousel" id="myTable">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <div class="row">
                            <c:forEach items="${joblist}" var="jobs">
                                <div class="col-md-4 mb-3">
                                    <div class="card">
                                        <img class="img-fluid" alt="100%x280" src="displayjobimage?id=${jobs.id}">
                                        <div class="card-body">
                                            <h4 class="card-title">${jobs.title}</h4>
                                            <p class="card-text">${jobs.description}</p>
                                            <a href="jobapplicationform?job_id=${jobs.id}" class="btn btn-primary">Apply Now</a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script>
function myFunction() {
  var input, filter, card, title, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  card = document.querySelectorAll(".card");

  for (i = 0; i < card.length; i++) {
    title = card[i].querySelector(".card-title");
    if (title) {
      txtValue = title.textContent || title.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        card[i].style.display = "";
      } else {
        card[i].style.display = "none";
      }
    }
  }
}
</script>
</html>
