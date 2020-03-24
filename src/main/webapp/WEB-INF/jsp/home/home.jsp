<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.brunotot.webshop.content.*" %>
<%@ page import="com.brunotot.webshop.util.*" %>

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
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_ITEMS_STYLE %>">
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_MAIN %>">
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_HEADER_STYLE %>">
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_FOOTER_STYLE %>">
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_BUTTON_STYLE %>">
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_FILTER_TABLE_STYLE %>">

<!-- JQUERY -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- JS -->
<script src="<%= Constants.PATH_SRC + Constants.PATH_JS + Constants.JS_ACTIONS %>"></script>
<script src="<%= Constants.PATH_SRC + Constants.PATH_JS + Constants.JS_FILTER_TABLE %>"></script>

<%
	String category = (String) request.getAttribute("category");
	int cheapestPrice = Helper.getLowestFromCategory(request, category, "price");
	int mostExpensivePrice = Helper.getHighestFromCategory(request, category, "price");

	int lowestRam = Helper.getLowestFromCategory(request, category, "ram");
	int highestRam = Helper.getHighestFromCategory(request, category, "ram");

	int valueLowest = (int) (Math.log(lowestRam) / Math.log(2));
	int valueHighest = (int) (Math.log(highestRam) / Math.log(2));
	
%>

<style>
	
	#left-col {
		width: 50%;
		text-align: right; 
		padding-right: 8px;
	}
	
	#right-col {
		padding: 0; 
		width: 50%;
	}
	
	#filter-title {
		text-align: center;
	}

	.submit-div {
		width: 100%;
	}

</style>

</head>
<body>
	<div class="main-container">
		<header><jsp:include page="<%= Helper.getHeaderPath(request) %>" /></header>
		
		<div class="main-wrapper">
			<div class="page-wrapper container">
				<div class="page-content">
				
					<div class="filter">
					<table id="cart-table" class="shoppingcart-table">
						<thead>
							<tr>
								<th colspan="2" id="filter-title">Filter items</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td id="left-col">Price:</td>
								<td id="right-col-slider">
									<section class="range-slider">
									  <span class="rangeValues1"></span><span style="top: 7px; position: relative;">&nbsp; &euro;</span>
									  <input value="<%= cheapestPrice %>" min="<%= cheapestPrice %>" max="<%= mostExpensivePrice %>" step="1" type="range">
									  <input value="<%= mostExpensivePrice %>" min="<%= cheapestPrice %>" max="<%= mostExpensivePrice %>" step="1" type="range">
									  <span style="top: 7px; position: relative; float: right;">&euro;</span><span class="rangeValues2"></span>
									</section>
								</td>
							</tr>
							
							<tr>
								<tr>
								<td id="left-col">Memory (RAM):</td>
								<td id="right-col-slider">
									<section class="range-slider">
									  <span class="rangeValues1"></span><span style="top: 7px; position: relative;">&nbsp;GB</span>
									  <input value="<%= valueLowest %>" min="<%= valueLowest %>" max="<%= valueHighest %>" step="1" type="range" name="ram">
									  <input value="<%= valueHighest %>" min="<%= valueLowest %>" max="<%= valueHighest %>" step="1" type="range" name="ram">
									  <span style="top: 7px; position: relative; float: right;">GB</span><span class="rangeValues2"></span>
									</section>
								</td>
							</tr>
							</tr>
							
							<tr>
								<td colspan="2"><div class="submit-div"><button id="btn-filter" class="my-button">FILTER</button></div></td>
							</tr>
						</tbody>
					</table>
					</div>
				
					<div class="items">
				    	<%= HtmlHelper.getAllItemsFromCategory(category, request) %>    
				    </div>
				</div>
			</div>
		</div>
		<footer><jsp:include page="<%= Helper.getFooterPath(request) %>" /></footer>
	</div>
</body>
</html>