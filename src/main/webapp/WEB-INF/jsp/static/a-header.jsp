<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay"
	crossorigin="anonymous">


<!-- CSS STYLING -->
<style>
* {
	font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
		'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

.header-wrapper {
	background: rgb(200, 232, 238);
	height: 45px;
}

.center-children {
	display: flex;
	justify-content: center;
	align-items: center;
}

#user {
	font-size: 17px;
	cursor: pointer;
	padding: 2px;
}

#user:active {
	color: rgb(0, 67, 122);
}

.header-content {
	display: flex;
	justify-content: flex-end;
	align-items: center;
	width: 100%;
	height: 30px;
}

@media ( max-width :629px) {
	#my-account-span {
		display: none;
	}
	.header-content {
		justify-content: center;
	}
	.dropdown-content {
		left: -70px;
	}
	.dropdown-content a {
		text-align: center;
		align-items: center;
	}
	.dropdown:hover #user {
		text-shadow: 1px 1px 3px rgb(0, 67, 122);
	}
}

.noselect {
	-webkit-touch-callout: none;
	-webkit-user-select: none;
	-khtml-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
	position: relative;
	display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {
	background-color: #ddd;
	text-decoration: none;
}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
	display: block;
}

/* Change the background color of the dropdown button when the dropdown content is shown */
.dropdown:hover #my-account-span {
	text-shadow: 1px 1px 3px rgb(0, 67, 122);
}
</style>
<!-- CSS STYLING -->

</head>
<body>
	<div class="header-wrapper center-children">
		<div class="header-content container">
			<div class="user-container">
				<div class="dropdown">
					<i id="user" class="far fa-user dropbtn">
						<span id="my-account-span" class="noselect"> Anonymous</span>
					</i>
					<div class="dropdown-content">
						<a href='<c:url value="/login"/>'>Login</a> 
						<a href='<c:url value="/user/signup"/>'>Register</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>