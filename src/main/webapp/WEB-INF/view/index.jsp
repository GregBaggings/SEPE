<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
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
	<sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
		url="${initParam['dbWebaddress']}" user="${initParam['dbUser']}"
		password="${initParam['dbPassword']}" />

	<sql:query var="news" dataSource="${myDS}">
        SELECT * FROM NEWS ORDER BY DATE DESC LIMIT 5;
    </sql:query>

	<!--  new table with design -->
	<div class="tg-wrap" align="center" table-layout="fixed">
		<c:forEach var="article" items="${news.rows}">
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