package com.brunotot.webshop.merchandise;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.brunotot.webshop.content.HtmlHelper;
import com.brunotot.webshop.content.Item;
import com.brunotot.webshop.content.PurchasedShoppingCartItem;
import com.brunotot.webshop.util.Helper;

public class Phone implements Item {
	
	/**
	 * Phone id.
	 */
	private int id;

	/**
	 * Phone name.
	 */
	private String name;

	/**
	 * Phone manufacturer.
	 */
	private String manufacturer;

	/**
	 * Phone graphics card.
	 */
	private String gpu;	

	/**
	 * Phone graphics card name.
	 */
	private String gpuName;

	/**
	 * Phone processor.
	 */
	private String cpu;	

	/**
	 * Phone processor name.
	 */
	private String cpuName;

	/**
	 * Phone processor cores count.
	 */
	private int cpuCores;

	/**
	 * Phone RAM amount.
	 */
	private int ram;

	/**
	 * Phone HDD amount.
	 */
	private int hdd;

	/**
	 * Phone image URL.
	 */
	private String imageUrl;

	/**
	 * Phone price.
	 */
	private int price;
	
	/**
	 * Phone maximum quantity in stock.
	 */
	private int maxInStock;
	
	/**
	 * Item category.
	 */
	private String category = "phones";
	
	/**
	 * Empty constructor for Phone.
	 */
	public Phone() {
		
	}
	
	/**
	 * Getter method for item name.
	 * 
	 * @return Item name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter method for item manufacturer.
	 * 
	 * @return Item manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Getter method for item graphics card.
	 * 
	 * @return Item graphics card
	 */
	public String getGpu() {
		return gpu;
	}

	/**
	 * Getter method for item processor.
	 * 
	 * @return Item processor
	 */
	public String getCpu() {
		return cpu;
	}

	/**
	 * Getter method for item RAM quantity.
	 * 
	 * @return Item RAM quantity
	 */
	public int getRam() {
		return ram;
	}

	/**
	 * Getter method for item HDD quantity.
	 * 
	 * @return Item HDD quantity
	 */
	public int getHdd() {
		return hdd;
	}

	/**
	 * Getter method for item image URL.
	 * 
	 * @return Item image URL
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Getter method for item price.
	 * 
	 * @return Item price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Getter method for item id.
	 * 
	 * @return Item id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Getter method for max item quantity.
	 * 
	 * @return Maximum item quantity in stock
	 */
	public int getMaxInStock() {
		return maxInStock;
	}
	
	/**
	 * Setter method for item name.
	 * 
	 * @param name New item name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Setter method for item manufacturer.
	 * 
	 * @param manufacturer New item manufacturer
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * Setter method for item graphics card.
	 * 
	 * @param gpu New item graphics card
	 */
	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	/**
	 * Setter method for item processor.
	 * 
	 * @param cpu New item processor
	 */
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	/**
	 * Setter method for item RAM quantity.
	 * 
	 * @param ram New item RAM quantity
	 */
	public void setRam(int ram) {
		this.ram = ram;
	}

	/**
	 * Setter method for item HDD quantity.
	 * 
	 * @param hdd New item HDD quantity
	 */
	public void setHdd(int hdd) {
		this.hdd = hdd;
	}

	/**
	 * Setter method for item image URL.
	 * 
	 * @param imageUrl New item image URL
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * Setter method for item price.
	 * 
	 * @param price New item price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Setter method for item id.
	 * 
	 * @param id New item id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter method for item processor name.
	 * 
	 * @return Processor name
	 */
	public String getCpuName() {
		return cpuName;
	}

	/**
	 * Setter method for item processor name.
	 * 
	 * @param cpuName New item processor name
	 */
	public void setCpuName(String cpuName) {
		this.cpuName = cpuName;
	}
	
	/**
	 * Getter method for item processor cores.
	 * 
	 * @return Processor cores
	 */
	public int getCpuCores() {
		return cpuCores;
	}

	/**
	 * Setter method for item processor cores.
	 * 
	 * @param cpuCores New item processor cores
	 */
	public void setCpuCores(int cpuCores) {
		this.cpuCores = cpuCores;
	}
	
	/**
	 * Getter method for item graphics card name.
	 * 
	 * @return String graphics card name
	 */
	public String getGpuName() {
		return gpuName;
	}

	/**
	 * Setter method for item graphics card name.
	 * 
	 * @param gpuName New item graphics card name
	 */
	public void setGpuName(String gpuName) {
		this.gpuName = gpuName;
	}
	
	@Override
	public String getDivElement() {
		return HtmlHelper.getItemDiv(this.getId(), this.getFullName(), this.getPrice(), this.getImageUrl(), this.category);
	}
	
	@Override
	public String getTableRowElement(int count, boolean inPayment) {
		return HtmlHelper.getTableRow(this.getId(), this.getFullName(), this.getPrice(), this.getImageUrl(), count, this.category, this.maxInStock, inPayment, null);
	}
	
	@Override
	public void setAllDataFromResultSet(ResultSet tableRowData) {
		try {
			this.id = tableRowData.getInt("id");
			this.name = tableRowData.getString("name");
			this.manufacturer = tableRowData.getString("manufacturer");
			this.gpu = tableRowData.getString("gpu");
			this.gpuName = tableRowData.getString("gpuName");
			this.cpu = tableRowData.getString("cpu");
			this.ram = tableRowData.getInt("ram");
			this.hdd = tableRowData.getInt("hdd");
			this.imageUrl = tableRowData.getString("image");
			this.price = tableRowData.getInt("price");
			this.cpuName = tableRowData.getString("cpuname");
			this.cpuCores = tableRowData.getInt("cpucores");
			this.maxInStock = tableRowData.getInt("stock");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getFullName() {
		return this.manufacturer + " " +
				   this.name + " " +
				   this.cpu + " " +
				   this.cpuName + " " +
				   Helper.getNumberOfCoresAsWord(this.cpuCores) + "-" + "Core, " +
				   this.gpu + " " + 
				   this.gpuName + " " +
				   this.ram + "GB RAM" + 
				   (this.hdd == 0 ? "" : (", " + this.hdd + "GB HDD"));
	}
	
	@Override
	public String getFilterElements(HttpServletRequest request, String category, Map<String, String[]> filteredMap) {
		String result = "";
		
		int price1 = -1;
		int price2 = -1;
		int ram1 = -1;
		int ram2 = -1;
		if (filteredMap != null) {
			price1 = Integer.parseInt(filteredMap.get("price1")[0]);
			price2 = Integer.parseInt(filteredMap.get("price2")[0]);
			ram1 = Integer.parseInt(filteredMap.get("ram1")[0]);
			ram2 = Integer.parseInt(filteredMap.get("ram2")[0]);
		}
		
		result += HtmlHelper.getSlider(request, category, "price", "&euro;", price1, price2);
		result += HtmlHelper.getSlider(request, category, "ram", "GB", ram1, ram2);
		result += HtmlHelper.getCheckboxRow(request, category, "manufacturer", filteredMap);
		result += HtmlHelper.getCheckboxRow(request, category, "gpu", filteredMap);
		return result;
	}

	@Override
	public String getAllItemInformation(HttpServletRequest request) {
		return HtmlHelper.getAllItemInformation(this.id, request);
	}

	@Override
	public String getTableRowElement(PurchasedShoppingCartItem purchasedShoppingCartItemObject) {
		return HtmlHelper.getTableRow(-1, purchasedShoppingCartItemObject.getName(), purchasedShoppingCartItemObject.getPrice(), purchasedShoppingCartItemObject.getImageUrl(), purchasedShoppingCartItemObject.getCount(), "category", -1, true, purchasedShoppingCartItemObject.getDate());
	}

	@Override
	public void setMaxInStock(int stock) {
		this.maxInStock = stock;
	}

	@Override
	public String getCategory() {
		return this.getCategory();
	}

}
