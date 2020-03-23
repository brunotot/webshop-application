function addItem(id, category) {
	var lastIndexOfSlash = window.location.href.lastIndexOf("/");
	var length = window.location.href.length;
	var servletPath = window.location.href.substring(lastIndexOfSlash, length);
	
	var start;
	var unavailableMsg;
	var wantedAmount;
	
	if (servletPath.localeCompare("/shoppingcart") === 0) {
		wantedAmount = parseInt(document.getElementById("quantity" + id).value);
		start = "shoppingcart";
		unavailableMsg = "We don't have that many!";
	} else {
		wantedAmount = 1;
		start = "home";
		unavailableMsg = "We no longer have this item in stock!";
	}
	
	if (wantedAmount === 0) {
		removeItem(id, category);
		return;
	}
	
	function isInStock() {
		return $.ajax({
	        type: 'POST',
	        url: 'instock',
	        data: {
	            id: id,
	            category: category,
	            wantedamount: wantedAmount,
	            start: start
	        }
	    });
	}
	
	$.when(isInStock()).done(function(response) {
		if (response) {
			$.ajax({
		        type: 'POST',
		        url: 'additem',
		        data: {
		            id: id,
		            category: category,
		            quantity: wantedAmount,
		            start: start
		        },
		        success: function () {
		            location.reload();
		        }
		    });
		} else {
			alert(unavailableMsg);
		}
	});
	
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