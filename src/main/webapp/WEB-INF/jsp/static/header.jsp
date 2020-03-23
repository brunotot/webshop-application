<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.springframework.web.util.*" %>
<%@ page import="org.springframework.util.*" %>

<%
	Cookie cookie = WebUtils.getCookie(request, "cart");
	int itemsCounter = 0;
	if (cookie != null) {
		itemsCounter = StringUtils.countOccurrencesOf(cookie.getValue(), "~");
	}
%>

<div class="header-wrapper center-children">
	<div class="header-content container">
		<div class="user-container">
			<span id="items-counter-desktop">(<%= itemsCounter %>)</span>
			<i onclick="location.href='<c:url value="/shoppingcart"/>'" id="shopping-cart" class="fas fa-shopping-cart my-button"></i>
			<div class="dropdown">
				<i id="user" class="far fa-user dropbtn"> 
					<span id="my-account-span" class="noselect"> 
						<c:out value="${pageContext.request.userPrincipal.name}" escapeXml="false" />
					</span>
				</i>
				<div class="dropdown-content">
					<a id="dropdown-shoppingcart" href='<c:url value="/shoppingcart"/>'>Shopping cart <span id="items-counter-mobile">(<%= itemsCounter %>)</span></a>
					<a href='<c:url value="/user/settings"/>'>Settings</a> 
					<a href='<c:url value="/logout"/>'>Logout</a>
				</div>
			</div>
		</div>
	</div>
</div>
