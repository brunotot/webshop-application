<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.brunotot.webshop.util.*" %>
<%@ page import="com.brunotot.webshop.content.*" %>
<%@ page import="org.springframework.web.util.*" %>
<%@ page import="org.springframework.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Shopping cart</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="http://192.168.1.5:8080/shoppolis/resources/css/main.css">
<link rel="stylesheet" type="text/css" href="http://192.168.1.5:8080/shoppolis/resources/css/header-style.css">
<link rel="stylesheet" type="text/css" href="http://192.168.1.5:8080/shoppolis/resources/css/footer-style.css">
<link rel="stylesheet" type="text/css" href="http://192.168.1.5:8080/shoppolis/resources/css/button-style.css">
<link rel="stylesheet" type="text/css" href="http://192.168.1.5:8080/shoppolis/resources/css/shoppingcart-table-style.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>

	.shoppingcart-btns {
		width: 100%; 
		text-align: right;
		margin-top: 18px;
	}
	
	.shoppingcart-btns>*:nth-child(1) {
		float: left;
	}

	#back-btn {
		padding: 4px;
	}

	#clear-btn {
		padding: 4px;
	}
	
	a {
		display: inline-block;
	}
</style>

<script>
	
	function updateItem(id, category) {
		var quantityId = 'quantity' + id;
		var quantityValue = document.getElementById(quantityId).value;
		
		if (quantityValue == 0) {
			removeItem(id, category);
			return;
		}
		
		function call_ajax() {
			return $.ajax({
		        type: 'POST',
		        url: 'instock',
		        data: {
		            id: id,
		            category: category,
		            wantedamount: quantityValue,
		            start: 'shoppingcart'
		        }
		    });
		}
		
		$.when( call_ajax() ).done(function(response) {
			if (response) {
				$.ajax({
			        type: 'POST',
			        url: 'additem',
			        data: {
			            id: id,
			            category: category,
			            quantity: quantityValue,
			            start: 'shoppingcart'
			        },
			        success: function () {
			            location.reload();
			        }
			    });
			} else {
				alert("We don't have that many!");
			}
		});
	}
	
	function setTimeForCookies (days) {
		var now = new Date();
		var time = now.getTime();
	 
		time += days * 60 * 24 * 60 * 1000;
		now.setTime(time);
		return now;
	}
	
	function getCookie(cname) {
		var name = cname + "=";
		var decodedCookie = decodeURIComponent(document.cookie);
		var ca = decodedCookie.split(';');
		for(var i = 0; i <ca.length; i++) {
			var c = ca[i];
			while (c.charAt(0) == ' ') {
				c = c.substring(1);
			}
			if (c.indexOf(name) == 0) {
				return c.substring(name.length, c.length);
			}
		}
		return "";
	}
	
	function removeItem(id, category) {
		$.ajax({
	        type: 'POST',
	        url: 'removeitem',
	        data: {
	            id: id,
	            category: category
	        },
	        success: function () {
	            location.reload();
	        }
	    });
	}
	
	$(function() {
		var total = 0;
		var table = document.getElementById("cart-table");
		var length = table.rows.length - 1;
		for (var i = 1; i < length; i++) {
			total += parseInt(table.rows[i].cells[4].innerHTML);
		}
		document.getElementById("total-value").textContent = total;

		if (length == 1) {
			table.style.display = 'none';
			document.getElementById("empty-cart-msg").textContent = 'Your shopping cart is empty!';
			document.getElementById("payment-btn").disabled = true;
		} else {
			document.getElementById("empty-cart-msg").style.display = 'none';
			document.getElementById("payment-btn").disabled = false;
		}
	});
</script>

</head>
<body>
	<header><jsp:include page="<%= Helper.getHeaderPath(request) %>" /></header>
	
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
					<%= HtmlHelper.test2(request) %>
					<tr>
						<td></td>
						<td colspan="3" style="text-align: right">TOTAL: </td>
						<td style="text-align: center; padding: 5px;"><span id="total-value"></span><span>&euro;</span></td>
					</tr>
				</tbody>
			</table>
			
			
			
			<div class="shoppingcart-btns" id="cart-btns">
				<div>
					<button type="button" class="my-button" onclick="location.href='/shoppolis/'"><div id="back-btn">BACK <i class="fas fa-arrow-left"></i></div></button>
					<a href='<c:url value="/shoppingcart/clearall"/>' id="clearall"><button type="button" class="my-button"><div id="clear-btn">CLEAR <i class="fas fa-shopping-cart"></i></div></button></a>
				</div>
				<div>
					<button type="button" id="payment-btn" class="my-button"><div style="height: 100%; padding: 4px;">PAYMENT <i class="far fa-money-bill-alt"></i></div></button>
				</div>
			</div>
		</div>
	</div>
	
	<footer><jsp:include page="<%= Helper.getFooterPath(request) %>" /></footer>
</body>
</html>