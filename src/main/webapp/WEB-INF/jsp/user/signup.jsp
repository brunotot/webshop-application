<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay"
	crossorigin="anonymous">
<title>Registration</title>

<!-- CSS STYLING -->
<style>
.login-block {
	width: 320px;
	padding: 20px;
	background: #fff;
	border-radius: 5px;
	border-top: 5px solid rgb(0, 67, 122);
	margin: 0 auto;
}

.login-block h1 {
	text-align: center;
	color: black;
	font-size: 18px;
	text-transform: uppercase;
	margin-top: 0;
	margin-bottom: 20px;
}

.login-block input {
	width: 100%;
	height: 42px;
	box-sizing: border-box;
	border-radius: 5px;
	border: 1px solid #ccc;
	margin-bottom: 20px;
	font-size: 14px;
	font-family: Montserrat;
	padding: 0 20px 0 50px;
	outline: none;
}

.login-block input#username {
	background: #fff url('http://i.imgur.com/u0XmBmv.png') 20px top
		no-repeat;
	background-size: 16px 80px;
}

.login-block input#username:focus {
	background: #fff url('http://i.imgur.com/u0XmBmv.png') 20px bottom
		no-repeat;
	background-size: 16px 80px;
}

.login-block input#password, input#confirmPassword {
	background: #fff url('http://i.imgur.com/Qf83FTt.png') 20px top
		no-repeat;
	background-size: 16px 80px;
}

.login-block input#password:focus, input#confirmPassword:focus {
	background: #fff url('http://i.imgur.com/Qf83FTt.png') 20px bottom
		no-repeat;
	background-size: 16px 80px;
}

.login-block input:active, .login-block input:focus {
	border: 1px solid #ff656c;
}

.login-block button {
	width: 100%;
	height: 40px;
	background: rgb(0, 67, 122);
	box-sizing: border-box;
	border-radius: 5px;
	border: 1px solid lightblue;
	color: #fff;
	font-weight: bold;
	text-transform: uppercase;
	font-size: 14px;
	font-family: Montserrat;
	outline: none;
	cursor: pointer;
}

.login-block button:hover {
	background: rgb(55, 118, 237);
}

input[type=checkbox] {
	transform: scale(0.42);
	vertical-align: middle;
}
</style>
<!-- CSS STYLING -->

</head>
<body>
	<header><jsp:include page="../static/a-header.jsp" /></header>
	<spring:url value="/user/register" var="registerURL" />

	<div style="margin-top: 100px; margin-bottom: 85px" class="login-block">
		<h1>Register</h1>
		<form:form action="${registerURL}" modelAttribute="userForm"
			method="post">
			<form:input path="username" type="text" placeholder="Username"
				id="username" required="true" />
			<form:errors path="username" />
			<form:input path="password" type="password" placeholder="Password"
				id="password" required="true" />
			<form:errors path="password" />
			<form:input path="confirmPassword" type="password"
				placeholder="Confirm password" id="confirmPassword" required="true" />
			<form:errors path="confirmPassword" />
			<button style="margin-top: 10px" type="submit">GO</button>
		</form:form>
	</div>

	<footer><jsp:include page="../static/footer.jsp" /></footer>
</body>
</html>