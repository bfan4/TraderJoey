package com.traderjoey.entity;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name="currency_price")
public class CurrencyPrice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="record_id")
	private int record;
	
	@Column(name="price")
	private float price;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="currency_id")
	private Currency currency;
	
	@Override
	public String toString() {
		return "CurrencyPrice [record=" + record + ", price=" + price + ", currency=" + currency.getName() + ", timestamp="
				+ timestamp + "]";
	}

	@Column(name="time_stamp")
	private Timestamp timestamp;


	public int getRecord() {
		return record;
	}

	public void setRecord(int record) {
		this.record = record;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Currency getCurrency() {
		return currency;
	}
	
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
