<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url value="/css/base.css" var="cssURL" />
<link rel="stylesheet" href="${cssURL}">
<title>Catalog Search</title>
</head>
<body>
<!-- Menu -->
 <ul class=topnav>
  <li><a href=/CW/>Home Page</a></li>
  <li><a href=/CW/search>Search</a></li>
  <li><a href=/CW/contact>Contact us</a></li>
  <ul class="topnav right">
    <li><a href=/CW/login>Login</a></li>
  </ul>
</ul> 
	<h2>Please enter your search keyword</h2>
	<form:form method="POST" action="/CW/searchResult">
		<table>
			<tr>
				<td><form:label path="searchKey">Search for:</form:label></td>
				<td><form:input path="searchKey" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	
		<!-- Footer -->
	<div id="footer">
		<p>Copyright 2016 &copy; Gergely Agnecz</p>
		<p>Contact us at agnegerg@gmail.com</p>
	</div>
</body>
</html>