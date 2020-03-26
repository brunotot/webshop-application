<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.brunotot.webshop.util.*" %>
<%@ page import="com.brunotot.webshop.content.*" %>
<%@ page import="org.springframework.web.util.*" %>
<%@ page import="org.springframework.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- META CONFIG -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- TITLE -->
<title><%= Constants.TITLE_SHOPPING_CART %></title>

<!-- BOOTSTRAP -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<!-- FONT AWESOME -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">

<!-- CSS STYLING -->
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_MAIN %>">
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_HEADER_STYLE %>">
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_FOOTER_STYLE %>">
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_BUTTON_STYLE %>">
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_SHOPPINGCART_BTNS %>">
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_SHOPPINGCART_TABLE_STYLE %>">

<!-- JQUERY -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- JS -->
<script src="<%= Constants.PATH_SRC + Constants.PATH_JS + Constants.JS_ACTIONS %>"></script>
<script src="<%= Constants.PATH_SRC + Constants.PATH_JS + Constants.JS_SHOPPINGCART %>"></script>

</head>
<body>
	<div class="main-container">
		<header><jsp:include page="<%= Helper.getHeaderPath(request) %>" /></header>
		
		<div class="main-wrapper">
			<div class="page-wrapper container">
				<div class="page-content">
					<p id="empty-cart-msg"></p>
					<table id="cart-table" class="shoppingcart-table">
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
							<%= HtmlHelper.getAllShoppingCartItems(request) %>
							
							<tr>
								<td></td>
								<td colspan="3" id="total-col">TOTAL: </td>
								<td id="total-value-col"><span id="total-value"></span><span>&euro;</span></td>
							</tr>
						</tbody>
					</table>
					
					
					
					<div class="shoppingcart-btns" id="cart-btns">
						<div>
							<button type="button" class="my-button" onclick="location.href='/shoppolis/'">
								<div id="back-btn">BACK <i class="fas fa-arrow-left"></i></div>
							</button>
							<a href='<c:url value="/shoppingcart/clearall"/>' id="clearall">
								<button type="button" class="my-button">
									<div id="clear-btn">CLEAR <i class="fas fa-shopping-cart"></i></div>
								</button>
							</a>
						</div>

						<div>
							<a onclick="payment()">
								<button type="button" id="payment-btn" class="my-button">
									<div id="payment-div">PAYMENT <i class="far fa-money-bill-alt"></i></div>
								</button>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<footer><jsp:include page="<%= Helper.getFooterPath(request) %>" /></footer>
	</div>
</body>
</html>