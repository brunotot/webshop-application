<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.brunotot.webshop.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Access denied</title>
<link rel="stylesheet" type="text/css" href="resources/css/main.css">
<link rel="stylesheet" type="text/css" href="resources/css/header-style.css">
<link rel="stylesheet" type="text/css" href="resources/css/footer-style.css">
</head>
<body>
	<header><jsp:include page="<%= Helper.getHeaderPath(request) %>" /></header>
	
	<div class="page-wrapper container">
		<div class="page-content">
			<h1>Access denied!</h1>
		</div>
	</div>
	
	<footer><jsp:include page="<%= Helper.getFooterPath(request) %>" /></footer>
</body>
</html>