package com.traderjoey.bean;

import java.sql.Timestamp;

public class CurrencyPrice {
	private Long id = null;
	private String currency;
	private String price;
	private Timestamp timestamp;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CurrencyPrice [id=" + id + ", currency=" + currency + ", price=" + price + ", timestamp=" + timestamp
				+ "]";
	}

}
