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
<title>Item</title>

<!-- BOOTSTRAP -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<!-- FONT AWESOME -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">

<!-- CSS STYLING -->
<link rel="stylesheet" type="text/css" href="<%=Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_MAIN%>">
<link rel="stylesheet" type="text/css" href="<%=Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_HEADER_STYLE%>">
<link rel="stylesheet" type="text/css" href="<%=Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_FOOTER_STYLE%>">
<link rel="stylesheet" type="text/css" href="<%=Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_BUTTON_STYLE%>">

<%
	String id = (String) request.getAttribute("id");
%>

</head>
<body>
	<div class="main-container">
		<header><jsp:include page="<%=Helper.getHeaderPath(request)%>" /></header>
		
		
		<div class="main-wrapper">
			<div class="page-wrapper container">
				<button type="button" class="my-button" onclick="location.href='/shoppolis/'" style="padding:6px 20px;">
					BACK <i class="fas fa-arrow-left"></i>
				</button>
				
				<table style="width: 100%; border: 1px solid black">
					<%= HtmlHelper.getItemInfo(id, request) %>
				</table>
				
			</div>
		</div>
		
		<footer><jsp:include page="<%=Helper.getFooterPath(request)%>" /></footer>
	</div>
</body>
</html>