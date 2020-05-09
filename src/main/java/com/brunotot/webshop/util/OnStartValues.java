package com.brunotot.webshop.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Initializator component class.
 * 
 * @author Bruno
 *
 */
@Component
public class OnStartValues {

	/**
	 * Method for getting column values info bean.
	 * 
	 * @return Column values bean
	 */
	@Bean
	public Map<String, String> infoColumnValues() {
		Map<String, String> map = new HashMap<>();

		map.put("promotion", "Promotion");
		map.put("warranty", "Warranty");
		map.put("brand", "Brand");
		map.put("color", "Color");
		map.put("screenSize", "Screen size");
		map.put("screenType", "Screen type");
		map.put("displayResolution", "Display resolution ");
		map.put("officeIncluded", "Office included");
		map.put("operatingSystem", "Operating system");
		map.put("bundledSoftware", "Bundled software");
		map.put("portsSlotsChassis", "Ports, slots & chassis");
		map.put("cameraMicrophone", "Build-in camera & microphone");
		map.put("processorBrand", "Processor brand");
		map.put("processor", "Processor");
		map.put("processorType", "Processor type");
		map.put("clockSpeed", "Clock speed (GHz)");
		map.put("frontSideBus", "Front side bus (MHz)");
		map.put("ramSize", "Ram size (GB)");
		map.put("maxExpandability", "Maximum expandability (GB)");
		map.put("memorySlots", "Number of memory slots");
		map.put("hardDrive", "Hard drive (GB)");
		map.put("ssd", "Solid state drive (GB)");
		map.put("driveRotation", "Drive rotation (RPM)");
		map.put("opticalDriveType", "Optical drive type");
		map.put("graphicsType", "Graphics type");
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

}
