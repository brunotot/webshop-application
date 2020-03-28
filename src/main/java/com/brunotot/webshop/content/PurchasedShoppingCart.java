package com.brunotot.webshop.content;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.brunotot.webshop.util.Constants;
import com.brunotot.webshop.util.Helper;


public class PurchasedShoppingCart {
	
	private List<PurchasedShoppingCartItem> purchasedItemsList;
	
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

	public List<PurchasedShoppingCartItem> getPurchasedItemsList() {
		return purchasedItemsList;
	}

	public void setPurchasedItemsList(List<PurchasedShoppingCartItem> purchasedItemsList) {
		this.purchasedItemsList = purchasedItemsList;
	}

}
