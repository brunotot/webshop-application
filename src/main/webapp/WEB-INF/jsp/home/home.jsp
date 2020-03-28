<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.brunotot.webshop.content.*" %>
<%@ page import="com.brunotot.webshop.util.*" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.Map" %>

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
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_FILTER_STYLE %>">

<!-- FAVICON -->
<link rel='icon' href='<%= Constants.FAVICON_URL %>' type='image/x-icon'/ >

<!-- JQUERY -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- JS -->
<script src="<%= Constants.PATH_SRC + Constants.PATH_JS + Constants.JS_ACTIONS %>"></script>
<script src="<%= Constants.PATH_SRC + Constants.PATH_JS + Constants.JS_FILTER_TABLE %>"></script>
<script src="<%= Constants.PATH_SRC + Constants.PATH_JS + Constants.JS_FILTER_CHECKBOXES %>"></script>

<%
	String category = null;
	category = (String) request.getAttribute("category");
	
	ResultSet filteredResultSet = null;
	filteredResultSet = (ResultSet) request.getAttribute("filteredResultSet");
	
	Map<String, String[]> filteredMap = null;
	filteredMap = (Map<String, String[]>) request.getAttribute("filteredMap");
%>

</head>
<body>
	<div class="main-container">
		<header><jsp:include page="<%= Helper.getHeaderPath(request) %>" /></header>
		
		<div class="main-wrapper">
			<div class="page-wrapper container">
				<div class="page-content">
					<button type="button" class="my-button" onclick="location.href='/shoppolis/'" style="padding:6px 20px; margin-bottom: 14px;">
						HOMEPAGE <i class="fas fa-arrow-left"></i>
					</button>
					<form action="filter?category=<%= category %>" method="post">
						<div class="filter">
						<table id="cart-table" class="shoppingcart-table">
							<thead>
								<tr>
									<th colspan="2" id="filter-title">Filter items</th>
								</tr>
							</thead>
							<tbody>
								<%= HtmlHelper.getAllFilterElementsFromCategory(request, category, filteredMap) %>
									
								<tr>
									<td colspan="2"><div class="submit-div"><button type="submit" id="btn-filter" class="my-button">FILTER</button></div></td>
								</tr>
							</tbody>
						</table>
						</div>
					</form>
									
					<div id="items" class="items">
				    	<%= HtmlHelper.getAllItemsFromCategory(category, request, filteredResultSet) %>    
				    </div>
				</div>
			</div>
		</div>
		<footer><jsp:include page="<%= Helper.getFooterPath(request) %>" /></footer>
	</div>
</body>
</html>