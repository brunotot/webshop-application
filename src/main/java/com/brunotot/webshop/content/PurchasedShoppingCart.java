package com.brunotot.webshop.content;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.brunotot.webshop.util.Constants;
import com.brunotot.webshop.util.Helper;

/**
 * Shopping cart of purchased items class.
 * 
 * @author Bruno
 *
 */
public class PurchasedShoppingCart {
	
	/**
	 * List of purchased items.
	 */
	private List<PurchasedShoppingCartItem> purchasedItemsList;
	
	/**
	 * Static method that returns an instance of PurchasedShoppingCart
	 * based on username and current servlet request.
	 * 
	 * @param username Client's username
	 * @param request Servlet request
	 * @return Instance of PurchasedShoppingCart
	 */
	public static PurchasedShoppingCart getInstance(String username, HttpServletRequest request) {
		PurchasedShoppingCart purchasedShoppingCart = new PurchasedShoppingCart();
		List<PurchasedShoppingCartItem> list = new ArrayList<PurchasedShoppingCartItem>();
		String preparedQuery = "select * from `" + Constants.TABLE_PURCHASED + "` where username='" + Helper.getEscapedQueryVariable(username) + "';";
		ResultSet rs = null;
		try {
			rs = Helper.executePreparedQuery(((DataSource) Helper.getBeanFromRequest(request, "getDataSource")).getConnection(), preparedQuery);
			while (rs.next()) {
				int id = rs.getInt("id");
				int count = rs.getInt("count");
				Date date = rs.getDate("date");
				String name = rs.getString("name");
				String imageUrl = rs.getString("image");
				int price = rs.getInt("price");
				PurchasedShoppingCartItem purchasedShoppingCartItem = new PurchasedShoppingCartItem(id, count, date, name, imageUrl, price);
				list.add(purchasedShoppingCartItem);
			}
			purchasedShoppingCart.setPurchasedItemsList(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return purchasedShoppingCart;
	}

	/**
	 * Getter method for purchased items list.
	 * 
	 * @return Purchased items list
	 */
	public List<PurchasedShoppingCartItem> getPurchasedItemsList() {
		return purchasedItemsList;
	}

	/**
	 * Setter method for purchased items list.
	 * 
	 * @param purchasedItemsList Purchased items list object to set
	 */
	public void setPurchasedItemsList(List<PurchasedShoppingCartItem> purchasedItemsList) {
		this.purchasedItemsList = purchasedItemsList;
	}

}
