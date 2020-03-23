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