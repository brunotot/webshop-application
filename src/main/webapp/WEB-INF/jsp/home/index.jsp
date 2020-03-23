<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.brunotot.webshop.content.*"%>
<%@ page import="com.brunotot.webshop.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- META CONFIG -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- PAGE TITLE -->
<title><%= Constants.TITLE_HOME %></title>

<!-- BOOTSTRAP -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<!-- FONT AWESOME -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">

<!-- CSS STYLING -->
<link rel="stylesheet" type="text/css" href="<%=Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_ITEMS_STYLE%>">
<link rel="stylesheet" type="text/css" href="<%=Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_MAIN%>">
<link rel="stylesheet" type="text/css" href="<%=Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_HEADER_STYLE%>">
<link rel="stylesheet" type="text/css" href="<%=Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_FOOTER_STYLE%>">
<link rel="stylesheet" type="text/css" href="<%=Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_BUTTON_STYLE%>">

</head>
<body>
	<header><jsp:include page="<%=Helper.getHeaderPath(request)%>" /></header>

	<div class="page-wrapper container">
		<div class="page-content">
			<p>Pick a category:</p>
			<ul>
				<li><a href='<c:url value="/category"><c:param name="category" value="laptops"/></c:url>'>Laptops</a></li>
				<li><a href='<c:url value="/category"><c:param name="category" value="phones"/></c:url>'>Phones</a></li>
				<li><a href='<c:url value="/category"><c:param name="category" value="desktops"/></c:url>'>Desktops</a></li>
			</ul>
		</div>
	</div>

	<footer><jsp:include page="<%=Helper.getFooterPath(request)%>" /></footer>
</body>
</html>