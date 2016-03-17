<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url value="/css/base.css" var="cssURL" />
<link rel="stylesheet" href="${cssURL}">
<title>Minerva Car Store - Contact Us</title>
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
	<h3>We are available at:</h3>
	<div id="contacts">
		<h5>E-mail:</h5>
		<p>
			shop@cw.com <br> sales@cw.com
		<p>
		<h5>Phone:</h5>
		<p>+48 123931700
		<h5>Address:</h5>
		<p>Starway to Heaven street 17. 1235, Wonderland</p>
		<h2>In any needs or questions don't hesitate to contact us on the
			following link:</h2>
		<p>
			<a href="mailto:sales@minerva.com?Subject=Inquiry about: <item_to_name>"
				target="_top">E-mail to sales</a>
		</p>

	</div>

	<!-- Footer -->
	<div id="footer">
		<p>Copyright 2016 &copy; Gergely Agnecz</p>
		<p>Contact us at agnegerg@gmail.com</p>
	</div>
</body>
</html>