<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url value="/css/base.css" var="cssURL" />
<link rel="stylesheet" href="${cssURL}">
<title>Add new Car to the database</title>
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
	<h2>Please enter the Car details:</h2>
	<form:form method="POST" action="/CW/admin/list_items">
		<table>
			<tr>
				<td><form:label path="name">name</form:label></td>
				<td><input id="name" name="name" type="text" required></td>
			</tr>
			<tr>
				<td><form:label path="age">age</form:label></td>
				<td><input id="age" name="age" type="number" required></td>
			</tr>
			<tr>
				<td><form:label path="price">price</form:label></td>
				<td><input id="price" name="price" type="number" required></td>
			</tr>
			<tr>
				<td colspan="2"><input id="addCar" type="submit" value="Add Item" /></td>
			</tr>
		</table>
	</form:form>

	<c:url value="/logout" var="logoutUrl" />

	<!-- csrt for log out-->
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