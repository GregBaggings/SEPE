<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
<c:url value="/css/base.css" var="cssURL" />
<link rel="stylesheet" href="${cssURL}">
</head>
<body onload='document.loginForm.username.focus();'>
	<!-- Menu -->
	<ul class=topnav>
		<li><a href=/CW />Home Page</a></li>
		<li><a href=/CW/search>Search</a></li>
		<li><a href=/CW/contact>Contact us</a></li>
		<ul class="topnav right">
			<li><a href=/CW/login>Login</a></li>
		</ul>
	</ul>
	<h1>Staff Login Site</h1>

	<div id="login-box">

		<h2>Enter your credentials:</h2>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm'
			action="<c:url value='j_spring_security_check' />" method='POST'>

			<table>
				<tr>
					<td>User Name:</td>
					<td><input type='text' name='username' value=''></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td colspan='2'><p id="submission"><input name="submit" type="submit"
						value="Login" /></p></td>
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>

	</div>
	<!-- Footer -->
	<div id="footer">
		<p>Copyright 2016 &copy; Gergely Agnecz</p>
		<p>Contact us at agnegerg@gmail.com</p>
	</div>

</body>
</html>