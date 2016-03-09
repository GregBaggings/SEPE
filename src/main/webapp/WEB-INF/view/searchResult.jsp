<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
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
<!-- 	<h2>Results of your search:</h2> -->
<!-- 	<table> -->
<!-- 		<tr> -->
<!-- 			<td>Name</td> -->
<%-- 			<td>${searchKey}</td> --%>
<!-- 		</tr> -->
<!-- 	</table> -->

	<sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
		url="${initParam['dbWebaddress']}" user="${initParam['dbUser']}"
		password="${initParam['dbPassword']}" />

	<sql:query var="cars" dataSource="${myDS}">
        SELECT * FROM list_of_cars where NAME = '${searchKey}';
    </sql:query>
    
    	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Content of the list of cars table:</h2>
			</caption>
			<tr>
				<th>Car ID</th>
				<th>Name</th>
				<th>Age</th>
				<th>Price in GBP</th>
			</tr>
			<c:forEach var="car" items="${cars.rows}">
				<tr>
					<td><c:out value="${car.car_id}" /></td>
					<td><c:out value="${car.name}" /></td>
					<td><c:out value="${car.age}" /></td>
					<td><c:out value="${car.price}" /></td>
				</tr>
			</c:forEach>
		</table>

	<!-- Footer -->
	<div id="footer">
		<p>Copyright 2016 &copy; Gergely Agnecz</p>
		<p>Contact us at agnegerg@gmail.com</p>
	</div>

</body>
</html>