<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<c:url value="/css/base.css" var="cssURL" />
<link rel="stylesheet" href="${cssURL}">
<title>Admin Page</title>
</head>
<body>
	<!-- Menu -->
	<ul class=topnav>
		<li><a href=/CW />Home Page</a></li>
		<li><a href=/CW/search>Search</a></li>
		<li><a href=/CW/contact>Contact us</a></li>
		<ul class="topnav right">
			<li><a href="/CW/admin">Admin</a></li>
			<li><a href="javascript:formSubmit()">Logout</a></li>
		</ul>
	</ul>

	<h1>Please choose about the following features:</h1>
	<li><a href=/CW/admin/addCar>Add Product</a></li>
	<li><a href=/CW/admin/removeCar>Remove Product</a></li>
	<li><a href="/CW/admin/list">List of the database</a></li>
	<li><a href="/CW/admin/addNews">Add news to the Home Page</a></li>
	<li><a href="/CW/admin/removeNews">Remove News from the Home Page</a></li>

	<!-- Logout stuff -->
	<c:url value="/logout" var="logoutUrl" />

	<!-- csrt for log out -->
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<!-- Footer -->
	<div id="footer">
		<p>Copyright 2016 &copy; Gergely Agnecz</p>
		<p>Contact us at agnegerg@gmail.com</p>
	</div>

</body>
</html>