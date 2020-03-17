<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.brunotot.webshop.content.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay"
	crossorigin="anonymous">

<!-- CSS STYLING -->
<style>
.page-content {
	padding-top: 20px;
	padding-bottom: 20px;
}

.item-wrapper{
    width:60%; /* Change this depending on the resolution */
    border: 1px solid red;
} 
    
img{
    width:100%;
}

p {
    width: 100%; 
    text-align: center;
}

#submitBtn {
    margin-left: auto;
    margin-right: auto;
    display: block;
}

</style>
<!-- CSS STYLING -->

</head>
<body background="https://moj.tvz.hr/slika/back.png">
	<header><jsp:include page="../static/a-header.jsp"/></header>
	
	<div class="page-wrapper container">
		<div class="page-content">
			<%= HtmlLaptops.getSingleLaptopDiv(HtmlLaptops.getTestLaptop()) %>
			<%= HtmlLaptops.getSingleLaptopDiv(HtmlLaptops.getTestLaptop()) %>
			<%= HtmlLaptops.getSingleLaptopDiv(HtmlLaptops.getTestLaptop()) %>
			<%= HtmlLaptops.getSingleLaptopDiv(HtmlLaptops.getTestLaptop()) %>
		</div>
	</div>
	
	<!--ref='<c:url value="/user/list" />'>Users List</a>-->
	<footer><jsp:include page="../static/footer.jsp"/></footer>
</body>
</html>