package com.traderjoey.bean;


public class Currency {
	private int id;
	private String name;
	private float currentPrice;

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

	public float getPrice() {
		return currentPrice;
	}

	public void setPrice(float price) {
		this.currentPrice = price;
	}

}
