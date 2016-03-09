<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Minerva Car Store</title>

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

	<!-- Header -->
	<div id="header">
		<h1>Minerva's car store - The best deals anywhere</h1>
	</div>

	<!-- News and other content -->
	<p>News:</p>



	<!-- Favourites section -->
	<div id=favourites>
		<p>Most favorite offers:</p>
		<table border="1" style="width: 50%">
			<tr>
				<th>Cars</th>
				<th>Parts</th>
			</tr>
			<tr>
				<td>Example - Audi</td>
				<td>Example3</td>
			</tr>
			<tr>
				<td>Example - BMW</td>
				<td>Example3</td>
			</tr>
			<tr>
				<td>Example - SEAT</td>
				<td>Example3</td>
			</tr>
		</table>
	</div>

	<!-- Footer -->
	<div id="footer">
		<p>Copyright 2016 &copy; Gergely Agnecz</p>
		<p>Contact us at agnegerg@gmail.com</p>
	</div>

</body>
</html>