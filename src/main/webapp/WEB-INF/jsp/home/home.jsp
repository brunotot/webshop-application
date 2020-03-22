<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.brunotot.webshop.content.*" %>
<%@ page import="com.brunotot.webshop.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="<%= Constants.SRC_PATH + Constants.CSS_PATH %>items-style.css">
<link rel="stylesheet" type="text/css" href="<%= Constants.SRC_PATH + Constants.CSS_PATH %>main.css">
<link rel="stylesheet" type="text/css" href="<%= Constants.SRC_PATH + Constants.CSS_PATH %>header-style.css">
<link rel="stylesheet" type="text/css" href="resources/css/footer-style.css">
<link rel="stylesheet" type="text/css" href="resources/css/button-style.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
	function addItem(id, category) {
		
		function call_ajax() {
			return $.ajax({
		        type: 'POST',
		        url: 'instock',
		        data: {
		            id: id,
		            category: category,
		            wantedamount: 1,
		            start: 'home'
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
			            quantity: 1,
			            start: 'home'
			        },
			        success: function () {
			            location.reload();
			        }
			    });
			} else {
				alert("We no longer have this item in stock!");
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
</script>
</head>
<body>
	<header><jsp:include page="<%= Helper.getHeaderPath(request) %>" /></header>
	
	<div class="page-wrapper container">
		<div class="page-content">
			<div class="items">
		    	<%= HtmlHelper.getInstance().test("laptops", request) %>    
		    </div>
		</div>
	</div>
	
	<footer><jsp:include page="<%= Helper.getFooterPath(request) %>" /></footer>
</body>
</html>