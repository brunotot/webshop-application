<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.brunotot.webshop.util.*" %>
<%@ page import="com.brunotot.webshop.content.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- META CONFIG -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- TITLE -->
<title><%= Constants.TITLE_ADMIN_USERS %></title>

<!-- BOOTSTRAP -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<!-- FONT AWESOME -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">

<!-- FAVICON -->
<link rel='icon' href='<%= Constants.FAVICON_URL %>' type='image/x-icon'/ >

<!-- CSS STYLING -->
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_MAIN %>">
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_HEADER_STYLE %>">
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_FOOTER_STYLE %>">
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_BUTTON_STYLE %>">

</head>
<body>
	<div class="main-container">
		<header><jsp:include page="../static/header.jsp"/></header>
		
		<div class="main-wrapper">
			<div class="page-wrapper container">
				<div class="page-content">
					<button type="button" class="my-button" onclick="location.href='/shoppolis/'" style="padding:6px 20px; margin-bottom: 14px;">
						HOMEPAGE <i class="fas fa-arrow-left"></i>
					</button>
					
					<div style="text-align: center;">
				        <select id="categorySelect">
				            <option selected="true" disabled>Choose item category</option>
				            <option id="laptop">Laptop</option>
				            <option id="desktop">Desktop</option>
				            <option id="phone">Phone</option>
				        </select>
				
						<br></br>
				
				        <form style="text-align: center;" action="additem" method="post">
				        	<table style="margin: 0 auto;" id="add-item-table">

							</table>
							
							</br>
							
							<button id="submit-btn" type="submit" style="display: none; margin: 0 auto;">SUBMIT</button>
				        </form>
				    </div>
				
				    <script type="text/javascript">
				        window.onload = function() {
				            var categorySelect = document.getElementById("categorySelect");
				
				            categorySelect.onchange = function() {
				            	var elemSubmitButton = document.getElementById("submit-btn");
				            	elemSubmitButton.style.display = 'inherit';
				                var elemTable = document.getElementById("add-item-table");
				                if (categorySelect.selectedIndex === 1) {
				                	elemTable.innerHTML = "<%= HtmlHelper.getAddItemTableForm(Constants.BEAN_INFO_COLUMN_VALUES_LAPTOP, request, "laptops") %>";
				                } else if (categorySelect.selectedIndex === 2) {
				                	elemTable.innerHTML = "<%= HtmlHelper.getAddItemTableForm(Constants.BEAN_INFO_COLUMN_VALUES_DESKTOP, request, "desktops") %>";
				                } else {
				                	elemTable.innerHTML = "<%= HtmlHelper.getAddItemTableForm(Constants.BEAN_INFO_COLUMN_VALUES_PHONE, request, "phones") %>";
				                }
				            }
				        }
				    </script>
				</div>
			</div>
		</div>
		
		<footer><jsp:include page="<%= Helper.getFooterPath(request) %>" /></footer>
	</div>
</body>
</html>