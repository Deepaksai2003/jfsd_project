<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Person Login Form</title>
    <link rel="stylesheet" type="text/css" href="login.css">
</head>
<body onload="getCaptcha()">
  <header>

  </header>
  <main>
    <table>
      <tr>
        <td style="width:100px">User Type</td>
        <td>
          <select id="userType" name="userType"> <!-- Use name attribute for form submission -->
            <option value="students">Student</option>
            <option value="company">Company</option>
            <option value="admin">Admin</option>
            <option value="university">University</option>
          </select>
        </td>
      </tr>
      <tr>
        <td>Name</td>
        <td> <input type="text" id="T1" name="username" /> </td> <!-- Use name attribute for form submission -->
      </tr>
      <tr>
        <td>Password</td>
        <td> <input type="password" id="T2" name="password" /> </td> <!-- Use name attribute for form submission -->
      </tr>
      <tr>
        <td></td>
      </tr>
    </table>

    <!-- CAPTCHA HTML -->
    <img id="captchaImage" src="" alt="Captcha" />
    <br>
    <input type="text" id="captchaInput" name="captcha" placeholder="Enter CAPTCHA" /> <!-- Use name attribute for form submission -->
    <br>
    <button onclick="validateCaptcha()">Login</button>
    <br>
    <p>If you are a new user, click <a href="registration.html">here</a> to register.</p>
    <p id="validationResult"></p>

  </main>

  <!-- JSP scriptlets for JavaScript -->
  <%
    String contextPath = request.getContextPath();
  %>
  <script type="text/javascript">
    function getCaptcha() {
      var url = "<%= contextPath %>/captcha/getcaptcha/6";
      callApi("GET", url, "", loadCaptcha);
    }

    // Rest of your JavaScript code...
  </script>

  <!-- Include your JavaScript functions here or link to an external JavaScript file -->

</body>
</html>
