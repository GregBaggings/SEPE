<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Minerva SRP</title>
<c:url value="/css/base.css" var="cssURL" />
<link rel="stylesheet" href="${cssURL}">
</head>
<body>
	<!-- Menu -->
	<ul class=topnav>
		<li><a href=/CW />Home Page</a></li>
		<li><a href=/CW/search>Search</a></li>
		<li><a href=/CW/contact>Contact us</a></li>
		<ul class="topnav right">
			<li><a href=/CW/login>Login</a></li>
		</ul>
	</ul>

    	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Result of the search:</h2>
			</caption>
			<tr>
				<th>Car ID</th>
				<th>Name</th>
				<th>Age</th>
				<th>Price in GBP</th>
			</tr>
			<c:forEach var="car" items="${list}">
				<tr>
					<td><c:out value="${car.carId}" /></td>
					<td><c:out value="${car.name}" /></td>
					<td><c:out value="${car.age}" /></td>
					<td><c:out value="${car.price}" /></td>
				</tr>
			</c:forEach>
		</table>
		
		<a href=/CW/search>Back to the search</a>

	<!-- Footer -->
	<div id="footer">
		<p>Copyright 2016 &copy; Gergely Agnecz</p>
		<p>Contact us at agnegerg@gmail.com</p>
	</div>

</body>
</html>