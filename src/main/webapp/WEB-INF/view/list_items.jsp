<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of the Databases</title>
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
			<li><a href="/CW/admin">Admin</a></li>
			<li><a href="javascript:formSubmit()">Logout</a></li>
		</ul>
	</ul>

	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Content of the list of cars table:</h2>
			</caption>
			<tr>
				<th>Car ID</th>
				<th>Name</th>
				<th>Age</th>
				<th>Price</th>
			</tr>
			<c:forEach var="car" items="${list_cars}">
				<tr>
					<td><c:out value="${car.carId}" /></td>
					<td><c:out value="${car.name}" /></td>
					<td><c:out value="${car.age}" /></td>
					<td><c:out value="${car.price}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Content of the list of services table:</h2>
			</caption>
			<tr>
				<th>Service ID</th>
				<th>Name</th>
				<th>Is on Stock?</th>
				<th>Price</th>
			</tr>
		<c:forEach var="service" items="${list_services}">
				<tr>
					<td><c:out value="${service.serviceId}" /></td>
					<td><c:out value="${service.name}" /></td>
					<td><c:out value="${service.onStock}" /></td>
					<td><c:out value="${service.price}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
		<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Content of the list of news table:</h2>
			</caption>
			<tr>
				<th>news ID</th>
				<th>Title</th>
				<th>Content</th>
				<th>Date</th>
			</tr>
		<c:forEach var="news" items="${list_news}">
				<tr>
					<td><c:out value="${news.newsId}" /></td>
					<td><c:out value="${news.date}" /></td>
					<td><c:out value="${news.title}" /></td>
					<td><c:out value="${news.content}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>

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
</body>
</html>