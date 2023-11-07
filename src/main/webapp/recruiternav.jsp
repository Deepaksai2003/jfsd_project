<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>navbar</title>
    <link rel='stylesheet' type='text/css' media='screen' href='../css/nav.css'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+D15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    <style>
   .nav-logo{
      position: absolute;
      left:10px;
      top:2px;
      border-radius:50%;
      width:4%;
      height:8%;
      background:url('displayrecruiterimage?email=${email}');
      background-size:cover;
   }
</style>
</head>
<body>
 <div class="nav-logo" >
   </div>
    <nav class="navbar navbar-expand-lg ">
        <div class="container">
          <a class="navbar-brand" href="/">ONLINE JOB PORTAL</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link"href="addjob">Add Jobs</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="recruiterresponsespage">Responses</a>
              </li>
               <li class="nav-item">
                <a class="nav-link" href="deletejobspage">Delete Jobs</a>
              </li>
            </ul>
            <form class="d-flex" >
                  <button type="button" class="btn0" style="margin-right: 10px;" onclick="window.location.href='logout'">Logout</button>
            </form>
      
          </div>
        </div>
      </nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
