<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.brunotot.webshop.util.*" %>
<%@ page import="com.brunotot.webshop.content.*" %>
<%@ page import="com.brunotot.webshop.merchandise.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- META CONFIG -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- TITLE -->
<title><%= Constants.TITLE_ADMIN_ADDITEM %></title>

<!-- BOOTSTRAP -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<!-- FONT AWESOME -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">

<!-- FAVICON -->
<link rel='icon' href='<%= Constants.FAVICON_URL %>' type='image/x-icon' />

<!-- CSS STYLING -->
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_MAIN %>">
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_HEADER_STYLE %>">
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_FOOTER_STYLE %>">
<link rel="stylesheet" type="text/css" href="<%= Constants.PATH_SRC + Constants.PATH_CSS + Constants.CSS_BUTTON_STYLE %>">

<% 
	String success = (String) request.getAttribute("success"); 
	request.setAttribute("laptopitem", new Laptop()); 
	request.setAttribute("desktopitem", new Desktop()); 
	request.setAttribute("phoneitem", new Phone());
%>

<script type="text/javascript">

	function validateForm() {
		var flag = false;
		var inputs = document.getElementsByClassName("inputClass");
		for (var i = 0; i < inputs.length; i++) {
			var inputElement = inputs[i];
			var type = inputElement.type;
			var value = inputElement.value;
			var placeholder = inputElement.placeholder;
			if (type === "text" && value !== "") {
				if (placeholder === "float" || placeholder === "int") {
					if (isNaN(value)) {
						inputElement.style.boxShadow = "inset 0 0 8px red";
						flag = true;
						continue;
					}
					if (placeholder === "int") {
						function isNumeric(value) {
						    return /^-{0,1}\d+$/.test(value);
						}
						if (!isNumeric(value)) {
							inputElement.style.boxShadow = "inset 0 0 8px red";
							flag = true;
							continue;
						}
					}
				}
			}
			inputElement.style.boxShadow = "none";
		}
		if (flag === true) {
			alert("Error! Check inputs.");
			return false;
		}
	}
	
	window.onload = function() {
		<% if (success != null) { %>
			<% if (success.equals("true")) { %>	
				alert("You have successfully inserted an item into database!");
			<% } else if (success.equals("false")) { %>
				alert("An error happened while inserting an item into database!");
			<% } %>
		<% } %>
			
	    var categorySelect = document.getElementById("categorySelect");
	    categorySelect.onchange = function() {
	    	var elemSubmitButton = document.getElementById("submit-btn");
	    	elemSubmitButton.style.display = 'inherit';
	        var elemTable = document.getElementById("add-item-table");
	        var elemFormClass = document.getElementsByClassName("formClass");
	        var elemForm = elemFormClass[0];
	        if (categorySelect.selectedIndex === 1) {
	        	elemTable.innerHTML = "<%= HtmlHelper.getAddItemTableForm(Constants.BEAN_INFO_COLUMN_VALUES_LAPTOP, request, "laptops") %>";
	        	elemForm.action = 'addlaptop';
	        	elemForm.id = 'laptopitem';
	        } else if (categorySelect.selectedIndex === 2) {
	        	elemTable.innerHTML = "<%= HtmlHelper.getAddItemTableForm(Constants.BEAN_INFO_COLUMN_VALUES_DESKTOP, request, "desktops") %>";
	        	elemForm.action = 'adddesktop';
	        	elemForm.id = 'desktopitem';
	        } else {
	        	elemTable.innerHTML = "<%= HtmlHelper.getAddItemTableForm(Constants.BEAN_INFO_COLUMN_VALUES_PHONE, request, "phones") %>";
	        	elemForm.action = 'addphone';
	        	elemForm.id = 'phoneitem';
	        }
	    }
	}
	
</script>

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
					
					<div style="text-align: center;">
				        <select id="categorySelect">
				            <option selected disabled>Choose item category</option>
				            <option id="laptop">Laptop</option>
				            <option id="desktop">Desktop</option>
				            <option id="phone">Phone</option>
				        </select>
				
						<br></br>
				
				        <form:form class="formClass" action="additem" modelAttribute="item" onsubmit="return validateForm()" method="post">
				        	<table style="margin: 0 auto;" id="add-item-table">
								<!-- Populates on change of category select -->
							</table><br>
							<button id="submit-btn" type="submit" style="display: none; margin: 0 auto;">SUBMIT</button>
				        </form:form>
				    </div>
				</div>
			</div>
		</div>
		
		<footer><jsp:include page="<%= Helper.getFooterPath(request) %>" /></footer>
	</div>
</body>
</html>