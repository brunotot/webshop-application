<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="header-wrapper center-children">
	<div class="header-content container">
		<div class="user-container">
			<i onclick="location.href='<c:url value="/shoppingcart"/>'" id="shopping-cart" class="fas fa-shopping-cart"></i>
			<div class="dropdown">
				<i id="user" class="far fa-user dropbtn">
					<span id="my-account-span" class="noselect"> Anonymous</span>
				</i>
				<div class="dropdown-content">
					<a id="dropdown-shoppingcart" href='<c:url value="/shoppingcart"/>'>Shopping cart</a> 
					<a href='<c:url value="/login"/>'>Login</a> 
					<a href='<c:url value="/user/signup"/>'>Register</a>
				</div>
			</div>
		</div>
	</div>
</div>