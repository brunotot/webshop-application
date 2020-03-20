package com.brunotot.webshop.merchandise;

import com.brunotot.webshop.content.HtmlHelper;
import com.brunotot.webshop.content.Item;

public class Laptop implements Item {
	private int id;
	private String name;
	private String manufacturer;
	private String gpu;	
	private String cpu;
	private String ram;
	private String ssd;
	private String hdd;
	private String imageUrl;
	private int price;
	public Laptop() {}
	public Laptop(int id, String name, String manufacturer, String gpu, String cpu, String ram, String ssd, String hdd,
			String imageUrl, int price) {
		super();
		this.id = id;
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
	public int getPrice() {
		return price;
	}
	public int getId() {
		return id;
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
	public void setPrice(int price) {
		this.price = price;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getDivElement() {
		return HtmlHelper.getItemDiv(this.getName(), this.getPrice(), this.getImageUrl());
	}
	
	@Override
	public String getTableRowElement() {
		return HtmlHelper.getTableRow(this.getName(), this.getPrice(), this.getImageUrl());
	}
}
