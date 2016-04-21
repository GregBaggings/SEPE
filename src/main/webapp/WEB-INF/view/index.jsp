<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	<c:url value="/images/ford_focus.png" var="ford" />
	<c:url value="/images/service.jpg" var="service" />
	<div id="pc-left">
		<img src="${ford}" alt="Ford" style="width: 350px; height: 300px;">
	</div>
	<div id="pc-right">
		<img src="${service}" alt="Service"
			style="width: 450px; height: 330px;">
	</div>
	<p id="news_table" align="justify">News:</p>
	<!--  news table with design -->
	<div id="news_table" class="tg-wrap" align="center" table-layout="fixed">
		<c:forEach var="article" items="${news_list}">
			<table class="tg">
				<tr>
					<th class="tg-news-date" colspan="2"><c:out
							value="${article.date}" /></th>
				</tr>
				<tr>
					<td class="tg-news-title" colspan="2"><c:out
							value="${article.title}" /></td>
				</tr>
				<tr>
					<td class="tg-news-content" colspan="2"><c:out
							value="${article.content}" /></td>
				</tr>
			</table>
		</c:forEach>
	</div>

	<!-- Footer -->
	<div id="footer">
		<p>Copyright 2016 &copy; Gergely Agnecz</p>
		<p>Contact us at agnegerg@gmail.com</p>
	</div>

</body>
</html>