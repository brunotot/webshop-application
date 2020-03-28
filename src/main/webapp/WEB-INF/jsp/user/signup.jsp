<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.brunotot.webshop.util.*" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- META CONFIG -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- TITLE -->
<title><%= Constants.TITLE_REGISTRATION %></title>

<!-- BOOTSTRAP -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<!-- FONT AWESOME -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">

<!-- FAVICON -->
<link rel='icon' href='<%= Constants.FAVICON_URL %>' type='image/x-icon'/ >

<!-- CSS STYLING -->
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_MAIN %>">
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_SIGNUP_STYLE %>">
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_HEADER_STYLE %>">
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_FOOTER_STYLE %>">
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_BUTTON_STYLE %>">

</head>
<body>
	<div class="main-container">
		<header><jsp:include page="<%= Helper.getHeaderPath(request) %>" /></header>
		<spring:url value="/user/register" var="registerURL" />
	
		<div class="main-wrapper">
			<div class="signup-block">
				<h1>Register</h1>
				<form:form action="${registerURL}" modelAttribute="userForm" method="post">
					<form:input path="username" type="text" placeholder="Username" id="username" required="true" />
					<form:errors path="username" />
					<form:input path="password" type="password" placeholder="Password" id="password" required="true" />
					<form:errors path="password" />
					<form:input path="confirmPassword" type="password" placeholder="Confirm password" id="confirmPassword" required="true" />
					<form:errors path="confirmPassword" />
					<button id="submit" class="my-button" type="submit">GO <i class="fas fa-arrow-right"></i></button>
				</form:form>
				<button type="button" class="my-button" onclick="location.href='/shoppolis/'"><div id="back-btn">HOMEPAGE <i class="fas fa-arrow-left"></i></div></button>
			</div>
		</div>
	
		<footer><jsp:include page="<%= Helper.getFooterPath(request) %>" /></footer>
	</div>
</body>
</html>