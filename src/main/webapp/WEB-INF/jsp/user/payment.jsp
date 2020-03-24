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
<title>Shopping cart</title>

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

<!-- PAYPAL -->
<script src="https://www.paypal.com/sdk/js?client-id=sb"></script>

</head>
<body>
	<div class="main-container">
		<header><jsp:include page="<%= Helper.getHeaderPath(request) %>" /></header>
		
		<div class="main-wrapper">
			<div class="page-wrapper container">
				<div class="page-content">
					<script
		    			src="https://www.paypal.com/sdk/js?client-id=AZ96z4mNPJF0N3o-O-L7JcOCRpigZg1YcT5OAmXGjjhjpgsCe-Z1PQyDSanPJQTw27cvADijxClyhHrIJ_V">
		  			</script>
					<div id="paypal-button-container"></div>
		
		  			<script>
					  paypal.Buttons({
					    createOrder: function(data, actions) {
					      // This function sets up the details of the transaction, including the amount and line item details.
					      return actions.order.create({
					        purchase_units: [{
					          amount: {
					            value: '0.01'
					          }
					        }]
					      });
					    },
					    onApprove: function(data, actions) {
					      // This function captures the funds from the transaction.
					      return actions.order.capture().then(function(details) {
					        // This function shows a transaction success message to your buyer.
					        alert('Transaction completed by ' + details.payer.name.given_name);
					      });
					    }
					  }).render('#paypal-button-container');
					  //This function displays Smart Payment Buttons on your web page.
					</script>
				</div>
			</div>
		</div>
		
		<footer><jsp:include page="<%= Helper.getFooterPath(request) %>" /></footer>
	</div>
</body>
</html>