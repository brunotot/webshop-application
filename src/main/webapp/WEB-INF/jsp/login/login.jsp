<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.brunotot.webshop.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay"crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="resources/css/login-style.css">
<link rel="stylesheet" type="text/css" href="resources/css/main.css">
<link rel="stylesheet" type="text/css" href="resources/css/header-style.css">
<link rel="stylesheet" type="text/css" href="resources/css/footer-style.css">
<link rel="stylesheet" type="text/css" href="resources/css/button-style.css">
</head>
<body>
	<header><jsp:include page="<%= Helper.getHeaderPath(request) %>" /></header>

	<div class="login-block">
		<h1>Login</h1>
		<form name="loginForm" action='<c:url value="j_spring_security_check" />' method="post">
			<input type="text" name="username" placeholder="Username" id="username" required /> 
			<input type="password" name="password" placeholder="Password" id="password" required />
			<table id="remember-me-table">
				<tr>
					<td id="remember-me-text">Remember me:</td>
					<td id="remember-me-checkbox"><input id="remember-me" type="checkbox" name="remember-me" /></td>
				</tr>
			</table>
			<button id="submit" type="submit">GO</button>
		</form>
	</div>
	
	<footer><jsp:include page="<%= Helper.getFooterPath(request) %>" /></footer>
</body>
</html>