package com.brunotot.webshop.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.brunotot.webshop.content.Item;
import com.brunotot.webshop.merchandise.Desktop;
import com.brunotot.webshop.merchandise.Laptop;
import com.brunotot.webshop.merchandise.Phone;

/**
 * Initializator component class.
 * 
 * @author Bruno
 *
 */
@Component
public class OnStartValues {

	/**
	 * Method for getting laptop column values info bean.
	 * 
	 * @return Laptop column values bean
	 */
	@Bean
	public Map<String, String> infoColumnValuesLaptop() {
		Map<String, String> map = new LinkedHashMap<>();

		map.put("image", "Image");
		map.put("price", "Price");
		map.put("stock", "Stock");
		map.put("name", "Item name");
		map.put("brand", "Brand");
		map.put("processorBrand", "Processor brand");
		map.put("processorType", "Processor type");
		map.put("processorCores", "Processor cores");
		map.put("gpuBrand", "Graphics card brand");
		map.put("gpuType", "Graphics card type");
		map.put("ramSize", "Ram size (GB)");
		map.put("hardDrive", "Hard drive (GB)");
		map.put("ssd", "Solid state drive (GB)");
		map.put("promotion", "Promotion");
		map.put("warranty", "Warranty");
		map.put("color", "Color");
		map.put("screenSize", "Screen size");
		map.put("screenType", "Screen type");
		map.put("displayResolution", "Display resolution ");
		map.put("officeIncluded", "Office included");
		map.put("operatingSystem", "Operating system");
		map.put("bundledSoftware", "Bundled software");
		map.put("portsSlotsChassis", "Ports, slots & chassis");
		map.put("cameraMicrophone", "Build-in camera & microphone");
		map.put("clockSpeed", "Clock speed (GHz)");
		map.put("frontSideBus", "Front side bus (MHz)");
		map.put("maxExpandability", "Maximum expandability (GB)");
		map.put("memorySlots", "Number of memory slots");
		map.put("driveRotation", "Drive rotation (RPM)");
		map.put("opticalDriveType", "Optical drive type");
		map.put("wifi", "Wi-Fi");
		map.put("dlna", "DLNA");
		map.put("bluetooth", "Bluetooth");
		map.put("hdmi", "HDMI");
		map.put("usb", "USB");
		map.put("multicardReader", "Multi-card reader");
		map.put("compatibleMemoryCards", "Compatible memory cards");
		map.put("batteryType", "Battery type");
		map.put("batteryUpTo", "Battery (up to)");
		map.put("width", "Width (mm)");
		map.put("depth", "Depth (mm)");
		map.put("height", "Height (mm) ");
		map.put("weight", "Weight (kg)");
		map.put("more", "More");

		return map;
	}

	/**
	 * Method for getting desktop column values info bean.
	 * 
	 * @return Desktop column values bean
	 */
	@Bean
	public Map<String, String> infoColumnValuesDesktop() {
		Map<String, String> map = new LinkedHashMap<>();

		map.put("image", "Image");
		map.put("price", "Price");
		map.put("stock", "Stock");
		map.put("name", "Item name");
		map.put("brand", "Brand");
		map.put("processorBrand", "Processor brand");
		map.put("processorType", "Processor type");
		map.put("processorCores", "Processor cores");
		map.put("gpuBrand", "Graphics card brand");
		map.put("gpuType", "Graphics card type");
		map.put("ramSize", "Ram size (GB)");
		map.put("hardDrive", "Hard drive (GB)");
		map.put("ssd", "Solid state drive (GB)");
		map.put("promotion", "Promotion");
		map.put("warranty", "Warranty");
		map.put("color", "Color");
		map.put("screenSize", "Screen size");
		map.put("screenType", "Screen type");
		map.put("displayResolution", "Display resolution ");
		map.put("officeIncluded", "Office included");
		map.put("operatingSystem", "Operating system");
		map.put("bundledSoftware", "Bundled software");
		map.put("portsSlotsChassis", "Ports, slots & chassis");
		map.put("cameraMicrophone", "Build-in camera & microphone");
		map.put("clockSpeed", "Clock speed (GHz)");
		map.put("frontSideBus", "Front side bus (MHz)");
		map.put("maxExpandability", "Maximum expandability (GB)");
		map.put("memorySlots", "Number of memory slots");
		map.put("driveRotation", "Drive rotation (RPM)");
		map.put("opticalDriveType", "Optical drive type");
		map.put("wifi", "Wi-Fi");
		map.put("dlna", "DLNA");
		map.put("bluetooth", "Bluetooth");
		map.put("hdmi", "HDMI");
		map.put("usb", "USB");
		map.put("multicardReader", "Multi-card reader");
		map.put("compatibleMemoryCards", "Compatible memory cards");
		map.put("width", "Width (mm)");
		map.put("depth", "Depth (mm)");
		map.put("height", "Height (mm) ");
		map.put("weight", "Weight (kg)");
		map.put("more", "More");

		return map;
	}
	
	/**
	 * Method for getting phone column values info bean.
	 * 
	 * @return Phone column values bean
	 */
	@Bean
	public Map<String, String> infoColumnValuesPhone() {
		Map<String, String> map = new LinkedHashMap<>();

		map.put("image", "Image");
		map.put("price", "Price");
		map.put("stock", "Stock");
		map.put("name", "Item name");
		map.put("brand", "Brand");
		map.put("processorBrand", "Processor brand");
		map.put("processorType", "Processor type");
		map.put("processorCores", "Processor cores");
		map.put("gpuBrand", "Graphics card brand");
		map.put("gpuType", "Graphics card type");
		map.put("ramSize", "Ram size (GB)");
		map.put("hardDrive", "Hard drive (GB)");
		map.put("promotion", "Promotion");
		map.put("warranty", "Warranty");
		map.put("color", "Color");
		map.put("screenSize", "Screen size");
		map.put("screenType", "Screen type");
		map.put("displayResolution", "Display resolution ");
		map.put("operatingSystem", "Operating system");
		map.put("bundledSoftware", "Bundled software");
		map.put("portsSlotsChassis", "Ports, slots & chassis");
		map.put("cameraMicrophone", "Build-in camera & microphone");
		map.put("clockSpeed", "Clock speed (GHz)");
		map.put("frontSideBus", "Front side bus (MHz)");
		map.put("maxExpandability", "Maximum expandability (GB)");
		map.put("memorySlots", "Number of memory slots");
		map.put("driveRotation", "Drive rotation (RPM)");
		map.put("opticalDriveType", "Optical drive type");
		map.put("wifi", "Wi-Fi");
		map.put("dlna", "DLNA");
		map.put("bluetooth", "Bluetooth");
		map.put("hdmi", "HDMI");
		map.put("usb", "USB");
		map.put("multicardReader", "Multi-card reader");
		map.put("compatibleMemoryCards", "Compatible memory cards");
		map.put("batteryType", "Battery type");
		map.put("batteryUpTo", "Battery (up to)");
		map.put("width", "Width (mm)");
		map.put("depth", "Depth (mm)");
		map.put("height", "Height (mm) ");
		map.put("weight", "Weight (kg)");
		map.put("more", "More");

		return map;
	}

	@Bean
	public Map<String, String> optionsMap() {
		Map<String, String> map = new HashMap<>();
		
		map.put("brand", "Select item brands");
		map.put("gpuBrand", "Select GPU brand");
		
		return map;
	}

	@Bean
	public Map<String, String> infoTableLeftColumnKeyMap() {
		Map<String, String> map = new HashMap<>();

		map.put("brand", "Item brands");
		map.put("ramSize", "RAM");
		map.put("price", "Price");
		map.put("gpuBrand", "GPU brands");
		return map;
		
	}

	@Bean
	public Map<String, Item> itemInstanceByCategoryMap() {
		Map<String, Item> map = new HashMap<>();

		map.put(Constants.CATEGORY_LAPTOPS, new Laptop());
		map.put(Constants.CATEGORY_DESKTOPS, new Desktop());
		map.put(Constants.CATEGORY_PHONES, new Phone());
		
		return map;
	}
	
	/**
	 * Initializator method for all roles ant matchers.
	 * 
	 * @return Array of strings as ant matchers for all roles.
	 */
	public static String[] getAntMatchersForAllRoles() {
		String[] allowed = new String[1];

		allowed[0] = "/";
		
		return allowed;
	}
	
	/**
	 * Initializator method for user role ant matchers.
	 * 
	 * @return Array of strings as ant matchers for user role.
	 */
	public static String[] getAntMatchersForUserRole() {
		String[] allowed = new String[3];

		allowed[0] = "/user";
		allowed[1] = "/user/settings";
		allowed[2] = "/user/payment";
		
		return allowed;
	}

	/**
	 * Initializator method for admin role ant matchers.
	 * 
	 * @return Array of strings as ant matchers for admin role.
	 */
	public static String[] getAntMatchersForAdminRole() {
		String[] allowed = new String[5];

		allowed[0] = "/admin";
		allowed[1] = "/admin/panel";
		allowed[2] = "/user";
		allowed[3] = "/user/settings";
		allowed[4] = "/user/payment";
		
		return allowed;
	}

}
