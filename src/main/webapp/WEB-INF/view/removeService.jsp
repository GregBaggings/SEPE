<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url value="/css/base.css" var="cssURL" />
<link rel="stylesheet" href="${cssURL}">
<title>Remove Product</title>
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
	<h2>Please enter the car details:</h2>
	<form:form method="POST" action="/CW/admin/list_items_after_delete_service">
		<table>
			<tr>
				<td><form:label path="serviceId">serviceId</form:label></td>
				<td><form:input path="serviceId" /></td>
			</tr>
			<tr>
				<td colspan="2"><input id="removeService" type="submit" value="Delete" /></td>
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