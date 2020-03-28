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
	
	private int id;
	
	private String name;
	
	private String manufacturer;	
	
	private String gpu;
	
	private String gpuName;
	
	private String cpu;	
	
	private String cpuName;	
	
	private int cpuCores;
	
	private int ram;
	
	private int hdd;
	
	private String imageUrl;
	
	private int price;
	
	private int maxInStock;
	
	private String category = "phones";
	
	public Phone() {
		
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getCategory() {
		return category;
	}
	
	public int getMaxInStock() {
		return maxInStock;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setMaxInStock(int maxInStock) {
		this.maxInStock = maxInStock;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public String getGpu() {
		return gpu;
	}
	
	public String getGpuName() {
		return gpuName;
	}
	
	public String getCpu() {
		return cpu;
	}
	
	public String getCpuName() {
		return cpuName;
	}
	
	public int getCpuCores() {
		return cpuCores;
	}
	
	public int getRam() {
		return ram;
	}
	
	public int getHdd() {
		return hdd;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public void setGpu(String gpu) {
		this.gpu = gpu;
	}
	
	public void setGpuName(String gpuName) {
		this.gpuName = gpuName;
	}
	
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	
	public void setCpuName(String cpuName) {
		this.cpuName = cpuName;
	}
	
	public void setCpuCores(int cpuCores) {
		this.cpuCores = cpuCores;
	}
	
	public void setRam(int ram) {
		this.ram = ram;
	}
	
	public void setHdd(int hdd) {
		this.hdd = hdd;
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

}
