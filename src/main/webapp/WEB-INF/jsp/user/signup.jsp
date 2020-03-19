<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="../resources/css/signup-style.css">
<link rel="stylesheet" type="text/css" href="../resources/css/a-header-style.css">
<link rel="stylesheet" type="text/css" href="../resources/css/main.css">
<link rel="stylesheet" type="text/css" href="../resources/css/footer-style.css">
</head>
<body>
	<header><jsp:include page="../static/a-header.jsp" /></header>
	<spring:url value="/user/register" var="registerURL" />

	<div class="signup-block">
		<h1>Register</h1>
		<form:form action="${registerURL}" modelAttribute="userForm" method="post">
			<form:input path="username" type="text" placeholder="Username" id="username" required="true" />
			<form:errors path="username" />
			<form:input path="password" type="password" placeholder="Password" id="password" required="true" />
			<form:errors path="password" />
			<form:input path="confirmPassword" type="password" placeholder="Confirm password" id="confirmPassword" required="true" />
			<form:errors path="confirmPassword" />
			<button id="submit" type="submit">GO</button>
		</form:form>
	</div>

	<footer><jsp:include page="../static/footer.jsp" /></footer>
</body>
</html>