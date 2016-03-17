<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
<c:url value="/css/base.css" var="cssURL" />
<link rel="stylesheet" href="${cssURL}">
</head>
<body>
<!-- Menu -->
 <ul class=topnav>
  <li><a href=/CW/>Home Page</a></li>
  <li><a href=/CW/search>Search</a></li>
  <li><a href=/CW/contact>Contact us</a></li>
  <ul class="topnav right">
    <li><a href=/CW/login>Login</a></li>
  </ul>
</ul> 
	<h2>Submitted Student Information</h2>
	<table>
		<tr>
			<td>Name</td>
			<td>${name}</td>
		</tr>
		<tr>
			<td>Age</td>
			<td>${age}</td>
		</tr>
		<tr>
			<td>ID</td>
			<td>${id}</td>
		</tr>
	</table>

	<!-- Footer -->
	<div id="footer">
		<p>Copyright 2016 &copy; Gergely Agnecz</p>
		<p>Contact us at agnegerg@gmail.com</p>
	</div>
	
</body>
</html>