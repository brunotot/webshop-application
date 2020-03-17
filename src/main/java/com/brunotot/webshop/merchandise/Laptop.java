package com.brunotot.webshop.merchandise;

public class Laptop {
	private String name;
	private String manufacturer;
	private String gpu;	
	private String cpu;
	private String ram;
	private String ssd;
	private String hdd;
	private String imageUrl;
	private String price;
	public Laptop(String name, String manufacturer, String gpu, String cpu, String ram, String ssd, String hdd,
			String imageUrl, String price) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.gpu = gpu;
		this.cpu = cpu;
		this.ram = ram;
		this.ssd = ssd;
		this.hdd = hdd;
		this.imageUrl = imageUrl;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public String getGpu() {
		return gpu;
	}
	public String getCpu() {
		return cpu;
	}
	public String getRam() {
		return ram;
	}
	public String getSsd() {
		return ssd;
	}
	public String getHdd() {
		return hdd;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public String getPrice() {
		return price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public void setGpu(String gpu) {
		this.gpu = gpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public void setSsd(String ssd) {
		this.ssd = ssd;
	}
	public void setHdd(String hdd) {
		this.hdd = hdd;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
