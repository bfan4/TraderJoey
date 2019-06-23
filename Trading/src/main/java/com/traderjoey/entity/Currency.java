package com.traderjoey.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name="currency")
public class Currency {
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	@JsonProperty(value = "currency")
	private String name;
	
	@Column(name="current_price")
	private float currentPrice;
	
	@OneToMany(mappedBy="currency",
			   cascade= CascadeType.ALL,
			   fetch = FetchType.EAGER)
	private List<CurrencyPrice> currencyPrices;
	
	public Currency() {}
	
	public Currency(String name) {
		super();
		this.name = name;
	}

	public List<CurrencyPrice> getCurrencyPrice() {
		return currencyPrices;
	}

	public void setCurrencyPrice(List<CurrencyPrice> currencyPrices) {
		this.currencyPrices = currencyPrices;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonGetter("currency")
	public String getName() {
		return name;
	}

	@JsonSetter("name")
	public void setName(String name) {
		this.name = name;
	}

	public float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}

	@Override
	public String toString() {
		return "Currency [id=" + id + ", name=" + name + ", currentPrice=" + currentPrice + "]";
	}


}
