<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
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
}
</style>
<!-- CSS STYLING -->
	
</head>
<body background="https://moj.tvz.hr/slika/back.png">
	<header><jsp:include page="../static/header.jsp"/></header>
	
	<div class="page-wrapper container">
		<div class="page-content">
			<p>Welcome <c:out value="${pageContext.request.userPrincipal.name}"/></p>
		</div>
	</div>
	
	<!--<a href='<c:url value="/user/list" />'>Users List</a>-->
	<footer><jsp:include page="../static/footer.jsp"/></footer>
</body>
</html>