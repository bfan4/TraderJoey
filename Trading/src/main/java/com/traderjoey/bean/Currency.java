package com.traderjoey.bean;


public class Currency {
	private int id;
	private String name;
	private String currentPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return currentPrice;
	}

	public void setPrice(String price) {
		this.currentPrice = price;
	}

}
