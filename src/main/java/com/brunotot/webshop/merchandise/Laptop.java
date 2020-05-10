package com.brunotot.webshop.merchandise;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.brunotot.webshop.content.HtmlHelper;
import com.brunotot.webshop.content.Item;
import com.brunotot.webshop.content.PurchasedShoppingCartItem;
import com.brunotot.webshop.util.Constants;
import com.brunotot.webshop.util.Helper;

public class Laptop implements Item {
	
	private int id;
	private String image;
	private int price;
	private int stock;
	private String name;
	private String brand;
	private String processorBrand;
	private String processorType;
	private int processorCores;
	private String gpuBrand;
	private String gpuType;
	private int ramSize;
	private int hardDrive;
	private int ssd;
	private String promotion;
	private int warranty;
	private String color;
	private float screenSize;
	private String screenType;
	private String displayResolution;
	private String officeIncluded;
	private String operatingSystem;
	private String bundledSoftware;
	private String portsSlotsChassis;
	private String cameraMicrophone;
	private float clockSpeed;
	private float frontSideBus;
	private int maxExpandability;
	private int memorySlots;
	private int driveRotation;
	private String opticalDriveType;
	private String wifi;
	private String dlna;
	private String bluetooth;
	private String hdmi;
	private String usb;
	private String multicardReader;
	private String compatibleMemoryCards;
	private String batteryType;
	private float batteryUpTo;
	private float width;
	private float depth;
	private float height;
	private float weight;
	private String more;
	private String category = "laptops";
	
	public int getStock() {
		return stock;
	}

	public String getName() {
		return name;
	}

	public String getBrand() {
		return brand;
	}

	public String getProcessorBrand() {
		return processorBrand;
	}

	public String getProcessorType() {
		return processorType;
	}

	public int getProcessorCores() {
		return processorCores;
	}

	public String getGpuBrand() {
		return gpuBrand;
	}

	public String getGpuType() {
		return gpuType;
	}

	public int getRamSize() {
		return ramSize;
	}

	public int getHardDrive() {
		return hardDrive;
	}

	public int getSsd() {
		return ssd;
	}

	public String getPromotion() {
		return promotion;
	}

	public int getWarranty() {
		return warranty;
	}

	public String getColor() {
		return color;
	}

	public float getScreenSize() {
		return screenSize;
	}

	public String getScreenType() {
		return screenType;
	}

	public String getDisplayResolution() {
		return displayResolution;
	}

	public String getOfficeIncluded() {
		return officeIncluded;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public String getBundledSoftware() {
		return bundledSoftware;
	}

	public String getPortsSlotsChassis() {
		return portsSlotsChassis;
	}

	public String getCameraMicrophone() {
		return cameraMicrophone;
	}

	public float getClockSpeed() {
		return clockSpeed;
	}

	public float getFrontSideBus() {
		return frontSideBus;
	}

	public int getMaxExpandability() {
		return maxExpandability;
	}

	public int getMemorySlots() {
		return memorySlots;
	}

	public int getDriveRotation() {
		return driveRotation;
	}

	public String getOpticalDriveType() {
		return opticalDriveType;
	}

	public String getWifi() {
		return wifi;
	}

	public String getDlna() {
		return dlna;
	}

	public String getBluetooth() {
		return bluetooth;
	}

	public String getHdmi() {
		return hdmi;
	}

	public String getUsb() {
		return usb;
	}

	public String getMulticardReader() {
		return multicardReader;
	}

	public String getCompatibleMemoryCards() {
		return compatibleMemoryCards;
	}

	public String getBatteryType() {
		return batteryType;
	}

	public float getBatteryUpTo() {
		return batteryUpTo;
	}

	public float getWidth() {
		return width;
	}

	public float getDepth() {
		return depth;
	}

	public float getHeight() {
		return height;
	}

	public float getWeight() {
		return weight;
	}

	public String getMore() {
		return more;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setProcessorBrand(String processorBrand) {
		this.processorBrand = processorBrand;
	}

	public void setProcessorType(String processorType) {
		this.processorType = processorType;
	}

	public void setProcessorCores(int processorCores) {
		this.processorCores = processorCores;
	}

	public void setGpuBrand(String gpuBrand) {
		this.gpuBrand = gpuBrand;
	}

	public void setGpuType(String gpuType) {
		this.gpuType = gpuType;
	}

	public void setRamSize(int ramSize) {
		this.ramSize = ramSize;
	}

	public void setHardDrive(int hardDrive) {
		this.hardDrive = hardDrive;
	}

	public void setSsd(int ssd) {
		this.ssd = ssd;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setScreenSize(float screenSize) {
		this.screenSize = screenSize;
	}

	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}

	public void setDisplayResolution(String displayResolution) {
		this.displayResolution = displayResolution;
	}

	public void setOfficeIncluded(String officeIncluded) {
		this.officeIncluded = officeIncluded;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public void setBundledSoftware(String bundledSoftware) {
		this.bundledSoftware = bundledSoftware;
	}

	public void setPortsSlotsChassis(String portsSlotsChassis) {
		this.portsSlotsChassis = portsSlotsChassis;
	}

	public void setCameraMicrophone(String cameraMicrophone) {
		this.cameraMicrophone = cameraMicrophone;
	}

	public void setClockSpeed(float clockSpeed) {
		this.clockSpeed = clockSpeed;
	}

	public void setFrontSideBus(float frontSideBus) {
		this.frontSideBus = frontSideBus;
	}

	public void setMaxExpandability(int maxExpandability) {
		this.maxExpandability = maxExpandability;
	}

	public void setMemorySlots(int memorySlots) {
		this.memorySlots = memorySlots;
	}

	public void setDriveRotation(int driveRotation) {
		this.driveRotation = driveRotation;
	}

	public void setOpticalDriveType(String opticalDriveType) {
		this.opticalDriveType = opticalDriveType;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public void setDlna(String dlna) {
		this.dlna = dlna;
	}

	public void setBluetooth(String bluetooth) {
		this.bluetooth = bluetooth;
	}

	public void setHdmi(String hdmi) {
		this.hdmi = hdmi;
	}

	public void setUsb(String usb) {
		this.usb = usb;
	}

	public void setMulticardReader(String multicardReader) {
		this.multicardReader = multicardReader;
	}

	public void setCompatibleMemoryCards(String compatibleMemoryCards) {
		this.compatibleMemoryCards = compatibleMemoryCards;
	}

	public void setBatteryType(String batteryType) {
		this.batteryType = batteryType;
	}

	public void setBatteryUpTo(float batteryUpTo) {
		this.batteryUpTo = batteryUpTo;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public void setDepth(float depth) {
		this.depth = depth;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public void setMore(String more) {
		this.more = more;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String getDivElement() {
		return HtmlHelper.getItemDiv(this.id, this.getFullName(), this.price, this.image, this.category);
	}
	
	@Override
	public String getTableRowElement(int count, boolean inPayment) {
		return HtmlHelper.getTableRow(this.id, this.getFullName(), this.price, this.image, count, this.category, this.stock, inPayment, null);
	}
	
	@Override
	public String getCategory() {
		return this.category;
	}
	
	@Override
	public void setAllDataFromResultSet(ResultSet tableRowData) {
		try {
			this.id = tableRowData.getInt("id");
			this.image = tableRowData.getString("image");
			this.price = tableRowData.getInt("price");
			this.stock = tableRowData.getInt("stock");
			this.name = tableRowData.getString("name");
			this.brand = tableRowData.getString("brand");
			this.processorBrand = tableRowData.getString("processorBrand");
			this.processorType = tableRowData.getString("processorType");
			this.processorCores = tableRowData.getInt("processorCores");
			this.gpuBrand = tableRowData.getString("gpuBrand");
			this.gpuType = tableRowData.getString("gpuType");
			this.ramSize = tableRowData.getInt("ramSize");
			this.hardDrive = tableRowData.getInt("hardDrive");
			this.ssd = tableRowData.getInt("ssd");
			this.promotion = tableRowData.getString("promotion");
			this.warranty = tableRowData.getInt("warranty");
			this.color = tableRowData.getString("color");
			this.screenSize = tableRowData.getFloat("screenSize");
			this.displayResolution = tableRowData.getString("displayResolution");
			this.officeIncluded = tableRowData.getString("officeIncluded");
			this.operatingSystem = tableRowData.getString("operatingSystem");
			this.bundledSoftware = tableRowData.getString("bundledSoftware");
			this.portsSlotsChassis = tableRowData.getString("portsSlotsChassis");
			this.cameraMicrophone = tableRowData.getString("cameraMicrophone");
			this.clockSpeed = tableRowData.getFloat("clockSpeed");
			this.frontSideBus = tableRowData.getFloat("frontSideBus");
			this.maxExpandability = tableRowData.getInt("maxExpandability");
			this.memorySlots = tableRowData.getInt("memorySlots");
			this.driveRotation = tableRowData.getInt("driveRotation");
			this.opticalDriveType = tableRowData.getString("opticalDriveType");
			this.wifi = tableRowData.getString("wifi");
			this.dlna = tableRowData.getString("dlna");
			this.bluetooth = tableRowData.getString("bluetooth");
			this.hdmi = tableRowData.getString("hdmi");
			this.usb = tableRowData.getString("usb");
			this.multicardReader = tableRowData.getString("multicardReader");
			this.compatibleMemoryCards = tableRowData.getString("compatibleMemoryCards");
			this.batteryType = tableRowData.getString("batteryType");
			this.batteryUpTo = tableRowData.getFloat("batteryUpTo");
			this.width = tableRowData.getFloat("width");
			this.depth = tableRowData.getFloat("depth");
			this.height = tableRowData.getFloat("height");
			this.weight = tableRowData.getFloat("weight");
			this.more = tableRowData.getString("more");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getFullName() {
		return this.brand + " " +
			   this.name + " " +
			   this.processorBrand + " " +
			   this.processorType + " " +
			   this.processorCores + "-" + "Core, " +
			   this.gpuBrand + " " + gpuType + " " +
			   this.ramSize + "GB RAM" + 
			   (this.ssd == 0 ? "" : (", " + this.ssd + "GB SSD")) + 
			   (this.hardDrive == 0 ? "" : (", " + this.hardDrive + "GB HDD"));
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
			ram1 = Integer.parseInt(filteredMap.get("ramSize1")[0]);
			ram2 = Integer.parseInt(filteredMap.get("ramSize2")[0]);
		}
		
		result += HtmlHelper.getSlider(request, category, "price", "&euro;", price1, price2);
		result += HtmlHelper.getSlider(request, category, "ramSize", "GB", ram1, ram2);
		result += HtmlHelper.getCheckboxRow(request, category, "brand", filteredMap);
		result += HtmlHelper.getCheckboxRow(request, category, "gpuBrand", filteredMap);
		return result;
	}

	@Override
	public String getAllItemInformation(HttpServletRequest request) {
		return HtmlHelper.getAllItemInformation(this.id, request, Constants.BEAN_INFO_COLUMN_VALUES_LAPTOP);
	}

	@Override
	public String getTableRowElement(PurchasedShoppingCartItem purchasedShoppingCartItemObject) {
		return HtmlHelper.getTableRow(-1, purchasedShoppingCartItemObject.getName(), purchasedShoppingCartItemObject.getPrice(), purchasedShoppingCartItemObject.getImageUrl(), purchasedShoppingCartItemObject.getCount(), "category", -1, true, purchasedShoppingCartItemObject.getDate());
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getPrice() {
		return this.price;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getImage() {
		return this.image;
	}

	@Override
	public void insertIntoDatabase(HttpServletRequest request) throws Exception {
		String preparedQuery = "INSERT INTO `info_laptops`(`id`, `image`, `price`, `stock`, `name`, `brand`, `processorBrand`, `processorType`, `processorCores`, `gpuBrand`, `gpuType`, `ramSize`, `hardDrive`, `ssd`, `promotion`, `warranty`, `color`, `screenSize`, `screenType`, `displayResolution`, `officeIncluded`, `operatingSystem`, `bundledSoftware`, `portsSlotsChassis`, `cameraMicrophone`, `clockSpeed`, `frontSideBus`, `maxExpandability`, `memorySlots`, `driveRotation`, `opticalDriveType`, `wifi`, `dlna`, `bluetooth`, `hdmi`, `usb`, `multicardReader`, `compatibleMemoryCards`, `batteryType`, `batteryUpTo`, `width`, `depth`, `height`, `weight`, `more`) VALUES ((select ifnull(max(id), " + Constants.UNIQUE_IDENTIFIER_LAPTOP + "0000)+1 from info_laptops maxId),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = ((DataSource) Helper.getBeanFromRequest(request, Constants.BEAN_DATA_SOURCE)).getConnection();
		Helper.executePreparedQuery(conn, preparedQuery,
				this.image,
				this.price,
				this.stock,
				this.name,
				this.brand,
				this.processorBrand,
				this.processorType,
				this.processorCores,
				this.gpuBrand,
				this.gpuType,
				this.ramSize,
				this.hardDrive,
				this.ssd,
				this.promotion,
				this.warranty,
				this.color,
				this.screenSize,
				this.screenType,
				this.displayResolution,
				this.officeIncluded,
				this.operatingSystem,
				this.bundledSoftware,
				this.portsSlotsChassis,
				this.cameraMicrophone,
				this.clockSpeed,
				this.frontSideBus,
				this.maxExpandability,
				this.memorySlots,
				this.driveRotation,
				this.opticalDriveType,
				this.wifi,
				this.dlna,
				this.bluetooth,
				this.hdmi,
				this.usb,
				this.multicardReader,
				this.compatibleMemoryCards,
				this.batteryType,
				this.batteryUpTo,
				this.width,
				this.depth,
				this.height,
				this.weight,
				this.more);
	}
}
