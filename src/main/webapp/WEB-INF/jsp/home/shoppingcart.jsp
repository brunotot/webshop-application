<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.brunotot.webshop.util.*" %>
<%@ page import="com.brunotot.webshop.content.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Shopping cart</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="resources/css/main.css">
<link rel="stylesheet" type="text/css" href="resources/css/header-style.css">
<link rel="stylesheet" type="text/css" href="resources/css/footer-style.css">
<link rel="stylesheet" type="text/css" href="resources/css/button-style.css">
<link rel="stylesheet" type="text/css" href="resources/css/shoppingcart-table-style.css">

</head>
<body>
	<header><jsp:include page="<%= Helper.getHeaderPath(request) %>" /></header>
	
	<div class="page-wrapper container">
		<div class="page-content">
			<table class="shoppingcart-table">
				<thead>
					<tr>
						<th></th>
						<th>Item</th>
						<th>Qty</th>
						<th></th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
				
				<form action="/shoppolis/shoppingcart" method="post">
				
					<input id="color" type="color" name="color" value="${color}"/>
					<label>Current selected: ${color}</label>

					<button type="submit">SUBMIT</button>

				</form>
									
				</tbody>
			</table>
			
			
			
			
			
			<div style="width: 100%; text-align: right; margin-top: 18px;">
				<div style="float: left;">
					<button type="button" class="my-button" onclick="location.href='/shoppolis/'"><div style="padding: 4px;">BACK <i class="fas fa-arrow-left"></i></div></button>
					<button type="button" class="my-button"><div style="padding: 4px;">CLEAR <i class="fas fa-shopping-cart"></i></div></button>
					
				</div>
				<div>
					<button type="button" class="my-button"><div style="height: 100%; padding: 4px;">PAYMENT <i class="far fa-money-bill-alt"></i></div></button>
				</div>
			</div>
		</div>
	</div>
	
	<footer><jsp:include page="<%= Helper.getFooterPath(request) %>" /></footer>
</body>
</html>